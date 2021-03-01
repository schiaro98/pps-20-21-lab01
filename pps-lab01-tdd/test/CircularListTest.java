import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.EvenStrategy;
import lab01.tdd.OddStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final CircularList list = new CircularListImpl();

    @Test
    void testListEmpty(){
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddingElement(){
       fillList(0,10);
        assertEquals(list.size(), 10);
    }

    @Test
    void testNext(){
        //Riempo la lista
        fillList(0,3);

        //Creo la lista {0,1,2} e controllo sia corretta
        assertTrue(checkOptional(list.next(), 0));
        assertTrue(checkOptional(list.next(), 1));
        assertTrue(checkOptional(list.next(), 2));

        //Controllo che il prossimo elemento se sono a fine lista sia il primo
        assertTrue(checkOptional(list.next(), 0));
    }

    @Test
    void testPrevious(){
        fillList(0,3);

        //Scorro avanti e indietro la lista alla ricerca di errori
        assertTrue(checkOptional(list.next(), 0));

        assertTrue(checkOptional(list.next(), 1));

        assertTrue(checkOptional(list.next(), 2));

        assertTrue(checkOptional(list.previous(), 1));

        assertTrue(checkOptional(list.previous(), 0));

        assertTrue(checkOptional(list.next(), 1));

        assertTrue(checkOptional(list.previous(), 0));

        assertTrue(checkOptional(list.previous(), 2));
    }

    @Test
    void testPreviousEmptyList(){
        assertEquals(list.previous(), Optional.empty());
    }

    @Test
    void testNextEmptyList(){
        assertEquals(list.next(), Optional.empty());
    }

    @Test
    void testStrategy(){
        fillList(0,10); //Riempo la lista da 0 a 9

        for (int i = 0; i < list.size(); i+=2) {
            assertTrue(checkOptional(list.next(new EvenStrategy()), i));
        }
    }

    @Test
    void testOddStrategy(){
        fillList(0,10); //Riempo la lista da 0 a 9

        for (int i = 0; i < list.size() - 1; i+=2) {
            assertTrue(checkOptional(list.next(new OddStrategy()), i+1));
        }
    }

    void fillList(int start, int max){
        for (int i = start; i < max; i++) {
            list.add(i);
        }
    }

    Boolean checkOptional (Optional<Integer> result, int expected){
        return result.filter(integer -> expected == integer).isPresent();
    }

}

import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void initializeList(){
        this.list = new CircularListImpl();
    }

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
    void testNextAndPrevious(){
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

    @Test
    void testMultipleStrategy(){
        fillList(0,50); //Riempo la lista da 0 a 50
        MultipleStrategy strategy = new MultipleStrategy(3);
        for (int i = 0; i < list.size(); i+=3) {
            assertTrue(checkOptional(list.next(strategy), i));
        }
        assertFalse(checkOptional(list.next(strategy), 11));
        assertFalse(checkOptional(list.next(strategy), 16));
    }

    @Test
    void testEqualStrategy(){
        fillList(0,50); //Riempo la lista da 0 a 50
        EqualStrategy strategy = new EqualStrategy(3);
        assertTrue(checkOptional(list.next(strategy), 3));
        assertFalse(checkOptional(list.next(strategy), 4));
        strategy.setTarget(18);
        assertTrue(checkOptional(list.next(strategy), 18));
    }


    @Test
    void testAll(){
        fillList(0,2);

        //Scorro avanti e indietro la lista alla ricerca di errori
        assertTrue(checkOptional(list.next(), 0));
        assertTrue(checkOptional(list.next(), 1));
        assertTrue(checkOptional(list.next(), 0));

        list.add(2);
        list.add(3);

        assertTrue(checkOptional(list.next(), 1));
        assertTrue(checkOptional(list.next(), 2));
        assertTrue(checkOptional(list.next(), 3));
        assertTrue(checkOptional(list.next(), 0));
    }

    @Test
    void testfactory(){
        fillList(0,50);

        StrategyFactory factory = new StrategyFactoryImpl();
        SelectStrategy strategy = factory.createOddStrategy();
        assertTrue(checkOptional(list.next(strategy), 1));
        assertTrue(checkOptional(list.next(strategy), 3));
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

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    //TODO: test implementation

    CircularList list = new CircularListImpl();

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @Test
    void testListEmpty(){
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

        //Create la lista {0,1,2} controllo sia corretta
        assertTrue(checkOptional(list.next(), 0));
        assertTrue(checkOptional(list.next(), 1));
        assertTrue(checkOptional(list.next(), 2));

        assertTrue(checkOptional(list.next(), 0));
    }

    @Test
    void testPrevious(){
        fillList(0,3);

        Optional<Integer> result = list.next();
        assertTrue(checkOptional(result, 0));

        result = list.next();
        assertTrue(checkOptional(result, 1));

        result = list.next();
        assertTrue(checkOptional(result, 2));

        result = list.previous();
        assertTrue(checkOptional(result, 1));

        result = list.previous();
        assertTrue(checkOptional(result, 0));

        result = list.next();
        assertTrue(checkOptional(result, 1));

        result = list.previous();
        assertTrue(checkOptional(result, 0));

        result = list.previous();
        assertTrue(checkOptional(result, 2));
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

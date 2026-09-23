import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class growingArrTest {

    @Test
    void equalElts(){
        growingArr ex1 = new growingArr(new int[]{1,3,4,6,0,0,0,0});
        growingArr ex2 = new growingArr(new int[]{1,3,4,6,0});
        assertEquals(true, ex1.equalElts(ex2));
    }

    @Test
    void length(){
        assertEquals(3, new growingArr(new int[]{1,2,3,0,0}).length());
    }

    @Test
    void get(){
        assertEquals(3, new growingArr(new int[]{1,2,3,0,0}).get(2));
    }

    @Test
    void set(){
        assertDoesNotThrow(()->new growingArr(new int[]{1,2,3,0,0}).set(2,4));
        assertThrows(NoSuchElementException.class, ()->new growingArr(new int[]{1,2,3,0,0}).set(8,4));
    }
}
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class growingArrTest {

    @Test
    void equalElts(){
        growingArr ex1 = new growingArr(new Integer[]{1,3,4,5}, 4);
        growingArr ex2 = new growingArr(new Integer[]{1,3,4,6}, 4);
        assertEquals(false, ex1.equalElts(ex2));
    }

    @Test
    void length(){
        growingArr ex1 = growingArr.empty();
        ex1.addToEnd(1);
        ex1.addToEnd(3);
        ex1.addToEnd(4);
        ex1.addToStart(7);

        assertEquals(4, ex1.length());
    }

    @Test
    void get(){
        growingArr ex1 = growingArr.empty();
        ex1.addToEnd(1);
        ex1.addToEnd(3);
        ex1.addToEnd(4);
        ex1.addToStart(7);

        assertThrows(NoSuchElementException.class, () -> ex1.get(5));
    }

    @Test
    void set(){
        growingArr ex1 = growingArr.empty();
        ex1.addToEnd(1);
        ex1.addToEnd(3);
        ex1.addToEnd(4);
        ex1.addToStart(7);

        assertThrows(NoSuchElementException.class, () -> ex1.set(5,5));
    }

    @Test
    void insert(){
        growingArr ex1 = growingArr.empty();
        growingArr ex2 = growingArr.empty();
        ex2.addToEnd(1);
        ex2.addToEnd(3);
        ex2.addToEnd(4);
        ex2.addToStart(7);

        assertThrows(IllegalArgumentException.class, ()-> ex1.insert(1,1));
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void lessThanHundred(){
        int[] ex = {1, 5, 19, 200};
        assertEquals(false, Main.lessThanHundred(ex));
    }
}

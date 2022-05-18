import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class GrilleImplTest {

    @Test
    public void testOK() {
        assertEquals( 4, GrilleImpl.getDimension(12, 16));

    }

    //test change
}
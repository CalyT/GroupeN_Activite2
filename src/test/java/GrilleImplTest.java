import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class GrilleImplTest {

    @Test
    public void setValue9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals('0',test.getValue(9,5));
    }

    @Test
    public void possible9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals(false,test.possible(9,5, 'y'));
    }

    @Test
    public void getDimension9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals('0',test.getDimension(9,5));
    }

    @Test
    public void getValue9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals('0',test.getValue(9,5));
    }

    @Test
    public void complete9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals('0',test.getValue(9,5));
    }

    @Test
    public void setValue16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals('0',test.getValue(9,5));
    }

    @Test
    public void possible16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals(false,test.possible(9,5, 'y'));
    }

    @Test
    public void getDimension16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals('0',test.getValue(9,5));
    }

    @Test
    public void getValue16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals('0',test.getValue(9,5));
    }

    @Test
    public void complete16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals('0',test.getValue(9,5));
    }
}
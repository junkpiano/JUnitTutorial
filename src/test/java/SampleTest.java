import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void num() {
        assertEquals(10, Sample.num());
        assertEquals("it's not 10.", 10, Sample.num());
    }

    @Test
    public void name() {
        assertEquals("michael smith", Sample.name("michael", "smith"));
    }
}
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

class AssumeTest {

    @Test
    void testOnlyOnDevEnv() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
            () -> "not dev, so end.");
        // if true, execute test.
    }

    @Test
    void testInAllEnvironments() {
        // That bellow case, only execute on dev env.
        assumingThat("DEV".equals(System.getenv("ENV")),
            () -> {
                assertEquals(1, 1);
            });

        // all env execute
        assertEquals("test", "test");
    }

}

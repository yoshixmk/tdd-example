package guide.asserting;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AsssertTest {

    @Test
    @DisplayName("1分未満で終わるタスクであること")
    void timeoutNotExceeded() {
        String actualResult = assertTimeout(ofMinutes(1), () -> {
            return "result";
        });
        assertEquals("result", actualResult);
    }

    @Test
    @Disabled("assertTimeoutの落ちるテスト")
    void timeoutExceeded() {
        assertTimeout(ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }

    @Test
    @Disabled("assertTimeoutの落ちるテスト2")
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }
}
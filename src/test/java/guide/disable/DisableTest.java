package disable;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

class DisableTest {

	// lamda multiple test
	@Test
    @Disabled("test checking for fail")
	void skippTest() {
		fail("失敗するテスト");
	}

}

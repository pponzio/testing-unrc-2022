package testing.mutation.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCal {

	@Test
	void test() {
		assertEquals(1, Cal.cal(6, 1, 6, 2, 2000));
		
	}
	
}

package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class junit_successfulsave {

	@Test
	void test() {
//		fail("Not yet implemented");
		String[] args= {""};
		int r = AddFrame.main(args);
		assertEquals(r, 1);
	
	}

}

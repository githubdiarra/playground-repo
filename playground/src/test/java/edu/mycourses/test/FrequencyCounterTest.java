package edu.mycourses.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import edu.mycourses.adt.st.client.FrequencyCounter;

public class FrequencyCounterTest {

	private static final String LEIPZIP = "edu/mycourses/st/leipzip1m.txt";
	
	@Test
	public void testCount8() throws IOException {
		final InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream(LEIPZIP);
		final FrequencyCounter fc = new FrequencyCounter();
		fc.count(8, is);
		is.close();
	}
	
	@Test
	public void testCount10() throws IOException {
		final InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream(LEIPZIP);
		final FrequencyCounter fc = new FrequencyCounter();
		fc.count(10, is);
		is.close();
	}
}

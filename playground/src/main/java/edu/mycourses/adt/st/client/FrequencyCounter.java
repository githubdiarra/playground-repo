/**
 * 
 */
package edu.mycourses.adt.st.client;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import edu.mycourses.adt.st.BasicST;
import edu.mycourses.adt.st.ST;

/**
 * @author Ibrahima Diarra
 * 
 */
public class FrequencyCounter {

	private static final Logger logger = LogManager
			.getLogger(FrequencyCounter.class);

	@SuppressWarnings("resource")
	public void count(final int minlen, final InputStream is) {
		Scanner sc = new Scanner(is).useDelimiter(" ");
		ST<String, Integer> st = new BasicST<String, Integer>();
		while (sc.hasNext()) {
			final String word = sc.next();
			if (word.length() < minlen)
				continue;
			if (!st.contains(word))
				st.put(word, 1);
			else
				st.put(word, st.get(word) + 1);
		}
		String max = "";
		st.put(max, 0);
		for (String word : st.keys())
			if (st.get(word) > st.get(max))
				max = word;
		logger.debug(max + " " + st.get(max));

	}

}

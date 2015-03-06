package edu.mycourses.test;

import org.junit.Test;

import edu.mycourses.adt.basic.analysis.ThreeSumFast;
import edu.mycourses.util.StopWatch;
import edu.mycourses.util.Utils;

public class ThreeSumTest {

	@Test
	public void threesumtest(){
		final String[] args = new String[]{Utils.BASE_PATH+"/1Mints.txt"};
		final StopWatch sw = new StopWatch();
		ThreeSumFast.main(args);
		System.out.println("Time: " + sw.elapsedTime() + " seconds");
	}
}

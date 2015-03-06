package edu.mycourses.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

	public static final String BASE_PATH = "/edu/mycourses/st";
	public static final String UF_BASE_PATH = "/edu/mycourses/uf/";
	
	public static int[] readInts(final String filename) {
		final InputStream is = getClassPathResource(filename);
		List<Integer> vals = new ArrayList<Integer>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(is);
		while (sc.hasNext())
			vals.add(sc.nextInt());
		int[] data = new int[vals.size()];
		int c = 0;
		for (Integer i : vals)
			data[c++] = i;
		return data;
	}
	
	public static InputStream getClassPathResource(final String filename){
		return Utils.class.getClass()
				.getResourceAsStream(filename);
	}
}

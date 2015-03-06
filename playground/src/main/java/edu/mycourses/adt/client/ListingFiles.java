/**
 * 
 */
package edu.mycourses.adt.client;

import java.io.File;

/**
 * @author Ibrahima Diarra
 * 
 */
public class ListingFiles {

	public static void listFiles(final String folder) {
		final File root = new File(folder);
		if (root.exists())
			listFiles(root, "");
	}

	private static void listFiles(final File folder, final String indentation) {
		final File[] files = folder.listFiles();
		for (File file : files) {
			System.out.println(indentation + file.getName());
			if (file.isDirectory())
				listFiles(file, new StringBuilder(indentation).append(" ")
						.toString());
		}
	}
}

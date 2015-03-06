package edu.mycourses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.mycourses.adt.client.Josephus;
import edu.mycourses.adt.client.ListingFiles;
import edu.mycourses.adt.client.TextEditorBuffer;

public class CreativeProblemTests {

	
	@Test
	public void JosuphusTest(){
		Josephus.findSafeSit(2, 7);
	}
	
	@Test
	public void ListingFilesTest(){
		final String folder = "C:\\scraper\\deploy";
		ListingFiles.listFiles(folder);
	}
	
	@Test
	public void TextEditorBufferTest(){
		final TextEditorBuffer buffer = new TextEditorBuffer();
		final String text = "I will go to second in ten minutes";
		insert(buffer,"I to");
		buffer.left(2);
		insert(buffer, "will go ");
		buffer.right(2);
		insert(buffer," second in ten minutes");
		assertTrue(buffer.size() == text.length());
		buffer.delete();
		System.out.println();
		System.out.println(buffer.text());
	}

	private void insert(TextEditorBuffer buffer, String string) {
		for (char c : string.toCharArray())
			buffer.insert(c);
	}
}

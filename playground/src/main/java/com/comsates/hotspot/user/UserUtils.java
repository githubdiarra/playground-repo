/**
 * 
 */
package com.comsates.hotspot.user;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author Ibrahima Diarra
 *
 */
public class UserUtils {
	
	public static String generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return new String(digits);
	}
	
	public static void loadBatch(final Set<Batch> batches, String filePath) throws Exception{
		batches.clear();
		Path  path = Paths.get(filePath);
		try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
			lines.forEachOrdered(new Consumer<String>(){
				@Override public void accept(String t) {
					String[] tokens = t.split(",");
					if(tokens.length == 5)
						for(int x = 0; x < tokens.length; x++){
							Profile p = Profile.valueOf(tokens[0]);
							Date d = new Date(Long.valueOf(tokens[2]));
							Integer count = Integer.valueOf(tokens[3]);
							batches.add(new Batch(tokens[1], p, d, count));
						}
				}	
			});
		}
	}
	
	public static void loadUserTokens(final Set<String> userTokens, String filePath) throws Exception{
		userTokens.clear();
		Path  path = Paths.get(filePath);
		try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
			lines.forEachOrdered(new Consumer<String>(){
				@Override public void accept(String t) {
					userTokens.add(t.trim());
				}	
			});
		}
	}
}

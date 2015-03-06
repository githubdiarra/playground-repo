/**
 * 
 */
package com.comsates.hotspot.user;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ibrahima Diarra
 *
 */
public class UserGenerator {
	
	private static final String DATE_FORMAT = "yyyyMMdd";
	private static final String BASE_PATH = "c:/comsates/hotspot/db/";
	private static final String TOKEN_DB_PATH = BASE_PATH + "data/token";
	private static final String BATCH_DB_PATH = BASE_PATH + "data/batch";
	private static final String COMMAND_PREFIX = "add customer=masa.sundiata name=";
	private static final String COMMAND_PART2 = " copy-from=[find name=";
	private static final String COMMAND_PART3 = "]";
	private static final Integer RAND_LENGTH = 4;
	private Set<Batch> batches = new HashSet<Batch>();
	private Set<String> userTokens = new HashSet<String>();
	
	public void generateUsers(Profile profile, Integer count) throws Exception{
		loadBatch();
		loadUserTokens();
		final String prefix = getPrefix();
		Set<String> tokens = generateTokens(prefix, count);
		Batch batch = new Batch(prefix, profile, new Date(), count);
		savedata(batch, tokens);
	}

	private void savedata(Batch batch,Set<String> tokens) throws Exception {
		saveBatchTodb(batch);
		saveTokensTodb(tokens);
		saveTokenFile(batch,tokens);
	}

	private void saveTokensTodb(Set<String> tokens) throws Exception {
		PrintWriter userdb = new PrintWriter(new BufferedWriter(new FileWriter(
				TOKEN_DB_PATH, true)));
		for (String token : tokens)
			userdb.println(token);
		userdb.close();
	}
	
	private void saveBatchTodb(final Batch batch) throws Exception {
		PrintWriter batchdb = new PrintWriter(new BufferedWriter(
				new FileWriter(BATCH_DB_PATH, true)));
		batchdb.println(batch.toCsv());
		batchdb.close();
	}
	
	private void saveTokenFile(Batch batch, Set<String> tokens) throws Exception {
		String path = new StringBuilder(BASE_PATH).append(batch.getProfile().getDescription()).append("-")
				.append(new SimpleDateFormat(DATE_FORMAT).format(new Date())).toString();
		saveAsCsv(tokens, path);
		saveAsMikrotikImport(tokens, path, batch);
	}

	private void saveAsCsv(Set<String> tokens, String path) throws Exception{
		FileOutputStream out = new FileOutputStream(path+".csv");
		byte[] terminator = "\n".getBytes();
		for(String token : tokens){
			out.write(formatToken(token).getBytes());
			out.write(terminator);
		}
		out.close();
	}
	
	private void saveAsMikrotikImport(Set<String> tokens, String path, Batch batch) throws Exception {
		FileOutputStream out = new FileOutputStream(path + ".rsc");
		// write headers
		byte[] terminator = "\n".getBytes();
		out.write(("# " + batch.toString()).getBytes());
		out.write(terminator);
		out.write("/tool user-manager user".getBytes());
		out.write(terminator);
		// write token commands
		for (String token : tokens) {
			out.write(getMikrotikCommand(batch.getProfile(), token).getBytes());
			out.write(terminator);
		}
		out.close();
	}

	private String getMikrotikCommand(Profile profile, String token) {
		return new StringBuilder(COMMAND_PREFIX).append(token)
				.append(COMMAND_PART2).append(profile.getUsername()).append(COMMAND_PART3).toString();
	}
	
	private String formatToken(String token) {
		StringBuilder bd = new StringBuilder();
		int count = 0;
		for (char c : token.toCharArray()) {
			bd.append(c);
			count++;
			if (count % RAND_LENGTH == 0)
				bd.append(" ");
		}
		return bd.toString();
	}

	private Set<String> generateTokens(String prefix, Integer count) {
		Set<String> tokens = new HashSet<String>(count);
		while (tokens.size() < count) {
			String token = generateToken(prefix);
			if (isValidToken(token))
				tokens.add(generateToken(prefix));
		}
		return tokens;
	}

	private String generateToken(String prefix) {
		StringBuilder bd = new StringBuilder(prefix);
		bd.append(generateRandom());
		bd.append(generateRandom());
		return bd.toString();
	}

	private String generateRandom() {
		return UserUtils.generateRandom(RAND_LENGTH);
	}

	private String getPrefix(){
		String prefix = generateRandom();
		while(batches.contains(new Batch(prefix)))
			prefix = generateRandom();
		return prefix;
	}
	
	private void loadBatch() throws Exception{
		UserUtils.loadBatch(batches, BATCH_DB_PATH);
	}
	
	private void loadUserTokens() throws Exception {
		UserUtils.loadUserTokens(userTokens, TOKEN_DB_PATH);	
	}

	private boolean isValidToken(String token){
		return !userTokens.contains(token);
	}
}

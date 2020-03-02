package com.util.random;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

//This is a utility class to load a word list from a input text file whose path is configurable in the properties file
//It also provides a functionality to print a word from the list randomly.
public class RandomWordUtil {
	private final static Logger log = Logger.getLogger(RandomWordUtil.class.getName());
	private static final String PROPERTIES_FILE_PATH = "util.properties";

	// Properties which can contain the path name of the input file from where the
	// app will load the word list
	// This is to make the word list file path generic and configurable outside from
	// this utility class.
	private final static Properties properties = new Properties();

	// The list contains all the words from the input file
	private static List<String> words = new ArrayList<String>();

	static {
		// load the properties per class
		loadProperties();
		// load the words per class
		readAllLines();
	}

	// load the properties
	private static void loadProperties() {
		try (InputStream inputStream = RandomWordUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_PATH)) {
			properties.load(inputStream);
		} catch (IOException e) {
			log.info("Could not read properties file from the path: " + PROPERTIES_FILE_PATH);
			e.printStackTrace();
		}
	}

	// load the words
	private static void readAllLines() {
		String path = null;
		try {
			path = properties.getProperty("path");
			words = Files.readAllLines(Paths.get(RandomWordUtil.class.getClassLoader().getResource(path).getPath()));
		} catch (IOException e) {
			log.info("Could not read words file from the path: " + path);
			e.printStackTrace();
		} catch (Exception e) {
			log.info("Error during reading the words file from the path: " + path);
			e.printStackTrace();
		}
	}

	// get a random word
	public static String getRandomWord() {
		// if the list of words is blank or null then return null
		if (words == null || words.isEmpty())
			return null;

		// Used ThreadLocalRandom as this will always create a new instance of
		// ThreadLocalRandom per thread
		// it is useful in multi threaded environment
		return words.get(ThreadLocalRandom.current().nextInt(words.size()));
	}

	public static void main(String[] args) {
		String str = RandomWordUtil.getRandomWord();
		System.out.println(str);
	}

}

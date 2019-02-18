package task3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileWriterReader {

	public static HashMap<Integer, String> fileToHashMap(String fileToRead) throws FileNotFoundException {
		Scanner reader = new Scanner(new File(fileToRead));
		int lineCount = 0;
		HashMap<Integer, String> poemLines = new HashMap<>();
		try {
			while (reader.hasNextLine()) {
				lineCount++;
				String fileLine = reader.nextLine();
				poemLines.put(lineCount, fileLine);
			}
		} finally {
			reader.close();
		}
		return poemLines;
	}

	public static void writeHashmapToFile(String fileToWrite, HashMap<Integer, String> hashmapToWrite)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite));
		try {
			int powersOf2 = 2;
			StringBuilder sb;
			for (Object objectName : hashmapToWrite.keySet()) {
				int key = (int) objectName;
				String line = hashmapToWrite.get(key);
				// System.out.println(key + "\t" + line);
				if (key == powersOf2) {
					sb = new StringBuilder();
					sb.append(key).append("\t").append(line).append(System.lineSeparator());
					bw.write(sb.toString());
					powersOf2 *= 2;
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e);

		} finally {
			bw.close();
		}
	}
}

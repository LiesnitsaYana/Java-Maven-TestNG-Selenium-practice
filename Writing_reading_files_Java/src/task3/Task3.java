package task3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Task3 {

	public static void main(String[] args) throws IOException {

		HashMap<Integer, String> fileToRead = FileWriterReader.fileToHashMap("HAMLET.txt");
		System.out.println(fileToRead);

		try {
			File file = new File("LINES_FROM_HAMLET.txt");
			if (!file.exists())
				file.createNewFile();

			FileWriterReader.writeHashmapToFile("LINES_FROM_HAMLET.txt", fileToRead);
		}

		catch (IOException e) {
			System.out.println("Erroe: " + e);
		}

	}

}

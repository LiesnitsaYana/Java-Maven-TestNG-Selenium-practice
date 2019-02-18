package homework5.homework5_team1;

import java.io.IOException;
import java.util.List;

import javax.naming.ConfigurationException;

public class App {
	public static void main(String[] args) throws IOException, ConfigurationException {

		try {
			List<Record> album = JsonParser.parseJson().getAlbum();
			System.out.println("The record list: \n" + album);

			MusicAlbum musicAlbum = new MusicAlbum();
			musicAlbum.recordsSorting(album);
		} catch (IOException ex) {
			throw new ConfigurationException("IO error " + ex);
		}
	}
}

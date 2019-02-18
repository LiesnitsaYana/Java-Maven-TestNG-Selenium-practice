package homework5.homework5_team1;

import java.io.File;
import java.io.IOException;
import javax.naming.ConfigurationException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	private static final String FILE = "src/main/resources/resource.json";

	public static MusicAlbum parseJson()
			throws IOException, JsonParseException, JsonMappingException, ConfigurationException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			MusicAlbum album = mapper.readValue(new File(FILE), MusicAlbum.class);
			return album;

		} catch (JsonParseException ex) {
			throw new ConfigurationException("The input is not valid JSON" + ex);
		} catch (JsonMappingException ex) {
			throw new ConfigurationException(
					"The input JSON doesn't match " + "the " + (MusicAlbum.class).getCanonicalName() + " class" + ex);
		} catch (IOException ex) {
			throw new ConfigurationException("IO error while reading the JSON" + ex);
		}
	}
}

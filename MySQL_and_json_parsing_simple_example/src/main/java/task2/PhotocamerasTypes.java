package task2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class PhotocamerasTypes {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		FileInputStream fis = new FileInputStream("src/main/resources/photocameras.json");
			
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		List<PhotocameraDTO> photocameras = objectMapper.readValue(fis, typeFactory.constructCollectionType(ArrayList.class, PhotocameraDTO.class));
		
		System.out.println(photocameras.get(3));

	}

}

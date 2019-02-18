package task2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotocameraDTO {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;

	@JsonProperty("sensor")
	private String sensor;

	@JsonProperty("lenses")
	private String lenses;

	@JsonProperty("display")
	private String display;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getSensor() {
		return sensor;
	}

	public String getLenses() {
		return lenses;
	}

	public String getDisplay() {
		return display;
	}

	@Override
	public String toString() {
		return ("PhotocameraDTO [id=" + id + ", name=" + name + ", type=" + type + ", sensor=" + sensor + ", lenses="
				+ lenses + ", display=" + display + "]");

	}
}

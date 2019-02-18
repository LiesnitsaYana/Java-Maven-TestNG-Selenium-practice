package homework5.homework5_team1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Record {

	private String groupName;
	private String songName;
	private double songDuration;

	@JsonProperty("groupname")
	public String getGroupName() {
		return groupName;
	}

	@JsonProperty("songname")
	public String getSongName() {
		return songName;
	}

	@JsonProperty("songduration")
	public double getSongDuration() {
		return songDuration;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public void setSongDuration(double songDuration) {
		this.songDuration = songDuration;
	}

	@Override
	public String toString() {
		return "Record [groupName=" + groupName + ", songName=" + songName + ", songDuration=" + songDuration + "] ";
	}

}

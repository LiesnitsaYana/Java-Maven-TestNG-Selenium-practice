package homework5.homework5_team1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MusicAlbum {

	@JsonProperty("musicAlbum")
	private List<Record> album;

	public List<Record> getAlbum() {
		return album;
	}

	@Override
	public String toString() {
		return "MusicAlbum [album=" + album + "]";
	}

	public void recordsSorting(List<Record> album) {
		Set<String> uniqueGroupNames = new HashSet<>();
		List<String> duplicateGroupNames = new ArrayList<>();
		List<Record> duplicatedGroup = new ArrayList<>();

		List<Record> sortedBySongName = album.stream().sorted((r1, r2) -> r1.getSongName().compareTo(r2.getSongName()))
				.collect(Collectors.toList());
		System.out.println("Sorted records list by song titles (in alphabetical order): \n" + sortedBySongName);
		for (Record r : album) {
			if (!uniqueGroupNames.add(r.getGroupName()))
				duplicateGroupNames.add(r.getGroupName());
		}
		for (Record r : album) {
			for (String s : duplicateGroupNames) {
				if ((r.getGroupName()).equals(s)) {
					duplicatedGroup.add(r);
				}
			}
		}
		System.out.println("The records list with duplicated group names: \n" + duplicatedGroup);
	}
}

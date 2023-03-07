package moviesong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecentPlayList {

	/*
	 * Created Variabe Capacity and Store List
	 */
	private int capacity; // 3
	private Map<String, List<String>> store;

	/*
	 * Constructor
	 */

	public RecentPlayList(int capacity) {
		this.capacity = capacity;
		this.store = new HashMap<>();
	}

	public void addRecentlyPlayedSong(String userId, String songId) {
		List<String> userHistory = store.getOrDefault(userId, new ArrayList<>());

		System.out.println(userHistory);

		if (userHistory.contains(songId)) {
			// If the song is already in the user's history, move it to the front of the
			userHistory.remove(songId);
		}

		userHistory.add(0, songId);

		System.out.println(userHistory);

		// Remove the least recently played song if the store is at capacity
		if (userHistory.size() > capacity) {
			userHistory.remove(capacity);
		}

		store.put(userId, userHistory);

		System.out.println(store);
	}

	public List<String> getRecentlyPlayedSongs(String userId) {
		return store.getOrDefault(userId, new ArrayList<>());
	}

}

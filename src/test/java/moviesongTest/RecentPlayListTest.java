package moviesongTest;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import moviesong.RecentPlayList;

public class RecentPlayListTest {

	@Test
	public void testAddRecentlyPlayedSong() {
		RecentPlayList store = new RecentPlayList(3);

		// User 1 plays 3 songs
		store.addRecentlyPlayedSong("user1", "song1");
		store.addRecentlyPlayedSong("user1", "song2");
		store.addRecentlyPlayedSong("user1", "song3");
		Assert.assertEquals(Arrays.asList("song3", "song2", "song1"), store.getRecentlyPlayedSongs("user1"));

		// User 1 plays 1 more song, pushing out the least recently played song (song1)
		store.addRecentlyPlayedSong("user1", "song4");
		Assert.assertEquals(Arrays.asList("song4", "song3", "song2"), store.getRecentlyPlayedSongs("user1"));

		// User 1 plays a previously played song (song2), moving it to the front of the
		// list
		store.addRecentlyPlayedSong("user1", "song2");
		Assert.assertEquals(Arrays.asList("song2", "song4", "song3"), store.getRecentlyPlayedSongs("user1"));

		// User 1 plays a previously played song (song3), moving it to the front of the
		// list and pushing out song2
		store.addRecentlyPlayedSong("user1", "song3");
		Assert.assertEquals(Arrays.asList("song3", "song2", "song4"), store.getRecentlyPlayedSongs("user1"));

		// User 2 plays a song for the first time
		store.addRecentlyPlayedSong("user2", "song5");
		Assert.assertEquals(Arrays.asList("song5"), store.getRecentlyPlayedSongs("user2"));
	}

}

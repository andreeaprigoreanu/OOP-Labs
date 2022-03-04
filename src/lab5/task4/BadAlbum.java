package lab5.task4;

import java.util.ArrayList;

public class BadAlbum extends Album {
    public BadAlbum() {
        songs = new ArrayList<Song>();
    }

    @Override
    public void addSong(Song song) {
        if (song.getName().length() != 3) {
            return;
        }

        int id = song.getId();
        int originalId = id;
        int reversedId = 0;

        while (originalId != 0) {
            reversedId = reversedId * 10 + originalId % 10;
            originalId /= 10;
        }

        if (reversedId == id) {
            songs.add(song);
        }
    }
}

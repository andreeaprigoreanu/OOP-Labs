package lab5.task4;

import java.util.ArrayList;

public class ThrillerAlbum extends Album {
    public ThrillerAlbum() {
        songs = new ArrayList<Song>();
    }

    @Override
    public void addSong(Song song) {
        if (song.getComposer().equals("Michael Jackson")) {
            songs.add(song);
        }
    }
}

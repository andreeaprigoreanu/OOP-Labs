package lab5.task4;

import java.util.ArrayList;

public class DangerousAlbum extends Album {
    public DangerousAlbum() {
        songs = new ArrayList<Song>();
    }

    @Override
    public void addSong(Song song) {
        int id = song.getId();

        if (id == 0 || id == 1) {
            return;
        }

        for (int d = 2; d * d < id; ++d) {
            if (id % d == 0) {
                return;
            }
        }

        songs.add(song);
    }
}

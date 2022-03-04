package lab5.task4;

import java.util.ArrayList;

abstract class Album {
    ArrayList<Song> songs;

    public abstract void addSong(Song song);

    public void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Album:{" +
                "songs=" + songs +
                '}';
    }
}

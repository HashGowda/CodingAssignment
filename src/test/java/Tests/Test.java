package Tests;

import PlayList.Playlist;
import Song.Song;
import utils.Constants;

public class Test {
    public static class SongDriver implements Constants {
        public static void main(String[] args) {
            Playlist one = new Playlist();

            Song song1 = new Song(songName1, artistName1, albumName1, trackLength1);
            Song song2 = new Song(songName2, artistName2, albumName2, trackLength2);
            Song song3 = new Song(songName3, artistName3, albumName3, trackLength3);
            Song song4 = new Song(songName4, artistName4, albumName4, trackLength4);
            Song song5 = new Song(songName5, artistName5, albumName5, trackLength5);
            Song song6 = new Song(songName6, artistName6, albumName6, trackLength6);
            Song song7 = new Song(songName7, artistName7, albumName7, trackLength7);

            one.add(song1);
            one.add(song2);
            one.add(song3);
            one.add(song4);
            one.add(song5);
            one.add(song6);
            one.add(song7);


            one.print();

            one.remove("679");

            one.print();

            one.remove("Watch Me");

            one.print();

            one.clear();
            one.print();
        }
    }
}

import java.util.ArrayList;
import java.util.LinkedList;

public class AlbumPlaylistInnerClass {
    // write code here
    private String name;
    private String artist;
    private SongList songs;

    // Constructor
    public AlbumPlaylistInnerClass(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    // Check for duplicated songs
    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    // add track to playlist
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong!=null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    // if song is in album then add to play list
    public boolean addToPlayList(String title, LinkedList<Song>playList) {
        Song checkedSong = songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    // inner class
    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        // add song to song list if not already there
        private boolean add(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        // check if song exists already
        private Song findSong(String title) {
            for(Song checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        // find song in song list and return its index
        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if((index >= 0) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }
}

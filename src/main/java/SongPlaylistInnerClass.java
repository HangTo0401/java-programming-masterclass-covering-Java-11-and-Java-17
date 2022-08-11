public class SongPlaylistInnerClass {
    // write code here
    private String title;
    private double duration;

    public SongPlaylistInnerClass(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}

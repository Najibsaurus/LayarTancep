package id.layar.layartancep.data;

public class Teve {

    public Teve(String mTitle, String mPosterPath, String overview){this.title = mTitle; this.poster_path = mPosterPath; this.overview = overview;  }

    private String title;
    private String poster_path;
    private String overview;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}

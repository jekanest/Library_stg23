public class Genres extends Books {

    private String genre = "Classic, Crime, ChildrenYoungAdults, SciFi, Drama, Autobiography, Horror, Adventure, HistoricalFiction,DystopianFiction, Fantasy";

    public Genres() {
    }

    public Genres(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

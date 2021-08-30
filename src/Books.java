public class Books {

    private int Id, genreId, year;
    private String Title, Author, placeId, language, publisher, availability;

    public Books() {
    }

    public Books(int id, int genreId, int year, String title, String author, String placeId, String language, String publisher, String availability) {
        this.Id = id;
        this.genreId = genreId;
        this.year = year;
        this.Title = title;
        this.Author = author;
        this.placeId = placeId;
        this.language = language;
        this.publisher = publisher;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Id=" + Id +
                ", genreId=" + genreId +
                ", year=" + year +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", placeId='" + placeId + '\'' +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}

public class Books {

    private int Id, genreId, year, availabilityId;
    private String Title, Author, language, publisher;

    public Books() {
    }

    public Books(int id, int genreId, int year, int availabilityId, String title, String author, String language, String publisher) {
        Id = id;
        this.genreId = genreId;
        this.year = year;
        this.availabilityId = availabilityId;
        Title = title;
        Author = author;
        this.language = language;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Id=" + Id +
                ", genreId=" + genreId +
                ", year=" + year +
                ", availabilityId=" + availabilityId +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
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

    public int getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(int availabilityId) {
        this.availabilityId = availabilityId;
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
}






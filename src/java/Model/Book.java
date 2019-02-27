package java.Model;

public class Book {
    private int isbn;
    private String title;
    private String[] authors;
    private String publisher;
    private String datePublished;
    private int pageCount;

    public Book(int isbn,
                String title,
                String authors,
                String publisher,
                String datePublished,
                int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors.split(",");
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.pageCount = pageCount;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getAuthorsAsString() {
        StringBuilder authorList = new StringBuilder();
        for (String author : authors) {
            authorList.append(author).append(",");
        }

        String authors = authorList.toString();

        return authors.substring(0, authors.lastIndexOf(","));
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public int getPageCount() {
        return pageCount;
    }
}

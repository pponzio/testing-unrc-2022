package testing.propertybased.teoria;

public class Book {

    private final String title;
    private final int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public static Book fromTitle(String title) {
        return new Book(title, 0);
    }

    public String getTitle() {
        return this.title;
    }
    
    public int getPages() {
        return this.pages;
    }

}
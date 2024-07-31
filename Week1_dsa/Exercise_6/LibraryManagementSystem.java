import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }

    public Book binarySearchByTitle(String title) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3, "1984", "George Orwell"));
        library.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));

        String searchTitle = "1984";
        Book book = library.linearSearchByTitle(searchTitle);
        if (book != null) {
            System.out.println("Linear Search - Book found: " + book);
        } else {
            System.out.println("Linear Search - Book not found.");
        }

        book = library.binarySearchByTitle(searchTitle);
        if (book != null) {
            System.out.println("Binary Search - Book found: " + book);
        } else {
            System.out.println("Binary Search - Book not found.");
        }
    }
}
 class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

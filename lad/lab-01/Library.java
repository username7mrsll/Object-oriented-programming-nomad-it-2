import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class Library {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();

        library.add(new Book("Мастер и Маргарита", "Михаил Булгаков"));
        library.add(new Book("Собачье сердце", "Михаил Булгаков"));
        library.add(new Book("Преступление и наказание", "Федор Достоевский"));
        library.add(new Book("Ведьмак", "Анджей Сапковский"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя автора для поиска: ");
        String searchAuthor = scanner.nextLine();

        System.out.println("Результаты поиска для автора \"" + searchAuthor + "\":");
        boolean found = false;

        for (Book book : library) {
            if (book.author.equalsIgnoreCase(searchAuthor)) {
                System.out.println("- " + book.title);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Книг данного автора не найдено.");
        }
    }
}
import java.util.Scanner;

class BookRecord {
	private String isbn;
	private String title;
	private double price;
	private String author;

	BookRecord(String isbn, String title, double price, String author) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	String getIsbn() {
		return isbn;
	}

	String getTitle() {
		return title;
	}

	double getPrice() {
		return price;
	}

	String getAuthor() {
		return author;
	}

	void update(String isbn, String title, double price, String author) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
	}
}

class BookStore {
	private final BookRecord[] books;
	private int size;

	BookStore(int capacity) {
		books = new BookRecord[capacity];
	}

	boolean add(BookRecord book) {
		if (size >= books.length) {
			return false;
		}
		books[size] = book;
		size++;
		return true;
	}

	BookRecord findByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equalsIgnoreCase(isbn)) {
				return books[i];
			}
		}
		return null;
	}

	BookRecord getAt(int index) {
		return books[index];
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}
}

class BookService {
	private final BookStore books = new BookStore(100);

	boolean addBook(String isbn, String title, double price, String author) {
		return books.add(new BookRecord(isbn, title, price, author));
	}

	BookRecord findBookByIsbn(String isbn) {
		return books.findByIsbn(isbn);
	}

	void updateBook(BookRecord book, String isbn, String title, double price, String author) {
		book.update(isbn, title, price, author);
	}

	void printAllBooks() {
		if (books.isEmpty()) {
			System.out.println("No books found.");
			return;
		}

		System.out.println("========================================================================");
		System.out.println("| No  | ISBN      | Title                      | Price  | Author         |");
		System.out.println("========================================================================");

		for (int i = 0; i < books.size(); i++) {
			BookRecord b = books.getAt(i);
			System.out.printf("| %-3d | %-9s | %-26s | %-6.2f | %-14s |%n", i + 1, b.getIsbn(), b.getTitle(), b.getPrice(), b.getAuthor());
		}
		System.out.println("========================================================================");
		System.out.println("Total books: " + books.size());
	}
}

public class ex3 {
	private final Scanner scanner = new Scanner(System.in);
	private final BookService bookService = new BookService();

	public static void main(String[] args) {
		new ex3().run();
	}

	private void run() {
		boolean running = true;

		while (running) {
			printMenu();
			int choice = readInt("Choose an option: ");
			System.out.println();

			switch (choice) {
				case 1:
					bookService.printAllBooks();
					break;
				case 2:
					handleAddBook();
					break;
				case 3:
					handleUpdateBook();
					break;
				case 4:
					running = false;
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println("Invalid option. Please choose 1-4.");
			}

			System.out.println();
		}
	}

	private void printMenu() {
		System.out.println("==== Menu ====");
		System.out.println("1. View all books");
		System.out.println("2. Add a new book");
		System.out.println("3. Update a book");
		System.out.println("4. Quit");
	}

	private void handleAddBook() {
		System.out.println("==== Add a new book ====");
		String isbn = readText("Input ISBN: ");
		String title = readText("Input title: ");
		double price = readDouble("Input price: ");
		String author = readText("Input author: ");

		if (bookService.addBook(isbn, title, price, author)) {
			System.out.println("Book added successfully.");
		} else {
			System.out.println("Book list is full.");
		}
	}

	private void handleUpdateBook() {
		System.out.println("==== Update a book ====");
		while (true) {
			String isbn = readText("Input ISBN: ");
			BookRecord book = bookService.findBookByIsbn(isbn);
			if (book != null) {
				System.out.println("Please update the following:");
				String newIsbn = readText("ISBN: ");
				String newTitle = readText("Title: ");
				double newPrice = readDouble("Price: ");
				String newAuthor = readText("Author: ");

				bookService.updateBook(book, newIsbn, newTitle, newPrice, newAuthor);
				System.out.println("Book updated successfully.");
				return;
			}
			System.out.println("Book is not found. Try again");
		}
	}

	private int readInt(String prompt) {
		System.out.print(prompt);
		String raw = scanner.nextLine();
		return Integer.parseInt(raw.trim());
	}

	private double readDouble(String prompt) {
		System.out.print(prompt);
		String raw = scanner.nextLine();
		return Double.parseDouble(raw.trim());
	}

	private String readText(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}
}

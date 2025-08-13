import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Java Programming", "James Gosling"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Data Structures", "Mark Allen Weiss"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowBook = library.findBook(borrowTitle);
                    if (borrowBook != null) borrowBook.borrowBook();
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.findBook(returnTitle);
                    if (returnBook != null) returnBook.returnBook();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

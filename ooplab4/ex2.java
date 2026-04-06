import java.util.Scanner;

class StudentRecord {
	private final String id;
	private final String name;
	private final int age;

	StudentRecord(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	String getId() {
		return id;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}
}

class StudentStore {
	private final StudentRecord[] students;
	private int size;

	StudentStore(int capacity) {
		students = new StudentRecord[capacity];
	}

	boolean add(StudentRecord student) {
		if (size >= students.length) {
			return false;
		}
		students[size] = student;
		size++;
		return true;
	}

	StudentRecord removeById(String id) {
		for (int i = 0; i < size; i++) {
			if (students[i].getId().equalsIgnoreCase(id)) {
				StudentRecord removed = students[i];
				for (int j = i; j < size - 1; j++) {
					students[j] = students[j + 1];
				}
				students[size - 1] = null;
				size--;
				return removed;
			}
		}
		return null;
	}

	StudentRecord getAt(int index) {
		return students[index];
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}
}

class StudentService {
	private final StudentStore students = new StudentStore(100);

	boolean addStudent(String id, String name, int age) {
		return students.add(new StudentRecord(id, name, age));
	}

	StudentRecord deleteStudentById(String id) {
		return students.removeById(id);
	}

	void printAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No students found.");
			return;
		}

		System.out.println("===================================================");
		System.out.println("| No  | ID        | Name                 | Age   |");
		System.out.println("===================================================");

		for (int i = 0; i < students.size(); i++) {
			StudentRecord s = students.getAt(i);
			System.out.printf("| %-3d | %-9s | %-20s | %-5d |%n", i + 1, s.getId(), s.getName(), s.getAge());
		}
		System.out.println("===================================================");
		System.out.println("Total students: " + students.size());
	}
}

public class ex2 {
	private final Scanner scanner = new Scanner(System.in);
	private final StudentService studentService = new StudentService();

	public static void main(String[] args) {
		new ex2().run();
	}

	private void run() {
		boolean running = true;

		while (running) {
			printMenu();
			int choice = readInt("Choose an option: ");
			System.out.println();

			switch (choice) {
				case 1:
					studentService.printAllStudents();
					break;
				case 2:
					handleAddStudent();
					break;
				case 3:
					handleDeleteStudent();
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
		System.out.println("1. View all students");
		System.out.println("2. Add a new student");
		System.out.println("3. Delete a student");
		System.out.println("4. Quit");
	}

	private void handleAddStudent() {
		System.out.println("==== Add a new student ====");
		String id = readText("Input student ID: ");
		String name = readText("Input student name: ");
		int age = readInt("Input student age: ");

		if (studentService.addStudent(id, name, age)) {
			System.out.println("Student added successfully.");
		} else {
			System.out.println("Student list is full.");
		}
	}

	private void handleDeleteStudent() {
		System.out.println("==== Delete a student ====");
		while (true) {
			String id = readText("Input student ID: ");
			StudentRecord deleted = studentService.deleteStudentById(id);
			if (deleted != null) {
				System.out.println("The following student has been deleted:");
				System.out.printf("| %s | %s | %d |%n", deleted.getId(), deleted.getName(), deleted.getAge());
				return;
			}
			System.out.println("Student is not found. Try again.");
		}
	}

	private int readInt(String prompt) {
		System.out.print(prompt);
		String raw = scanner.nextLine();
		return Integer.parseInt(raw.trim());
	}

	private String readText(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}
}

public class ex6 {
    class Student {
        int id, age;
        String name, gender, major;
        Student next;

        Student(String name) {
            this.name = name;
            this.next = null;
        }
    }

    class StudentList {
        Student head = null;

        void add(String name) {
            Student s = new Student(name);
            if (head == null) { 
                head = s; 
                return; 
            }
            Student curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = s;
        }

        void removeLast() {
            if (head == null) return;
            if (head.next == null) { 
                head = null; return; 
            }
            Student curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
        }

        void remove(int index) {
            if (index < 0 || head == null) { 
                System.out.println("Index is out of range"); 
                return; 
            }
            if (index == 0) { 
                head = head.next; 
                return; 
            }
            Student curr = head;
            for (int i = 0; i < index - 1; i++) {
                if (curr.next == null) { 
                    System.out.println("Index is out of range"); 
                    return; 
                }
                curr = curr.next;
            }
            if (curr.next == null) { 
                System.out.println("Index is out of range"); 
                return; 
            }
            curr.next = curr.next.next;
        }

        void clear() { head = null; }

        void display() {
            if (head == null) { 
                System.out.println("Array is emply"); 
                return; 
            }
            Student curr = head;
            while (curr != null) { 
                System.out.print(curr.name + " "); 
                curr = curr.next; 
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ex6 app = new ex6();
        StudentList myArr = app.new StudentList();

        System.out.println("==> Add");
        myArr.add("Lyda");
        myArr.add("both");
        myArr.add("phengroth");
        myArr.display();

        System.out.println("\n==> Remove at last");
        myArr.removeLast();
        myArr.add("hengrith");
        myArr.add("Caro");
        myArr.display();

        System.out.println("\n==> Remove at larger index");
        myArr.remove(10);

        System.out.println("==> Clear all element");
        myArr.clear();
        myArr.display();
    }
}
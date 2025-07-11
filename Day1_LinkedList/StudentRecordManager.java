package Day1_LinkedList;

import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManager {
    Student head = null;

    public void addAtBeginning(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos <= 0)
            return;
        if (pos == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null)
            return;
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRoll(int roll) {
        if (head == null)
            return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println(temp.rollNumber + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1.Add at beginning\n2.Add at end\n3.Add at position\n4.Delete by roll\n5.Search by roll\n6.Update grade\n7.Display all\n8.Exit");
            int choice = sc.nextInt();
            if (choice == 8)
                break;
            switch (choice) {
                case 1:
                    manager.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    manager.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    manager.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 4:
                    manager.deleteByRoll(sc.nextInt());
                    break;
                case 5:
                    manager.searchByRoll(sc.nextInt());
                    break;
                case 6:
                    manager.updateGrade(sc.nextInt(), sc.next());
                    break;
                case 7:
                    manager.displayAll();
                    break;
            }
        }
        sc.close();
    }
}

package Day2_JavaConstructor;

public class Person {
    private String name;
    private int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person anotherPerson) {
        this.name = anotherPerson.name;
        this.age = anotherPerson.age;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Person original = new Person("Nishant", 21);
        Person clone = new Person(original); // Using copy constructor

        System.out.println("Original Person:");
        original.displayDetails();

        System.out.println("\nCloned Person:");
        clone.displayDetails();
    }
}

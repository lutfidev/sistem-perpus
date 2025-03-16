import java.util.Scanner;

public abstract class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayRole();

    public void displayInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
    }

    public abstract void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner);
}
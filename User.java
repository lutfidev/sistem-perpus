import java.util.Scanner;

abstract class User {
    protected String id;
    protected String name;
 
    public User(String var1, String var2) {
       this.id = var1;
       this.name = var2;
    }
 
    public abstract void displayRole();
    public void displayInfo() {
       System.out.println("User ID: " + this.id);
       System.out.println("Name: " + this.name);
    }

    public abstract void interactWithLibrary(Perpustakaan perpustakaan, Scanner scanner);
}
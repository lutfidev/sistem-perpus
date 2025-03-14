class User {
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method yang akan dioverride (Polymorphism)
    public void displayInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
    }
}

// Child Class Admin
class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }

    // Override displayInfo() untuk menampilkan informasi khusus Admin
    @Override
    public void displayInfo() {
        System.out.println("List Admin:");
        super.displayInfo();
    }
}

// Child Class Member
class Member extends User {
    public Member(String id, String name) {
        super(id, name);
    }

    // Override displayInfo() untuk Member
    @Override
    public void displayInfo() {
        System.out.println("=== Member Info ===");
        super.displayInfo();
    }
}
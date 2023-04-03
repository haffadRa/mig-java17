package fr.record;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("John Doe", 30);
        System.out.println(p.name()); // John Doe
        System.out.println(p.age()); // 30
    }
}

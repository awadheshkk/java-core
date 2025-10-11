package org.example.serilization;

import java.io.*;

// Step 1: Class must implement Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // version control


    private int id;
    private transient String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Student s1 = new Student(101, "John Doe");

        if(s1 instanceof Serializable){
            System.out.println("s1 instanceof Serializable");
        }
        // ---- Serialization ----
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(s1);
            System.out.println("Object has been serialized: " + s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ---- Deserialization ----
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Object has been deserialized: " + s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

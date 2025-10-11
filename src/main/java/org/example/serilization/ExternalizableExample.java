package org.example.serilization;

import java.io.*;

class Employee implements Externalizable {
    private String name;
    private int age;
    private transient double salary; // won't be saved unless manually written

    // public no-arg constructor (MUST HAVE)
    public Employee() {}

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Custom serialization
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        // Manually deciding to include salary
        out.writeDouble(salary);
    }

    // Custom deserialization
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        salary = in.readDouble();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class ExternalizableExample {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee("John", 30, 50000.0);

        // Serialize
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
        oos.writeObject(emp);
        oos.close();

        // Deserialize
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"));
        Employee e = (Employee) ois.readObject();
        ois.close();

        System.out.println("Deserialized Employee: " + e);
    }
}

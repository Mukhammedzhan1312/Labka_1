import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;
    private String position;

    public Employee(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }
    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("ID: " + id + ", Имя: " + name +
                ", Должность: " + position +
                ", Зарплата: " + calculateSalary() + " тг.");
    }
}

class Worker extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Worker(String name, int id, String position, double hourlyRate, int hoursWorked) {
        super(name, id, position);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
class Manager extends Employee {
    private double fixedSalary;
    private double bonus;

    public Manager(String name, int id, String position, double fixedSalary, double bonus) {
        super(name, id, position);
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary + bonus;
    }
}

class StaffSystem {
    private List<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void displayAllEmployees() {
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

    public static void main(String[] args) {
        StaffSystem system = new StaffSystem();

        Worker worker1 = new Worker("Мухаммеджан", 1, "Рабочий", 500.0, 160);
        Worker worker2 = new Worker("Ержанат", 2, "Рабочий", 520.0, 150);
        Manager manager1 = new Manager("Шынгыс", 3, "Менеджер", 80000.0, 10000.0);
        system.addEmployee(worker1);
        system.addEmployee(worker2);
        system.addEmployee(manager1);

        system.displayAllEmployees();
    }
}

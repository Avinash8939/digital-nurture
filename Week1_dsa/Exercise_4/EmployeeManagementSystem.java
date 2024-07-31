public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            return true;
        } else {
            System.out.println("Cannot add employee. Array is full.");
            return false;
        }
    }

    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; 
    }

    public void traverseEmployees() {
        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployeeById(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null; 
                count--;
                return true;
            }
        }
        return false; 
    }

    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem managementSystem = new EmployeeManagementSystem(5);

        managementSystem.addEmployee(new Employee(1, "Alice", "Developer", 75000));
        managementSystem.addEmployee(new Employee(2, "Bob", "Manager", 85000));
        managementSystem.addEmployee(new Employee(3, "Charlie", "Analyst", 65000));

        managementSystem.traverseEmployees();

        Employee employee = managementSystem.searchEmployeeById(2);
        if (employee != null) {
            System.out.println("Employee found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        boolean deleted = managementSystem.deleteEmployeeById(2);
        if (deleted) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found for deletion.");
        }

        managementSystem.traverseEmployees();
    }
}

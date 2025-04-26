public class Employee {
    private int employeeID;
    private String name;
    private String email;
    private String hireDate;
    private static int numOfEmployee;
    private Job job;

    public Employee(int employeeID, String name, String email, String hireDate, String title, double salary,
            String jobDuty) {
        this.employeeID = employeeID;
        this.name = name;
        this.email = email;
        this.hireDate = hireDate;
        this.job = new Job(title, salary, jobDuty);
        numOfEmployee++;
    }
    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getHireDate() {
        return this.hireDate;
    }

    public static int getNumOfEmployee() {
        return numOfEmployee;
    }

    public Job getJob() {
        return new Job(this.job);
    }

    public static void updateNumOfEmployee() {
        numOfEmployee--;
    }
    public void setJob(Job job) {
        this.job = new Job(job);
    }

    public void setEmployeeID(int employeeID) {
        if (employeeID > 0)
            this.employeeID = employeeID;
            else 
            throw new IllegalArgumentException("Employee ID cannot stay empty!!");
    }

    public void setName(String name) {
        if (!name.equals(""))
            this.name = name;
            else 
            throw new IllegalArgumentException("Employee Name cannot stay empty!!");
    }

    public void setEmail(String email) {
        if (!email.equals(""))
            this.email = email;
            else 
            throw new IllegalArgumentException("Employee Email cannot stay empty!!");
    }

    public void setHireDate(String hireDate) {
        if (!hireDate.equals(""))
            this.hireDate = hireDate;
            else 
            throw new IllegalArgumentException("Employee Hired date cannot stay empty!!");
    }

    public String toString() {
        return "Employee ID: " +this.getEmployeeID() + "\n"
                + "Employee Name: " + this.getName() + "\n"
                + "Employee Email: " + this.getEmail() + "\n"
                + "Hired date: " + this.getHireDate() + "\n"
                + this.getJob().toString();
    }

}

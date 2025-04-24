public class Employee {
    private String name;
    private String email;
    private String hireDate;
    private static int numOfEmployee;
    private Job job;



public Employee(String name,String email, String hireDate, String jobID,String title, double salary, String jobDuty){
 this.name = name;
 this.email = email;
 this.hireDate = hireDate;
 this.job = new Job(title, salary, jobDuty);
 numOfEmployee++; 
}
public String getName(){return this.name;}
public String getEmail(){return this.email;}
public String getHireDate(){return this.hireDate;}
public static int getNumOfEmployee(){return numOfEmployee--;}
public Job getJob() { return new Job(this.job); }

public void setJob(Job job) {
    this.job = new Job(job);
 }

public void setName(String name){
 if(name.equals(""))
 this.name = name;
}
public void setEmail(String email){
if(email.equals(""))
this.email = email;
}
public void setHireDate(String hireDate){
if(hireDate.equals(""))
this.hireDate = hireDate;
}
public String toString(){
    return "Employee Name: " + this.getName() + "\n"
    + "Employee Email: " + this.getEmail() + "\n"
    + "Hired date: " + this.getHireDate() + "\n" 
    + this.getJob().toString();
}
    
}

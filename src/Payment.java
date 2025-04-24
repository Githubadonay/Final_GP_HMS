public class Payment {
    private String paymentID;
    private String paymentMethod;
    private String paymentDate;
    private double paymentBalance; 

    Payment(){
        this.paymentID = "";
        this.paymentMethod = "";
        this.paymentDate = "";
        this.paymentBalance = 0;
    }

    Payment(String paymentID, String paymentMethod, String paymentDate, double paymentBalance){
        this.paymentID = "";
        this.paymentMethod = "";
        this.paymentDate = "";
        this.paymentBalance = 0;
    }

    //Accessors (getter methods)
    public String getpaymentID (){
        return this.paymentID;
    }
    public String getpaymentMethod (){
        return this.paymentMethod;
    }
    public String getpaymentDate (){
        return this.paymentDate;
    }
    public double getpaymentBalance(){
        return this.paymentBalance;
    }
    //mutators (setter methods)
    public void setpaymentID (String paymentID){
    if(paymentID.equals("") && paymentID.length() != 5)
        throw new IllegalArgumentException(" Error! The payment ID cannot be blank and must have a length of 5");
    else 
        this.paymentID = paymentID;
    }
    public void setpaymentMethod (String paymentMethod){
    if(!paymentMethod.equals(""))
        this.paymentMethod = paymentMethod;
    else
        throw new IllegalArgumentException("Error! Please fill out the field");
    }
    //validation using is digit 
    public void setpaymentDate (String paymentDate){
        this.paymentDate = paymentDate;
    }
    public void setpaymentBalance (double paymentBalance){
        if (paymentBalance>0)
        this.paymentBalance = paymentBalance;
    else 
        throw new IllegalArgumentException("Error! Please enter a valid number");
    }

    //toString method 
    public String toString (){
        return this.getpaymentID() + " | "  + 
        this.getpaymentMethod() + " | "  + 
        this.getpaymentDate() + " | "  + 
        this.getpaymentBalance(); 
    }

}

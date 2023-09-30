public class Employee extends AbstrEmp {
    String name;
    int payment;

    public Employee(String name, int payment){
        super(name, payment);
        this.name = name;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public int getPayment() {
        return payment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void printInfo(){
        System.out.println("name: "+name+"\nPayment: "+payment);
    }
}

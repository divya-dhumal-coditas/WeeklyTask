package week1;
abstract class Employee{
    String name;
    double baseSalary;
    int attendanceDays;
    int rating;
    static final double PF = 0.12;

    public Employee(String name, double baseSalary, int attendanceDays, int rating){
        this.name = name;
        this.baseSalary = baseSalary;
        this.attendanceDays = attendanceDays;
        this.rating = rating;
    }

    // gross salary for each employee type
    abstract double calculateGrossSalary();
    void generateSalarySlip(){
        double gross = calculateGrossSalary();
        double dailySalary = baseSalary / 30;
        int absentDays = 30 - attendanceDays;

        double attendanceDeduction = dailySalary * absentDays;

        double bonusPercent =0;
        if (rating == 5) bonusPercent = 0.20;
        else if (rating == 4) bonusPercent = 0.15;
        else if (rating == 3) bonusPercent = 0.10;
        else if (rating == 2) bonusPercent = 0.05;

        double bonus = gross * bonusPercent;

        double pf = baseSalary * PF;

        //tax calculation
        double taxableIncome = gross + bonus;
        double taxRate;
        if(taxableIncome <= 50000)
            taxRate = 0.05;
        else if(taxableIncome <= 100000)
            taxRate = 0.10;
        else if(taxableIncome <= 150000)
            taxRate = 0.15;
        else taxRate = 0.20;

        double tax = taxableIncome * taxRate;

        //net salary
        double netSalary = gross + bonusPercent - tax - pf - attendanceDeduction;

        System.out.println("\n Salary Slip for:" + name);
        System.out.println("\n Gross Slip :" +gross);
        System.out.println("\n Bonus:" +bonus);
        System.out.println("\n Attendance Deduction:" + attendanceDeduction);
        System.out.println("\n PF:" +pf);
        System.out.println("\n TAX:" +tax);
        System.out.println("\n Net Salary:" +netSalary);

    }

}


class Developer extends Employee{
    int overtime;
    Developer(String name, double baseSalary, int attendanceDays, int ratings, int overtime){
        super(name, baseSalary, attendanceDays,ratings);
        this.overtime = overtime;

    }

    @Override
    double calculateGrossSalary() {
        return 0;
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, double baseSalary, int attendanceDays, int ratings, int teamSize) {
        super(name, baseSalary, attendanceDays, ratings);
        this.teamSize = teamSize;
    }

    @Override
    double calculateGrossSalary() {
        return 0;
    }
}


//Intern
class Intern extends Employee{
    Intern(String name, double baseSalary, int attendanceDays,int ratings){
        super(name, baseSalary,attendanceDays, ratings);
    }
    @Override
    double calculateGrossSalary() {
        double percent = (double) (attendanceDays + 100) /30;
        if(percent < 70)
            return baseSalary -(baseSalary * 0.20);
        return baseSalary;
    }
}



public class Week1_Task {
    public static void main(String[] args){
        Employee developer1 = new Developer ("Divya",80000, 28,5,8);

        Employee manager1 = new Manager ("Sahil",10000, 22,5,10);
        Employee intern1 = new Intern ("Soha",40000, 18,3);

        developer1.generateSalarySlip();
        intern1.generateSalarySlip();
        manager1.generateSalarySlip();

    }
}

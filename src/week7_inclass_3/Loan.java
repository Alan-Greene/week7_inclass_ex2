package week7_inclass_3;

public class Loan {
    public final int MONTHS_IN_YEAR = 12;
    double loan_amount = 0.0;
    double monthly_interest_rate =0.0;
    int number_of_payments = 0;

    public Loan(double loan_amount, double annual_interest_rate, int number_of_years){
        this.loan_amount = loan_amount;
        this.monthly_interest_rate = annual_interest_rate / 100 / MONTHS_IN_YEAR;
        this.number_of_payments = number_of_years * MONTHS_IN_YEAR;
    }

    public int getNumber_of_payments(){
        return this.number_of_payments;
    }

    public double getRate(){
        return this.monthly_interest_rate * 12;
    }

    public void setRate(double annual_interest_rate) {
        this.monthly_interest_rate = annual_interest_rate / 100 / MONTHS_IN_YEAR;
    }

    public void setNumber_of_payments(int number_of_years){
        this.number_of_payments = number_of_years * MONTHS_IN_YEAR;
    }

    public double get_monthly_payment(){
        return (loan_amount * monthly_interest_rate) / (1 - Math.pow(1/(1 + monthly_interest_rate), (number_of_payments)));
    }

    public void print(){
        System.out.printf("%-30s %-30s%n", "Monthly Payment", "Total Payment");
        System.out.printf("%,-30.2f %,-30.2f%n", this.get_monthly_payment(), this.get_monthly_payment() * this.getNumber_of_payments());
    }

}

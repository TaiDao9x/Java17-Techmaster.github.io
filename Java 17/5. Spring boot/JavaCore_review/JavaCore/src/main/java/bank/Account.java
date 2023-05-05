package bank;

import java.text.DecimalFormat;

public class Account {
    private long accountNumber;
    private String accountName;
    private double money;
    private final double interestRate = 0.035;

    public Account() {
    }

    public Account(long accountNumber, String accountName, double money) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.money = money;
    }

    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.money = 50;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void depositMoney(double money) {
        this.money += money;
    }

    public void withdrawMoney(double money) {
        this.money -= money;
    }

    @Override
    public String toString() {
        DecimalFormat dcf = new DecimalFormat("#,###.##");
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", money=" + dcf.format(money) +
                '}';
    }
}

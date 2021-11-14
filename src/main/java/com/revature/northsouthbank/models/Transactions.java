package com.revature.northsouthbank.models;

public class Transactions {

    private String id;
    private double currentBalance;
    private double deposits;
    private double withdrawls;
    private AppUser accountHolder;


    public Transactions(double currentBalance, double deposits, double withdrawls) {
        this.currentBalance = currentBalance;
        this.deposits = deposits;
        this.withdrawls = withdrawls;
    }

    public Transactions(double currentBalance, double deposits, double withdrawls, AppUser accountHolder) {
        this(currentBalance, deposits, withdrawls);
        this.accountHolder = accountHolder;
    }

    public Transactions(String id, double currentBalance, double deposits, double withdrawls, AppUser accountHolder) {
        this(currentBalance, deposits, withdrawls, accountHolder);
        this.id = id;
    }

    public Transactions() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getDeposits() {
        return deposits;
    }

    public void setDeposits(double deposits) {
        this.deposits = deposits;
    }

    public double getWithdrawls() {
        return withdrawls;
    }

    public void setWithdrawls(double withdrawls) {
        this.withdrawls = withdrawls;
    }

    public AppUser getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AppUser accountHolder) {
        this.accountHolder = accountHolder;
    }
}

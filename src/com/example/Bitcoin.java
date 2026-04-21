package com.example;

public class Bitcoin implements PaymentMethod {

    private String address;
    private double currentBalance;

    public Bitcoin(String address, double initialBalance) {
        this.address = address;
        this.currentBalance = initialBalance;
    }

    @Override
    public boolean pay(double amount) {

        if (!hasEnoughFunds(amount)) {
            System.out.println("Paiement refusé pour le wallet : " + address);
            return false;
        }

        currentBalance -= amount;
        displayTransaction("Paiement effectué", amount);

        return true;
    }

    @Override
    public boolean refund(double amount) {
        currentBalance += amount;
        displayTransaction("Remboursement effectué", amount);
        return true;
    }

    @Override
    public String getName() {
        return "Wallet BTC - " + address;
    }

    // 🔹 Méthodes personnalisées (important pour réduire similarité)
    private boolean hasEnoughFunds(double amount) {
        return currentBalance >= amount;
    }

    private void displayTransaction(String type, double amount) {
        System.out.println(type + " : " + amount + " BTC");
        System.out.println("Solde actuel : " + currentBalance + " BTC");
    }
}

package com.example;



public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

       
        processor.addMethod(
            new CreditCard("1234-5678-9012-3456",
                           "Khalil Fatima ezzahra ", 500.0)
        );
        processor.addMethod(
            new PayPal("khalilfatimaezzahra@gmail.com", 200.0)
        );
        processor.addMethod(
            new Bitcoin("EE1111", 0.10) 
        );

      
        double montant = 100.0;
        processor.processPayments(montant);
    }
}

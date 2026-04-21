package com.exemple.tp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        NotificationManager manager = new NotificationManager();

        setupChannels(manager);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le destinataire : ");
        String receiver = scanner.nextLine();

        System.out.print("Entrez le message : ");
        String message = scanner.nextLine();

        sendNotification(manager, receiver, message);

        scanner.close();
    }

    private static void setupChannels(NotificationManager manager) {
        manager.addChannel(new EmailNotification("service@myapp.com"));
        manager.addChannel(new SMSNotification("+212600000000"));
        manager.addChannel(new PushNotification("app.unique.id"));
    }

    private static void sendNotification(NotificationManager manager, String receiver, String message) {
        System.out.println("Envoi des notifications en cours...");
        manager.broadcast(receiver, message);
        System.out.println("Notifications envoyées avec succès !");
    }
}

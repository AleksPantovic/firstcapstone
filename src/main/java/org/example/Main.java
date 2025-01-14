package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Bank account= new Bank("Aleksandar Pantovic",500);
        int choice;
        do {
            System.out.println("\nBanking Application Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Previous Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0;
            }
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.CheckBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = Double.parseDouble(scanner.nextLine());
                    if(account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful.");
                    }
                    else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    List<String> transactions = account.getTransactions();
                    if (transactions.isEmpty()) {
                        System.out.println("No previous transactions found.");
                    } else {
                        System.out.println("Previous Transactions:");
                        for (String transaction : transactions) {
                            System.out.println(transaction);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int ans = sc.nextInt();
        if (ans == 1 ) {
            System.out.println("Вы выбрали первый вариант");
            Scanner scanner = new Scanner(System.in);
            String sourceDirectory = scanner.next();
            Task1.createBackup(sourceDirectory); // РЕЗЕРВНАЯ КОПИЯ СОХРАНЯЕТСЯ В ТУ ЖЕ ПАПКУ, КОТОРАЯ КОПИРОВАЛАСЬ!
        } else if (ans == 2 ) {
            System.out.println("Вы выбрали второй вариант");
            Task2.newGame();
        }
    }
}
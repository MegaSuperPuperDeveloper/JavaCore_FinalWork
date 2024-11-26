package com.example;

import java.util.Scanner;

public class Task2 {

    public static byte[][] field = new byte[3][3];

    public static void newGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 0;
            }
        }
        startGame();
    }

    public static void getField() {
        System.out.println("Названия столбцов: a, b, c");
        System.out.println("Названия строк: a, b, c");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(String.valueOf(field[i][j]) + " ");
            }
            System.out.print("\n\n");
        }
    }

    public static void startGame() {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Как ходить? Например: \"aa\", \"ac\", где первая буква это столбец, а вторая буква строка");
        while (true) {
            getField();
            System.out.println("Ход крестиков");
            System.out.print("Введите: ");
            input = sc.nextLine();
            changeField(input, 1);
            System.out.println();


            getField();
            System.out.println("Ход ноликов");
            System.out.print("Введите: ");
            input = sc.nextLine();
            changeField(input, 2);
            checkWin();
            System.out.println();
        }
    }

    private static boolean changeField(String s, int c) {
        String[] sc = s.split("");
        int a = 0, b = 0;

        if (sc.length != 2) {
            return false;
        }

        // Проверяем корректность ввода (a, b, c)
        if (!sc[0].equals("a") && !sc[0].equals("b") && !sc[0].equals("c") ||
            !sc[1].equals("a") && !sc[1].equals("b") && !sc[1].equals("c")) {
                return false;
        }

        // Преобразуем символы в индексы
        if (sc[0].equals("a")) {
            a = 0;
        } else if (sc[0].equals("b")) {
            a = 1;
        } else if (sc[0].equals("c")) {
            a = 2;
        }

        if (sc[1].equals("a")) {
            b = 0;
        } else if (sc[1].equals("b")) {
            b = 1;
        } else if (sc[1].equals("c")) {
            b = 2;
        }

        // Проверяем, что клетка не занята
        if (field[a][b] != 0) {
            return false;
        }

        field[a][b] = (byte) c;
        return true;
    }

    private static void checkWin() {
        int counterX, counterY;
        int counterDiagonal1 = 0;
        int counterDiagonal2 = 0;

        int whoIsIt = 0;

        for (int i = 0; i < 3; i++) {
            counterX = 0;
            counterY = 0;

            for (int j = 0; j < 3; j++) {
                // Проверка горизонтали
                if (field[i][j] == field[i][0] && field[i][0] != 0) {
                    counterX++;
                    whoIsIt = field[i][j];
                }

                // Проверка вертикали
                if (field[j][i] == field[0][i] && field[0][i] != 0) {
                    counterY++;
                    whoIsIt = field[j][i];
                }

                // Проверка диагонали слева направо
                if (i == j && field[j][j] == field[0][0] && field[0][0] != 0) {
                    counterDiagonal1++;
                    whoIsIt = field[j][j];
                }

                // Проверка диагонали справа налево
                if (i + j == 2 && field[i][j] == field[0][2] && field[0][2] != 0) {
                    counterDiagonal2++;
                    whoIsIt = field[i][j];
                }
            }

            // Победа в строке или столбце
            if (counterX == 3 || counterY == 3) {
                if (whoIsIt == 1) {
                    System.out.println("Крестики победили");
                } else if (whoIsIt == 2) {
                    System.out.println("Нолики победили");
                }
                newGame();
            }
        }

        // Победа на диагоналях
        if (counterDiagonal1 == 3 || counterDiagonal2 == 3) {
            if (whoIsIt == 1) {
                System.out.println("Крестики победили");
            } else if (whoIsIt == 2) {
                System.out.println("Нолики победили");
            }
            newGame();
        }
    }

}
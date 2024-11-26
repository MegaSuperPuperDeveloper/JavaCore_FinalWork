package com.example;

import java.io.*;
import java.nio.file.*;

public class Task1 {

    public static void createBackup(String sourceDirectoryPath) {
        // Путь к папке для резервного копирования
        Path sourceDirPath = Paths.get(sourceDirectoryPath);
        Path backupDirPath = sourceDirPath.resolve("backup");

        try {
            // Создаем папку ./backup, если ее нет
            if (!Files.exists(backupDirPath)) {
                Files.createDirectory(backupDirPath);
                System.out.println("Папка 'backup' создана");
            }

            // Проходим по всем файлам в исходной директории (без поддиректорий)
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirPath, path -> Files.isRegularFile(path))) {
                for (Path filePath : stream) {
                    // Формируем путь для файла в папке backup
                    Path destinationPath = backupDirPath.resolve(filePath.getFileName());

                    // Копируем файл
                    Files.copy(filePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл скопирован: " + filePath.getFileName());
                }
            } catch (IOException e) {
                System.out.println("Ошибка при перечислении файлов: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Ошибка при создании папки 'backup': " + e.getMessage());
        }
    }

}

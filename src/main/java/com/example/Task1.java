package com.example;

import java.io.*;
import java.nio.file.*;

public class Task1 {

    public static void createBackup(String sourceDirectoryPath) {
        Path sourceDirPath = Paths.get(sourceDirectoryPath);
        Path backupDirPath = sourceDirPath.resolve("backup");

        try {

            if (!Files.exists(backupDirPath)) {

                Files.createDirectory(backupDirPath);
                System.out.println("Папка 'backup' создана");

            }

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDirPath, path -> Files.isRegularFile(path))) {
                for (Path filePath : stream) {

                    Path destinationPath = backupDirPath.resolve(filePath.getFileName());
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

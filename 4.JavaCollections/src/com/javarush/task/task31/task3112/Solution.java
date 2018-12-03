package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads")); //"D:/MyDownloads"

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL urlToDownload = new URL(urlString);
        String[] urlSplit = urlString.split("/");
        String fileName = urlSplit[urlSplit.length-1];
        //Path tempDir = Files.createTempDirectory("tempDir - ");
        InputStream inputStream = urlToDownload.openStream();

        Path fileFormUrl = Files.createTempFile("", ".txt");
        Files.copy(inputStream, fileFormUrl, StandardCopyOption.REPLACE_EXISTING);
        Path fileDownload = Paths.get(downloadDirectory.toString() + "/" + fileName);
        Files.move(fileFormUrl, fileDownload);
        return fileDownload;
    }
}

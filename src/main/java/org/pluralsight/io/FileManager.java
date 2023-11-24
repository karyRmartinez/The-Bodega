package org.pluralsight.io;

import java.io.*;

public class FileManager {

    public String readFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String fileLine = null;
            while((fileLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(fileLine).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.printf("Oops could not read from File:%s",filePath);
        }

        return stringBuilder.toString();
    }

    public void writeToFile(String filePath, String fileContents) {
        File file = new File(filePath);

        try {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(fileContents);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.printf("Oops could not write to File:%s",filePath);
        }
    }
}

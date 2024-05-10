package utils;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public static void readFile(String filePath, ArrayList<String> listQuestions){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                listQuestions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(String filePath, Object toWrite, Boolean isAppend){

        try (FileWriter arquivo = new FileWriter(filePath, isAppend)){
            arquivo.write(toWrite.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeLineFile(String filePath, int toRemove){
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("tempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            int lineNmber = 1;

            while ((currentLine = reader.readLine()) != null){
                if (lineNmber != toRemove){
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                lineNmber++;
            }
            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

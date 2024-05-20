package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                    writer.write(currentLine + System.lineSeparator());
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

    public static void remove(String filePath, int lineNumberToRemove) {
        List<String> lines = new ArrayList<>();

        // Read the file and store lines in the list, adjusting numbers as needed
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                currentLine++;
                if (currentLine != lineNumberToRemove) {
                    if (currentLine > lineNumberToRemove) {
                        // Adjust the question number
                        int questionNumberEndIndex = line.indexOf(" - ");
                        if (questionNumberEndIndex != -1) {
                            int questionNumber = Integer.parseInt(line.substring(0, questionNumberEndIndex));
                            questionNumber--;
                            line = questionNumber + line.substring(questionNumberEndIndex);
                        }
                    }
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the lines back to the file, excluding the removed line
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package application;

import java.util.ArrayList;

import static utils.ReadFile.readFile;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listQuestions = new ArrayList<>();

        readFile("src/formulario.txt", listQuestions);

        for (String i: listQuestions) {
            System.out.println(i);
        }
    }
}
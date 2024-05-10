package application;

import entities.Client;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.ReadFile.readFile;
import static utils.SaveFile.saveFile;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listQuestions = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();

        readFile("src/formulario.txt", listQuestions);

        String name = null, email = null;
        int age = 0;
        float height = 0;

        for (int i = 0; i < listQuestions.size(); i++) {
            System.out.println(listQuestions.get(i));
            switch (i){
                case 0:
                    name = sc.nextLine();
                    break;
                case 1:
                    email = sc.nextLine();
                    break;
                case 2:
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, insira uma idade válida:");
                        sc.next();
                    }
                    age = sc.nextInt();
                    break;
                case 3:
                    while (!sc.hasNextFloat()) {
                        System.out.println("Por favor, insira uma altura válida:");
                        sc.next();
                    }
                    height = sc.nextFloat();
                    break;
            }
        }

        clients.add(new Client(name,
                email,
                age,
                height));

        for (Client c:
             clients) {
            saveFile(c, clients);
        }

    }
}
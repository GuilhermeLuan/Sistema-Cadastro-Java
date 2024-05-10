package application;

import entities.Client;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.Menu.*;
import static utils.FileUtil.readFile;
import static utils.FileUtil.saveFile;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listQuestions = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        Client client = new Client();
        readFile("src/formulario.txt", listQuestions);

        int input;
        do{
            showMenu();
            input = sc.nextInt();

            switch (input){
                case 1:
                    String name = null, email = null;
                    int age = 0;
                    float height = 0;
                    sc.nextLine();
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
                    client = new Client(name, email, age, height);
                    clients.add(client);
                break;

                case 2:
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.println(i + 1 + " - " + clients.get(i).getName());
                    }
                    break;
                case 3:
                    System.out.println("Qual pergunta deseja adicionar no arquivo?");
                    sc.nextLine();
                    String newQuestion = sc.nextLine();
                    newQuestion = listQuestions.size() + 1 + " - " + newQuestion;
                    addQuestionFile(newQuestion);
                    break;
                case 4:
                    System.out.println("Qual número da pergunta que deseja excluir?");
                    int indexQuestion = sc.nextInt();
                    removeQuestion(indexQuestion);
                    break;
                case 5:


                    break;
            }

            for (Client c: clients) {
                String filePath = clients.indexOf(client) + 1 + "-" +
                        client
                                .getName()
                                .toUpperCase()
                                .replaceAll(" ", "") + ".txt";

                saveFile(filePath, client, false);
            }

        } while (input != 6);
    }
}
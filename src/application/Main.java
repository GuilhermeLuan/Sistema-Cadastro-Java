package application;

import entities.Client;
import entities.exceptions.AgeException;
import entities.exceptions.EmailException;
import entities.exceptions.HeightException;
import entities.exceptions.NameException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static entities.Client.registerUser;
import static entities.validate.Validate.*;
import static utils.FileUtil.*;
import static utils.Menu.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listQuestions = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        Client client;
        readFile("src/formulario.txt", listQuestions);

        int input;
        do{
            showMenu();
            input = sc.nextInt();

            switch (input){
                case 1:
                    String name = null, email = null, newQuestionInput = null;
                    int age = 0;
                    String height = null;
                    sc.nextLine();
                    for (int i = 0; i < listQuestions.size(); i++) {
                        System.out.println(listQuestions.get(i));
                        switch (i){
                            case 0:
                                boolean validName = false;
                                while (!validName){
                                    try {
                                        name = sc.nextLine();
                                        validateName(name);
                                        validName = true;
                                    } catch (NameException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Insira o nome novamente:");
                                    }
                                }
                                break;
                            case 1:
                                boolean validEmail = false;
                                while (!validEmail){
                                    try{
                                        email = sc.nextLine();
                                        validateEmail(clients, email);
                                        validEmail = true;
                                    } catch (EmailException e){
                                        System.out.println(e.getMessage());
                                        System.out.println("Insira o email novamente:");
                                    }
                                }
                                break;
                            case 2:
                                boolean validAge = false;
                                while (!validAge){
                                    try {
                                        age = sc.nextInt();
                                        validateAge(age);
                                        validAge = true;
                                    } catch (AgeException e){
                                        System.out.println(e.getMessage());
                                        System.out.println("Insira o idade novamente: ");
                                        sc.nextLine();
                                    } catch (InputMismatchException e){
                                        System.out.println("A idade pode ser apenas numeros.");
                                        System.out.println("Insira o nome novamente: ");
                                        sc.nextLine();

                                    }
                                }
                                break;
                            case 3:
                                boolean validHeight = false;
                                while (!validHeight){
                                    try {
                                        height = sc.next();
                                        validateHeight(height);
                                        validHeight = true;
                                    } catch (HeightException e){
                                        System.out.println(e.getMessage());
                                        System.out.println("Insira o altura novamente: ");
                                    } catch (InputMismatchException e){
                                        System.out.println("A altura pode ser apenas numeros.");
                                        System.out.println("Insira o nome novamente: ");
                                    }
                                }
                                break;
                            default:
                                //System.out.println(i);
                                if (i == 4) sc.nextLine();
                                newQuestionInput = sc.nextLine().trim();
                                listNewAnswers.add(newQuestionInput);
                                break;
                        }
                    }
                    client = new Client(name, email, age, height);
                    if(!listNewAnswers.isEmpty()){
                        for (String listNewAnswer : listNewAnswers) {
                            client.addResponse(listNewAnswer);
                        }
                    }
                    registerUser(client, clients);
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
                    newQuestion = (listQuestions.size() + 1) + " - " + newQuestion;
                    listQuestions.add(newQuestion);
                    addQuestionFile("\n" + newQuestion);
                    break;
                case 4:
                    System.out.println("Qual número da pergunta que deseja excluir?");
                    int indexQuestion = sc.nextInt();
                    removeQuestion(indexQuestion, listQuestions);

                    break;
                case 5:
                    System.out.println("Pesquisar usuário por nome ou idade ou email, nome ou email: ");
                    sc.nextLine();
                    String search = sc.nextLine();
                    ArrayList<Client> searchResult = Client.searchClient(clients, search);

                    for (Client c : searchResult) {
                        System.out.println(c);
                    }

                    break;
            }

        } while (input != 6);

        for (Client c: clients) {
            String filePath = clients.indexOf(c) + 1 + "-" + c
                            .getName()
                            .toUpperCase()
                            .replaceAll(" ", "") + ".txt";
            saveFile(filePath, c, false);
        }
    }
}
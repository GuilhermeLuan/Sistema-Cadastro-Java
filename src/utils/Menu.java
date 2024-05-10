package utils;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.SaveFile.saveFile;

public class Menu {

    private final ArrayList<String> listQuestions = new ArrayList<>();
    static final Scanner sc = new Scanner(System.in);
    public static void showMenu(){
        System.out.println(
                "1 - Cadastrar o usuário\n" +
                "2 - Listar todos usuários cadastrados\n" +
                "3 - Cadastar nova pergunta no formulário\n" +
                "4 - Deletar perguntas no formulário\n" +
                "5 - Pesquisar usuário por nome ou idade ou email\n" +
                "6 - Sair do Menu\n"
        );
    }
    public static void cadastrarNovaPergunta(){
        String newQuestion = sc.nextLine();
        saveFile();
    }
}

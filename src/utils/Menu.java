package utils;

import java.util.ArrayList;

import static utils.FileUtil.removeLineFile;
import static utils.FileUtil.saveFile;

public class Menu {
    public static void showMenu(){
        System.out.println(
                """
                        1 - Cadastrar o usuário
                        2 - Listar todos usuários cadastrados
                        3 - Cadastar nova pergunta no formulário
                        4 - Deletar perguntas no formulário
                        5 - Pesquisar usuário por nome ou idade ou email
                        6 - Sair do Menu
                        """
        );
    }
    public static void addQuestionFile(String newQuestion){
        saveFile("src/formulario.txt", newQuestion, true);
    }
    
    public static void removeQuestion(int indexQuestion, ArrayList<String> listQuestions){
        if(indexQuestion < 4){
            System.out.println("Não é possível apagar as 4 primeiras perguntas");
            return;
        }

        for (int i = 0; i < listQuestions.size(); i++) {
            listQuestions.remove(indexQuestion - 1);
        }
        removeLineFile("src/formulario.txt", indexQuestion);
    }

}

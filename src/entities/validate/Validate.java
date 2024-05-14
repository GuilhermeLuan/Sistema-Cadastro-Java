package entities.validate;

import entities.exceptions.AgeException;
import entities.exceptions.EmailException;
import entities.exceptions.HeightException;
import entities.exceptions.NameException;

public class Validate {
    public static void validateName(String name) throws NameException {
        if(name.length() < 10){
            throw new NameException("O nome deve ter pelo menos 10 caracteres.");
        }
    }

    public static void validateEmail(String email) throws EmailException {
        if(!email.contains("@")){
            throw new EmailException("O email não é valido.");
        }
    }

    public static void validateAge(int age) throws AgeException {
        if(age < 18){
            throw new AgeException("A idade deve ser maior que 18.");
        }
    }

    public static void validateHeight(String height) throws HeightException {
        if(!height.matches("\\d+,\\d+")){
            throw new HeightException("O formato da altura não é valido.");
        }
    }
}

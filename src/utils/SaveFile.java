package utils;

import entities.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SaveFile {
    public static void saveFileClient(Client client, ArrayList<Client> clients){

        String filePath = clients.indexOf(client) + 1 + "-" + client.getName().toUpperCase().replaceAll(" ", "") + ".txt";
        try (FileWriter arquivo = new FileWriter(filePath)){
            arquivo.write(client.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveFile(String filePath, Object toWrite){

        try (FileWriter arquivo = new FileWriter(filePath)){
            arquivo.write(toWrite.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

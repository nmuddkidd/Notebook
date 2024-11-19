package io.github.nmuddkidd;
import io.github.nmuddkidd.Displays.Notebook;
import io.github.nmuddkidd.Displays.Questions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        JSONObject source = null;
        Settings settings;
        Notebook notebook;
        Questions questions;

        try {
            source = initialRead(); //TODO -- implement: json sourcing
        } catch (IOException e) {
            System.out.println("A fatal error has occurred in reading the json file");
            System.out.println("Exiting the program");
            exit(-1);
        } catch (JSONException e) {
            System.out.println("A fatal error has occurred in translating the json file into an object");
            System.out.println("Exiting the program");
            exit(-2);
        }

        try {
            settings = new Settings(
                    source.get("TitleColor").toString(),
                    source.get("DescriptionColor").toString(),
                    source.get("CommandColor").toString(),
                    source.get("NumberColor").toString());
        } catch (JSONException e) {
            settings = new Settings();
        }

        settings.menu();

        /*Scanner input = new Scanner(System.in);
        String action = "";
        while (!action.equals("quit")) {
            settings.menu();
            action = input.nextLine();
        }*/

        try {
            finalWrite(source);
        } catch (IOException e) {
            System.out.println("A fatal error has occurred in writing the json object into a file");
            System.out.println("Exiting the program");
            exit(-1);
        }
    }

    static JSONObject initialRead() throws IOException, JSONException {
        FileReader reader;
        StringBuilder spooler = new StringBuilder();
        int spoolprepper = 0;
        JSONObject source;

        try {
            reader = new FileReader("notebook.json");
        } catch (FileNotFoundException e) {
            return jsonTemplater();
        }

        while((spoolprepper=reader.read())!=-1){
            spooler.append((char)spoolprepper);
        }

        reader.close();
        return new JSONObject(spooler.toString());
    }

    static JSONObject jsonTemplater() throws JSONException {
        JSONObject source = new JSONObject();
        source.put("Questions",new JSONArray());
        source.put("Entries",new JSONArray());
        return source;
    }

    static void finalWrite(JSONObject save) throws IOException {
        FileWriter writer = new FileWriter("notebook.json");
        writer.write(save.toString());
        writer.flush();
    }
}
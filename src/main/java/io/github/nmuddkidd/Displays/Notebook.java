package io.github.nmuddkidd.Displays;

import io.github.nmuddkidd.ConsoleColors;
import io.github.nmuddkidd.Display;
import io.github.nmuddkidd.IPage;
import org.json.JSONArray;

import java.util.Scanner;

public class Notebook extends Display implements IPage {
    public Notebook(JSONArray content, String name, int pageLength, ConsoleColors title, ConsoleColors description, ConsoleColors command, ConsoleColors number){
        super(content,"Questions",pageLength,title,description,command,number);
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        String action="";
        while(!action.equalsIgnoreCase("quit")) {
            System.out.println(this);
            action = input.nextLine();
            switch(action.toLowerCase()){
                case "add":
                case "add entry":
                case "new":
                case "new entry":
                case "create":
                case "create entry":
                    createQuestion();
                    break;
                case "resolve":
                case "resolve entry":
                case "remove":
                case "remove entry":
                case "delete":
                case "delete entry":
                    deleteEntry(-1);
                    break;
                case ">":
                case "page >":
                case "up":
                case "page up":
                case "right":
                case "page right":
                case "forward":
                case "page forward":
                case "fwd":
                case "page fwd":
                    pageForward();
                    break;
                case "<":
                case "page <":
                case "down":
                case "page down":
                case "left":
                case "page left":
                case "backward":
                case "page backward":
                case "back":
                case "page back":
                    pageBack();
                    break;
                case "quit":
                case "exit":
                case "leave":
                case "main menu":
                case "menu":
                case "end":
                    action="quit";
                    quit();
                    input.close();
                    break;
            }
        }
    }

    void createQuestion(){
        //TODO -- implement: Notebook creation
    }

    void quit(){
        //TODO -- implement: JSON updating
    }


    public String commands(){
        StringBuilder sb = new StringBuilder()
                .append(super.command)
                .append("Add Entry").append('\n')
                .append("Remove Entry").append('\n')
                .append("Page Forward").append('\n')
                .append("Page Back").append('\n')
                .append("Quit to Main Menu");
        return sb.toString();
    }
}

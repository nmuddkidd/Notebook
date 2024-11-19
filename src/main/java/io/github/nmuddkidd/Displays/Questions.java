package io.github.nmuddkidd.Displays;

import io.github.nmuddkidd.ConsoleColors;
import io.github.nmuddkidd.Display;
import io.github.nmuddkidd.IPage;
import org.json.JSONArray;

import java.util.Scanner;

public class Questions extends Display implements IPage {
    public Questions(JSONArray content, String name, int pageLength, ConsoleColors title, ConsoleColors description, ConsoleColors command, ConsoleColors number){
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
                case "add question":
                case "new":
                case "new question":
                case "create":
                case "create question":
                    createQuestion();
                    break;
                case "resolve":
                case "resolve question":
                case "remove":
                case "remove question":
                case "delete":
                case "delete question":
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
        //TODO -- implement: Question creation
    }

    void quit(){
        //TODO -- implement: JSON updating
    }


    public String commands(){
        StringBuilder sb = new StringBuilder()
                .append(super.command)
                .append("Add Question").append('\n')
                .append("Resolve Question").append('\n')
                .append("Page Forward").append('\n')
                .append("Page Back").append('\n')
                .append("Quit to Main Menu");
        return sb.toString();
    }
}

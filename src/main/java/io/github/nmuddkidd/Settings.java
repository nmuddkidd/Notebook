package io.github.nmuddkidd;

import io.github.nathanjrussell.CoolHelloWorld;

import java.util.Scanner;

public class Settings implements IPage {
    int pageLength = 5;
    ConsoleColors title;
    ConsoleColors description;
    ConsoleColors command;
    ConsoleColors number;

    public Settings(String title, String description, String command, String number){
        this.title=translate(title);
        this.description=translate(description);
        this.command=translate(command);
        this.number=translate(number);
    }

    public Settings() {
        title = ConsoleColors.RESET;
        description = ConsoleColors.RESET;
        command = ConsoleColors.RESET;
        number = ConsoleColors.RESET;
    }

    private ConsoleColors translate(String keyword){
        return switch (keyword.toLowerCase()) {
            case "red","r" -> ConsoleColors.RED;
            case "green","g" -> ConsoleColors.GREEN;
            case "yellow","y" -> ConsoleColors.YELLOW;
            case "blue","b" -> ConsoleColors.BLUE;
            case "purple","p" -> ConsoleColors.PURPLE;
            case "cyan","c" -> ConsoleColors.CYAN;
            case "white","w" -> ConsoleColors.WHITE;
            default -> ConsoleColors.RESET;
        };
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        String action="";
        while(!action.equalsIgnoreCase("quit")) {
            System.out.println(this);
            action = input.nextLine();
            switch(action.toLowerCase()){
                case "color":
                case "recolor":
                case "change color":
                    color();
                    break;
                case "elements":
                case "elements per page":
                case "change elements per page":
                case "length":
                case "change length":
                case "page length":
                case "change page length":
                case "size":
                case "change size":
                case "page size":
                case "change page size":
                    setPageLength();
                    break;
                case "credits":
                case "roll credits":
                case "end credits":
                    credits();
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

    void color(){
        Scanner input = new Scanner(System.in);
        String action = "";
        String mode = "";
        ConsoleColors selected = null;

        while(mode.isEmpty()) {
            System.out.println("\nWhich color group? ");
            action = input.nextLine();
            mode = switch (action.toLowerCase()) {
                case "title", "title color" -> "title";
                case "description", "description color" -> "description";
                case "cmd", "command", "command color" -> "command";
                case "num", "number", "number color" -> "number";
                default -> mode;
            };
        }

        System.out.println(colorExamples());
        while(selected==null) {
            System.out.println("\nWhich? color? ");
            action = input.nextLine();
            selected = translate(action);
        }

        switch(mode){
            case "title":
                title=selected;
                break;
            case "description":
                description=selected;
                break;
            case "command":
                command=selected;
                break;
            case "number":
                number=selected;
                break;
        }
    }

    String colorExamples(){
        StringBuilder sb = new StringBuilder()
                .append("Red: ").append(ConsoleColors.RED).append("Hello World!").append(ConsoleColors.RESET).append('\t')
                .append("Yellow: ").append(ConsoleColors.YELLOW).append("Hello World!").append(ConsoleColors.RESET).append('\t')
                .append("Green: ").append(ConsoleColors.GREEN).append("Hello World!").append(ConsoleColors.RESET).append('\t')
                .append('\n')
                .append("Blue: ").append(ConsoleColors.BLUE).append("Hello World!").append(ConsoleColors.RESET).append('\t')
                .append("Cyan: ").append(ConsoleColors.CYAN).append("Hello World!").append(ConsoleColors.RESET).append('\t')
                .append("Purple: ").append(ConsoleColors.PURPLE).append("Hello World!").append(ConsoleColors.RESET).append('\t')
                .append('\n')
                .append("White: ").append(ConsoleColors.WHITE).append("Hello World!").append(ConsoleColors.RESET).append('\t');
        return sb.toString();
    }

    void setPageLength(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nHow long? ");
        pageLength=input.nextInt();
    }

    void credits(){
        System.out.println("\nDeveloped by Nathan Mudd with contributions from Professor Nathan J Russell\n");

    }

    void quit(){
        //TODO -- implement: saving to json
    }

    public String toString(){
        StringBuilder sb = new StringBuilder()
                .append("Settings").append('\n')
                .append("--------").append('\n')
                .append("Title Color: ").append(title).append("Hello World!").append(ConsoleColors.RESET).append('\n')
                .append("Description Color: ").append(description).append("Hello World!").append(ConsoleColors.RESET).append('\n')
                .append("Command Color: ").append(command).append("Hello World!").append(ConsoleColors.RESET).append('\n')
                .append("Number Color: ").append(number).append("Hello World!").append(ConsoleColors.RESET).append('\n')
                .append("Elements Per Page: ").append(pageLength).append('\n')
                .append('\n').append(commands()).append('\n');
        return sb.toString();
    }

    public String commands(){
        StringBuilder sb = new StringBuilder()
                .append(command)
                .append("Change Color").append('\n')
                .append("Change Elements Per Page").append('\n')
                .append("Roll Credits").append('\n')
                .append("Quit to Main Menu")
                .append(ConsoleColors.RESET);
        return sb.toString();
    }

    public int getPageLength() {return pageLength;}
}

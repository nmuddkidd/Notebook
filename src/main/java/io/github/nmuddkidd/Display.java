package io.github.nmuddkidd;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.Scanner;

public abstract class Display implements IPage {
    JSONArray content;
    String name;
    int page;
    final int pageLength;
    ConsoleColors title;
    ConsoleColors description;
    protected ConsoleColors command;
    ConsoleColors number;
    public Display(JSONArray content, String name, int pageLength, ConsoleColors title, ConsoleColors description, ConsoleColors command, ConsoleColors number){
        this.content = content;
        this.name = name;
        this.pageLength = pageLength;
        this.title = title;
        this.description = description;
        this.command = command;
        this.number = number;
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        String action="";
        while(!action.equalsIgnoreCase("quit")) {
            System.out.println(this);
            System.out.println("Menu method has not been specified for this class");
            action = input.nextLine();
        }
    }

    public void deleteEntry(int index){
        //TODO - implement deletion
    }

    public String toString(){
        String entry=null;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<pageLength;i++){
            try {
                entry = content.getString(index(i));
            } catch (JSONException e) {
                break;
            }
            sb
                .append(title).append(name).append(ConsoleColors.RESET).append('\n')
                .repeat('-',name.length()).append('\n')
                .append(number).append(i+1).append(ConsoleColors.RESET).append(" - ")
                .append(description).append(entry).append(ConsoleColors.RESET).append('\n');
            if((index(i)>pageLength&&i==pageLength-1)||(index(i)==content.length()-1)){
                sb.append(command).append('<').append(ConsoleColors.RESET);
            }else if(i==pageLength-1&&index(i)!=content.length()-1){
                sb.append(command).append('>').append(ConsoleColors.RESET);
            }
        }
        sb
        .append(" Page ").append(page).append(" of ").append(content.length()/pageLength).append("\n\n")
        .append(commands()).append('\n');
        return sb.toString();
    }

    public String commands(){
        return "Commands method has not been specified for this class";
    }

    public int index(int choice){return page*pageLength+choice;}
    public void pageForward(){page++;}
    public void pageBack(){page--;}
}

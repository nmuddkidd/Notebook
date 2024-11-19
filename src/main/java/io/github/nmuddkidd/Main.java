package io.github.nmuddkidd;
import io.github.nathanjrussell.CoolHelloWorld;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        JSONObject source = new JSONObject(); //TODO -- implement: json sourcing
        Settings settings;
        try {
            settings = new Settings(
                    source.get("TitleColor").toString(),
                    source.get("DescriptionColor").toString(),
                    source.get("CommandColor").toString(),
                    source.get("NumberColor").toString());
        } catch(JSONException e) {
            settings = new Settings();
        }
        settings.menu();
    }
}
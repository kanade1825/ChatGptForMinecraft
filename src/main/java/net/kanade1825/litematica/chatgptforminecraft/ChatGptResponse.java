package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.*;
import java.net.*;
import org.json.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGptResponse implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length < 1) {
            if (strings[0].equalsIgnoreCase("a")) {
                commandSender.sendMessage("Don't use this commands with no args!");
                return true;
            }
        }

        String question1 = strings[0];


        String apiKey = "API-KEY";
        String question = question1;
        String url = "https://api.openai.com/v1/engines/davinci-codex/completions";


        try {
            // Create the HTTP request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);

            // Set the request body
            JSONObject requestBody = new JSONObject();
            requestBody.put("prompt", question);
            requestBody.put("max_tokens", 100);
            requestBody.put("temperature", 0.7);
            requestBody.put("stop", "");


            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(requestBody.toString().getBytes());
            os.flush();
            os.close();

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray choices = jsonResponse.getJSONArray("choices");
            JSONObject firstChoice = choices.getJSONObject(0);
            String answer = firstChoice.getString("text");

            // Display the answer
            System.out.println(answer);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}

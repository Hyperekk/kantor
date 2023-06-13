package com.example.kantor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {
    public Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;

    public void initialize() throws IOException
    {
        try {
            String apiUrl = "http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=json";
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String jsonResponse = response.toString();
                System.out.println("Odpowiedź JSON: " + jsonResponse);


                // Możesz tutaj parsować i przetwarzać JSON


            } else {
                System.out.println("Błąd podczas pobierania danych. Kod odpowiedzi: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


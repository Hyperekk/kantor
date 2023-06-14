package com.example.kantor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {
    public Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;

    public String jsonString;

    public Double kupUSD, sprzedajUSD, kupEUR, sprzedajEUR, kupCHF, sprzedajCHF ,kupGBP, sprzedajGBP, kupCNY, sprzedajCNY;

    public void initialize() throws IOException {

        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=json");
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray osobyArray = jsonObject.getJSONArray("rates");

        for (int i = 0; i < osobyArray.length(); i++) {
            JSONObject osobaObject = osobyArray.getJSONObject(i);
            kupUSD = osobaObject.getDouble("mid");
            kupUSD = kupUSD + 0.22;
            sprzedajUSD = osobaObject.getDouble("mid");
        }

        lb1.setText(kupUSD.toString());
        lb2.setText(sprzedajUSD.toString());


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json");
        jsonObject = new JSONObject(jsonString);
        osobyArray = jsonObject.getJSONArray("rates");

        for (int i = 0; i < osobyArray.length(); i++) {
            JSONObject osobaObject = osobyArray.getJSONObject(i);
            kupEUR = osobaObject.getDouble("mid");
            kupEUR = kupEUR + 0.22;
            sprzedajEUR = osobaObject.getDouble("mid");
        }

        lb3.setText(String.format("%.4f", kupEUR));
        lb4.setText(sprzedajEUR.toString());


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=json");
        jsonObject = new JSONObject(jsonString);
        osobyArray = jsonObject.getJSONArray("rates");

        for (int i = 0; i < osobyArray.length(); i++) {
            JSONObject osobaObject = osobyArray.getJSONObject(i);
            kupCHF = osobaObject.getDouble("mid");
            kupCHF = kupCHF + 0.22;
            sprzedajCHF = osobaObject.getDouble("mid");
        }

        lb5.setText(String.format("%.4f", kupCHF));
        lb6.setText(sprzedajCHF.toString());


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json");
         jsonObject = new JSONObject(jsonString);
         osobyArray = jsonObject.getJSONArray("rates");

         for (int i = 0; i < osobyArray.length(); i++) {
            JSONObject osobaObject = osobyArray.getJSONObject(i);
            kupGBP = osobaObject.getDouble("mid");
            kupGBP = kupGBP + 0.22;
            sprzedajGBP = osobaObject.getDouble("mid");
        }

        lb7.setText(kupGBP.toString());
        lb8.setText(sprzedajGBP.toString());


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/cny/?format=json");
        jsonObject = new JSONObject(jsonString);
        osobyArray = jsonObject.getJSONArray("rates");
        for (int i = 0; i < osobyArray.length(); i++) {
            JSONObject osobaObject = osobyArray.getJSONObject(i);
            kupCNY = osobaObject.getDouble("mid");
            kupCNY = kupCNY + 0.22;
            sprzedajCNY = osobaObject.getDouble("mid");
        }

        lb9.setText(String.format("%.4f", kupCNY));
        lb10.setText(sprzedajCNY.toString());

    }

    public void laczenie(String apiUrl) throws IOException {
        try {
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
                jsonString = jsonResponse;
            }

            else {
                System.out.println("Błąd podczas pobierania danych. Kod odpowiedzi: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




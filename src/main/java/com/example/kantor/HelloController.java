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

    public String jsonString;

    public void initialize() throws IOException {

        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/usd/?format=json");
        //JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray osobyArray = jsonObject.getJSONArray("rates");
        JSONObject osobaObject = osobyArray.getJSONObject();

        String kupUSD = osobaObject.getString("imie");
        kupUSD = Double.parseDouble(kupUSD) + 0,22;
        String sprzedajUSD = osobaObject.getString("imie");
        sprzedajUSD = Double.parseDouble(sprzedajUSD);

        lb1.setText(kupUSD);
        lb2.setText(sprzedajUSD);


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json");
        //JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray osobyArray = jsonObject.getJSONArray("rates");
        JSONObject osobaObject = osobyArray.getJSONObject();

        String kupEUR = osobaObject.getString("imie");
        kupEUR = Double.parseDouble(kupEUR) + 0,22;
        String sprzedajEUR = osobaObject.getString("imie");
        sprzedajEUR = Double.parseDouble(sprzedajEUR);

        lb3.setText(kupEUR);
        lb4.setText(sprzedajEUR);


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=json");
        //JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray osobyArray = jsonObject.getJSONArray("rates");
        JSONObject osobaObject = osobyArray.getJSONObject();

        String kupCHF = osobaObject.getString("imie");
        kupCHF = Double.parseDouble(kupCHF) + 0,22;
        String sprzedajCHF = osobaObject.getString("imie");
        sprzedajCHF = Double.parseDouble(sprzedajCHF);

        lb5.setText(kupCHF);
        lb6.setText(sprzedajCHF);


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json");
        //JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray osobyArray = jsonObject.getJSONArray("rates");
        JSONObject osobaObject = osobyArray.getJSONObject();

        String kupGBP = osobaObject.getString("imie");
        kupGBP = Double.parseDouble(kupGBP) + 0,22;
        String sprzedajGBP = osobaObject.getString("imie");
        sprzedajGBP = Double.parseDouble(sprzedajGBP);

        lb7.setText(kupGBP);
        lb8.setText(sprzedajGBP);


        laczenie("http://api.nbp.pl/api/exchangerates/rates/a/cny/?format=json");
        //JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray osobyArray = jsonObject.getJSONArray("rates");
        JSONObject osobaObject = osobyArray.getJSONObject();

        String kupCNY = osobaObject.getString("imie");
        kupCNY = Double.parseDouble(kupCNY) + 0,22;
        String sprzedajCNY = osobaObject.getString("imie");
        sprzedajCNY = Double.parseDouble(kupCNY);

        lb9.setText(kupCNY);
        lb10.setText(sprzedajCNY);
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




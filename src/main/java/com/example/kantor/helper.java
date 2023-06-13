package com.example.kantor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class helper
{
    {
        try {
// Adres URL REST API
            String apiUrl = "";
            URL url = new URL(apiUrl);

// Otwieranie połączenia HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Ustawianie metody na GET
            connection.setRequestMethod("GET");

            // Odczytywanie odpowiedzi
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

                // Przykład obsługi zwracanej wartości
                String jsonResponse = response.toString();
                System.out.println("Odpowiedź JSON: " + jsonResponse);


                // Możesz tutaj parsować i przetwarzać JSON


            } else {
                System.out.println("Błąd podczas pobierania danych. Kod odpowiedzi: " + responseCode);
            }
// Zamykanie połączenia
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

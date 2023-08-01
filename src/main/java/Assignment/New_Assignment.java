package Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class New_Assignment {
    private static final String API_BASE_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Get weather");
            System.out.println("2. Get Wind Speed");
            System.out.println("3. Get Pressure");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    getWeather(scanner);
                    break;
                case 2:
                    getWindSpeed(scanner);
                    break;
                case 3:
                    getPressure(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void getWeather(Scanner scanner) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.next();
        String apiUrl = API_BASE_URL;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                JsonElement responseJson = JsonParser.parseReader(new BufferedReader(new InputStreamReader(conn.getInputStream())));
                JsonArray hourlyForecasts = responseJson.getAsJsonObject().getAsJsonArray("list");

                for (JsonElement element : hourlyForecasts) {
                    JsonObject forecast = element.getAsJsonObject();
                    String forecastDate = forecast.get("dt_txt").getAsString().split(" ")[0];

                    if (forecastDate.equals(date)) {
                        JsonObject main = forecast.getAsJsonObject("main");
                        double temperature = main.get("temp").getAsDouble();
                        System.out.println("Temperature on " + date + ": " + temperature + "°C");
                        return;
                    }
                }

                System.out.println("No weather data found for the given date.");
            } else {
                System.out.println("Failed to fetch weather data. HTTP error code: " + conn.getResponseCode());
            }
        } catch (IOException e) {
            System.out.println("Error occurred while making the API request: " + e.getMessage());
        }
    }

    private static void getWindSpeed(Scanner scanner) {
    	System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.next();
        String apiUrl = API_BASE_URL;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                JsonElement responseJson = JsonParser.parseReader(new BufferedReader(new InputStreamReader(conn.getInputStream())));
                JsonArray hourlyForecasts = responseJson.getAsJsonObject().getAsJsonArray("list");

                for (JsonElement element : hourlyForecasts) {
                    JsonObject forecast = element.getAsJsonObject();
                    String forecastDate = forecast.get("dt_txt").getAsString().split(" ")[1];

                    if (forecastDate.equals(date)) {
                        JsonObject main = forecast.getAsJsonObject("main");
                        double windspeed = main.get("wind.speed").getAsDouble();
                        System.out.println("wind.speed on " + date + ": " + windspeed + "km/h");
                        return;
                    }
                }

                System.out.println("No wind.speed data found for the given date.");
            } else {
                System.out.println("Failed to fetch wind.speed data. HTTP error code: " + conn.getResponseCode());
            }
        } catch (IOException e) {
            System.out.println("Error occurred while making the API request: " + e.getMessage());
        }
    }
        // Similar to getWeather method, retrieve the wind speed for the given date.
        // You can use the same API response parsing logic with slight modifications.
    
    private static void getPressure(Scanner scanner) {
    	 System.out.print("Enter date (YYYY-MM-DD): ");
         String date = scanner.next();
         String apiUrl = API_BASE_URL;

         try {
             URL url = new URL(apiUrl);
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");

             if (conn.getResponseCode() == 200) {
                 JsonElement responseJson = JsonParser.parseReader(new BufferedReader(new InputStreamReader(conn.getInputStream())));
                 JsonArray hourlyForecasts = responseJson.getAsJsonObject().getAsJsonArray("list");

                 for (JsonElement element : hourlyForecasts) {
                     JsonObject forecast = element.getAsJsonObject();
                     String forecastDate = forecast.get("dt_txt").getAsString().split(" ")[0];

                     if (forecastDate.equals(date)) {
                         JsonObject main = forecast.getAsJsonObject("main");
                         double pressure = main.get("pres").getAsDouble();
                         System.out.println("Temperature on " + date + ": " + pressure + "pa");
                         return;
                     }
                 }

                 System.out.println("No pressure data found for the given date.");
             } else {
                 System.out.println("Failed to fetch pressure data. HTTP error code: " + conn.getResponseCode());
             }
         } catch (IOException e) {
             System.out.println("Error occurred while making the API request: " + e.getMessage());
         }
     }
    }
    	 
        // Similar to getWeather and getWindSpeed methods, retrieve the pressure for the given date.
        // You can use the same API response parsing logic with slight modifications.
    

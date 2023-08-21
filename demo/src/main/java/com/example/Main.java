package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
   public static void main(String[] args) throws JSONException {
	 
	        String user = "H3hYxb8z6-6M_OoWEaETbw..:Q0ComPacWlizho9nSonBIQ..";
	        String grantType = "client_credentials";
	        String url = "https://g01255b1b1a6448-agendamientomintic.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/oauth/token";

	        try {
	            // Create authentication token
	            //String authString = username + ":" + password;
	            String authHeader = "Basic " + Base64.getEncoder().encodeToString(user.getBytes());

	            // Create request data
	            String data = "grant_type=" + grantType;
	            byte[] postData = data.getBytes(StandardCharsets.UTF_8);

	            // Set up the connection
	            URL endpoint = new URL(url);
	            HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
	            connection.setRequestMethod("POST");
	            connection.setRequestProperty("Authorization", authHeader);
	            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            connection.setRequestProperty("Content-Length", String.valueOf(postData.length));
	            connection.setDoOutput(true);

	            // Write data to the connection
	            try (OutputStream os = connection.getOutputStream()) {
	                os.write(postData);
	            }

	            // Get response
	            int responseCode = connection.getResponseCode();
	            System.out.println("Response Code: " + responseCode);
	            
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	            	 try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	 	            	String inputLine;
	 	                StringBuilder response = new StringBuilder();

	 	                while ((inputLine = in.readLine()) != null) {
	 	                    response.append(inputLine);
	 	                }
	 	                in.close();

	 	                // Aquí debes parsear la respuesta JSON para obtener los valores necesarios
	 	                // Por ejemplo, si la respuesta es un JSON como {"Access_token": "...", "token_type": "...", "expires_in": "..."}
	 	                // puedes parsearlos así:
	 	                 JSONObject jsonObject = new JSONObject(response.toString());
	 	                 String accessToken = jsonObject.getString("access_token");
	 	                 String tokenType = jsonObject.getString("token_type");
	 	                 int expiresIn = jsonObject.getInt("expires_in");

	 	                // Imprimir o usar los valores obtenidos
	 	                 System.out.println("Los valores del response son:");
	 	                 System.out.println("access_token: "+accessToken);
	 	                 System.out.println("token_type: "+ tokenType);
	 	                 System.out.println("expires_in: "+expiresIn);
	 	            }catch (Exception e) {
						// TODO: handle exception
					}
	            }
	        } catch (IOException e) {
	           
	        }
	 }
}
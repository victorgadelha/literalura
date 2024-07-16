package br.com.victorgadelha.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.victorgadelha.literalura.DTO.BookDTO;
import br.com.victorgadelha.literalura.DTO.ListBooksDTO;

@Service
public class ApiService {

    public BookDTO getApi(String title) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS) // Configure redirect behavior here
                .build();

        String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);

        String apiUrl = "https://gutendex.com/books?search=" + encodedTitle;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        ObjectMapper objectMapper = new ObjectMapper();

        ListBooksDTO listBooksDTO = objectMapper.readValue(responseBody, ListBooksDTO.class);
        return listBooksDTO.results().get(0);
    }

}

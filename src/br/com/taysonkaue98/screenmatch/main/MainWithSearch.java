package br.com.taysonkaue98.screenmatch.main;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;
import br.com.taysonkaue98.screenmatch.models.Title;
import br.com.taysonkaue98.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import com.google.gson.Gson;

public class MainWithSearch {
    public static void main(String[] args) throws Exception, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do filme que deseja buscar: ");
        var search = sc.nextLine();
        
// Construindo a URL para a API do OMDB usando o nome do filme fornecido pelo usuário, substituindo espaços por "+" e incluindo a chave de API

        String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=648ed95d";

// Criando um cliente HTTP e construindo uma requisição GET para a URL da API

        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

// Enviando a requisição e obtendo a resposta como uma string, que é então impressa no console

        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());


// Imprime a resposta JSON da API no console para ver o formato dos dados retornados
        String jsonResponse = response.body();
        System.out.println("Resposta em JSON: " + jsonResponse);


        Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();
        
// Converte a resposta JSON para um objeto TitleOmdb usando a biblioteca Gson, que mapeia os campos do JSON para os atributos do record TitleOmdb
        TitleOmdb myTitleOmdb = gson.fromJson(jsonResponse, TitleOmdb.class);
        System.out.println("Meu Record: " + myTitleOmdb);

// Tenta criar um objeto Title a partir do TitleOmdb, utilizando o construtor que extrai e converte as informações relevantes do record. Se ocorrer um erro de conversão, captura a exceção e imprime uma mensagem de erro.
        try {
            Title title = new Title(myTitleOmdb);
            System.out.println("Titulo: " + title.getTitle());
            System.out.println("Data de lançamento: " + title.getReleaseDate());
            System.out.println("Duração em minutos: " + title.getDurationInMinutes());
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro na conversão dos números: " + e.getMessage());
        }
    }
}

package br.com.taysonkaue98.screenmatch.main;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;
import br.com.taysonkaue98.screenmatch.models.Title;

public class MainWithSearch {
    public static void main(String[] args) throws Exception, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do filme que deseja buscar: ");
        var search = sc.nextLine();
        
// Construindo a URL para a API do OMDB usando o título do filme fornecido pelo usuário e a chave de API

        String address = "http://www.omdbapi.com/?t=" + search + "&apikey=648ed95d";

// Criando um cliente HTTP e construindo uma requisição GET para a URL da API

        HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

// Enviando a requisição e obtendo a resposta como uma string, que é então impressa no console

        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

 // Usando a biblioteca Gson para converter a resposta JSON em um objeto Title, que é então usado para imprimir o título do filme no console               
        String jsonResponse = response.body();
        System.out.println(jsonResponse);

        Gson gson = new Gson();
        Title title = gson.fromJson(jsonResponse, Title.class);
        System.out.println(title);
    }
}

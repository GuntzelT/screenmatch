package br.com.taysonkaue98.screenmatch.main;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;
import br.com.taysonkaue98.screenmatch.exceptions.ErrorConvertYearException;
import br.com.taysonkaue98.screenmatch.models.Title;
import br.com.taysonkaue98.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class MainWithSearch {
    public static void main(String[] args) throws Exception, InterruptedException {

        Scanner sc = new Scanner(System.in);

// Variável para armazenar o termo de busca fornecido pelo usuário, inicializada como uma string vazia
        String search = "";

// Lista para armazenar os títulos buscados, permitindo que o usuário adicione vários títulos à lista durante a execução do programa
        List<Title> watchList = new ArrayList<>();

// Configura a biblioteca Gson para usar uma política de nomenclatura que corresponde ao formato dos campos no JSON retornado pela API do OMDB, permitindo que os campos do JSON sejam mapeados corretamente para os atributos do record TitleOmdb
         Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();

// Loop que continua solicitando ao usuário o nome de um filme para buscar até que o usuário digite "sair". Dentro do loop, a URL para a API do OMDB é construída usando o nome do filme fornecido pelo usuário, e uma requisição HTTP é enviada para obter os dados do filme. A resposta JSON é convertida para um objeto TitleOmdb, que é então usado para criar um objeto Title. O título é adicionado a uma lista de títulos e a resposta JSON e os detalhes do título são impressos no console. O loop também inclui tratamento de exceções para lidar com erros durante a conversão dos dados.
    while (!search.equalsIgnoreCase("sair")) {

        System.out.print("Digite o nome do filme que deseja buscar: ");
        search = sc.nextLine();
// Verifica se o usuário digitou "sair" para encerrar o programa, ignorando diferenças de maiúsculas e minúsculas. Se o usuário digitar "sair", o loop é interrompido e o programa é encerrado.
        if (search.equalsIgnoreCase("sair")) {
            break;
        }
        
// Construindo a URL para a API do OMDB usando o nome do filme fornecido pelo usuário, substituindo espaços por "+" e incluindo a chave de API

        String address = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=648ed95d";

// Criando um cliente HTTP e construindo uma requisição GET para a URL da API
    try {
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
        
// Converte a resposta JSON para um objeto TitleOmdb usando a biblioteca Gson, que mapeia os campos do JSON para os atributos do record TitleOmdb
        TitleOmdb myTitleOmdb = gson.fromJson(jsonResponse, TitleOmdb.class);
        System.out.println("Meu Record: " + myTitleOmdb);

// Cria um objeto Title usando o construtor que recebe um TitleOmdb, extraindo as informações relevantes e convertendo-as para os tipos apropriados. Lança exceções personalizadas se ocorrerem erros durante a conversão.
        
            Title title = new Title(myTitleOmdb);
            System.out.println("Titulo: " + title.getTitle());
            System.out.println("Data de lançamento: " + title.getReleaseDate());
            System.out.println("Duração em minutos: " + title.getDurationInMinutes());
            watchList.add(title);

        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro na conversão dos números: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro na criação do título: " + e.getMessage());
        } catch (ErrorConvertYearException e) {
            System.out.println("Ocorreu um erro na conversão do ano: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }

    }   

    System.out.println(watchList);

    System.out.println("Programa encerrado corretamente.");

// Escreve a lista de títulos em um arquivo JSON usando a biblioteca Gson, criando um FileWriter para o arquivo "watchlist.json" e convertendo a lista de títulos para JSON antes de escrevê-la no arquivo
    FileWriter writer = new FileWriter("watchlist.json");
    writer.write(gson.toJson(watchList));
    writer.flush();
    writer.close();

    sc.close();
    }
}
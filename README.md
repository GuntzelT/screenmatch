Um sistema em **Java** para gerenciamento de um catálogo de filmes e séries. O projeto foi desenvolvido com foco em consolidar os pilares da **Programação Orientada a Objetos** (Herança, Polimorfismo, Encapsulamento e Abstração), além de explorar o consumo de APIs externas e a manipulação de arquivos JSON.

## Funcionalidades

* **Catálogo de Mídias:** Modelagem estruturada de `Filmes`, `Séries` e `Episódios`.
* **Cálculo de Maratona:** Uma calculadora (`TimeCalculator`) que soma o tempo total necessário para assistir a uma lista de títulos selecionados.
* **Sistema de Recomendações:** Um filtro (`RecomendFilter`) que avalia e classifica os títulos com base em suas notas e visualizações.
* **Integração com API Externa:** Busca de dados reais de filmes em tempo real comunicando-se com a [OMDB API](http://www.omdbapi.com/).
* **Desserialização e Serialização JSON:** Uso da biblioteca **Gson** para converter os dados recebidos da API para objetos Java (`Record` e classes) e para salvar a sua lista de busca em um arquivo `watchlist.json`.
* **Tratamento de Exceções:** Criação e manipulação de exceções customizadas (como o `ErrorConvertYearException`) para garantir que dados formatados incorretamente pela API não quebrem o sistema.
* **Ordenação de Listas:** Implementação da interface `Comparable` e uso de `Comparator` para ordenar filmes por nome e por ano de lançamento.

## Tecnologias Utilizadas

* **Java (>= 11)** (Devido à utilização da biblioteca nativa `java.net.http.HttpClient`)
* **Gson (2.14.0)** - Biblioteca do Google para manipulação de dados JSON.
* **OMDB API** - API RESTful utilizada para buscar informações dos filmes.

## Estrutura do Projeto

A arquitetura do projeto está dividida nos seguintes pacotes:

* `models`: Contém as entidades de domínio do projeto (`Title`, `Movie`, `Series`, `Episodie`) e o DTO `TitleOmdb` (Record) para recebimento seguro dos dados da API.
* `calculations`: Contém a lógica de negócio, como a calculadora de tempo (`TimeCalculator`), o filtro de recomendação (`RecomendFilter`) e a interface `Classification`.
* `exceptions`: Contém classes de tratamento de erros personalizados, como a `ErrorConvertYearException`.
* `main`: Contém as classes executáveis para diferentes cenários de teste:
    * `Main.java`: Testa a criação básica de filmes, séries e a calculadora de tempo.
    * `MainWithLists.java`: Testa o uso de Coleções (`ArrayList`), ordenação e polimorfismo.
    * `MainWithSearch.java`: Classe principal que inicia o menu de busca integrado à API do OMDB e salva os resultados no `watchlist.json`.

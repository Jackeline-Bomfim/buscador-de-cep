package br.com.buscacep.principal;

import br.com.buscacep.modelos.Endereco;
import br.com.buscacep.modelos.EnderecoViaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalBuscaCep {

    public static void main(String[] args) throws IOException, InterruptedException {

        try {

            Scanner leitura = new Scanner(System.in);
            System.out.println("==============================");
            System.out.println("|        DIGITE O CEP        |");
            System.out.println("==============================");
            var cep = leitura.nextLine();

            String endereco = "https://viacep.com.br/ws/" + cep + "/json";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            EnderecoViaCep meuEnderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
            //System.out.println(meuEnderecoViaCep);

            Endereco meuEndereco = new Endereco(meuEnderecoViaCep);
            //System.out.println(meuEndereco);
            System.out.println("Endereço: " + meuEndereco.getEndereco());
            System.out.println("Bairro: " + meuEndereco.getBairro());
            System.out.println("Cidade: " + meuEndereco.getCidade());
            System.out.println("Estado: " + meuEndereco.getEndereco());


            FileWriter escrita = new FileWriter("endereco.json");
            escrita.write(gson.toJson(meuEndereco));
            escrita.close();
        } catch (JsonSyntaxException | IllegalStateException ex) {
            System.out.println("CEP não localizado!");
            System.out.println(ex.getMessage());
        }

    }
}
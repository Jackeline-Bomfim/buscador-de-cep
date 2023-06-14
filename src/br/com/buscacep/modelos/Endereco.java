package br.com.buscacep.modelos;



public class Endereco {

    private String cep;
    private String endereco;
    private String cidade;
    private String bairro;
    private String estado;

    public Endereco(EnderecoViaCep meuEnderecoViaCep) {
        this.endereco = meuEnderecoViaCep.logradouro();
        this.bairro = meuEnderecoViaCep.bairro();
        this.cidade = meuEnderecoViaCep.localidade();
        this.estado = meuEnderecoViaCep.uf();
        this.cep = meuEnderecoViaCep.cep();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "(Cep: " + cep + " - Endereço: " + endereco + " - Bairro: " + bairro + " - Cidade: " + cidade + " - Estado: " + estado +")";
    }
}

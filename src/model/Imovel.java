package model;

import java.util.List;

public class Imovel {
    // chave primaria
    private String codigo;
    private String descricao;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String tipo;
    private int quantidadeGaragens;
    private int quantidadeSuites;
    private int quantidadeQuartos;
    private List<String> itensSeguranca;
    private double valorAluguel;
    private double valorCondominio;

    public Imovel(){}

    public Imovel(
            String codigo, String descricao, String rua, int numero, String bairro,
            String cidade, String estado, String pais, String cep, String tipo,
            int quantidadeGaragens, int quantidadeSuites, int quantidadeQuartos,
            List<String> itensSeguranca, double valorAluguel, double valorCondominio
    ){
        this.codigo = codigo;
        this.descricao = descricao;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.tipo = tipo;
        this.quantidadeGaragens = quantidadeGaragens;
        this.quantidadeSuites = quantidadeSuites;
        this.quantidadeQuartos = quantidadeQuartos;
        this.itensSeguranca = itensSeguranca;
        this.valorAluguel = valorAluguel;
        this.valorCondominio = valorCondominio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeGaragens() {
        return quantidadeGaragens;
    }

    public void setQuantidadeGaragens(int quantidadeGaragens) {
        this.quantidadeGaragens = quantidadeGaragens;
    }

    public int getQuantidadeSuites() {
        return quantidadeSuites;
    }

    public void setQuantidadeSuites(int quantidadeSuites) {
        this.quantidadeSuites = quantidadeSuites;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public List<String> getItensSeguranca() {
        return itensSeguranca;
    }

    public void setItensSeguranca(List<String> itensSeguranca) {
        this.itensSeguranca = itensSeguranca;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public double getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }
}

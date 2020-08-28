//package model;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class ImovelTest {
//    private Imovel imovel;
//
//    @BeforeAll
//    public void inicializaImovel(){
//        imovel = new Imovel(
//                "C3A19",
//                "Essa é uma descrição bem descritiva",
//                "Rua dos bobos",
//                0,
//                "Desconhecido",
//                "Escondida",
//                "ND",
//                "Neverland",
//                "88800-000",
//                "casa",
//                2,
//                0,
//                3,
//                Arrays.asList("extintor de incêndio", "mangueira"),
//                1000.00f,
//                400.00f
//        );
//    }
//
//    @Order(1)
//    @DisplayName("Teste getCodigo")
//    @ParameterizedTest
//    @ValueSource(strings = {"40A16", "6030ER", "C3A19"})
//    void getCodigo(String codigo) {
//        assertEquals(codigo, imovel.getCodigo());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"40A16", "6030ER", "C3A19"})
//    @Order(2)
//    @DisplayName("Teste setCodigo")
//    void setCodigo(String codigo) {
//        imovel.setCodigo(codigo);
//        assertEquals(codigo, imovel.getCodigo());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"Essa é uma descrição bem descritiva", "descrição um pouco mais criativa", "descrição mais criativa que o normal"})
//    @Order(3)
//    @DisplayName("Teste getDescricao")
//    void getDescricao(String descricao) {
//        assertEquals(descricao, imovel.getDescricao());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"descrição curta", "descrição um pouco longa", "descrição muito, mas muito, muito longa"})
//    @Order(4)
//    @DisplayName("Teste setDescricao")
//    void setDescricao(String descricao) {
//        imovel.setDescricao(descricao);
//        assertEquals(descricao, imovel.getDescricao());
//    }
//
//    @ParameterizedTest
//    @Order(5)
//    @ValueSource(strings = {"Rua 0", "Rua dos bobos"})
//    @DisplayName("Teste getRua")
//    void getRua(String rua) {
//        assertEquals(rua, imovel.getRua());
//    }
//
//    @ParameterizedTest
//    @Order(6)
//    @DisplayName("Teste getRua")
//    @ValueSource(strings = {"Rua 0", "Rua dos bobos"})
//    void setRua(String rua) {
//        imovel.setDescricao(rua);
//        assertEquals(rua, imovel.getRua());
//    }
//
//    @ParameterizedTest
//    @Order(7)
//    @ValueSource(ints = {0, 4579, 123})
//    @DisplayName("Teste getNumero")
//    void getNumero(int numero) {
//        assertEquals(numero, imovel.getNumero());
//    }
//
//    @ParameterizedTest
//    @Order(8)
//    @DisplayName("Teste setNumero")
//    @ValueSource(ints = {0, 4579, 123})
//    void setNumero(int numero) {
//        imovel.setNumero(numero);
//        assertEquals(numero, imovel.getNumero());
//    }
//
//    @ParameterizedTest
//    @Order(9)
//    @DisplayName("Teste getBairro")
//    @ValueSource(strings = {"Bairro 1", "Bairro 2", "Desconhecido"})
//    void getBairro(String bairro) {
//        assertEquals(bairro, imovel.getBairro());
//    }
//
//    @ParameterizedTest
//    @Order(10)
//    @DisplayName("Teste setBairro")
//    @ValueSource(strings = {"Bairro 1", "Bairro 2", "Desconhecido"})
//    void setBairro(String bairro) {
//        imovel.setBairro(bairro);
//        assertEquals(bairro, imovel.getBairro());
//    }
//
//    @ParameterizedTest
//    @Order(11)
//    @DisplayName("Teste getCidade")
//    @ValueSource(strings = {"Cidade 1", "Cidade 2", "Escondida"})
//    void getCidade(String cidade) {
//        assertEquals(cidade, imovel.getCidade());
//    }
//
//    @ParameterizedTest
//    @Order(12)
//    @DisplayName("Teste setCidade")
//    @ValueSource(strings = {"Cidade 1", "Cidade 2", "Escondida"})
//    void setCidade(String cidade) {
//        imovel.setCidade(cidade);
//        assertEquals(cidade, imovel.getCidade());
//    }
//
//    @ParameterizedTest
//    @Order(13)
//    @DisplayName("Teste getEstado")
//    @ValueSource(strings = {"PR", "SP", "ND"})
//    void getEstado(String estado) {
//        assertEquals(estado, imovel.getEstado());
//    }
//
//    @ParameterizedTest
//    @Order(14)
//    @DisplayName("Teste setEstado")
//    @ValueSource(strings = {"PR", "SP", "ND"})
//    void setEstado(String estado) {
//        imovel.setEstado(estado);
//        assertEquals(estado, imovel.getEstado());
//    }
//
//    @ParameterizedTest
//    @Order(15)
//    @DisplayName("Teste getPais")
//    @ValueSource(strings = {"Sri Lanka", "Groenlândia", "Neverland"})
//    void getPais(String pais) {
//        assertEquals(pais, imovel.getPais());
//    }
//
//    @ParameterizedTest
//    @Order(16)
//    @DisplayName("Teste setPais")
//    @ValueSource(strings = {"Sri Lanka", "Groenlândia", "Neverland"})
//    void setPais(String pais) {
//        imovel.setPais(pais);
//        assertEquals(pais, imovel.getPais());
//    }
//
//    @ParameterizedTest
//    @Order(17)
//    @DisplayName("Teste getCep")
//    @ValueSource(strings = {"13564-350", "14169-510", "88800-000"})
//    void getCep(String cep) {
//        assertEquals(cep, imovel.getCep());
//    }
//
//    @ParameterizedTest
//    @Order(18)
//    @DisplayName("Teste setCep")
//    @ValueSource(strings = {"13564-350", "14169-510", "88800-000"})
//    void setCep(String cep) {
//        imovel.setCep(cep);
//        assertEquals(cep, imovel.getCep());
//    }
//
//    @ParameterizedTest
//    @Order(19)
//    @DisplayName("Teste getTipo")
//    @ValueSource(strings = {"casa", "apartamento", "sala comercial"})
//    void getTipo(String tipo) {
//        assertEquals(tipo, imovel.getTipo());
//    }
//
//    @ParameterizedTest
//    @Order(20)
//    @DisplayName("Teste setTipo")
//    @ValueSource(strings = {"casa", "apartamento", "sala comercial"})
//    void setTipo(String tipo) {
//        imovel.setTipo(tipo);
//        assertEquals(tipo, imovel.getTipo());
//    }
//
//    @ParameterizedTest
//    @Order(21)
//    @DisplayName("Teste getQuantidadeGaragens")
//    @ValueSource(ints = {0, 1, 2, 4})
//    void getQuantidadeGaragens(int qtdGaragens) {
//        assertEquals(qtdGaragens, imovel.getQuantidadeGaragens());
//    }
//
//    @ParameterizedTest
//    @Order(22)
//    @DisplayName("Teste setQuantidadeGaragens")
//    @ValueSource(ints = {0, 1, 2, 4})
//    void setQuantidadeGaragens(int qtdGaragens) {
//        imovel.setQuantidadeGaragens(qtdGaragens);
//        assertEquals(qtdGaragens, imovel.getQuantidadeGaragens());
//    }
//
//    @ParameterizedTest
//    @Order(23)
//    @DisplayName("Teste getQuantidadeSuites")
//    @ValueSource(ints = {0, 1, 2, 4})
//    void getQuantidadeSuites(int qtdSuites) {
//        assertEquals(qtdSuites, imovel.getQuantidadeSuites());
//    }
//
//    @ParameterizedTest
//    @Order(24)
//    @DisplayName("Teste setQuantidadeSuites")
//    @ValueSource(ints = {0, 1, 2, 4})
//    void setQuantidadeSuites(int qtdSuites) {
//        imovel.setQuantidadeSuites(qtdSuites);
//        assertEquals(qtdSuites, imovel.getQuantidadeSuites());
//    }
//
//    @ParameterizedTest
//    @Order(25)
//    @DisplayName("Teste getQuantidadeQuartos")
//    @ValueSource(ints = {0, 1, 2, 3})
//    void getQuantidadeQuartos(int qtdQuartos) {
//        assertEquals(qtdQuartos, imovel.getQuantidadeQuartos());
//    }
//
//    @ParameterizedTest
//    @Order(26)
//    @DisplayName("Teste setQuantidadeQuartos")
//    @ValueSource(ints = {0, 1, 2, 3})
//    void setQuantidadeQuartos(int qtdQuartos) {
//        imovel.setQuantidadeQuartos(qtdQuartos);
//        assertEquals(qtdQuartos, imovel.getQuantidadeQuartos());
//    }
//
//    @Test
//    @Order(27)
//    @DisplayName("Teste getItensSeguranca")
//    void getItensSeguranca() {
//        List<String> listaItensSeguranca = new ArrayList<>();
//        listaItensSeguranca.add("extintor de incêndio");
//        listaItensSeguranca.add("mangueira");
//
//        assertIterableEquals(imovel.getItensSeguranca(), listaItensSeguranca);
//    }
//
//    @Test
//    @Order(28)
//    @DisplayName("Teste setItensSeguranca")
//    void setItensSeguranca() {
//        List<String> listaItensSeguranca = new ArrayList<>();
//        listaItensSeguranca.add("câmera de segurança");
//        listaItensSeguranca.add("interfone");
//        imovel.setItensSeguranca(listaItensSeguranca);
//
//        assertIterableEquals(listaItensSeguranca, imovel.getItensSeguranca());
//    }
//
//    @ParameterizedTest
//    @Order(29)
//    @DisplayName("Teste getValorAluguel")
//    @ValueSource(doubles = {1000.00f, 1503.21f, 780.32f})
//    void getValorAluguel(double valor) {
//        assertEquals(valor, imovel.getValorAluguel());
//    }
//
//    @ParameterizedTest
//    @Order(30)
//    @DisplayName("Teste setValorAluguel")
//    @ValueSource(doubles = {1000.00f, 1503.21f, 780.32f})
//    void setValorAluguel(double valor) {
//        imovel.setValorAluguel(valor);
//        assertEquals(valor, imovel.getValorAluguel());
//    }
//
//    @ParameterizedTest
//    @Order(31)
//    @DisplayName("Teste getValorCondominio")
//    @ValueSource(doubles = {400.00f, 450.00f, 250.00f})
//    void getValorCondominio(double valor) {
//        assertEquals(valor, imovel.getValorCondominio());
//    }
//
//    @ParameterizedTest
//    @Order(32)
//    @DisplayName("Teste setValorCondominio")
//    @ValueSource(doubles = {400.00f, 450.00f, 250.00f})
//    void setValorCondominio(double valor) {
//        imovel.setValorCondominio(valor);
//        assertEquals(valor, imovel.getValorCondominio());
//    }
//}

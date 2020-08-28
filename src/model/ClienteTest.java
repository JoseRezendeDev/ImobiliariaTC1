//package model;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class ClienteTest {
//    private static Cliente cliente;
//
//    @BeforeAll
//    public static void inicializaCliente() {
//        cliente = new Cliente();
//    }
//
//    @DisplayName("Teste sexo certo")
//    @Order(1)
//    @ParameterizedTest
//    @ValueSource(strings = {"m", "f", "M", "F", "masculino", "feminino", "MASCULINO", "FEMININO"})
//    public void setSexoCerto(String sexo) throws Exception {
//        cliente.setSexo(sexo);
//        assertEquals(sexo, cliente.getSexo());
//    }
//
//    @DisplayName("Teste sexo errado")
//    @Order(2)
//    @ParameterizedTest
//    @ValueSource(strings = {"blablabla", "ads"})
//    public void setSexoErrado(String sexo) throws Exception {
//        assertThrows(Exception.class, () -> cliente.setSexo(sexo));
//    }
//
//    @DisplayName("Teste CPF")
//    @Order(3)
//    @ParameterizedTest
//    @ValueSource(strings = {"11144455566", "11122233344"})
//    public void getSetCpf(String cpf) {
//        cliente.setCpf(cpf);
//        assertEquals(cpf, cliente.getCpf());
//    }
//
//    @DisplayName("Teste data de nascimento certo")
//    @Order(4)
//    @ParameterizedTest
//    @ValueSource(strings = {"12/04/1999", "04/11/2001"})
//    public void getSetDataNascimentoCerto(String data) throws ParseException {
//        cliente.setDataNascimento(data);
//        assertEquals(data, cliente.getDataNascimento());
//    }
//
//    @DisplayName("Teste data de nascimento errado")
//    @Order(5)
//    @ParameterizedTest
//    @ValueSource(strings = {"blablabla", "1234124234"})
//    public void getSetDataNascimentoErrado(String data) throws ParseException {
//        assertThrows(ParseException.class, () -> cliente.setDataNascimento(data));
//    }
//
//    @DisplayName("Teste salário")
//    @Order(6)
//    @ParameterizedTest
//    @ValueSource(doubles = {1500.23, 2200.00})
//    public void getSetSalario(Double salario) {
//        cliente.setSalario(salario);
//        assertEquals(salario, cliente.getSalario());
//    }
//
//    @DisplayName("Teste emails")
//    @Order(7)
//    @Test
//    public void getSetEmails() {
//        List<String> listaEmails = new ArrayList<>(Arrays.asList("jose@gmail.com", "felipe@gmail.com"));
//        cliente.setEmails(listaEmails);
//        assertEquals(listaEmails, cliente.getEmails());
//        // assertArrayEquals(listaEmails, cliente.getEmails());
//        assertIterableEquals(listaEmails, cliente.getEmails());
//    }
//
//    @DisplayName("Teste telefones")
//    @Order(8)
//    @Test
//    public void getSetTelefones() {
//        List<String> listaTelefones = new ArrayList<>(Arrays.asList("999887766", "911223344"));
//        cliente.setTelefones(listaTelefones);
//        assertEquals(listaTelefones, cliente.getTelefones());
//        // assertArrayEquals(listaTelefones, cliente.getTelefones());
//        assertIterableEquals(listaTelefones, cliente.getTelefones());
//    }
//}
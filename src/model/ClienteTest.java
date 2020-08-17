package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteTest {
    private Cliente cliente;

    @BeforeAll
    public void inicializaCliente() {
        cliente = new Cliente();
    }

    // @ParameterizedTest
    // @ValueSource(strings = {"m", "f", "M", "F", "masculino", "feminino"})
    public void setSexoCerto(String sexo) throws Exception {
        cliente.setSexo(sexo);
        assertEquals(sexo, cliente.getSexo());
    }

    // @ParameterizedTest
    // @ValueSource(strings = {"blablabla", "ads"})
    public void setSexoErrado(String sexo) throws Exception {
        assertThrows(Exception.class, () -> cliente.setSexo(sexo));
    }

    // @ParameterizedTest
    // @ValueSource(strings = {"11144455566", "11122233344"})
    public void getSetCpf(String cpf) {
        cliente.setCpf(cpf);
        assertEquals(cpf, cliente.getCpf());
    }

    // @ParameterizedTest
    // @ValueSource(strings = {"12/04/1999", "04/11/2001"})
    public void getSetDataNascimentoCerto(String data) throws ParseException {
        cliente.setDataNascimento(data);
        assertEquals(data, cliente.getDataNascimento());
    }

    // @ParameterizedTest
    // @ValueSource(strings = {"blablabla", "1234124234"})
    public void getSetDataNascimentoErrado(String data) throws ParseException {
        assertThrows(ParseException.class, () -> cliente.setDataNascimento(data));
    }

    // @ParameterizedTest
    // @ValueSource(doubles = {"1500.23", "2200.00"})
    public void getSetSalario(Double salario) {
        cliente.setSalario(salario);
        assertEquals(salario, cliente.getSalario());
    }
}
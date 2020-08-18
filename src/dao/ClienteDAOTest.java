package dao;

import model.Cliente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDAOTest {
    private ClienteDAO clienteDAO;

    @BeforeEach
    public void inicializaClienteDao() {
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void inserirCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("jose");
        cliente.setCpf("11122233344");
        cliente.setDataNascimento("01/01/2001");
        cliente.setSexo("m");
        cliente.setSalario(1000.0);
        cliente.setEmails(Arrays.asList("jose@gmail.com", "felipe@gmail.com"));
        cliente.setTelefones(Arrays.asList("112233445", "999112299"));

        clienteDAO.inserirCliente(cliente);

        Cliente clienteInserido = clienteDAO.getClientes().get(0);

        assertEquals(cliente.getNome(), clienteInserido.getNome());
        assertEquals(cliente.getCpf(), clienteInserido.getCpf());
        assertEquals(cliente.getDataNascimento(), clienteInserido.getDataNascimento());
        assertEquals(cliente.getSexo(), clienteInserido.getSexo());
        assertEquals(cliente.getSalario(), clienteInserido.getSalario());
        assertEquals(cliente.getEmails(), clienteInserido.getEmails());
        assertIterableEquals(cliente.getEmails(), clienteInserido.getEmails());
        assertEquals(cliente.getTelefones(), clienteInserido.getTelefones());
        assertIterableEquals(cliente.getTelefones(), clienteInserido.getTelefones());
    }

    @Test
    public void alterarCliente() throws Exception {
        Cliente clienteVelho = new Cliente();
        clienteVelho.setNome("jose");
        clienteVelho.setCpf("11122233344");
        clienteVelho.setDataNascimento("01/01/2001");
        clienteVelho.setSexo("m");
        clienteVelho.setSalario(1000.0);
        clienteVelho.setEmails(Arrays.asList("jose@gmail.com", "felipe@gmail.com"));
        clienteVelho.setTelefones(Arrays.asList("112233445", "999112299"));

        clienteDAO.inserirCliente(clienteVelho);

        Cliente clienteNovo = new Cliente();
        clienteNovo.setNome("felipe");
        clienteNovo.setDataNascimento("02/02/2002");
        clienteNovo.setSexo("m");
        clienteNovo.setSalario(2000.0);
        clienteNovo.setEmails(Arrays.asList("jose2@gmail.com", "felipe2@gmail.com"));
        clienteNovo.setTelefones(Arrays.asList("112233445", "999112299", "445566332"));

        clienteDAO.alterarCliente("11122233344", clienteNovo);

        Cliente clienteAlterado = clienteDAO.getClientes().get(0);

        assertEquals(clienteNovo.getNome(), clienteAlterado.getNome());
        assertEquals(clienteNovo.getDataNascimento(), clienteAlterado.getDataNascimento());
        assertEquals(clienteNovo.getSexo(), clienteAlterado.getSexo());
        assertEquals(clienteNovo.getSalario(), clienteAlterado.getSalario());
        assertEquals(clienteNovo.getEmails(), clienteAlterado.getEmails());
        assertIterableEquals(clienteNovo.getEmails(), clienteAlterado.getEmails());
        assertEquals(clienteNovo.getTelefones(), clienteAlterado.getTelefones());
        assertIterableEquals(clienteNovo.getTelefones(), clienteAlterado.getTelefones());
    }

    @Test
    public void excluirCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("jose");
        cliente.setCpf("99988877766");
        cliente.setDataNascimento("01/01/2001");
        cliente.setSexo("m");
        cliente.setSalario(1000.0);
        cliente.setEmails(Arrays.asList("jose@gmail.com", "felipe@gmail.com"));
        cliente.setTelefones(Arrays.asList("112233445", "999112299"));

        clienteDAO.inserirCliente(cliente);

        clienteDAO.excluirCliente("99988877766");

        Cliente clienteExcluido = clienteDAO.getCliente("99988877766");

        assertNull(clienteExcluido);
    }
}
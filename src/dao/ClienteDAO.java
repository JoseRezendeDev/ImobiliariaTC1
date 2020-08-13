package dao;

import model.Cliente;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes;

    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    public void inserirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void alterarCliente(String cpf, Cliente clienteAtualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                try {
                    cliente.setDataNascimento(clienteAtualizado.getDataNascimento().toString());
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setSalario(clienteAtualizado.getSalario());
                    cliente.setSexo(clienteAtualizado.getSexo().toString());
                    cliente.setEmails(clienteAtualizado.getEmails());
                    cliente.setTelefones(clienteAtualizado.getTelefones());
                } catch (Exception e) {
                    System.out.println("Falha ao alterar cliente");
                }
            }
        }
    }

    public void excluirCliente(String cpf) {
        clientes.remove(getCliente(cpf));
    }

    public Cliente getCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

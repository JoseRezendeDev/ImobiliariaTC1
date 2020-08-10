package dao;

import model.Cliente;

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
                cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setSalario(clienteAtualizado.getSalario());
                cliente.setSexo(clienteAtualizado.getSexo());
                cliente.setEmails(clienteAtualizado.getEmails());
                cliente.setTelefones(clienteAtualizado.getTelefones());
            }
        }
    }

    public void excluirCliente(String cpf) {
        clientes.remove(getCliente(cpf));
    }

    public Cliente getCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

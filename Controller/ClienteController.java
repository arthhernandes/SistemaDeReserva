package Controller;
import Model.Cliente;

import java.util.ArrayList;

public class ClienteController {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(int id, String nome, String sobrenome, String telefone) {
        Cliente novoCliente = new Cliente(id, nome, sobrenome, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado: " + nome);
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome());
        }
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}

package Controller;
import Model.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClienteController {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void cadastrarCliente(int id, String nome, String sobrenome, String telefone) {
        Cliente novoCliente = new Cliente(id, nome, sobrenome, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado: " + nome);
    }

    public static void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome());
        }
    }

    public static Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public static void salvarClientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt"))) {
            for (Cliente cliente : clientes) {
                String linha = cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getSobrenome() + ";" + cliente.getTelefone();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Clientes salvos com sucesso no arquivo clientes.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }
}

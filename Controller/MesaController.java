package Controller;
import Model.Mesa;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class MesaController {
    private static ArrayList<Mesa> mesas = new ArrayList<>();

    public static void adicionarMesa(int numero, int capacidade) {
        Mesa novaMesa = new Mesa(numero, capacidade);
        mesas.add(novaMesa);
        System.out.println("Mesa adicionada: " + numero);
    }

    public static void listarMesas() {
        for (Mesa mesa : mesas) {
            System.out.println("Mesa " + mesa.getNumeroMesa() + " | Disponível: " + mesa.isDisponivel());
        }
    }

    public static Mesa buscarMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numero) {
                return mesa;
            }
        }
        return null;
    }
  public static void salvarMesas() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("mesas.txt"))) {
        for (Mesa mesa : mesas) {
            String linha = mesa.getNumeroMesa() + ";" + mesa.getCapacidade() + ";" + mesa.isDisponivel();
            writer.write(linha);
            writer.newLine();
        }
        System.out.println("Mesas salvas com sucesso no arquivo mesas.txt");
    } catch (IOException e) {
        System.out.println("Erro ao salvar mesas: " + e.getMessage());
    }
}

}

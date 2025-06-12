package Controller;
import Model.Mesa;

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
}

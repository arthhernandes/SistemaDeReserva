package Controller;
import Model.Mesa;

import java.util.ArrayList;

public class MesaController {
    private ArrayList<Mesa> mesas = new ArrayList<>();

    public void adicionarMesa(int numero, int capacidade) {
        Mesa novaMesa = new Mesa(numero, capacidade);
        mesas.add(novaMesa);
        System.out.println("Mesa adicionada: " + numero);
    }

    public void listarMesas() {
        for (Mesa mesa : mesas) {
            System.out.println("Mesa " + mesa.getNumeroMesa() + " | Disponível: " + mesa.isDisponivel());
        }
    }

    public Mesa buscarMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numero) {
                return mesa;
            }
        }
        return null;
    }
}

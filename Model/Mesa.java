package Model;

public class Mesa implements Reservavel{

    private int numeroMesa;
    private int capacidade;
    private boolean disponivel;

    public Mesa(int numeroMesa, int capacidade){
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    @Override
    public void reservar() {
        if (disponivel){
            disponivel = false;
            System.out.print("A mesa " + numeroMesa + " foi reservada!");
        }else{
            System.out.print("A mesa " + numeroMesa + " ja foi reservada.");
        }
    }

    @Override
    public void liberar() {
        disponivel = true;
        System.out.print("A mesa " + numeroMesa + " foi liberada para reserva novamente.");
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}

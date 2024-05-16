package teste_elevador;

class Elevador {
	
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int numPessoas;

    public Elevador(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0; 
        this.numPessoas = 0;
    }

    public void entra() {
        if (numPessoas < capacidade) {
            numPessoas++;
        } else {
            System.out.println("Elevador cheio!");
        }
    }

    public void sai() {
        if (numPessoas > 0) {
            numPessoas--;
        } else {
            System.out.println("Elevador já está vazio!");
        }
    }

    public void sobe() {
        if (andarAtual < totalAndares) {
            andarAtual++;
        } else {
            System.out.println("Você já está no último andar!");
        }
    }

    public void desce() {
        if (andarAtual > 0) {
            andarAtual--;
        } else {
            System.out.println("Você já está no térreo!");
        }
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumPessoas() {
        return numPessoas;
    }
}

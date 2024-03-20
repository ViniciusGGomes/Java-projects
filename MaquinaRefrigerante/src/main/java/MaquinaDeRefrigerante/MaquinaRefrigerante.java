package MaquinaDeRefrigerante;

import MaquinaDeRefrigerante.Bebidas;

public class MaquinaRefrigerante {
    private int capacidade;
    private int quantidadeAtual;
    private double dinheiro;
    private Bebidas[] estoque;
    
    public MaquinaRefrigerante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaquinaRefrigerante(int capacidade, double dinheiroInicial, Bebidas[] estoqueInicial) {
        this.capacidade = capacidade;
        this.quantidadeAtual = capacidade;
        this.dinheiro = dinheiroInicial;
        this.estoque = estoqueInicial;
    }
	
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public Bebidas[] getEstoque() {
		return estoque;
	}

	public void setEstoque(Bebidas[] estoque) {
		this.estoque = estoque;
	}

	//Método da compra
	public double comprar(int indiceBebida, double valorInserido) {
        if (indiceBebida >= 0 && indiceBebida < estoque.length) {
            Bebidas bebida = estoque[indiceBebida];
            if (bebida.getQuantidade() > 0 && valorInserido >= bebida.getValor()) {
                quantidadeAtual--;
                dinheiro += bebida.getValor();
                bebida.setQuantidade(bebida.getQuantidade() - 1);
                double troco = valorInserido - bebida.getValor();
                System.out.println("Compra realizada com sucesso: " + bebida.getNome());
                return troco;
            }
        }
        return -1; // Retorna -1 para indicar que a compra não foi realizada
    }

	//Método troco
    public double troco() {
        double troco = dinheiro;
        dinheiro = 0;
        return troco;
    }
    
    
}

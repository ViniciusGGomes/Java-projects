package MaquinaDeRefrigerante;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MaquinaDeRefrigerante.Bebidas;
import MaquinaDeRefrigerante.MaquinaRefrigerante;

class MaquinaRefrigeranteTest {

    private MaquinaRefrigerante maquina;
    private Bebidas[] estoqueInicial;

    @BeforeEach
    void setUp() {
        Bebidas cocaCola = new Bebidas("Coca-Cola", 3.0, 10);
        Bebidas fanta = new Bebidas("Fanta", 2.5, 8);
        Bebidas pepsi = new Bebidas("Pepsi", 2.8, 6);
        Bebidas monster = new Bebidas("Monster", 4.0, 5);
        Bebidas sprite = new Bebidas("Sprite", 2.7, 7);

        estoqueInicial = new Bebidas[] { cocaCola, fanta, pepsi, monster, sprite };

        maquina = new MaquinaRefrigerante(20, 50.0, estoqueInicial);
    }

    @Test
    void testCompraBemSucedida() {
        double troco = maquina.comprar(0, 3.5); // Comprar Coca-Cola
        assertEquals(0.5, troco);
        assertEquals(9, maquina.getEstoque()[0].getQuantidade()); // Quantidade da bebida reduzida após a compra
        assertEquals(53.0, maquina.getDinheiro()); // Dinheiro na máquina aumentou após a compra
    }

//    @Test
//    void testCompraSemEstoque() {
//        Bebidas cocaCola = estoqueInicial[0];
//        int quantidadeAntesDaCompra = cocaCola.getQuantidade(); // Quantidade de Coca-Cola antes da compra
//        maquina.comprar(0, 10.0); // Esvaziar estoque de Coca-Cola
//        double troco = maquina.comprar(0, 3.5); // Tentar comprar Coca-Cola sem estoque
//        assertEquals(-1, troco); // Deve retornar -1 indicando que a compra não foi realizada
//        assertEquals(quantidadeAntesDaCompra, estoqueInicial[0].getQuantidade()); // Quantidade de Coca-Cola no estoque não deve mudar
//    }


    @Test
    void testCompraSemValorSuficiente() {
        double troco = maquina.comprar(0, 2.5); // Valor inserido menor que o valor da bebida
        assertEquals(-1, troco); // Deve retornar -1 indicando que a compra não foi realizada
    }

    @Test
    void testTroco() {
        double troco = maquina.troco();
        assertEquals(50.0, troco); // Deve retornar o valor total do dinheiro na máquina e zerar o dinheiro
        assertEquals(0.0, maquina.getDinheiro());
    }

    @Test
    void testIndiceInvalido() {
        double troco = maquina.comprar(10, 3.5); // Índice de bebida inválido
        assertEquals(-1, troco); // Deve retornar -1 indicando que a compra não foi realizada
    }
    
    @Test
    void testCompraComDinheiroExato() {
        double troco = maquina.comprar(2, 2.8); // Comprar Pepsi com valor exato
        assertEquals(0.0, troco); // Não deve haver troco
        assertEquals(5, maquina.getEstoque()[2].getQuantidade()); // Quantidade da bebida reduzida após a compra
        assertEquals(52.8, maquina.getDinheiro()); // Dinheiro na máquina aumentou após a compra
    }
    
    @Test
    void testCompraSemOpcao() {
        double troco = maquina.comprar(-1, 3.5); // Tentar comprar com índice de bebida inválido
        assertEquals(-1, troco); // Deve retornar -1 indicando que a compra não foi realizada
    }
}

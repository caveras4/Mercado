package br.com.lab.lab03;

import java.util.Locale;

public class Produto {

    private String produtoNome;
    private Double valorProduto;
    private boolean produtoAtivo;

    public Produto(String produtoNome, Double valorProduto, boolean produtoAtivo) {

        this.produtoNome = produtoNome;
        this.valorProduto = valorProduto;
        this.produtoAtivo = produtoAtivo;
    }

    public boolean buscaProduto(String nomeProduto){
        BancoDeDados banco = new BancoDeDados();

        for (Produto produto : banco.getListaProduto()) {
            if (produto.produtoNome.equals(nomeProduto.toUpperCase())){
                if (produto.produtoAtivo) {
                    System.out.println("\n************************************" +
                                       produto +
                                       "\n************************************");
                    return true;
                }
            }
        }
        System.out.println("Produto indisponível");
        return false;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public Double getValorProduto() {
        return valorProduto;
    }
    public boolean isProdutoAtivo() {
        return produtoAtivo;
    }

    @Override
    public String toString() {
        return ("\nProduto: " + this.produtoNome +
                "\nPreço: R$" + this.valorProduto
                );
    }

}

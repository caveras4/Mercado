package br.com.lab.lab03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDeDados {

    Map<Usuario, List<Produto>> carrinhoUsuario = new HashMap<>();
    List<Usuario> listaUsuario = new ArrayList<>();
    List<Produto> listaProduto = new ArrayList<>();

    List<Produto> carrinho = new ArrayList<>();

    public List<Usuario> getListaUsuarios(){
        listaUsuario.add(new Usuario("caio", "1234"));
        listaUsuario.add(new Usuario("carlos", "12345"));
        listaUsuario.add(new Usuario("dalvo", "abc123"));

        return listaUsuario;
    }

    public List<Produto> getListaProduto(){

        listaProduto.add(new Produto("QUEIJO", 5.50, true));
        listaProduto.add(new Produto("LEITE", 9.00, true));
        listaProduto.add(new Produto("CEBOLA", 10.55, true));
        listaProduto.add(new Produto("BATATA", 16.00, false));
        listaProduto.add(new Produto("BANANA", 8.13, true));
        listaProduto.add(new Produto("TOMATE", 10.18, true));
        listaProduto.add(new Produto("LARANJA", 8.00, false));

        return listaProduto;
    }

    public void adicionarCarrinho(String produto){

        BancoDeDados banco = new BancoDeDados();

        for (Produto produtoBuscado : banco.getListaProduto()) {
            if (produtoBuscado.getProdutoNome().equals(produto)){

                carrinho.add(produtoBuscado);
            }
        }
    }

    public void carrinho(Usuario usuario, List<Produto> listaProdutos){


        carrinhoUsuario.put(usuario, listaProdutos);
        double totalValor = 0;

        System.out.println("\n************************************" +
                           "\n------------ NOTA FISCAL --------------");

        for (Produto produto : listaProdutos) {
            System.out.println(produto);
            totalValor += produto.getValorProduto();
        }

        System.out.printf("\nTotal: R$%.2f", totalValor);
        System.out.println("\n************************************");
    }

}

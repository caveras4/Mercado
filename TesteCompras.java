package br.com.lab.lab03;

import java.util.Scanner;

public class TesteCompras {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Usuario usuarios = new Usuario(null, null);
        Produto produto = new Produto(null, null, false);
        BancoDeDados banco = new BancoDeDados();
        boolean loginCorreto = false;
        boolean temProduto;
        String nomeProduto;
        String login = "";
        String senha;
        boolean entrarSistema = true;

        System.out.println("Bem vindo ao mercado!");

        while (entrarSistema){

            System.out.println("Deseje logar com sua conta? (1)Sim (0)Não");
            String logar = input.nextLine().toLowerCase();

            if (logar.equals("1") || logar.equals("sim")){

                while (!loginCorreto) {

                    System.out.println("Digite seu login: ");
                    login = input.nextLine();

                    System.out.println("Digite sua senha: ");
                    senha = input.nextLine();

                    loginCorreto = usuarios.validaLogin(login, senha);
                    if (!loginCorreto) System.out.println("Login inválido! \nTente novamente!\n");
                }

                System.out.println("Logado com sucesso!");


                do {
                    System.out.println("Digite o nome do produto ou 'sair' para encerrar: ");
                    nomeProduto = input.nextLine().toUpperCase();

                    if (!nomeProduto.equals("SAIR")) {
                        temProduto = produto.buscaProduto(nomeProduto);

                        if (temProduto) {
                            System.out.println("Deseja adicionar o produto ao carrinho? Digite 1 (Sim) ou 0 (Não)");
                            String adicionarCarrinho = input.nextLine();

                            if (adicionarCarrinho.equals("1")) {
                                banco.adicionarCarrinho(nomeProduto);
                                System.out.println("Produto adicionado ao carrinho!\n");
                            }
                        }
                    }

                } while (!nomeProduto.equals("SAIR"));

                for (Usuario usuario : banco.getListaUsuarios()) {
                    if (usuario.getLogin().equals(login)) {
                        banco.carrinho(usuario, banco.carrinho);
                    }
                }

                loginCorreto = false;

            } else {
                entrarSistema = false;
            }
        }


        System.out.println("Programa encerrado!");

    }
}

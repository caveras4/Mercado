package br.com.lab.lab03;


public class Usuario {

    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }


    public boolean validaLogin(String login, String senha) {

        BancoDeDados banco = new BancoDeDados();

        for (Usuario usuario : banco.getListaUsuarios()) {
            if (usuario.login.equals(login) && usuario.senha.equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return login;
    }
}

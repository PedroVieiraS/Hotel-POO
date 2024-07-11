package com.poo.hotel.poo;

import java.util.ArrayList;
import java.util.List;

public class Login {
    public static final List<Usuario> usuarios = new ArrayList<>();

    // Inicializar com alguns usuários padrão
    static {
        usuarios.add(new Usuario("visitante", "123", "visitante"));
        usuarios.add(new Usuario("funcionario", "456", "funcionario"));
        usuarios.add(new Usuario("gestor", "789", "gestor"));
        usuarios.add(new Usuario("cliente", "123", "pedro"));
    }

    public static boolean autenticar(String login, String senha, String tipoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha) && usuario.getTipoUsuario().equalsIgnoreCase(tipoUsuario)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cadastrarUsuario(String login, String senha, String tipoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println("Usuário já existe!");
                return false;
            }
        }
        usuarios.add(new Usuario(login, senha, tipoUsuario));
        System.out.println("Usuário cadastrado com sucesso!");
        return true;
    }
}

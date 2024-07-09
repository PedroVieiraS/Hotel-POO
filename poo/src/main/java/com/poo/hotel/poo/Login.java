package com.poo.hotel.poo;

public class Login {
    private static final String VISITANTE_LOGIN = "visitante";
    private static final String VISITANTE_SENHA = "123";
    private static final String FUNCIONARIO_LOGIN = "funcionario";
    private static final String FUNCIONARIO_SENHA = "456";
    private static final String GESTOR_LOGIN = "gestor";
    private static final String GESTOR_SENHA = "789";

    public static boolean autenticar(String login, String senha, String tipoUsuario) {
        switch (tipoUsuario.toLowerCase()) {
            case "visitante":
                return login.equals(VISITANTE_LOGIN) && senha.equals(VISITANTE_SENHA);
            case "funcionario":
                return login.equals(FUNCIONARIO_LOGIN) && senha.equals(FUNCIONARIO_SENHA);
            case "gestor":
                return login.equals(GESTOR_LOGIN) && senha.equals(GESTOR_SENHA);
            default:
                return false;
        }
    }
}

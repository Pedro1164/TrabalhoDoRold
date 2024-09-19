import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario implements Serializable {
    private String login;
    private String senhaCriptografada;

    // Construtor da classe Usuario
    public Usuario(String login, String senha) {
        this.login = login;
        this.senhaCriptografada = criptografarSenha(senha);
    }

    // Método para criptografar a senha usando o algoritmo SHA
    private String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar senha", e);
        }
    }

    // Retorna ao login do usuário
    public String getLogin() {
        return login;
    }

    // Valida a senha do usuário
    public boolean validarSenha(String senha) {
        return this.senhaCriptografada.equals(criptografarSenha(senha));
    }

    // Método para gerenciar osusuários
    public static void gerenciarUsuarios(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.println("Gerenciar Usuários:");
        System.out.println("1. Adicionar Usuário");
        System.out.println("2. Listar Usuários");
        System.out.println("--------------");

        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.println("Digite o login do novo usuário:");
                String login = scanner.nextLine();
                System.out.println("Digite a senha do novo usuário:");
                String senha = scanner.nextLine();
                usuarios.add(new Usuario(login, senha));
                System.out.println("Usuário adicionado com sucesso!");
                break;
            case 2:
                System.out.println("Usuários:");
                System.out.println("--------------");
                for (Usuario usuario : usuarios) {
                    System.out.println("Login: " + usuario.getLogin());
                }
                break;
            default:
                System.out.println("Opção inválida.");
                System.out.println("--------------");
        }
    }
}

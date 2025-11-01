package view;

import model.Cadastro;

import java.util.Scanner;

public class CadastroView {
    private static Scanner scan = new Scanner(System.in) ;

    public static Cadastro novoCadastro(){
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Idade: ");
        Integer idade = scan.nextInt();

        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setIdade(idade);

        return cadastro;
    }

}

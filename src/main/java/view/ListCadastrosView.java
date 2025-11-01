package view;

import model.Cadastro;

import java.util.List;

public class ListCadastrosView {
    public static void mostrarLista(List<Cadastro> cadastroList){
        int larguraTotal = 50;
        System.out.println("-".repeat(larguraTotal));//linha separadora

        //texto centralizado
        System.out.println(centralizar("LISTA DE CADASTROS",larguraTotal));

        System.out.println("-".repeat(larguraTotal));//linha separadora

        //cabeçalho da tabela
        System.out.printf("%-5s | %-20s | %-5s%n","ID","NOME","IDADE");

        System.out.println("-".repeat(larguraTotal));

        //linhas da tabela
        if(cadastroList.isEmpty()){
            System.out.println("Nenhum cadastro encontrado");
        }else {
            for (Cadastro c: cadastroList){
                System.out.printf("%-5d | %-20s | %-55d%n",c.getId(),c.getNome(),c.getIdade());
            }
        }


    }

    public static String centralizar(String texto,int largura){
        if(texto.length() >= largura) return texto;
        int espacos = (largura - texto.length()) / 2;
        return " ".repeat(espacos)+texto;
    }

    public static void mostrarCadastro(Cadastro cadastro) {
        int larguraTotal = 50;
        System.out.println("-".repeat(larguraTotal));

        System.out.println(centralizar("DETALHES DO CADASTRO", larguraTotal));
        System.out.println("-".repeat(larguraTotal));

        if (cadastro == null) {
            System.out.println("Cadastro não encontrado!");
        } else {
            System.out.printf("%-10s: %d%n", "ID", cadastro.getId());
            System.out.printf("%-10s: %s%n", "NOME", cadastro.getNome());
            System.out.printf("%-10s: %d%n", "IDADE", cadastro.getIdade());
        }

        System.out.println("-".repeat(larguraTotal));
    }



}

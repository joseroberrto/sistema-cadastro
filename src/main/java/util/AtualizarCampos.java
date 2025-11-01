package util;


import java.util.Scanner;

public class AtualizarCampos {
    private static  Scanner scan = new Scanner(System.in);
    public static String atualizarNomeIdade(String pergunta){
        System.out.println(pergunta +"(s/n)");
        String resp = scan.nextLine();

        if (resp.equalsIgnoreCase("s")){
            System.out.println("Digite o novo valor: ");
            String valor = scan.nextLine();
            if (!valor.isBlank()){
                return valor;
            }
        }
        return null;
    }

    public static Integer atualizarId(){
        System.out.print("Digite o ID do cadastro: ");
        Integer id = scan.nextInt();
        scan.nextLine();

        return id;

    }


}

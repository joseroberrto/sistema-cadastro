package application;

import model.Cadastro;
import util.AtualizarCampos;
import util.ConexaoFactory;
import dao.CadastroRepository;
import view.CadastroView;
import view.ListCadastrosView;
import java.util.List;
import java.util.Scanner;


public class SistemaCadastro {
    public static void main(String[] args) {
        //entre na pasta util/ConexaoFactory para config do DB MySQL
        ConexaoFactory.conectar();
        CadastroRepository repository = new CadastroRepository() ;
        Cadastro cadastro;
        List<Cadastro>cadastroList ;
        int opcao;
        Scanner scan = new  Scanner(System.in);

        do {
            System.out.println("==================================================");
            System.out.println("                 SISTEMA DE CADASTRO              ");
            System.out.println("==================================================");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar cadastros");
            System.out.println("3 - Alterar cadastro");
            System.out.println("4 - Excluir cadastro");
            System.out.println("5 - Buscar cadastro");
            System.out.println("0 - Sair");
            System.out.println("==================================================");
            System.out.print(">>Digite sua opção: ");
            opcao = scan.nextInt();

            switch (opcao){
                case 1 :
                    cadastro = CadastroView.novoCadastro();
                    repository.incluir(cadastro);
                    break;
                case 2:
                    cadastroList = repository.listar();
                    ListCadastrosView.mostrarLista( cadastroList);
                    break;
                case 3:
                    repository.alterar();
                    break;
                case 4:
                    repository.excluir();
                    break;
                case 5:
                    repository.buscar(AtualizarCampos.atualizarId());
                    break;
                case 0:
                    System.out.println("Fechando sistema.....Bye Bye");
                    break;
                default:
                    System.out.println("Opção inálida.Tenete novamente");
                    break;
            }

        }while (opcao != 0);



    }
}

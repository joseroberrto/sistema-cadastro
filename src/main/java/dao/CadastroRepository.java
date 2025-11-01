package dao;
import model.Cadastro;
import util.AtualizarCampos;
import util.ConexaoFactory;
import view.ListCadastrosView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CadastroRepository {
    private static Scanner scan = new Scanner(System.in);
    private Connection conexao;

    public CadastroRepository(){
        conexao = ConexaoFactory.getConexao();
    }
    public void incluir(Cadastro cadastro){

        String instrucaoSQL ="INSERT INTO sistema_cadastro.pessoa(nome, idade)VALUES(?,?);";
        try (PreparedStatement pst = conexao.prepareStatement(instrucaoSQL, Statement.RETURN_GENERATED_KEYS);){
            pst.setString(1,cadastro.getNome());
            pst.setInt(2,cadastro.getIdade());
            int linhasAfetadas = pst.executeUpdate();


            if (linhasAfetadas > 0) {
                try (ResultSet rs = pst.getGeneratedKeys()) {  //pega o ID auto-increment
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        cadastro.setId(id);
                    }
                }
            }
            System.out.println("Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void alterar( ){
       int id= AtualizarCampos.atualizarId();

        CadastroRepository repository = new CadastroRepository();
        Cadastro cadastro= repository.buscar(id);
        String valor = AtualizarCampos.atualizarNomeIdade("Alterar nome?");
        if (valor != null){
            cadastro.setNome(valor);
        }

        valor = AtualizarCampos.atualizarNomeIdade("Alterar idade?");
        if(valor != null){
            cadastro.setIdade(Integer.parseInt(valor));
        }



        String instrucaoSQL ="UPDATE sistema_cadastro.pessoa SET nome=?, idade=? WHERE id=?";
        try (PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);){

            pst.setString(1,cadastro.getNome());
            pst.setInt(2,cadastro.getIdade());
            pst.setInt(3,cadastro.getId());
            pst.execute();
            System.out.println("Cadastro alterado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Dados invalidos.Tente inserir um dado valido");
        }
    }


    public void excluir( ){
        Integer id = AtualizarCampos.atualizarId();
        if(buscar(id) == null){
            System.out.println("ID não existe.Tente um ID válido");
            return;
        }


        String instrucaoSQL ="DELETE FROM sistema_cadastro.pessoa WHERE id=?;";
        try (PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);){
            pst.setInt(1,id);
            pst.execute();
            System.out.println("Cadastro excluido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Cadastro> listar(){
        List<Cadastro> listaCadastros = new ArrayList<>();
        String intrucaoSQL = "SELECT id, nome, idade FROM sistema_cadastro.pessoa";
        try(PreparedStatement pst = conexao.prepareStatement(intrucaoSQL);
            ResultSet result = pst.executeQuery();) {

            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                int idade  = result.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                listaCadastros.add(cadastro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCadastros;

    }
    public Cadastro buscar(Integer id){
        Cadastro cadastro = null;
        String intrucaoSQL = "SELECT id, nome, idade FROM sistema_cadastro.pessoa WHERE id =?";
        try(PreparedStatement pst = conexao.prepareStatement(intrucaoSQL);) {

            pst.setInt(1,id);
            try(ResultSet result = pst.executeQuery();){
                if(result.next()){
                    String nome = result.getString("nome");
                    int idade  = result.getInt("idade");

                    cadastro = new Cadastro();
                    cadastro.setId(id);
                    cadastro.setNome(nome);
                    cadastro.setIdade(idade);

                    ListCadastrosView.mostrarCadastro(cadastro);


                }else{
                    return null;
                }


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cadastro;
    }

}

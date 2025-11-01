package util;

import java.sql.*;

public class ConexaoFactory {
    private static final String urlRoot = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static  final String password = "SuaSenhaAqui";//troque pela sua senhar usada no mysql
    private  static  final String dbName = "sistema_cadastro";//nome do DB
    private static Connection conexao;

    public static Connection getConexao() {
        return conexao;
    }

    public static void conectar() {
       try {
           // conecta sem banco para criar se necessário
           conexao = DriverManager.getConnection(urlRoot, user, password);
           Statement stmt = conexao.createStatement();

           // verifica se o banco existe
           ResultSet rst = stmt.executeQuery("SHOW DATABASES LIKE '" + dbName + "'");
           if (!rst.next()) {
               stmt.executeUpdate("CREATE DATABASE " + dbName);
               System.out.println("Banco de dados '" + dbName + "' criado com sucesso!");
           } else {
               System.out.println("Banco de dados '" + dbName + "' já existe.");
           }

           // conecta já com o banco para criar a tabela
           conexao = DriverManager.getConnection(urlRoot + dbName, user, password);
           stmt = conexao.createStatement();
           stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS pessoa (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    idade INT
                )
        """);
           System.out.println("Tabela 'pessoa' criada/verificada com sucesso!");

       }catch (SQLException e){
           e.printStackTrace();
           System.out.println("Erro ao criar/verificar banco de dados ou tabela");
       }

    }
}

package br.com.projetoos.dal;
import java.sql.*;
public class Conexao {
    
    public static Connection Conectar(){
       java.sql.Connection conexao = null;
       String driver = "com.mysql.cj.jdbc.Driver";
       String url = "jdbc:mysql://localhost:3306/sistema?useTimezone=true&serverTimezone=UTC";
       String user = "root";
       String senha = "";
       
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection( url , user ,senha);
            return conexao;
        } catch (Exception ex){
            System.out.println("Erro : " + ex);
            return null;
        }
       
       
       
    
    }
    
    
    
}

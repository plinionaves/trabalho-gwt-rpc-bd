package org.libertas.pjn.model;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

    private Connection conexao;

    private Connection criarConexao() {
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost/gwt";

        /*try {
         conexao = DriverManager.getConnection(url, user, pass);
         System.out.println("Conexão iniciada!");
         return conexao;
         } catch (SQLException e) {
         System.out.println("Falha ao conectar com o banco!");
         return null;
         }*/
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(url, user, pass);
            return conexao;
        } catch (Exception e) {
            System.out.println("Falha ao conectar com o banco!");
            return null;
        }

    }

    public Connection getConexao() {
        if (conexao == null) {
            return criarConexao();
        } else {
            return conexao;
        }
    }
}

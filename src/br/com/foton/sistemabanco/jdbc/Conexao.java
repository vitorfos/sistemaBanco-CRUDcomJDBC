package br.com.foton.sistemabanco.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao
{

   private static final String nomeUsuario = "root";
   private static final String senha = "info1234";
   private static final String urlBd = "jdbc:mysql://localhost:3306/sistemabanco" + "?verifyServerCertificate=false" + "&useSSL=false";

   public static Connection criaConexaoComBd() throws Exception
   {
      Class.forName("com.mysql.jdbc.Driver");

      Connection conexaoAtual = DriverManager.getConnection(urlBd, nomeUsuario, senha);
      return conexaoAtual;
   }

   // Teste de verificacao da conexao Java-BancoDeDados
   // public static void main(String[] args) throws Exception
   // {
   // Connection novaConexao = criaConexaoComBd();
   //
   // if (novaConexao != null)
   // {
   // System.out.println("Conexao -" + novaConexao + "- obtida com sucesso!");
   // }
   // }
}

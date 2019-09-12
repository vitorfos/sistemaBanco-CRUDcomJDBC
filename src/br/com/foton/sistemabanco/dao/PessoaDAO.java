package br.com.foton.sistemabanco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.foton.sistemabanco.entidades.Pessoa;
import br.com.foton.sistemabanco.jdbc.Conexao;

/**
 * @TODO Comentar com descrição do fonte Classe que encapsula todas as operações referentes ao banco de dados da entidade pessoa
 * @author setembro/2019: vitor
 */

public class PessoaDAO
{

   /**
    * @TODO Insere uma nova pessoa no banco de dados
    * @param pessoa
    */
   public void insere(Pessoa pessoa)
   {
      String sql = "INSERT INTO pessoa (nome, endereco) VALUES (?,?)";
      
      Connection conexao = null;
      PreparedStatement pstm = null;
      
      try {
         conexao = Conexao.criaConexaoComBd();
         pstm = conexao.prepareStatement(sql);

         pstm.setString(1, pessoa.getNome());
         pstm.setString(2, pessoa.getEndereco());
         pstm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally {
         try
         {
            if (pstm != null)
            {
               pstm.close();
            }

            if (conexao != null)
            {
               conexao.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }

   }

   /**
    * @TODO Remove uma pessoa do banco de dados através do id
    * @param idPessoa
    */
   public void removePorId(Pessoa idPessoa)
   {
      String sql = "DELETE FROM sistemabanco WHERE id_pessoa = ?";

      Connection conexao = null;
      PreparedStatement pstm = null;

      try
      {
         conexao = Conexao.criaConexaoComBd();
         pstm = conexao.prepareStatement(sql);

         pstm.setInt(1, idPessoa.getIdPessoa());
         pstm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (conexao != null)
            {
               conexao.close();
            }
            if (pstm != null)
            {
               pstm.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }

      }

   }

   public void atualiza(Pessoa pessoaAtualizado)
   {
      String sql = "UPDATE sistemabanco SET nome = ?, endereco = ? WHERE id = ?";
      
      Connection conexao = null;
      PreparedStatement pstm = null;
      
      try
      {
         conexao = Conexao.criaConexaoComBd();
         pstm = conexao.prepareStatement(sql);

         pstm.setString(1, pessoaAtualizado.getNome());
         pstm.setString(2, pessoaAtualizado.getEndereco());
         pstm.setInt(3, pessoaAtualizado.getIdPessoa());
         pstm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (conexao != null)
            {
               conexao.close();
            }
            if (pstm != null)
            {
               pstm.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   public List<Pessoa> retornaPessoas()
   {
      String sql = "SELECT * FROM sistemabanco";
      List<Pessoa> pessoas = new ArrayList<Pessoa>();

      Connection conexao = null;
      PreparedStatement pstm = null;
      ResultSet rst = null;

      try
      {
         conexao = Conexao.criaConexaoComBd();
         pstm = conexao.prepareStatement(sql);
         rst = pstm.executeQuery();

         while (rst.next())
         {
            Pessoa pessoa = new Pessoa();

            pessoa.setNome(rst.getString("nome"));
            pessoa.setEndereco(rst.getString("endereco"));

            pessoas.add(pessoa);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (conexao != null)
            {
               conexao.close();
            }
            if (pstm != null)
            {
               pstm.close();
            }
            if (rst != null)
            {
               rst.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }

      return pessoas;
   }
}

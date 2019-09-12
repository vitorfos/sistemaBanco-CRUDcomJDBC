package br.com.foton.sistemabanco.entidades;


public class Pessoa
{

   private int id_pessoa;
   private String nome;
   private String endereco;

   public int getIdPessoa()
   {
      return this.id_pessoa;
   }

   public void setIdPessoa(int id_pessoa)
   {
      this.id_pessoa = id_pessoa;
   }

   public String getNome()
   {
      return this.nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getEndereco()
   {
      return this.endereco;
   }

   public void setEndereco(String endereco)
   {
      this.endereco = endereco;
   }
}

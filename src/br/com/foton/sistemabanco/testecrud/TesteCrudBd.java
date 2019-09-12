package br.com.foton.sistemabanco.testecrud;

import br.com.foton.sistemabanco.dao.PessoaDAO;
import br.com.foton.sistemabanco.entidades.Pessoa;

public class TesteCrudBd
{

   public static void main(String[] args) throws Exception
   {
      // Connection novaConexao = Conexao.criaConexaoComBd();
      //
      // if (novaConexao != null)
      // {
      // System.out.println("Conexao -" + novaConexao + "- obtida com sucesso!");
      // }

        // Cria um contato e salva no banco de dados 
        PessoaDAO pessoaDao = new PessoaDAO(); 
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Vitor Felix"); 
        pessoa.setEndereco("Recife-PE"); 
        pessoaDao.insere(pessoa);

        System.out.println("Pessoa inserida com sucesso!");
       
      
      // Cria outro contato e salva no banco de dados
      /*
       * PessoaDTO pessoa1 = new PessoaDTO(); pessoa1.setNome("Pedro Barros"); pessoa1.setEndereco("Olinda-PE"); pessoaDao.insere(pessoa);
       * // Atualiza um contato existente no banco de dados com novos dados através do id PessoaDTO pessoaNova = new PessoaDTO();
       * pessoaNova.setIdPessoa(2); pessoaNova.setNome("Joan Felix"); pessoaNova.setEndereco("São Paulo-SP");
       * pessoaDao.atualiza(pessoaNova); // Remove um contato do banco de dados através do id // Lista todos os contatos do banco de dados
       */

   }

}

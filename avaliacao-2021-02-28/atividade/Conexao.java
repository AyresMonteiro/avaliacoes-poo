package atividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Conexao {
  private Connection conn;
  private Statement consulta;

  public Conexao() {
    try {
      this.conn = DriverManager.getConnection("jdbc:sqlite:listaTelefonica.db");

      this.consulta = this.conn.createStatement();

      this.consulta.executeUpdate(
          "create table if not exists pessoas(idPessoa integer primary key autoincrement, nome varchar(255), telefone varchar(13))");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void encerrarConexao() {
    try {
      this.conn.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public String adicionarContato(String nome, String telefone) {
    try {
      String sql = "insert into pessoas(nome, telefone) values ('";
      sql += nome + "','" + telefone + "')";

      this.consulta.executeUpdate(sql);

      return "Contato cadastrado!";
    } catch (SQLException e) {
      return e.getMessage();
    }
  }

  public void alterarContato(int idContato, String nome, String telefone) {
    try {
      String sql = "update pessoas set nome = '";
      sql += nome + "', telefone = '" + telefone + "' where idPessoa = " + idContato;

      this.consulta.executeUpdate(sql);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void excluirContato(int idContato) {
    try {
      String sql = "delete from pessoas where idPessoa = " + idContato;

      this.consulta.executeUpdate(sql);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public ArrayList<Contato> listarContatos(String termo) {
    try {
      String sql = "select * from pessoas";

      if (termo != null) {
        sql += " where nome like '%" + termo + "%' or ";
        sql += "telefone like '%" + Contato.parseTelefone(termo) + "%'";
      }

      ResultSet resultado = this.consulta.executeQuery(sql);

      ArrayList<Contato> contatos = new ArrayList<Contato>();

      while (resultado.next()) {
        contatos.add(
            new Contato(resultado.getInt("idPessoa"), resultado.getString("nome"), resultado.getString("telefone")));
      }

      return contatos;
    } catch (SQLException e) {
      return new ArrayList<Contato>();
    }
  }

  public ArrayList<Contato> listarContatos() {
    return this.listarContatos(null);
  }
}

package atividade;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ContatoTableModel extends AbstractTableModel {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private String[] colunas = { "Nome", "Telefone", "Id" };
  private ArrayList<Contato> contatos;

  private final int COLUNA_NOME = 0;
  private final int COLUNA_TELEFONE = 1;
  private final int COLUNA_ID = 2;

  private Conexao conn;

  public ContatoTableModel() {
    this.conn = new Conexao();
    this.contatos = this.conn.listarContatos();
  }

  public Conexao getConexao() {
    return this.conn;
  }

  public void inserirDado(Contato novo) {
    this.contatos.add(novo);
  };

  public void atualizarDados() {
    this.contatos = this.conn.listarContatos();
    this.fireTableDataChanged();
  }

  public void atualizarDados(String termo) {
    this.contatos = this.conn.listarContatos(termo);
    this.fireTableDataChanged();
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }

  @Override
  public int getRowCount() {
    return this.contatos.size();
  }

  @Override
  public int getColumnCount() {
    return colunas.length;
  }

  @Override
  public String getColumnName(int index) {
    return colunas[index];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case COLUNA_ID:
        return Integer.class;
      default:
        return String.class;
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Contato contato = this.contatos.get(rowIndex);

    switch (columnIndex) {
      case COLUNA_NOME:
        return contato.getNome();
      case COLUNA_TELEFONE:
        return contato.getTelefone();
      case COLUNA_ID:
        return contato.getIdPessoa();
    }

    return null;
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Contato contato = this.contatos.get(rowIndex);

    switch (columnIndex) {
      case COLUNA_NOME:
        contato.setNome(String.valueOf(aValue));
        break;
      case COLUNA_TELEFONE:
        contato.setTelefone(String.valueOf(aValue));
        break;
      case COLUNA_ID:
        contato.setIdPessoa(Integer.valueOf(String.valueOf(aValue)));
        break;
    }

    this.conn.alterarContato(contato.getIdPessoa(), contato.getNome(), contato.getTelefoneLimpo());

    this.atualizarDados();
  }
}

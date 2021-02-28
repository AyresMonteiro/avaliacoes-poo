package atividade;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ActionMapUIResource;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public InterfaceGrafica() {
    super("Lista de Contatos");
  }

  public void abrirFrame() {
    try {
      Conexao c = new Conexao();
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setVisible(true);

      JPanel painel = new JPanel();
      JPanel painelDosBotoes = new JPanel();
      JPanel painelDeBusca = new JPanel();

      painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
      painel.setLayout(new GridLayout(0, 1));
      painelDosBotoes.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
      GridLayout layoutPainelDosBotoes = new GridLayout(2, 2);
      layoutPainelDosBotoes.setHgap(3080);
      painelDosBotoes.setLayout(layoutPainelDosBotoes);
      painelDeBusca.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
      painelDeBusca.setLayout(new GridLayout(0, 2));

      JButton btnAdicionarContato = new JButton("Adicionar contato");
      JButton btnListarTodos = new JButton("Listar todos os contatos");
      JButton btnBuscar = new JButton("Buscar");
      JTextField inputDeBusca = new JTextField();

      btnBuscar.setPreferredSize(new Dimension(100, 25));
      ;

      ContatoTableModel modelo = new ContatoTableModel();
      JTable tabela = new JTable(modelo);

      JPopupMenu menuBotaoDireito = new JPopupMenu();
      JMenuItem excluir = new JMenuItem("Excluir");

      excluir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 2)));
          if (id != -1) {
            modelo.getConexao().excluirContato(id);
            modelo.atualizarDados();
          } else {
            JOptionPane.showMessageDialog(btnAdicionarContato, "Selecione uma linha na tabela!");
          }
        }
      });

      menuBotaoDireito.add(excluir);

      tabela.setComponentPopupMenu(menuBotaoDireito);

      tabela.getColumnModel().getColumn(2).setPreferredWidth(10);

      tabela.getColumnModel().getColumn(2).setMinWidth(0);
      tabela.getColumnModel().getColumn(2).setMaxWidth(0);

      JScrollPane painelRolavel = new JScrollPane(tabela);

      painelRolavel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0)));
      painelRolavel.setPreferredSize(new Dimension(300, 300));

      painel.add(painelRolavel);
      painelDosBotoes.add(btnAdicionarContato);
      painelDosBotoes.add(btnListarTodos);
      painelDeBusca.add(inputDeBusca);
      painelDeBusca.add(btnBuscar);
      this.add(painelDosBotoes, BorderLayout.NORTH);
      this.add(painelDeBusca, BorderLayout.CENTER);
      this.add(painel, BorderLayout.SOUTH);
      this.pack();

      this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent) {
          modelo.getConexao().encerrarConexao();
          JOptionPane.showMessageDialog(null, "Encerrando...");
          System.exit(0);
        }
      });

      btnAdicionarContato.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String resultado = "";
          String nome = JOptionPane.showInputDialog(btnAdicionarContato, "Insira um nome de contato:");

          if (nome != null) {
            String telefone = JOptionPane.showInputDialog(btnAdicionarContato,
                "Insira um número de telefone nos\nseguintes padrões: (11) 9 3442-3449\nou 11934423449");

            if (nome != null && telefone != null) {
              Contato c = new Contato(1, nome, telefone);

              if (c.getNome() == null) {
                resultado += "Insira um nome válido!\n";
              }

              if (c.getTelefoneLimpo() == null) {
                resultado += "Insira um telefone válido!";
              }

              if (c.getTelefoneLimpo() != null && c.getNome() != null) {
                resultado = modelo.getConexao().adicionarContato(c.getNome(), c.getTelefoneLimpo());
              }
            } else {
              resultado += "Você clicou no botão de cancelar,\ncadastro não efetuado!";
            }
          } else {
            resultado += "Você clicou no botão de cancelar,\ncadastro não efetuado!";
          }

          JOptionPane.showMessageDialog(btnAdicionarContato, resultado);

          modelo.atualizarDados();
        }
      });

      btnBuscar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String termo = inputDeBusca.getText();

          modelo.atualizarDados(termo);
        }
      });

      btnListarTodos.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          modelo.atualizarDados();
        }
      });
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

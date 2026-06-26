import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class PrincipalSwing extends JFrame {

    private Biblioteca biblioteca = new Biblioteca();
    private Usuario usuarioAdmin = new Usuario("admin", "123");

    private JTabbedPane abasPainel;
    private JTable tabelaMusicas;
    private DefaultTableModel modeloMusicas;
    private JTable tabelaEmprestimos;
    private DefaultTableModel modeloEmprestimos;

    public PrincipalSwing() {
        setTitle("Sistema de Mini-Biblioteca de Musica");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarDadosTeste();
    }

    public void iniciarFluxo() {
        mostrarTelaLogin();
    }

    private void mostrarTelaLogin() {
        JDialog loginDialog = new JDialog(this, "Autenticação", true);
        loginDialog.setSize(350, 220);
        loginDialog.setLayout(new BorderLayout());
        loginDialog.setLocationRelativeTo(null);
        loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsuario = new JLabel("Usuário:");
        JTextField txtUsuario = new JTextField();
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        painelCampos.add(lblUsuario);
        painelCampos.add(txtUsuario);
        painelCampos.add(lblSenha);
        painelCampos.add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        JLabel lblErro = new JLabel("", SwingConstants.CENTER);
        lblErro.setForeground(Color.RED);

        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        painelInferior.add(btnEntrar, BorderLayout.CENTER);
        painelInferior.add(lblErro, BorderLayout.SOUTH);

        btnEntrar.addActionListener(e -> {
            String username = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());

            if (usuarioAdmin.autenticar(username, senha)) {
                loginDialog.dispose();
                configurarPainelPrincipal();
                setVisible(true);
            } else {
                lblErro.setText("Usuário ou senha inválidos.");
            }
        });

        loginDialog.getRootPane().setDefaultButton(btnEntrar);
        loginDialog.add(painelCampos, BorderLayout.CENTER);
        loginDialog.add(painelInferior, BorderLayout.SOUTH);
        loginDialog.setVisible(true);
    }

    private void configurarPainelPrincipal() {
        
        getContentPane().removeAll();
        setLayout(new BorderLayout());

        // --- BARRA SUPERIOR COM O BOTÃO SAIR ---
        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(230, 230, 230));
        painelTopo.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblBemVindo = new JLabel("Painel Administrativo | Biblioteca Musical");
        lblBemVindo.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(217, 83, 79)); // Vermelho elegante
        btnSair.setForeground(Color.BLUE);
        btnSair.setFocusPainted(false);
        
        btnSair.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(
                    this, 
                    "Deseja realmente encerrar a sessão atual?", 
                    "Confirmar Saída", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
            );
            
            if (resposta == JOptionPane.YES_OPTION) {
                setVisible(false); // Oculta a janela principal
                mostrarTelaLogin(); // Retorna para o fluxo de autenticação
            }
        });

        painelTopo.add(lblBemVindo, BorderLayout.WEST);
        painelTopo.add(btnSair, BorderLayout.EAST);
        add(painelTopo, BorderLayout.NORTH);

        // --- SISTEMA DE ABAS ---
        abasPainel = new JTabbedPane();
        configurarAbaMusicas();
        configurarAbaEmprestimos();
        add(abasPainel, BorderLayout.CENTER);

        // Atualiza e renderiza a janela
        revalidate();
        repaint();
    }

    private void configurarAbaMusicas() {
        JPanel painelMusicas = new JPanel(new BorderLayout());
        painelMusicas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"ID", "Título", "Álbum", "Cantor", "Banda", "Ano", "Emprestada"};
        modeloMusicas = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaMusicas = new JTable(modeloMusicas);
        tabelaMusicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarTabelaMusicas();

        JScrollPane scrollPane = new JScrollPane(tabelaMusicas);
        painelMusicas.add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JButton btnCadastrar = new JButton("➕ Cadastrar Música");
        JButton btnEditar = new JButton("✏️ Editar Selecionada");
        JButton btnRemover = new JButton("❌ Remover");
        JButton btnOuvir = new JButton("▶️ Ouvir Música (Link)");
        JButton btnEmprestar = new JButton("🤝 Registrar Empréstimo");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnOuvir);
        painelBotoes.add(btnEmprestar);
        painelMusicas.add(painelBotoes, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> abrirFormularioMusica(null));
        btnEditar.addActionListener(e -> {
            Musica m = getMusicaSelecionada();
            if (m != null) abrirFormularioMusica(m);
        });
        btnRemover.addActionListener(e -> {
            Musica m = getMusicaSelecionada();
            if (m != null) {
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja mesmo remover \"" + m.getTitulo() + "\"?");
                if (confirmacao == JOptionPane.YES_OPTION) {
                    biblioteca.remover(m.getId());
                    atualizarTabelaMusicas();
                }
            }
        });
        btnOuvir.addActionListener(e -> {
            Musica m = getMusicaSelecionada();
            if (m != null) PlayerMusica.tocar(m);
        });
        btnEmprestar.addActionListener(e -> {
            Musica m = getMusicaSelecionada();
            if (m != null) abrirDialogoEmprestimo(m);
        });

        abasPainel.addTab("🎵 Músicas", painelMusicas);
    }

    private void atualizarTabelaMusicas() {
        modeloMusicas.setRowCount(0);
        for (Musica m : biblioteca.getMusicas()) {
            modeloMusicas.addRow(new Object[]{
                    m.getId(), m.getTitulo(), m.getAlbum(), m.getCantor(), m.getBanda(), m.getAno(), m.isEmprestada() ? "SIM" : "NÃO"
            });
        }
    }

    private Musica getMusicaSelecionada() {
        int linha = tabelaMusicas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma música na tabela.");
            return null;
        }
        int id = (int) tabelaMusicas.getValueAt(linha, 0);
        return biblioteca.buscar(id);
    }

    private void abrirFormularioMusica(Musica musicaEdicao) {
        JDialog formDialog = new JDialog(this, musicaEdicao == null ? "Cadastrar Música" : "Editar Música", true);
        formDialog.setSize(400, 320);
        formDialog.setLayout(new GridLayout(7, 2, 10, 10));
        formDialog.setLocationRelativeTo(this);

        formDialog.add(new JLabel(" Título:"));
        JTextField txtTitulo = new JTextField(musicaEdicao != null ? musicaEdicao.getTitulo() : "");
        formDialog.add(txtTitulo);

        formDialog.add(new JLabel(" Álbum:"));
        JTextField txtAlbum = new JTextField(musicaEdicao != null ? musicaEdicao.getAlbum() : "");
        formDialog.add(txtAlbum);

        formDialog.add(new JLabel(" Cantor:"));
        JTextField txtCantor = new JTextField(musicaEdicao != null ? musicaEdicao.getCantor() : "");
        formDialog.add(txtCantor);

        formDialog.add(new JLabel(" Banda:"));
        JTextField txtBanda = new JTextField(musicaEdicao != null ? musicaEdicao.getBanda() : "");
        formDialog.add(txtBanda);

        formDialog.add(new JLabel(" Ano:"));
        JTextField txtAno = new JTextField(musicaEdicao != null ? String.valueOf(musicaEdicao.getAno()) : "");
        formDialog.add(txtAno);

        formDialog.add(new JLabel(" Link Streaming:"));
        JTextField txtLink = new JTextField(musicaEdicao != null ? musicaEdicao.getLinkStreaming() : "");
        formDialog.add(txtLink);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            try {
                String tit = txtTitulo.getText();
                String alb = txtAlbum.getText();
                String can = txtCantor.getText();
                String ban = txtBanda.getText();
                int ano = Integer.parseInt(txtAno.getText());
                String lnk = txtLink.getText();

                if (musicaEdicao == null) {
                    biblioteca.adicionar(new Musica(biblioteca.gerarId(), tit, alb, can, ban, ano, lnk));
                } else {
                    musicaEdicao.editar(tit, alb, can, ban, ano);
                    musicaEdicao.setLinkStreaming(lnk);
                }
                atualizarTabelaMusicas();
                formDialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(formDialog, "O campo 'Ano' precisa ser um número válido.");
            }
        });

        formDialog.add(new JLabel(""));
        formDialog.add(btnSalvar);
        formDialog.setVisible(true);
    }

    private void abrirDialogoEmprestimo(Musica musica) {
        if (musica.isEmprestada()) {
            JOptionPane.showMessageDialog(this, "Esta música já se encontra emprestada.");
            return;
        }

        JDialog empDialog = new JDialog(this, "Registrar Empréstimo", true);
        empDialog.setSize(350, 200);
        empDialog.setLayout(new GridLayout(4, 1, 10, 10));
        empDialog.setLocationRelativeTo(this);

        empDialog.add(new JLabel(" Emprestando: " + musica.getTitulo(), SwingConstants.CENTER));
        
        JTextField txtPessoa = new JTextField();
        txtPessoa.setBorder(BorderFactory.createTitledBorder("Nome do Locatário:"));
        empDialog.add(txtPessoa);

        JTextField txtData = new JTextField(LocalDate.now().plusDays(7).toString());
        txtData.setBorder(BorderFactory.createTitledBorder("Data de Devolução Prevista (AAAA-MM-DD):"));
        empDialog.add(txtData);

        JButton btnConfirmar = new JButton("Confirmar Empréstimo");
        btnConfirmar.addActionListener(e -> {
            try {
                String pessoa = txtPessoa.getText();
                LocalDate dataPrevista = LocalDate.parse(txtData.getText());

                if(pessoa.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(empDialog, "Informe o nome da pessoa.");
                    return;
                }

                biblioteca.emprestar(musica, pessoa, dataPrevista);
                atualizarTabelaMusicas();
                atualizarTabelaEmprestimos();
                empDialog.dispose();
                JOptionPane.showMessageDialog(this, "Empréstimo registrado!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(empDialog, "Formato de data inválido. Use AAAA-MM-DD.");
            }
        });
        empDialog.add(btnConfirmar);
        empDialog.setVisible(true);
    }

    private void configurarAbaEmprestimos() {
        JPanel painelEmprestimos = new JPanel(new BorderLayout());
        painelEmprestimos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"Música", "Pessoa", "Data Empréstimo", "Devolução Prevista", "Devolução Realizada"};
        modeloEmprestimos = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaEmprestimos = new JTable(modeloEmprestimos);
        
        JScrollPane scrollPane = new JScrollPane(tabelaEmprestimos);
        painelEmprestimos.add(scrollPane, BorderLayout.CENTER);

        JButton btnDevolver = new JButton("↩️ Registrar Devolução da Música Selecionada");
        btnDevolver.addActionListener(e -> {
            int linha = tabelaEmprestimos.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um registro de empréstimo.");
                return;
            }

            Emprestimo emp = biblioteca.getEmprestimos().get(linha);
            if (emp.getDataDevolucao() != null) {
                JOptionPane.showMessageDialog(this, "Este empréstimo já foi finalizado/devolvido.");
                return;
            }

            emp.devolver(LocalDate.now());
            atualizarTabelaMusicas();
            atualizarTabelaEmprestimos();
            JOptionPane.showMessageDialog(this, "Devolução concluída com sucesso!");
        });

        painelEmprestimos.add(btnDevolver, BorderLayout.SOUTH);
        abasPainel.addTab("📅 Empréstimos", painelEmprestimos);
    }

    private void atualizarTabelaEmprestimos() {
        modeloEmprestimos.setRowCount(0);
        for (Emprestimo e : biblioteca.getEmprestimos()) {
            modeloEmprestimos.addRow(new Object[]{
                    e.getMusica().getTitulo(),
                    e.getPessoa(),
                    e.getDataEmprestimo(),
                    e.getDataPrevistaDevolucao(),
                    e.getDataDevolucao() == null ? "PENDENTE" : e.getDataDevolucao()
            });
        }
    }

    private void inicializarDadosTeste() {
        biblioteca.adicionar(new Musica(biblioteca.gerarId(), "Bohemian Rhapsody", "A Night at the Opera", "Queen", "Queen", 1975, "https://www.youtube.com/watch?v=fJ9rUzIMcZQ"));
        biblioteca.adicionar(new Musica(biblioteca.gerarId(), "Hotel California", "Hotel California", "Eagles", "Eagles", 1976, "https://www.youtube.com/watch?v=09839DpTctU"));
    }
}
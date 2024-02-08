
package view;

import data.Funcionario;
import data.FuncionarioDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class FuncionariosView extends javax.swing.JFrame {
   public FuncionariosView() {
        initComponents();
        //o método listar valores está aqui para aparecer a tabela quando iniciar a tela
        //e eu chamo ele em todos os métodos que tem acesso ao banco de dados
        listarValores();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSetor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Funcionários");

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Cargo", "Salario", "Nascimento", "CPF", "Email", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);
        if (tabelaFuncionarios.getColumnModel().getColumnCount() > 0) {
            tabelaFuncionarios.getColumnModel().getColumn(0).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(1).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(2).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(3).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(4).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(5).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(6).setResizable(false);
        }

        lblMatricula.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMatricula.setText("Matricula:");

        txtMatricula.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        txtMatricula.setEnabled(false);

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblCargo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCargo.setText("Cargo:");

        lblSalario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSalario.setText("Salario:");

        lblNascimento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNascimento.setText("Data de Nascimento:");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCPF.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Email:");

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Setor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnExcluir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula)
                    .addComponent(lblNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(lblNome)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalario)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
            salvar();
            listarValores();
            limparCampos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        ListSelectionModel tableSelectionModel = tabelaFuncionarios.getSelectionModel();
        tabelaFuncionarios.setSelectionModel(tableSelectionModel);
        String rowMatricula = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 0).toString();
        String nome = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 1).toString();
        String cargo = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 2).toString();
        String rowSalario = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 3).toString();
        String nascimento = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 4).toString();
        String cpf = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),5).toString();
        String email = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),6).toString();
        String setor = tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(),7).toString();
        txtMatricula.setText(rowMatricula);
        txtNome.setText(nome);
        txtCargo.setText(cargo);
        txtSalario.setText(rowSalario);
        txtNascimento.setText(nascimento);
        txtCPF.setText(cpf);
        txtEmail.setText(email);
        txtSetor.setText(setor);
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        alterar();
        listarValores();
        limparCampos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        listarValores();
        limparCampos();        
    }//GEN-LAST:event_btnExcluirActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionariosView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtSetor;
    // End of variables declaration//GEN-END:variables
    
    private void limparCampos(){
    txtMatricula.setText("");
    txtNome.setText("");
    txtCargo.setText("");
    txtSalario.setText("");
    txtNascimento.setText("");
    txtCPF.setText("");
    txtEmail.setText("");
    txtSetor.setText("");
    txtNascimento.requestFocus();
}
    private void salvar(){
        String nome = txtNome.getText();
        String cargo = txtCargo.getText();
        Double salario = Double.parseDouble (txtSalario.getText());
        String nascimento = txtNascimento.getText();
        String CPF = txtCPF.getText();
        String email = txtEmail.getText();
        String setor = txtSetor.getText();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionario.setNascimento(nascimento);
        funcionario.setCPF(CPF);
        funcionario.setEmail(email);
        funcionario.setSetor(setor);
        FuncionarioDao funcionariodao = new FuncionarioDao();
        funcionariodao.cadastrar(funcionario);
    }
    private void listarValores(){
        try{
            FuncionarioDao funcionariodao = new FuncionarioDao();
            DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
            model.setNumRows(0);
            ArrayList<Funcionario> lista = funcionariodao.pesquisar();
            for(int num = 0; num < lista.size(); num++){
                model.addRow(new Object[]{
                    lista.get(num).getMatricula(),
                    lista.get(num).getNome(),
                    lista.get(num).getCargo(),
                    lista.get(num).getSalario(),
                    lista.get(num).getNascimento(),
                    lista.get(num).getCPF(),
                    lista.get(num).getEmail(),
                    lista.get(num).getSetor()
                });
        }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Não foi possível listar os valores");
        }
    }
    private void alterar(){
        int matricula = Integer.parseInt(txtMatricula.getText());
        String nome = txtNome.getText();
        String cargo = txtCargo.getText();
        Double salario = Double.parseDouble(txtSalario.getText());
        String nascimento = txtNascimento.getText();
        String cpf = txtCPF.getText();
        String email = txtEmail.getText();
        String setor = txtSetor.getText();
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(matricula);
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionario.setNascimento(nascimento);
        funcionario.setCPF(cpf);
        funcionario.setEmail(email);
        funcionario.setSetor(setor);
        FuncionarioDao funcionariodao = new FuncionarioDao();
        funcionariodao.alterar(funcionario);
    }
    private void excluir(){
        int matricula = Integer.parseInt(txtMatricula.getText());
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(matricula);
        FuncionarioDao funcionariodao = new FuncionarioDao();
        funcionariodao.excluir(funcionario);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoos.telas;
import java.sql.*;
import br.com.projetoos.dal.Conexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Marcos André
 */
public class Cliente extends javax.swing.JInternalFrame {
   
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
   
    public Cliente() {
        initComponents();
        conexao = Conexao.Conectar();

        if (conexao != null) {
            StatusC.setText("Conectado com o BD");
        } else {
            StatusC.setText("Erro no BD");

        }
    }
    
    private void Adicionar(){
        String sql = "insert into clientes values(default,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, NomeC.getText());
            pst.setString(2, EnderecoC.getText());
            pst.setString(3, FoneC.getText());
            pst.setString(4, EmailC.getText());
            pst.setString(5, CpfC.getText());
            pst.setString(6, CidadeC.getText());
            pst.setString(7,  EstadoC.getText());
             if((NomeC.getText().isEmpty()) || (EnderecoC.getText().isEmpty())|| (CpfC.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
             }else{
                 int adicionado = pst.executeUpdate();
                 if(adicionado > 0){
                      JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                      Limpar();
                 }else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
                }
             }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro : " + ex);
        }
    
    }
    
    private void Buscar(){
        String sql = "select * from clientes where nome like ?";
        
        try{
         pst = conexao.prepareStatement(sql);
         pst.setString(1,PesquisaC.getText() + "%");
         rst = pst.executeQuery();
         
         TabelaPesquisa.setModel(DbUtils.resultSetToTableModel(rst));
         
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro : " + ex);
        }
    
    }
    
    private void Editar(){
        String sql = "update clientes set nome = ?, endereco = ?, fone = ?, email = ?, cpf = ?,cidade = ? , estado = ? where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, NomeC.getText());
            pst.setString(2, EnderecoC.getText());
            pst.setString(3, FoneC.getText());
            pst.setString(4, EmailC.getText());
            pst.setString(5, CpfC.getText());
            pst.setString(6, CidadeC.getText());
            pst.setString(7,  EstadoC.getText());
            pst.setString(8, IdC.getText());
            
             if((NomeC.getText().isEmpty()) || (EnderecoC.getText().isEmpty())|| (CpfC.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
             }
             else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                    Limpar();
                    Buscar();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar dados");
                    
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    
    }
 
        private void Excluir(){
      int confirma = JOptionPane.showConfirmDialog(null , "Tem certeza  que deseja excluir esse usuario ? ","Atenção",JOptionPane.YES_NO_OPTION);
      if(confirma == JOptionPane.YES_OPTION){
        String sql = "delete from clientes where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, IdC.getText());
           int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "cliente removido com sucesso!");
                    Limpar();
                    Buscar();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao remover");
                    
                }
            
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
      }

    
    }
    private void Preencher(){
        int setar = TabelaPesquisa.getSelectedRow();
            IdC.setText(TabelaPesquisa.getModel().getValueAt(setar, 0).toString());
            NomeC.setText(TabelaPesquisa.getModel().getValueAt(setar, 1).toString());
            EnderecoC.setText(TabelaPesquisa.getModel().getValueAt(setar, 2).toString());
            FoneC.setText(TabelaPesquisa.getModel().getValueAt(setar, 3).toString());
            EmailC.setText(TabelaPesquisa.getModel().getValueAt(setar, 4).toString());
            CpfC.setText(TabelaPesquisa.getModel().getValueAt(setar, 5).toString());
            CidadeC.setText(TabelaPesquisa.getModel().getValueAt(setar, 6).toString());
            EstadoC.setText(TabelaPesquisa.getModel().getValueAt(setar, 7).toString());
            AdicionarC.setEnabled(false);
        
    
    }
    
    private void Limpar(){
            IdC.setText(null);
            NomeC.setText(null);
            EnderecoC.setText(null);
            FoneC.setText(null);
            EmailC.setText(null);
            CpfC.setText(null);
            CidadeC.setText(null);
            EstadoC.setText(null);
            AdicionarC.setEnabled(true);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NomeC = new javax.swing.JTextField();
        EnderecoC = new javax.swing.JTextField();
        FoneC = new javax.swing.JTextField();
        EmailC = new javax.swing.JTextField();
        CpfC = new javax.swing.JTextField();
        CidadeC = new javax.swing.JTextField();
        EstadoC = new javax.swing.JTextField();
        AdicionarC = new javax.swing.JButton();
        ExcluirC = new javax.swing.JButton();
        AtualizarC = new javax.swing.JButton();
        PesquisaC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TabelaC = new javax.swing.JScrollPane();
        TabelaPesquisa = new javax.swing.JTable();
        LimparC = new javax.swing.JButton();
        StatusC = new javax.swing.JLabel();
        IdC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("*Nome");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes - Os");
        setPreferredSize(new java.awt.Dimension(560, 451));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("*Campos Obrigatórios");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("*Nome");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("*Fone");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("*CPF");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("*Endereço");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Estado");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cidade");

        NomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCActionPerformed(evt);
            }
        });

        EnderecoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnderecoCActionPerformed(evt);
            }
        });

        FoneC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoneCActionPerformed(evt);
            }
        });

        EmailC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailCActionPerformed(evt);
            }
        });

        CpfC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpfCActionPerformed(evt);
            }
        });

        CidadeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CidadeCActionPerformed(evt);
            }
        });

        EstadoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoCActionPerformed(evt);
            }
        });

        AdicionarC.setBackground(new java.awt.Color(204, 204, 255));
        AdicionarC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AdicionarC.setText("Adicionar");
        AdicionarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarCActionPerformed(evt);
            }
        });

        ExcluirC.setBackground(new java.awt.Color(204, 204, 255));
        ExcluirC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ExcluirC.setText("Excluir");
        ExcluirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirCActionPerformed(evt);
            }
        });

        AtualizarC.setBackground(new java.awt.Color(204, 204, 255));
        AtualizarC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AtualizarC.setText("Atualizar");
        AtualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarCActionPerformed(evt);
            }
        });

        PesquisaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisaCKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pesquisar");

        TabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Endereço", "Fone", "Email", "CPF", "Cidade", "Estado"
            }
        ));
        TabelaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaPesquisaMouseClicked(evt);
            }
        });
        TabelaC.setViewportView(TabelaPesquisa);

        LimparC.setBackground(new java.awt.Color(204, 204, 255));
        LimparC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LimparC.setText("Limpar");
        LimparC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparCActionPerformed(evt);
            }
        });

        StatusC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        StatusC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StatusC.setText("Status");

        IdC.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("*ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CidadeC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EstadoC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmailC, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FoneC, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CpfC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AdicionarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AtualizarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ExcluirC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EnderecoC, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LimparC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(StatusC, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdC)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(PesquisaC, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(TabelaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PesquisaC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(TabelaC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(StatusC))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdC, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnderecoC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimparC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoneC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CpfC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExcluirC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CidadeC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstadoC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153))
        );

        setBounds(0, 0, 560, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void NomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeCActionPerformed

    private void EnderecoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnderecoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnderecoCActionPerformed

    private void FoneCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoneCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FoneCActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void EmailCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailCActionPerformed

    private void CpfCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpfCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpfCActionPerformed

    private void CidadeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CidadeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CidadeCActionPerformed

    private void EstadoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoCActionPerformed

    private void AdicionarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarCActionPerformed
      Adicionar();
    }//GEN-LAST:event_AdicionarCActionPerformed

    private void AtualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarCActionPerformed
        Editar();
    }//GEN-LAST:event_AtualizarCActionPerformed

    private void ExcluirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirCActionPerformed
      Excluir();
    }//GEN-LAST:event_ExcluirCActionPerformed

    private void LimparCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparCActionPerformed
       Limpar();
    }//GEN-LAST:event_LimparCActionPerformed

    private void PesquisaCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisaCKeyReleased
        Buscar();
    }//GEN-LAST:event_PesquisaCKeyReleased

    private void TabelaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaPesquisaMouseClicked
        Preencher();
    }//GEN-LAST:event_TabelaPesquisaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarC;
    private javax.swing.JButton AtualizarC;
    private javax.swing.JTextField CidadeC;
    private javax.swing.JTextField CpfC;
    private javax.swing.JTextField EmailC;
    private javax.swing.JTextField EnderecoC;
    private javax.swing.JTextField EstadoC;
    private javax.swing.JButton ExcluirC;
    private javax.swing.JTextField FoneC;
    private javax.swing.JTextField IdC;
    private javax.swing.JButton LimparC;
    private javax.swing.JTextField NomeC;
    private javax.swing.JTextField PesquisaC;
    private javax.swing.JLabel StatusC;
    private javax.swing.JScrollPane TabelaC;
    private javax.swing.JTable TabelaPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}

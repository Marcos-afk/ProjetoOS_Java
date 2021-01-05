package br.com.projetoos.telas;

import java.sql.*;
import br.com.projetoos.dal.Conexao;
import javax.swing.JOptionPane;

public class Usuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rst = null;

    public Usuario() {
        initComponents();
        conexao = Conexao.Conectar();

        if (conexao != null) {
            StatusV.setText("Conectado com o BD");
        } else {
            StatusV.setText("Erro no BD");

        }
    }

    private void Consultar() {
        String sql = "select * from usuarios where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idP.getText());
            rst = pst.executeQuery();

            if (rst.next()) {
                idP.setText(rst.getString(1));
                UsuarioP.setText(rst.getString(2));
                FoneP.setText(rst.getString(3));
                LoginP.setText(rst.getString(4));
                SenhaP.setText(rst.getString(5));
                PerfilP.setSelectedItem(rst.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não existe no sistema!");
                LimparP();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }

    private void Adicionar() {
        String sql = "insert into usuarios values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idP.getText());
            pst.setString(2, UsuarioP.getText());
            pst.setString(3, FoneP.getText());
            pst.setString(4, LoginP.getText());
            pst.setString(5, SenhaP.getText());
            pst.setString(6, PerfilP.getSelectedItem().toString());

            if((idP.getText().isEmpty()) || (UsuarioP.getText().isEmpty()) || (LoginP.getText().isEmpty()) || (SenhaP.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    LimparP();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário");
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

    }
    
    private void Editar(){
        String sql = "update usuarios set usuario = ?, fone = ?, login = ?, senha = ?, perfil = ?  where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, UsuarioP.getText());
            pst.setString(2, FoneP.getText());
            pst.setString(3, LoginP.getText());
            pst.setString(4, SenhaP.getText());
            pst.setString(5, PerfilP.getSelectedItem().toString());
            pst.setString(6, idP.getText());
            
              if((idP.getText().isEmpty()) || (UsuarioP.getText().isEmpty()) || (LoginP.getText().isEmpty()) || (SenhaP.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                    LimparP();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar dados");
                    
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    
    }
    
    private void Deletar(){
      int confirma = JOptionPane.showConfirmDialog(null , "Tem certeza  que deseja excluir esse usuario ? ","Atenção",JOptionPane.YES_NO_OPTION);
      if(confirma == JOptionPane.YES_OPTION){
        String sql = "delete from usuarios where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idP.getText());
           int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario removido com sucesso!");
                    LimparP();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao remover");
                    
                }
            
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
      }

    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        Pusuario = new javax.swing.JLabel();
        Pfone = new javax.swing.JLabel();
        Plogin = new javax.swing.JLabel();
        Psenha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Pid = new javax.swing.JLabel();
        idP = new javax.swing.JTextField();
        UsuarioP = new javax.swing.JTextField();
        LoginP = new javax.swing.JTextField();
        FoneP = new javax.swing.JTextField();
        SenhaP = new javax.swing.JTextField();
        PerfilP = new javax.swing.JComboBox<>();
        EditarP = new javax.swing.JButton();
        AdicionarP = new javax.swing.JButton();
        ConsultarP = new javax.swing.JButton();
        ExcluirP = new javax.swing.JButton();
        StatusV = new javax.swing.JLabel();
        LimparP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField5.setText("jTextField1");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários - Os");

        Pusuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Pusuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pusuario.setText("*Usuário");

        Pfone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Pfone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pfone.setText("Fone");

        Plogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Plogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Plogin.setText("*Login");

        Psenha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Psenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Psenha.setText("*Senha");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("*Perfil");

        Pid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Pid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pid.setText("*ID");

        FoneP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FonePActionPerformed(evt);
            }
        });

        SenhaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaPActionPerformed(evt);
            }
        });

        PerfilP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        EditarP.setBackground(new java.awt.Color(204, 204, 255));
        EditarP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        EditarP.setText("Editar");
        EditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPActionPerformed(evt);
            }
        });

        AdicionarP.setBackground(new java.awt.Color(204, 204, 255));
        AdicionarP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AdicionarP.setText("Adicionar");
        AdicionarP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AdicionarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarPActionPerformed(evt);
            }
        });

        ConsultarP.setBackground(new java.awt.Color(204, 204, 255));
        ConsultarP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ConsultarP.setText("Consultar");
        ConsultarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarPActionPerformed(evt);
            }
        });

        ExcluirP.setBackground(new java.awt.Color(204, 204, 255));
        ExcluirP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ExcluirP.setText("Excluir");
        ExcluirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirPActionPerformed(evt);
            }
        });

        StatusV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        StatusV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StatusV.setText("Status");

        LimparP.setBackground(new java.awt.Color(204, 204, 255));
        LimparP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LimparP.setText("Limpar");
        LimparP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparPActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("*Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LimparP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(StatusV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ConsultarP)
                        .addGap(26, 26, 26)
                        .addComponent(ExcluirP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditarP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AdicionarP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Psenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Plogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Pfone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Pusuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(Pid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(SenhaP)
                                .addComponent(PerfilP, 0, 149, Short.MAX_VALUE)
                                .addComponent(idP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FoneP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(UsuarioP, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(LoginP))))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(idP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsuarioP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pfone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoneP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Plogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(LoginP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Psenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SenhaP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PerfilP, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsultarP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExcluirP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusV, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(LimparP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBounds(0, 0, 560, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void FonePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FonePActionPerformed

    }//GEN-LAST:event_FonePActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

    }//GEN-LAST:event_jTextField5ActionPerformed

    private void SenhaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhaPActionPerformed

    }//GEN-LAST:event_SenhaPActionPerformed

    private void ConsultarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarPActionPerformed
        Consultar();
    }//GEN-LAST:event_ConsultarPActionPerformed

    private void LimparPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparPActionPerformed
        LimparP();
    }//GEN-LAST:event_LimparPActionPerformed

    private void AdicionarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarPActionPerformed
        Adicionar();        // TODO add your handling code here:
    }//GEN-LAST:event_AdicionarPActionPerformed

    private void EditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPActionPerformed
        Editar();
    }//GEN-LAST:event_EditarPActionPerformed

    private void ExcluirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirPActionPerformed
       Deletar();
    }//GEN-LAST:event_ExcluirPActionPerformed

    private void LimparP() {
        idP.setText(null);
        UsuarioP.setText(null);
        FoneP.setText(null);
        LoginP.setText(null);
        SenhaP.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarP;
    private javax.swing.JButton ConsultarP;
    private javax.swing.JButton EditarP;
    private javax.swing.JButton ExcluirP;
    private javax.swing.JTextField FoneP;
    private javax.swing.JButton LimparP;
    private javax.swing.JTextField LoginP;
    private javax.swing.JComboBox<String> PerfilP;
    private javax.swing.JLabel Pfone;
    private javax.swing.JLabel Pid;
    private javax.swing.JLabel Plogin;
    private javax.swing.JLabel Psenha;
    private javax.swing.JLabel Pusuario;
    private javax.swing.JTextField SenhaP;
    private javax.swing.JLabel StatusV;
    private javax.swing.JTextField UsuarioP;
    private javax.swing.JTextField idP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}

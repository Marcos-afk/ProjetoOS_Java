package br.com.projetoos.telas;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    public TelaPrincipal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        Usuario = new javax.swing.JLabel();
        DataP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        CadastroP = new javax.swing.JMenu();
        ClienteP = new javax.swing.JMenuItem();
        OsP = new javax.swing.JMenuItem();
        UsuarioMenP = new javax.swing.JMenuItem();
        RelatorioP = new javax.swing.JMenu();
        ServicosP = new javax.swing.JMenuItem();
        AjudaP = new javax.swing.JMenu();
        SobreP = new javax.swing.JMenuItem();
        OpcoesP = new javax.swing.JMenu();
        SairP = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Página Principal - SistemaOs");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Desktop.setBackground(new java.awt.Color(204, 204, 204));
        Desktop.setPreferredSize(new java.awt.Dimension(560, 450));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Usuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Usuario.setText("Usuário");
        Usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        DataP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DataP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DataP.setText("Data");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bem vindo");

        Menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Menu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        CadastroP.setText("Cadastro");
        CadastroP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroPActionPerformed(evt);
            }
        });

        ClienteP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        ClienteP.setText("Cliente");
        ClienteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientePActionPerformed(evt);
            }
        });
        CadastroP.add(ClienteP);

        OsP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        OsP.setText("Os");
        OsP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OsPActionPerformed(evt);
            }
        });
        CadastroP.add(OsP);

        UsuarioMenP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        UsuarioMenP.setText("Usuários");
        UsuarioMenP.setEnabled(false);
        UsuarioMenP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioMenPActionPerformed(evt);
            }
        });
        CadastroP.add(UsuarioMenP);

        Menu.add(CadastroP);

        RelatorioP.setText("Relatório");
        RelatorioP.setEnabled(false);

        ServicosP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        ServicosP.setText("Serviços");
        RelatorioP.add(ServicosP);

        Menu.add(RelatorioP);

        AjudaP.setText("Ajuda");

        SobreP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        SobreP.setText("Sobre");
        SobreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobrePActionPerformed(evt);
            }
        });
        AjudaP.add(SobreP);

        Menu.add(AjudaP);

        OpcoesP.setText("Opções");

        SairP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        SairP.setText("Sair");
        SairP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairPActionPerformed(evt);
            }
        });
        OpcoesP.add(SairP);

        Menu.add(OpcoesP);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DataP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DataP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(693, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClientePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientePActionPerformed
        Cliente cliente = new Cliente();
        cliente.setVisible(true);
        Desktop.add(cliente);
    }//GEN-LAST:event_ClientePActionPerformed

    private void UsuarioMenPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioMenPActionPerformed
       Usuario usuario = new Usuario();
       usuario.setVisible(true);
       Desktop.add(usuario);
    }//GEN-LAST:event_UsuarioMenPActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        DataP.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void SairPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairPActionPerformed
      int sair = JOptionPane.showConfirmDialog(null , "Tem certeza ? ","Atenção",JOptionPane.YES_NO_OPTION);
      if(sair == JOptionPane.YES_OPTION){
          System.exit(0);
      }
    }//GEN-LAST:event_SairPActionPerformed

    private void SobrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SobrePActionPerformed
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_SobrePActionPerformed

    private void CadastroPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroPActionPerformed
         
    }//GEN-LAST:event_CadastroPActionPerformed

    private void OsPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OsPActionPerformed
        TelaOS telaOs = new TelaOS();
        telaOs.setVisible(true);
        Desktop.add(telaOs);
    }//GEN-LAST:event_OsPActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AjudaP;
    private javax.swing.JMenu CadastroP;
    private javax.swing.JMenuItem ClienteP;
    private javax.swing.JLabel DataP;
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu OpcoesP;
    private javax.swing.JMenuItem OsP;
    public static javax.swing.JMenu RelatorioP;
    private javax.swing.JMenuItem SairP;
    private javax.swing.JMenuItem ServicosP;
    private javax.swing.JMenuItem SobreP;
    public static javax.swing.JLabel Usuario;
    public static javax.swing.JMenuItem UsuarioMenP;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

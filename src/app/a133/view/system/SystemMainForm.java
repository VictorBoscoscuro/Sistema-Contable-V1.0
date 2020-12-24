/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.view.system;

import app.a133.connection.MyConnection;
import app.a133.view.libros.LibroDiarioGenerarForm;
import app.a133.view.login.LoginForm;
import app.a133.view.libros.LibroDiarioGenerarForm;
import app.a133.view.libros.LibroMayorGenerarForm;
import java.sql.Connection;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author victo
 */
public class SystemMainForm extends javax.swing.JFrame {

    /**
     * Creates new form SystemMainForm
     */
    public SystemMainForm() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Bienvenido/a "+LoginForm.username+" |"+LoginForm.alias+"|");
//        Image icon = new ImageIcon(getClass().getResource("/app/a133/view/img/logo3.png")).getImage();      //64px
//        setIconImage(icon);
        if("USER".equals(LoginForm.rol)){
            icoUsers.setVisible(false);
            btnGestionUsuarios.setVisible(false);
            icoCuentas.setVisible(false);
            btnGestionCuentas.setVisible(false);
            icoEmpresa.setVisible(false);
            btnInformacionEmpresa.setVisible(false);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        try {
            String sql = "SELECT * FROM empresa WHERE id_empresa = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                lblRazonSocial.setText(rs.getString("razon_social"));
                lblCuit.setText(rs.getString("cuit").substring(0, 2)+"-"+rs.getString("cuit").substring(2, 10)+"-"+rs.getString("cuit").substring(10));
                lblTelefono.setText("Telefono: "+rs.getString("telefono"));
                lblMail.setText("Mail: "+rs.getString("mail"));
            }
        } catch (Exception e) {
        } finally{
            try {
                rs.close();
            } catch (Exception e) {}
            try {
                ps.close();
            } catch (Exception e) {}
            try {
                con.close();
            } catch (Exception e) {}
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAsiento = new javax.swing.JButton();
        btnLibroDiario = new javax.swing.JButton();
        btnLibroMayor = new javax.swing.JButton();
        btnGestionUsuarios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        icoUsers = new javax.swing.JLabel();
        rSLabelFecha2 = new rojeru_san.RSLabelFecha();
        jLabel9 = new javax.swing.JLabel();
        btnGestionCuentas = new javax.swing.JButton();
        icoCuentas = new javax.swing.JLabel();
        btnInformacionEmpresa = new javax.swing.JButton();
        icoEmpresa = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        lblCuit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTelefono = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAsiento.setText("INSERTAR ASIENTOS");
        btnAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsientoActionPerformed(evt);
            }
        });

        btnLibroDiario.setText("LIBRO DIARIO");
        btnLibroDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibroDiarioActionPerformed(evt);
            }
        });

        btnLibroMayor.setText("LIBRO MAYOR");
        btnLibroMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibroMayorActionPerformed(evt);
            }
        });

        btnGestionUsuarios.setText("GESTIONAR USUARIOS");
        btnGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionUsuariosActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/logo3.png"))); // NOI18N

        icoUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/users32.png"))); // NOI18N

        rSLabelFecha2.setForeground(new java.awt.Color(0, 0, 0));
        rSLabelFecha2.setToolTipText("Fecha Actual");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("A133 -beta");

        btnGestionCuentas.setText("GESTIONAR PLAN DE CUENTAS");
        btnGestionCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionCuentasActionPerformed(evt);
            }
        });

        icoCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/cuentas32.png"))); // NOI18N

        btnInformacionEmpresa.setText("INFORMACION DE LA EMPRESA");
        btnInformacionEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacionEmpresaActionPerformed(evt);
            }
        });

        icoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/empresa32.png"))); // NOI18N

        lblRazonSocial.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRazonSocial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazonSocial.setText("EMPRESA");

        lblCuit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblCuit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuit.setText("cuit");

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblTelefono.setText("Telefono");

        lblMail.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblMail.setText("Mail");

        jLabel7.setFont(new java.awt.Font("Haettenschweiler", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Desarrollado por Victor Boscoscuro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(icoCuentas)
                                                    .addComponent(icoUsers)
                                                    .addComponent(icoEmpresa))
                                                .addGap(28, 28, 28))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnLibroDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnInformacionEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnGestionCuentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                                .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAsiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnLibroMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rSLabelFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblRazonSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuit)
                .addGap(18, 18, 18)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMail)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLibroDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLibroMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(icoUsers)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(icoCuentas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(icoEmpresa)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInformacionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(19, 19, 19)
                        .addComponent(rSLabelFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLibroDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroDiarioActionPerformed
        LibroDiarioGenerarForm form = new LibroDiarioGenerarForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLibroDiarioActionPerformed

    private void btnAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsientoActionPerformed
        AsientoForm asientoForm = new AsientoForm();
        asientoForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsientoActionPerformed

    private void btnGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionUsuariosActionPerformed
        UserManagementForm form = new UserManagementForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionUsuariosActionPerformed

    private void btnGestionCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionCuentasActionPerformed
        PlanCuentasForm form = new PlanCuentasForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionCuentasActionPerformed

    private void btnInformacionEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacionEmpresaActionPerformed
        InfoEmpresaForm form = new InfoEmpresaForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInformacionEmpresaActionPerformed

    private void btnLibroMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroMayorActionPerformed
        LibroMayorGenerarForm form = new LibroMayorGenerarForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLibroMayorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SystemMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsiento;
    private javax.swing.JButton btnGestionCuentas;
    private javax.swing.JButton btnGestionUsuarios;
    private javax.swing.JButton btnInformacionEmpresa;
    private javax.swing.JButton btnLibroDiario;
    private javax.swing.JButton btnLibroMayor;
    private javax.swing.JLabel icoCuentas;
    private javax.swing.JLabel icoEmpresa;
    private javax.swing.JLabel icoUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblTelefono;
    private rojeru_san.RSLabelFecha rSLabelFecha2;
    // End of variables declaration//GEN-END:variables
}

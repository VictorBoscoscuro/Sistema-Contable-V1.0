
package app.a133.view.libros;

import app.a133.view.system.SystemMainForm;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class LibroDiarioGenerarForm extends javax.swing.JFrame {

    public LibroDiarioGenerarForm() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Generar Libro Diario");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAnio = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAnioDesde = new javax.swing.JTextField();
        txtMesDesde = new javax.swing.JTextField();
        txtDiaDesde = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAnioHasta = new javax.swing.JTextField();
        txtMesHasta = new javax.swing.JTextField();
        txtDiaHasta = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnGenerarDesdeHasta = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtAnio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnioFocusLost(evt);
            }
        });
        txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioKeyTyped(evt);
            }
        });

        txtMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMesFocusLost(evt);
            }
        });
        txtMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesKeyTyped(evt);
            }
        });

        txtDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaFocusLost(evt);
            }
        });
        txtDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaKeyTyped(evt);
            }
        });

        jLabel2.setText("Año");

        jLabel3.setText("Mes");

        jLabel4.setText("Dia");

        jLabel5.setText("-");

        jLabel6.setText("-");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GENERAR LIBRO DIARIO");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel8.setText("Desde");

        jLabel9.setText("Año");

        jLabel10.setText("Mes");

        jLabel11.setText("Dia");

        jLabel12.setText("-");

        jLabel13.setText("-");

        txtAnioDesde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnioDesdeFocusLost(evt);
            }
        });
        txtAnioDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioDesdeKeyTyped(evt);
            }
        });

        txtMesDesde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMesDesdeFocusLost(evt);
            }
        });
        txtMesDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesDesdeActionPerformed(evt);
            }
        });
        txtMesDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesDesdeKeyTyped(evt);
            }
        });

        txtDiaDesde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaDesdeFocusLost(evt);
            }
        });
        txtDiaDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaDesdeKeyTyped(evt);
            }
        });

        jLabel14.setText("Dia");

        jLabel15.setText("-");

        jLabel16.setText("-");

        txtAnioHasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnioHastaFocusLost(evt);
            }
        });
        txtAnioHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioHastaKeyTyped(evt);
            }
        });

        txtMesHasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMesHastaFocusLost(evt);
            }
        });
        txtMesHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesHastaKeyTyped(evt);
            }
        });

        txtDiaHasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaHastaFocusLost(evt);
            }
        });
        txtDiaHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaHastaKeyTyped(evt);
            }
        });

        jLabel17.setText("Hasta");

        jLabel18.setText("Año");

        jLabel19.setText("Mes");

        btnGenerarDesdeHasta.setText("Generar");
        btnGenerarDesdeHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarDesdeHastaActionPerformed(evt);
            }
        });

        jLabel20.setText("Día");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerarDesdeHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9)
                                            .addGap(40, 40, 40)
                                            .addComponent(jLabel10)
                                            .addGap(36, 36, 36)
                                            .addComponent(jLabel11))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel19)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel3)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel4)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarDesdeHasta)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vaciarCampos(){
        txtAnio.setText(null);
        txtMes.setText(null);
        txtDia.setText(null);
    }
    
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        
        if(!"".equals(txtAnio.getText()) && !"".equals(txtMes.getText()) && !"".equals(txtDia.getText())){
            LibroDiarioForm form = new LibroDiarioForm(txtAnio.getText(),txtMes.getText(),txtDia.getText());
            form.setVisible(true);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Complete la fecha correctamente");
            vaciarCampos();
        }
            
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        SystemMainForm form = new SystemMainForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioKeyTyped
        if(txtAnio.getText().length() < 4){
            if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
                if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo numeros"); 
                    txtAnio.requestFocus();
                } 
            }
        } else evt.consume();
    }//GEN-LAST:event_txtAnioKeyTyped

    private void txtMesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesKeyTyped
        if(txtMes.getText().length() < 2){
            if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
                if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo numeros");
                    txtMes.requestFocus();
                }
            }
        } else evt.consume();
    }//GEN-LAST:event_txtMesKeyTyped

    private void txtDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            btnGenerar.doClick();
        }else{
            if(txtDia.getText().length() < 2){
                if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
                    if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                        evt.consume();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Solo numeros"); 
                        txtDia.requestFocus();
                    }
                }
            } else evt.consume();
        }        
    }//GEN-LAST:event_txtDiaKeyTyped

    private void txtAnioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioFocusLost
        try{
        Integer anio = Integer.parseInt(txtAnio.getText());
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Integer anioActual  = localDate.getYear();
        if(anio < 1950 || anio > anioActual){
            JOptionPane.showMessageDialog(null, "Ingrese un año válido...");   
            txtAnio.setText(null);
        }
        } catch(Exception e){
            
        }
    }//GEN-LAST:event_txtAnioFocusLost

    private void txtMesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMesFocusLost
        try {
            Integer mes = Integer.parseInt(txtMes.getText());
            if(txtMes.getText().length() == 2){
            if(mes < 1 || mes > 12){
                JOptionPane.showMessageDialog(null, "Que calendario raro manejas... Dale hacé las cosas bien.");
                txtMes.setText(null);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Recuerde que el formato es MM (2 digitos)");
            txtMes.setText(null);
            txtMes.requestFocus();
        }
        } catch (Exception e) {
            txtAnio.requestFocus();
        }

    }//GEN-LAST:event_txtMesFocusLost

    private void txtDiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaFocusLost
        try {
            Integer dia = Integer.parseInt(txtDia.getText());
            if(txtDia.getText().length() == 2){
                if(dia < 1 || dia > 31){
                    JOptionPane.showMessageDialog(null, "Que calendario raro manejas...");
                    txtDia.setText(null);
                    txtDia.requestFocus();
                }
            } else{
                JOptionPane.showMessageDialog(null, "Recuerde que el formato es MM (2 digitos)");
                txtDia.setText(null);
                txtDia.requestFocus();
            }    
        } catch (Exception e) {
           txtMes.requestFocus();
        }

    }//GEN-LAST:event_txtDiaFocusLost

    private void txtAnioDesdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioDesdeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioDesdeFocusLost

    private void txtAnioDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioDesdeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioDesdeKeyTyped

    private void txtMesDesdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMesDesdeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesDesdeFocusLost

    private void txtMesDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesDesdeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesDesdeKeyTyped

    private void txtDiaDesdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaDesdeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaDesdeFocusLost

    private void txtDiaDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaDesdeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaDesdeKeyTyped

    private void txtAnioHastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioHastaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioHastaFocusLost

    private void txtAnioHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioHastaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioHastaKeyTyped

    private void txtMesHastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMesHastaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesHastaFocusLost

    private void txtMesHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesHastaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesHastaKeyTyped

    private void txtDiaHastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaHastaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaHastaFocusLost

    private void txtDiaHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaHastaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaHastaKeyTyped

    private void btnGenerarDesdeHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarDesdeHastaActionPerformed
        if(!"".equals(txtAnioDesde.getText()) && !"".equals(txtAnioHasta.getText()) && !"".equals(txtMesDesde.getText()) && !"".equals(txtMesHasta.getText()) && !"".equals(txtDiaDesde.getText()) && !"".equals(txtDiaHasta.getText())){
            LibroDiarioForm form = new LibroDiarioForm(txtAnioDesde.getText(),txtMesDesde.getText(),txtDiaDesde.getText(),txtAnioHasta.getText(),txtMesHasta.getText(),txtDiaHasta.getText());
            form.setVisible(true);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Complete la fecha correctamente");
            vaciarCampos();
        }
    }//GEN-LAST:event_btnGenerarDesdeHastaActionPerformed

    private void txtMesDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesDesdeActionPerformed

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
            java.util.logging.Logger.getLogger(LibroDiarioGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroDiarioGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroDiarioGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroDiarioGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroDiarioGenerarForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGenerarDesdeHasta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAnioDesde;
    private javax.swing.JTextField txtAnioHasta;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtDiaDesde;
    private javax.swing.JTextField txtDiaHasta;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMesDesde;
    private javax.swing.JTextField txtMesHasta;
    // End of variables declaration//GEN-END:variables
}

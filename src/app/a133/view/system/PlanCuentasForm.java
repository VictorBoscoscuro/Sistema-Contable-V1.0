
package app.a133.view.system;

import app.a133.connection.MyConnection;
import app.a133.model.Asiento_Cuenta;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author victo
 */
public class PlanCuentasForm extends javax.swing.JFrame {

    public PlanCuentasForm() {
        initComponents();
        setTitle("Plan de Cuentas");
        setLocationRelativeTo(null);
        jtPlanCuentas.setVisible(false);
        cbxTipo.setSelectedIndex(0);
        cbxBuscarTipo.setSelectedItem(0);
        formatoTabla();
    }

    private void formatoTabla(){
        int[] weights = {20,140,120,15};
            
        for(int i = 0; i < jtPlanCuentas.getColumnCount(); i++){
            jtPlanCuentas.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(146, 43, 33));
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setFont(new Font("Segoe UI",Font.BOLD,14));
        headerRenderer.setOpaque(true);

        
        for (int i = 0; i < jtPlanCuentas.getModel().getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
            jtPlanCuentas.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);    
        }
        
    }
    
    private void vaciarCamposBusqueda(){
        txtBuscarCodigo.setText(null);
        txtBuscarNombre.setText(null);
        cbxBuscarTipo.setSelectedIndex(0);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPlanCuentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chkRecibeSaldo = new javax.swing.JCheckBox();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnModificarCuenta = new javax.swing.JButton();
        btnNuevaCuenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarCodigo = new javax.swing.JTextField();
        txtBuscarNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxBuscarTipo = new javax.swing.JComboBox<>();
        btnBuscarCuenta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtPlanCuentas.setBackground(new java.awt.Color(231, 76, 60));
        jtPlanCuentas.setForeground(new java.awt.Color(0, 0, 0));
        jtPlanCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Tipo", "Recibe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPlanCuentas.setFocusable(false);
        jtPlanCuentas.setRowHeight(25);
        jtPlanCuentas.setSelectionBackground(new java.awt.Color(205, 97, 85));
        jtPlanCuentas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jtPlanCuentas);

        jLabel1.setText("Codigo");

        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre");

        chkRecibeSaldo.setText("Recibe saldo");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de cuenta", "ACTIVO", "PASIVO", "PATRIMONIO", "RESULTADO_POSITIVO", "RESULTADO_NEGATIVO" }));

        jLabel4.setText("Tipo");

        btnModificarCuenta.setText("Modificar");
        btnModificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCuentaActionPerformed(evt);
            }
        });

        btnNuevaCuenta.setText("Nueva");
        btnNuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCuentaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel5.setText("Codigo");

        jLabel6.setText("Tipo");

        cbxBuscarTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de cuenta", "ACTIVO", "PASIVO", "PATRIMONIO", "RESULTADO_POSITIVO", "RESULTADO_NEGATIVO" }));

        btnBuscarCuenta.setText("Buscar");
        btnBuscarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentaActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/filtro32.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/logo3.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("A133 -beta");

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("PLAN DE CUENTAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(btnBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxBuscarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnNuevaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(124, 124, 124))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chkRecibeSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkRecibeSaldo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarCuenta)
                    .addComponent(btnNuevaCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbxBuscarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCuenta)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentaActionPerformed
        String codigo = txtBuscarCodigo.getText();
        String nombre = txtBuscarNombre.getText().toUpperCase();
        String tipo = (String) cbxBuscarTipo.getSelectedItem();
        
        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        try {
            if("".equals(codigo) && "".equals(nombre) && "Seleccione el tipo de cuenta".equals(tipo)){
                jtPlanCuentas.setVisible(true);
                DefaultTableModel model = new DefaultTableModel();
                jtPlanCuentas.setModel(model);
                sql = "SELECT codigo, nombre, tipo_cuenta, recibe_saldo FROM cuenta ORDER BY codigo;";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData rsMD = rs.getMetaData();     
                int numberColumns = rsMD.getColumnCount();
            
                model.addColumn("Codigo");
                model.addColumn("Nombre");
                model.addColumn("Tipo");
                model.addColumn("Recibe");
            
                formatoTabla();
            
                while(rs.next()){
                    Object[] rows = new Object[numberColumns];
                    for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                    }
                model.addRow(rows);
                }
            } else if(! "".equals(codigo)){
                jtPlanCuentas.setVisible(true);
                DefaultTableModel model = new DefaultTableModel();
                jtPlanCuentas.setModel(model);
                sql = "SELECT codigo, nombre, tipo_cuenta, recibe_saldo FROM cuenta WHERE codigo LIKE '"+codigo+"%' ORDER BY codigo;";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData rsMD = rs.getMetaData();     
                int numberColumns = rsMD.getColumnCount();
            
                model.addColumn("Codigo");
                model.addColumn("Nombre");
                model.addColumn("Tipo");
                model.addColumn("Recibe");
            
                formatoTabla();
            
                while(rs.next()){
                    Object[] rows = new Object[numberColumns];
                    for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                    }
                model.addRow(rows);
                }
                
                vaciarCamposBusqueda();
            } else if("".equals(codigo) && "".equals(nombre) &&  !"Seleccione el tipo de cuenta".equals(tipo)){
               jtPlanCuentas.setVisible(true);
                DefaultTableModel model = new DefaultTableModel();
                jtPlanCuentas.setModel(model);
                sql = "SELECT codigo, nombre, tipo_cuenta, recibe_saldo FROM cuenta WHERE tipo_cuenta = '"+tipo+"' ORDER BY codigo;";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData rsMD = rs.getMetaData();     
                int numberColumns = rsMD.getColumnCount();
            
                model.addColumn("Codigo");
                model.addColumn("Nombre");
                model.addColumn("Tipo");
                model.addColumn("Recibe");
            
                formatoTabla();
            
                while(rs.next()){
                    Object[] rows = new Object[numberColumns];
                    for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                    }
                model.addRow(rows);
                }
                
                vaciarCamposBusqueda(); 
            } else if("".equals(codigo) && !"".equals(nombre) &&  !"Seleccione el tipo de cuenta".equals(tipo)){
               jtPlanCuentas.setVisible(true);
                DefaultTableModel model = new DefaultTableModel();
                jtPlanCuentas.setModel(model);
                sql = "SELECT codigo, nombre, tipo_cuenta, recibe_saldo FROM cuenta WHERE tipo_cuenta = '"+tipo+"' AND nombre LIKE '%"+nombre+"%' ORDER BY codigo;";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData rsMD = rs.getMetaData();     
                int numberColumns = rsMD.getColumnCount();
            
                model.addColumn("Codigo");
                model.addColumn("Nombre");
                model.addColumn("Tipo");
                model.addColumn("Recibe");
            
                formatoTabla();
            
                while(rs.next()){
                    Object[] rows = new Object[numberColumns];
                    for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                    }
                model.addRow(rows);
                }
                
                vaciarCamposBusqueda(); 
            }
        } catch (Exception e) {
        } finally{
            try{
                rs.close();
            } catch(Exception e){}
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch (Exception e ) {}
        }
        
    }//GEN-LAST:event_btnBuscarCuentaActionPerformed

    private void vaciarCampos(){
        txtCodigo.setText(null);
        txtNombre.setText(null);
        cbxTipo.setSelectedIndex(0);
        chkRecibeSaldo.setSelected(false);
    }
    
    private void btnNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCuentaActionPerformed
        String sql = "INSERT INTO cuenta (codigo, nombre, recibe_saldo,tipo_cuenta, saldo_actual) VALUES(?,?,?,?,0);";
        PreparedStatement ps = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText().toUpperCase();
        boolean recibe_saldo = chkRecibeSaldo.isSelected();
        String tipo = (String) cbxTipo.getSelectedItem();
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setBoolean(3, recibe_saldo);
            if(tipo != "Seleccione el tipo de cuenta"){
                ps.setString(4, tipo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
                vaciarCampos();
            } else{
                JOptionPane.showMessageDialog(null, "Seleccione el tipo de la cuenta");
                cbxTipo.requestFocus();
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            vaciarCampos();
            
        } finally{
            try {
                ps.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_btnNuevaCuentaActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        if(txtCodigo.getText().length() < 5){
            if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8 && evt.getKeyChar() != 32){
                if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo numeros");               
                }
            }
        } else evt.consume();
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
        int longitud = txtCodigo.getText().length();
        if(longitud < 5 && longitud > 0){
            JOptionPane.showMessageDialog(null, "El codigo debe tener 5 numeros");
            txtCodigo.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoFocusLost

    private void btnModificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCuentaActionPerformed
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText().toUpperCase();
        String tipo = (String) cbxTipo.getSelectedItem();
        boolean recibe = chkRecibeSaldo.isSelected();
        
        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        try {
            sql = "SELECT * FROM cuenta WHERE codigo = '"+codigo+"';";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                sql = "SELECT * FROM cuenta INNER JOIN asiento_cuenta ON(cuenta.id_cuenta = asiento_cuenta.id_cuenta) WHERE cuenta.codigo = '"+codigo+"';";
                ps = con.prepareStatement(sql);
                rs2 = ps.executeQuery();
                if(rs2.next()){
                    int opcion = JOptionPane.showConfirmDialog(null,"Solo podrá CAMBIAR EL NOMBRE a: "+nombre+" . Desea hacerlo?", "Asientos relacionados",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(opcion == JOptionPane.YES_OPTION){
                            try {
                                if(!"".equals(nombre)){
                                   sql = "UPDATE cuenta SET nombre = '"+nombre+"' WHERE codigo = '" + codigo + "';";
                                   ps = con.prepareStatement(sql);
                                   ps.executeUpdate();
                                   JOptionPane.showMessageDialog(null, "Ahora el nombre de la cuenta "+codigo+" es: "+nombre);
                                } else{
                                    JOptionPane.showMessageDialog(null, "ERROR. El nombre no puede estar vacio");
                                    vaciarCampos();
                                }           
                            } catch (Exception e) {}
                        } else if (opcion == JOptionPane.NO_OPTION){
                            vaciarCampos();
                        } else if (opcion == JOptionPane.CLOSED_OPTION){
                            vaciarCampos();
                        }
                } else{
                    if(!"Seleccione el tipo de cuenta".equals(tipo) && !"".equals(nombre)){
                       sql = "UPDATE cuenta SET nombre = '"+nombre+"' , tipo_cuenta = '"+tipo+"' , recibe_saldo = "+recibe+" WHERE codigo ='" + codigo + "';";
                       ps = con.prepareStatement(sql);
                       ps.executeUpdate();
                       JOptionPane.showMessageDialog(null, "Cuenta actualizada correctamente");
                       vaciarCampos();
                    } else JOptionPane.showMessageDialog(null, "Asegurese de completar los campos!");
                    
                }
                 
           
            } else JOptionPane.showMessageDialog(null, "El codigo no existe");
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
            } catch (Exception e) {}
            try {
                rs2.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {}
            try {
                con.close();
            } catch (Exception e) {}
            }
    }//GEN-LAST:event_btnModificarCuentaActionPerformed

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
            java.util.logging.Logger.getLogger(PlanCuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanCuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanCuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanCuentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanCuentasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCuenta;
    private javax.swing.JButton btnModificarCuenta;
    private javax.swing.JButton btnNuevaCuenta;
    private javax.swing.JComboBox<String> cbxBuscarTipo;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JCheckBox chkRecibeSaldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPlanCuentas;
    private javax.swing.JTextField txtBuscarCodigo;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

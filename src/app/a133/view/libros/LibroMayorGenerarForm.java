/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.view.libros;
import app.a133.connection.MyConnection;
import app.a133.view.system.SystemMainForm;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
/**
 *
 * @author victo
 */
public class LibroMayorGenerarForm extends javax.swing.JFrame {

    /**
     * Creates new form LibroMayorGenerar
     */
    public LibroMayorGenerarForm() {
        initComponents();
        formatoTabla();
        setLocationRelativeTo(null);
        setTitle("Generar Asiento Mayor");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarCodigo = new javax.swing.JButton();
        txtCodigoBuscarCuenta = new javax.swing.JTextField();
        btnBuscarNombre = new javax.swing.JButton();
        txtNombreBuscarCuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCuentas = new javax.swing.JTable();
        btnVerTodas = new javax.swing.JButton();
        btnCopiarCodigo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoGenerar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAnioInicial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMesInicial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiaInicial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAnioFinal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMesFinal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDiaFinal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnTodosAsientos = new javax.swing.JButton();
        btnGenerarFiltrado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GENERAR LIBRO MAYOR");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setText("Buscar por código");

        btnBuscarCodigo.setText("Buscar");
        btnBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodigoActionPerformed(evt);
            }
        });

        btnBuscarNombre.setText("Buscar");
        btnBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setText("Buscar por nombre");

        jtCuentas.setBackground(new java.awt.Color(204, 204, 204));
        jtCuentas.setForeground(new java.awt.Color(0, 0, 0));
        jtCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCuentas.setFocusable(false);
        jtCuentas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCuentas.setRowHeight(22);
        jtCuentas.setSelectionBackground(new java.awt.Color(255, 255, 153));
        jtCuentas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtCuentas.setShowGrid(false);
        jtCuentas.getTableHeader().setReorderingAllowed(false);
        jtCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCuentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCuentas);

        btnVerTodas.setText("Ver Todas");
        btnVerTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodasActionPerformed(evt);
            }
        });

        btnCopiarCodigo.setText("Copiar Codigo");
        btnCopiarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarCodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo Cuenta");

        jLabel2.setText("Desde");

        jLabel3.setText("Año");

        txtAnioInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnioInicialFocusLost(evt);
            }
        });
        txtAnioInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioInicialKeyTyped(evt);
            }
        });

        jLabel8.setText("-");

        txtMesInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMesInicialFocusLost(evt);
            }
        });
        txtMesInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesInicialKeyTyped(evt);
            }
        });

        jLabel4.setText("Mes");

        txtDiaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaInicialFocusLost(evt);
            }
        });
        txtDiaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaInicialKeyTyped(evt);
            }
        });

        jLabel9.setText("Dia");

        jLabel10.setText("-");

        jLabel11.setText("Hasta");

        txtAnioFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAnioFinalFocusLost(evt);
            }
        });
        txtAnioFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioFinalKeyTyped(evt);
            }
        });

        jLabel12.setText("-");

        txtMesFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMesFinalFocusLost(evt);
            }
        });
        txtMesFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesFinalKeyTyped(evt);
            }
        });

        jLabel13.setText("Mes");

        txtDiaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaFinalFocusLost(evt);
            }
        });
        txtDiaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaFinalKeyTyped(evt);
            }
        });

        jLabel14.setText("Dia");

        jLabel15.setText("-");

        jLabel16.setText("Año");

        btnTodosAsientos.setText("Todos los asientos relacionados");
        btnTodosAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosAsientosActionPerformed(evt);
            }
        });

        btnGenerarFiltrado.setText("Generar");
        btnGenerarFiltrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFiltradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnVerTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCodigoBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNombreBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(202, 202, 202)
                                            .addComponent(btnCopiarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCodigoGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnTodosAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAnioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(btnGenerarFiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(159, 159, 159))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAnioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtMesInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel16))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAnioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(txtMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGenerarFiltrado)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnTodosAsientos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(btnVerTodas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCodigo))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCopiarCodigo)
                        .addGap(13, 13, 13)
                        .addComponent(btnVolver))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formatoTabla(){            //Ajusta el ancho de las columnas
        int[] weights = {12,117,78};
            
        for(int i = 0; i < jtCuentas.getColumnCount(); i++){
            jtCuentas.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer codigo_cuenta_HR = new DefaultTableCellRenderer();
        codigo_cuenta_HR.setBackground(new Color(255, 215, 0));
        codigo_cuenta_HR.setForeground(Color.BLACK);
        codigo_cuenta_HR.setHorizontalAlignment(SwingConstants.LEFT);
        jtCuentas.getColumnModel().getColumn(0).setHeaderRenderer(codigo_cuenta_HR);
        jtCuentas.getColumnModel().getColumn(1).setHeaderRenderer(codigo_cuenta_HR);
        
        DefaultTableCellRenderer tipo_HR = new DefaultTableCellRenderer();
        tipo_HR.setBackground(new Color(255, 215, 0));
        tipo_HR.setForeground(Color.BLACK);
        tipo_HR.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer tipo_CR = new DefaultTableCellRenderer();
        tipo_CR.setHorizontalAlignment(SwingConstants.CENTER);
        jtCuentas.getColumnModel().getColumn(2).setHeaderRenderer(tipo_HR);
        jtCuentas.getColumnModel().getColumn(2).setCellRenderer(tipo_CR);
        
    }
    
    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        String sql="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();

        try {
            DefaultTableModel model = new DefaultTableModel();
            jtCuentas.setModel(model);
            String codigo = txtCodigoBuscarCuenta.getText();

            sql="SELECT codigo,nombre,tipo_cuenta FROM cuenta WHERE codigo LIKE '"+codigo+"%' ORDER BY codigo;";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();

            int numberColumns = rsMD.getColumnCount();

            model.addColumn("Codigo");
            model.addColumn("Nombre");
            model.addColumn("Tipo");

            formatoTabla();

            while(rs.next()){
                Object[] rows = new Object[numberColumns];
                for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                }
                model.addRow(rows);
            }

        } catch (SQLException e) {
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
            txtCodigoBuscarCuenta.setText("");
        }
    }//GEN-LAST:event_btnBuscarCodigoActionPerformed

    private void btnBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNombreActionPerformed
        String sql="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();

        try {
            DefaultTableModel model = new DefaultTableModel();
            jtCuentas.setModel(model);
            String nombre = txtNombreBuscarCuenta.getText().toUpperCase();

            sql="SELECT codigo,nombre,tipo_cuenta FROM cuenta WHERE nombre LIKE '%"+nombre+"%' ORDER BY codigo;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();

            int numberColumns = rsMD.getColumnCount();

            model.addColumn("Codigo");
            model.addColumn("Nombre");
            model.addColumn("Tipo");

            formatoTabla();

            while(rs.next()){
                Object[] rows = new Object[numberColumns];
                for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                }
                model.addRow(rows);
            }

        } catch (SQLException e) {
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
            txtNombreBuscarCuenta.setText("");
        }
    }//GEN-LAST:event_btnBuscarNombreActionPerformed

    private void btnVerTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodasActionPerformed
        String sql="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();

        try {
            DefaultTableModel model = new DefaultTableModel();
            jtCuentas.setModel(model);
            String nombre = txtNombreBuscarCuenta.getText().toUpperCase();

            sql="SELECT codigo,nombre,tipo_cuenta FROM cuenta ORDER BY codigo;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();

            int numberColumns = rsMD.getColumnCount();

            model.addColumn("Codigo");
            model.addColumn("Nombre");
            model.addColumn("Tipo");
            
            

            formatoTabla();

            while(rs.next()){
                Object[] rows = new Object[numberColumns];
                for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs.getObject(i+1);
                }
                model.addRow(rows);
            }

        } catch (SQLException e) {
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
    }//GEN-LAST:event_btnVerTodasActionPerformed

    private void jtCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCuentasMouseClicked
 
    }//GEN-LAST:event_jtCuentasMouseClicked

    private void btnCopiarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarCodigoActionPerformed
        try {
            int FILA = jtCuentas.getSelectedRow();
            String codigo = jtCuentas.getValueAt(FILA, 0).toString();
            if(!"".equals(codigo)){
                StringSelection ss = new StringSelection((codigo));
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(ss, null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta");
        }  
    }//GEN-LAST:event_btnCopiarCodigoActionPerformed

    private void txtAnioInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioInicialFocusLost
        Integer anio = Integer.parseInt(txtAnioInicial.getText());
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Integer anioActual  = localDate.getYear();
        if(anio < 1950 || anio > anioActual){
            JOptionPane.showMessageDialog(null, "Ingrese un año válido...");
            txtAnioInicial.setText(null);
            txtAnioInicial.requestFocus();
        }
    }//GEN-LAST:event_txtAnioInicialFocusLost

    private void txtAnioInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioInicialKeyTyped
        if(txtAnioInicial.getText().length() < 4){
            if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
                if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo numeros");
                }
            }
        } else evt.consume();
    }//GEN-LAST:event_txtAnioInicialKeyTyped

    private void txtMesInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMesInicialFocusLost
        Integer mes = Integer.parseInt(txtMesInicial.getText());
        if(txtMesInicial.getText().length() == 2){
            if(mes < 1 || mes > 12){
                JOptionPane.showMessageDialog(null, "Que calendario raro manejas... Dale hacé las cosas bien.");
                txtMesInicial.setText(null);
                txtMesInicial.requestFocus();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Recuerde que el formato es MM (2 digitos)");
            txtMesInicial.setText(null);
            txtMesInicial.requestFocus();
        }
    }//GEN-LAST:event_txtMesInicialFocusLost

    private void txtMesInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesInicialKeyTyped
        if(txtMesInicial.getText().length() < 2){
            if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
                if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Solo numeros");
                }
            }
        } else evt.consume();
    }//GEN-LAST:event_txtMesInicialKeyTyped

    private void txtDiaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaInicialFocusLost
        Integer dia = Integer.parseInt(txtMesInicial.getText());
        if(txtDiaInicial.getText().length() == 2){
            if(dia < 1 || dia > 31){
                JOptionPane.showMessageDialog(null, "Que calendario raro manejas... Dale hacé las cosas bien.");
                txtDiaInicial.setText(null);
                txtDiaInicial.requestFocus();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Recuerde que el formato es MM (2 digitos)");
            txtDiaInicial.setText(null);
            txtDiaInicial.requestFocus();
        }
    }//GEN-LAST:event_txtDiaInicialFocusLost

    private void txtDiaInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaInicialKeyTyped


            if(txtDiaInicial.getText().length() < 2){
                if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
                    if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                        evt.consume();
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Solo numeros");
                    }
                }
            } else evt.consume();
        

    }//GEN-LAST:event_txtDiaInicialKeyTyped

    private void txtAnioFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnioFinalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioFinalFocusLost

    private void txtAnioFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioFinalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioFinalKeyTyped

    private void txtMesFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMesFinalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesFinalFocusLost

    private void txtMesFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesFinalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesFinalKeyTyped

    private void txtDiaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaFinalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaFinalFocusLost

    private void txtDiaFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaFinalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaFinalKeyTyped

    private void btnTodosAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosAsientosActionPerformed
        LibroMayorForm form = new LibroMayorForm(txtCodigoGenerar.getText());
        form.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnTodosAsientosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        SystemMainForm form = new SystemMainForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGenerarFiltradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFiltradoActionPerformed

        if(!"".equals(txtAnioInicial.getText()) && !"".equals(txtAnioFinal.getText()) && !"".equals(txtMesInicial.getText()) && !"".equals(txtMesFinal.getText()) && !"".equals(txtDiaInicial.getText()) && !"".equals(txtDiaFinal.getText())){
            LibroMayorForm form = new LibroMayorForm(txtCodigoGenerar.getText(),txtAnioInicial.getText(),txtAnioFinal.getText(),txtMesInicial.getText(),txtMesFinal.getText(),txtDiaInicial.getText(), txtDiaFinal.getText());
            form.setVisible(true);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Complete los datos correctamente");
            txtAnioFinal.setText(null);
            txtAnioInicial.setText(null);
            txtMesFinal.setText(null);
            txtMesInicial.setText(null);
            txtDiaFinal.setText(null);
            txtDiaInicial.setText(null);
        }
        
    }//GEN-LAST:event_btnGenerarFiltradoActionPerformed

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
            java.util.logging.Logger.getLogger(LibroMayorGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroMayorGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroMayorGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroMayorGenerarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroMayorGenerarForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCodigo;
    private javax.swing.JButton btnBuscarNombre;
    private javax.swing.JButton btnCopiarCodigo;
    private javax.swing.JButton btnGenerarFiltrado;
    private javax.swing.JButton btnTodosAsientos;
    private javax.swing.JButton btnVerTodas;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtCuentas;
    private javax.swing.JTextField txtAnioFinal;
    private javax.swing.JTextField txtAnioInicial;
    private javax.swing.JTextField txtCodigoBuscarCuenta;
    private javax.swing.JTextField txtCodigoGenerar;
    private javax.swing.JTextField txtDiaFinal;
    private javax.swing.JTextField txtDiaInicial;
    private javax.swing.JTextField txtMesFinal;
    private javax.swing.JTextField txtMesInicial;
    private javax.swing.JTextField txtNombreBuscarCuenta;
    // End of variables declaration//GEN-END:variables
}

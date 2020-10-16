/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.view.system;

import app.a133.connection.MyConnection;
import app.a133.model.Asiento;
import app.a133.model.Asiento_Cuenta;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class AsientoForm extends javax.swing.JFrame implements ClipboardOwner{
    
    
    public AsientoForm() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ingreso de asientos");
        Image icon = new ImageIcon(getClass().getResource("/app/a133/view/img/logo3.png")).getImage();      //64px
        setIconImage(icon);
        txtFecha1.setText(fechaActualString());
        formatoTabla();
        
        String sql = "SELECT MAX(id_asiento) AS z FROM asiento;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                ultimoIdAsiento = rs.getLong("z");
                ultimoIdAsiento ++;
                txtNumero1.setText(String.valueOf(ultimoIdAsiento));           
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            }  finally{
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
    }

    private void formatoTabla(){            //Ajusta el ancho de las columnas
        int[] weights = {12,125,70};
            
        for(int i = 0; i < jtCuentas.getColumnCount(); i++){
            jtCuentas.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(0, 139, 139));
        headerRenderer.setForeground(Color.BLACK);

        
        for (int i = 0; i < jtCuentas.getModel().getColumnCount(); i++) {          //Recorro y se lo aplico a cada header
        jtCuentas.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    public static String fechaActualString(){
        java.util.Date date = new java.util.Date();
        DateFormat fechaActual = new SimpleDateFormat("yyyy-MM-dd");
	String convertido = fechaActual.format(date);
        return convertido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHaber1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDebe2 = new javax.swing.JTextField();
        txtCuenta1 = new javax.swing.JTextField();
        txtDebe1 = new javax.swing.JTextField();
        txtCuenta4 = new javax.swing.JTextField();
        txtDebe7 = new javax.swing.JTextField();
        txtCuenta5 = new javax.swing.JTextField();
        txtHaber5 = new javax.swing.JTextField();
        txtDebe5 = new javax.swing.JTextField();
        txtDebe4 = new javax.swing.JTextField();
        Haber = new javax.swing.JLabel();
        txtCuenta3 = new javax.swing.JTextField();
        txtHaber8 = new javax.swing.JTextField();
        txtHaber2 = new javax.swing.JTextField();
        txtDebe3 = new javax.swing.JTextField();
        txtDebe6 = new javax.swing.JTextField();
        txtHaber7 = new javax.swing.JTextField();
        txtHaber3 = new javax.swing.JTextField();
        txtCuenta7 = new javax.swing.JTextField();
        Haber1 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JTextField();
        txtDebe8 = new javax.swing.JTextField();
        txtFecha1 = new javax.swing.JTextField();
        txtLeyenda1 = new javax.swing.JTextField();
        txtHaber4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCuenta2 = new javax.swing.JTextField();
        txtCuenta8 = new javax.swing.JTextField();
        txtHaber6 = new javax.swing.JTextField();
        txtCuenta6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnIngresarAsientos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarCodigo = new javax.swing.JButton();
        btnBuscarNombre = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoBuscarCuenta = new javax.swing.JTextField();
        txtNombreBuscarCuenta = new javax.swing.JTextField();
        btnCopiarCodigoPortapapeles = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCuentas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnTodasCuentas = new javax.swing.JButton();
        btnRecibeSaldoSeleccionada = new javax.swing.JButton();

        jButton2.setText("Validar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cuenta");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtHaber1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber1KeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDebe2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe2KeyTyped(evt);
            }
        });

        txtCuenta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta1KeyTyped(evt);
            }
        });

        txtDebe1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDebe1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDebe1FocusLost(evt);
            }
        });
        txtDebe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDebe1ActionPerformed(evt);
            }
        });
        txtDebe1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe1KeyTyped(evt);
            }
        });

        txtCuenta4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta4KeyTyped(evt);
            }
        });

        txtDebe7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe7KeyTyped(evt);
            }
        });

        txtCuenta5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta5KeyTyped(evt);
            }
        });

        txtHaber5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber5KeyTyped(evt);
            }
        });

        txtDebe5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe5KeyTyped(evt);
            }
        });

        txtDebe4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe4KeyTyped(evt);
            }
        });

        Haber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Haber.setText("Haber");
        Haber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCuenta3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta3KeyTyped(evt);
            }
        });

        txtHaber8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber8KeyTyped(evt);
            }
        });

        txtHaber2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber2KeyTyped(evt);
            }
        });

        txtDebe3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe3KeyTyped(evt);
            }
        });

        txtDebe6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe6KeyTyped(evt);
            }
        });

        txtHaber7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber7KeyTyped(evt);
            }
        });

        txtHaber3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber3KeyTyped(evt);
            }
        });

        txtCuenta7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta7KeyTyped(evt);
            }
        });

        Haber1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Haber1.setText("Leyenda");
        Haber1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNumero1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero1.setFocusable(false);
        txtNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumero1ActionPerformed(evt);
            }
        });

        txtDebe8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDebe8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebe8KeyTyped(evt);
            }
        });

        txtFecha1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha1.setFocusable(false);

        txtHaber4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber4KeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Debe");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCuenta2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta2KeyTyped(evt);
            }
        });

        txtCuenta8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta8KeyTyped(evt);
            }
        });

        txtHaber6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHaber6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaber6KeyTyped(evt);
            }
        });

        txtCuenta6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuenta6KeyTyped(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Número");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(txtNumero1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCuenta2)
                    .addComponent(txtCuenta1)
                    .addComponent(txtCuenta4)
                    .addComponent(txtCuenta3)
                    .addComponent(txtCuenta6)
                    .addComponent(txtCuenta8)
                    .addComponent(txtCuenta7)
                    .addComponent(txtCuenta5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDebe7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDebe6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDebe5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDebe4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDebe3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDebe2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDebe1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDebe8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHaber1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Haber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(txtHaber2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHaber3)
                    .addComponent(txtHaber6)
                    .addComponent(txtHaber7)
                    .addComponent(txtHaber8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHaber5)
                    .addComponent(txtHaber4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLeyenda1)
                    .addComponent(Haber1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDebe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtDebe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtDebe5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtDebe6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtDebe7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtDebe8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(Haber1)
                            .addComponent(Haber)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHaber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDebe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCuenta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHaber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDebe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHaber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtHaber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtHaber5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtLeyenda1))
                                .addGap(3, 3, 3)
                                .addComponent(txtHaber6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtHaber7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtHaber8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCuenta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumero1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCuenta4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtCuenta5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFecha1))
                                .addGap(3, 3, 3)
                                .addComponent(txtCuenta6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtCuenta7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtCuenta8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnIngresarAsientos.setText("Insertar asiento");
        btnIngresarAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarAsientosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Source Serif Pro Black", 1, 18)); // NOI18N
        jLabel7.setText("Cuentas");

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

        btnCopiarCodigoPortapapeles.setText("Copiar codigo");

        jtCuentas.setForeground(new java.awt.Color(0, 0, 0));
        jtCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jtCuentas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCuentas.setRowHeight(22);
        jtCuentas.setSelectionBackground(new java.awt.Color(255, 255, 153));
        jtCuentas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtCuentas.setShowHorizontalLines(false);
        jtCuentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtCuentas);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/a133/view/img/logo3.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("A133 -beta");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnTodasCuentas.setText("Ver Todas");
        btnTodasCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasCuentasActionPerformed(evt);
            }
        });

        btnRecibeSaldoSeleccionada.setText("Recibe?");
        btnRecibeSaldoSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibeSaldoSeleccionadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIngresarAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCodigoBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnBuscarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                            .addComponent(btnRecibeSaldoSeleccionada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnCopiarCodigoPortapapeles)
                                            .addComponent(txtNombreBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTodasCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnIngresarAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTodasCuentas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarCodigo)
                            .addComponent(txtCodigoBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarNombre)
                            .addComponent(txtNombreBuscarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCopiarCodigoPortapapeles)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecibeSaldoSeleccionada)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private Long ultimoIdAsiento;
    
    List<Asiento_Cuenta> listaValidos = new ArrayList<Asiento_Cuenta>();
    
    private String[][] matriz = {/* Cod_cuenta , Debe , Haber */
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""},
                                {""            ,  ""  ,  ""}};

    private void txtDebe1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDebe1FocusGained
     
    }//GEN-LAST:event_txtDebe1FocusGained

    private void txtDebe1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDebe1FocusLost

    }//GEN-LAST:event_txtDebe1FocusLost

    private void txtNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero1ActionPerformed

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

    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        String sql="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtCuentas.setModel(model);
            
            sql="SELECT codigo,nombre,tipo_cuenta FROM cuenta WHERE codigo = ? ORDER BY codigo;";
            ps = con.prepareStatement(sql);
            ps.setString(1, txtCodigoBuscarCuenta.getText());
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

    private void txtDebe1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe1KeyTyped
        
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe1.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe1.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe1KeyTyped

    
    private boolean verificarPartidaDoble(Double debe, Double haber){
        return Objects.equals(debe, haber) && debe != 0.0;
    }
    
    private void restaurarMatriz(){
        matriz[0][0] = "";
        matriz[1][0] = "";
        matriz[2][0] = "";
        matriz[3][0] = "";
        matriz[4][0] = "";
        matriz[5][0] = "";
        matriz[6][0] = "";
        matriz[7][0] = "";

        matriz[0][1] = "";
        matriz[1][1] = "";
        matriz[2][1] = "";
        matriz[3][1] = "";
        matriz[4][1] = "";
        matriz[5][1] = "";
        matriz[6][1] = "";
        matriz[7][1] = "";

        matriz[0][2] = "";
        matriz[1][2] = "";
        matriz[2][2] = "";
        matriz[3][2] = "";
        matriz[4][2] = "";
        matriz[5][2] = "";
        matriz[6][2] = "";
        matriz[7][2] = "";
    }
    
    private void reiniciarForm(){

        txtFecha1.setText(fechaActualString());
        String sql = "SELECT MAX(id_asiento) AS z FROM asiento;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                ultimoIdAsiento = rs.getLong("z");
                ultimoIdAsiento ++;
                txtNumero1.setText(String.valueOf(ultimoIdAsiento));           
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
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

        listaValidos = new ArrayList<Asiento_Cuenta>();
        
        restaurarMatriz();
        vaciarTodosCampos();

        
    }
    
    
    private void vaciarTodosCampos(){
        txtCuenta1.setText("");
        txtCuenta2.setText("");
        txtCuenta3.setText("");
        txtCuenta4.setText("");
        txtCuenta5.setText("");
        txtCuenta6.setText("");
        txtCuenta7.setText("");
        txtCuenta8.setText("");
        
        txtDebe1.setText("");
        txtDebe2.setText("");
        txtDebe3.setText("");
        txtDebe4.setText("");
        txtDebe5.setText("");
        txtDebe6.setText("");
        txtDebe7.setText("");
        txtDebe8.setText("");
        
        txtHaber1.setText("");
        txtHaber2.setText("");
        txtHaber3.setText("");
        txtHaber4.setText("");
        txtHaber5.setText("");
        txtHaber6.setText("");
        txtHaber7.setText("");
        txtHaber8.setText("");
        
        txtLeyenda1.setText("");
    }
    
    private void asignarValoresMatriz(){
        
        matriz[0][0] = txtCuenta1.getText();
        matriz[1][0] = txtCuenta2.getText();
        matriz[2][0] = txtCuenta3.getText();
        matriz[3][0] = txtCuenta4.getText();
        matriz[4][0] = txtCuenta5.getText();
        matriz[5][0] = txtCuenta6.getText();
        matriz[6][0] = txtCuenta7.getText();
        matriz[7][0] = txtCuenta8.getText();

        matriz[0][1] = txtDebe1.getText();
        matriz[1][1] = txtDebe2.getText();
        matriz[2][1] = txtDebe3.getText();
        matriz[3][1] = txtDebe4.getText();
        matriz[4][1] = txtDebe5.getText();
        matriz[5][1] = txtDebe6.getText();
        matriz[6][1] = txtDebe7.getText();
        matriz[7][1] = txtDebe8.getText();

        matriz[0][2] = txtHaber1.getText();
        matriz[1][2] = txtHaber2.getText();
        matriz[2][2] = txtHaber3.getText();
        matriz[3][2] = txtHaber4.getText();
        matriz[4][2] = txtHaber5.getText();
        matriz[5][2] = txtHaber6.getText();
        matriz[6][2] = txtHaber7.getText();
        matriz[7][2] = txtHaber8.getText();
    }
    
    private Long obtenerIdCuentaDesdeCodigo(String codigoCuenta){
        
        Long idCuenta;
        String sql = "SELECT id_cuenta FROM cuenta WHERE codigo = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigoCuenta);
            rs = ps.executeQuery();
            if(rs.next()){
                idCuenta = rs.getLong("id_cuenta");
                return idCuenta;    
            } else {
                JOptionPane.showMessageDialog(null,"Uno de los codigos ingresados no existe");
                return null;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;     
        } finally{
            try{
                rs.close();
            } catch (Exception e ) {}
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch (Exception e ) {}
        }
        
    }
    
    private void movimientosValidosLista(){     
        
        
        int x1 = 0;
        if(!"".equals(matriz[0][0]))
            x1 += 4;
        if(!"".equals(matriz[0][1]))
            x1 += 2;
        if(!"".equals(matriz[0][2]))
            x1 += 1;
        
        int x2 = 0;
        if(!"".equals(matriz[1][0]))
            x2 += 4;
        if(!"".equals(matriz[1][1]))
            x2 += 2;
        if(!"".equals(matriz[1][2]))
            x2 += 1;
        
        int x3 = 0;
        if(!"".equals(matriz[2][0]))
            x3 += 4;
        if(!"".equals(matriz[2][1]))
            x3 += 2;
        if(!"".equals(matriz[2][2]))
            x3 += 1;
  
        int x4 = 0;
        if(!"".equals(matriz[3][0]))
            x4 += 4;
        if(!"".equals(matriz[3][1]))
            x4 += 2;
        if(!"".equals(matriz[3][2]))
            x4 += 1;
        
        int x5 = 0;
        if(!"".equals(matriz[4][0]))
            x5 += 4;
        if(!"".equals(matriz[4][1]))
            x5 += 2;
        if(!"".equals(matriz[4][2]))
            x5 += 1;
        
        int x6 = 0;
        if(!"".equals(matriz[5][0]))
            x6 += 4;
        if(!"".equals(matriz[5][1]))
            x6 += 2;
        if(!"".equals(matriz[5][2]))
            x6 += 1;
        
        int x7 = 0;
        if(!"".equals(matriz[6][0]))
            x7 += 4;
        if(!"".equals(matriz[6][1]))
            x7 += 2;
        if(!"".equals(matriz[6][2]))
            x7 += 1;
        
        int x8 = 0;
        if(!"".equals(matriz[7][0]))
            x8 += 4;
        if(!"".equals(matriz[7][1]))
            x8 += 2;
        if(!"".equals(matriz[7][2]))
            x8 += 1;
        
        switch(x1){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[0][0]), Double.parseDouble(matriz[0][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[0][0]));
                        ac.setDebe(Double.parseDouble(matriz[0][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    } else {
                        JOptionPane.showMessageDialog(null, "Un movimiento no es correcto");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[0][0]), 0.0 , Double.parseDouble(matriz[0][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[0][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[0][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> //Solo cuenta
                JOptionPane.showMessageDialog(null, "Movimiento 1. Debe ingresar debe o haber");
            case 3 -> //Solo Debe y Haber
                JOptionPane.showMessageDialog(null, "Movimiento 1. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> //Todos los campos llenos
                JOptionPane.showMessageDialog(null, "Movimiento 1. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> //Solo Haber
                JOptionPane.showMessageDialog(null, "Movimiento 1. Cuenta no indicada");
            case 2 -> //Solo Debe
                JOptionPane.showMessageDialog(null, "Movimiento 1. Cuenta no indicada");
        }
        
        switch(x2){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[1][0]), Double.parseDouble(matriz[1][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[1][0]));
                        ac.setDebe(Double.parseDouble(matriz[1][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[1][0]), 0.0 , Double.parseDouble(matriz[1][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[1][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[1][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 2. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 2. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 2. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 2. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 2. Cuenta no indicada");
        }
        
        switch(x3){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[2][0]), Double.parseDouble(matriz[2][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[2][0]));
                        ac.setDebe(Double.parseDouble(matriz[2][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[2][0]), 0.0 , Double.parseDouble(matriz[2][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[2][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[2][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 3. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 3. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 3. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 3. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 3. Cuenta no indicada");            
        }
        
        switch(x4){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[3][0]), Double.parseDouble(matriz[3][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[3][0]));
                        ac.setDebe(Double.parseDouble(matriz[3][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[3][0]), 0.0 , Double.parseDouble(matriz[3][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[3][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[3][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 4. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 4. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 4. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 4. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 4. Cuenta no indicada");
        }        
        
        switch(x5){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[4][0]), Double.parseDouble(matriz[4][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[4][0]));
                        ac.setDebe(Double.parseDouble(matriz[4][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[4][0]), 0.0 , Double.parseDouble(matriz[4][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[4][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[4][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 5. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 5. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 5. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 5. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 5. Cuenta no indicada");
        }
        switch(x6){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[5][0]), Double.parseDouble(matriz[5][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[5][0]));
                        ac.setDebe(Double.parseDouble(matriz[5][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[5][0]), 0.0 , Double.parseDouble(matriz[5][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[5][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[5][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 6. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 6. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 6. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 6. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 6. Cuenta no indicada");
        }        
        
        switch(x7){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[6][0]), Double.parseDouble(matriz[6][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[6][0]));
                        ac.setDebe(Double.parseDouble(matriz[6][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[6][0]), 0.0 , Double.parseDouble(matriz[6][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[6][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[6][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 7. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 7. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 7. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 7. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 7. Cuenta no indicada");
        }
        
        switch(x8){
            case 6 -> {
                Asiento_Cuenta ac = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[7][0]), Double.parseDouble(matriz[7][1]) , 0.0)){
                        ac.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[7][0]));
                        ac.setDebe(Double.parseDouble(matriz[7][1]));
                        ac.setHaber(0.0);
                        ac.setSaldo_parcial(setearNuevoSaldo(ac.getId_cuenta(),ac.getDebe(),ac.getHaber()));
                        listaValidos.add(ac);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 5 -> {
                Asiento_Cuenta ac2 = new Asiento_Cuenta();
                
                try {
                    if(chequearCuentaValida(obtenerIdCuentaDesdeCodigo(matriz[7][0]), 0.0 , Double.parseDouble(matriz[7][2]))){
                        ac2.setId_cuenta(obtenerIdCuentaDesdeCodigo(matriz[7][0]));
                        ac2.setDebe(0.0);
                        ac2.setHaber(Double.parseDouble(matriz[7][2]));
                        ac2.setSaldo_parcial(setearNuevoSaldo(ac2.getId_cuenta(),ac2.getDebe(),ac2.getHaber()));
                        listaValidos.add(ac2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
            }
            case 4 -> JOptionPane.showMessageDialog(null, "Movimiento 8. Debe ingresar debe o haber");
            case 3 -> JOptionPane.showMessageDialog(null, "Movimiento 8. No puede ingresar debe y haber para un mismo movimiento");
            case 7 -> JOptionPane.showMessageDialog(null, "Movimiento 8. No puede ingresar debe y haber para un mismo movimiento");
            case 1 -> JOptionPane.showMessageDialog(null, "Movimiento 8. Cuenta no indicada");
            case 2 -> JOptionPane.showMessageDialog(null, "Movimiento 8. Cuenta no indicada");
        }
        
 
    }
    
    private Double operarSaldo(Double saldoActual, Double debe, Double haber, String tipoCuenta){
        
        Double saldoOperado = null;
        
        switch(tipoCuenta){
            case "ACTIVO":
                saldoOperado = saldoActual + debe - haber;
                break;
            case "PASIVO":
                saldoOperado = saldoActual - debe + haber;
                break;
            case "PATRIMONIO":
                saldoOperado = saldoActual - debe + haber;
                break;
            case "RESULTADO_NEGATIVO":
                saldoOperado = saldoActual + debe;
                break;
            case "RESULTADO_POSITIVO":
                saldoOperado = saldoActual + haber;
                break;
        }
        return saldoOperado;
    }
    
    
    private Double setearNuevoSaldo(Long idCuenta, Double debe, Double haber){
        String sql = "SELECT saldo_actual,tipo_cuenta FROM cuenta WHERE id_cuenta = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        Double nuevoSaldo = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, idCuenta);
            rs = ps.executeQuery();
            if(rs.next()){
                if(chequearCuentaValida(idCuenta, debe, haber)){
                    nuevoSaldo = operarSaldo(rs.getDouble("saldo_actual"), debe, haber, rs.getString("tipo_cuenta"));
                } 
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;     
        } finally{
            try{
                rs.close();
            } catch (Exception e ) {}
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch (Exception e ) {}
            return nuevoSaldo;
        }
    }
    
    private boolean chequearCuentaValida(Long idCuenta, Double debe, Double haber){
        
        String sql = "SELECT * FROM cuenta WHERE id_cuenta = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        boolean valida = false;      
        try {

            ps = con.prepareStatement(sql);
            ps.setLong(1, idCuenta);
            
            rs = ps.executeQuery();
            

            
            if(rs.next()){
                if(rs.getBoolean("recibe_saldo")){
                    switch(rs.getString("tipo_cuenta")){
                        case "ACTIVO":
                            if((rs.getDouble("saldo_actual")-haber)>=0.0){
                                valida = true;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "La cuenta "+rs.getString("nombre")+ " no puede quedar en negativo");
                                break;
                            }
                        case "PASIVO":
                            if((rs.getDouble("saldo_actual")-debe)>=0.0){
                                valida = true;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "La cuenta "+rs.getString("nombre")+ " no puede quedar en negativo");
                                break;
                            }
                        case "PATRIMONIO":
                            if((rs.getDouble("saldo_actual")-debe)>=0.0){
                                valida = true;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "La cuenta "+rs.getString("nombre")+ " no puede quedar en negativo");
                                break;
                            }
                        case "RESULTADO_NEGATIVO":
                            if(debe > 0.0){
                                valida = true;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Los resultados negativos van por el debe padre...");
                                break;
                            }
                        case "RESULTADO_POSITIVO":
                            if(haber > 0.0){
                                valida = true;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Los resultados positivos van por el haber padre");
                                break;
                            }
                        }
                } else JOptionPane.showMessageDialog(null, "La cuenta "+rs.getString("nombre")+" no puede recibir saldo!");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Codigo de cuenta inexistente ingresado "+e.getMessage());
        } finally{
            try{
                rs.close();
            } catch (Exception e ) {}
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch (Exception e ) {}
            return valida;
            }
            
    }
    
    private void btnIngresarAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarAsientosActionPerformed
        
        asignarValoresMatriz();
        movimientosValidosLista();
        if(listaValidos.size()>0){      //Primero reviso que haya algun asiento valido a insertar
            
            Double debeAcumulado = 0d;
            Double haberAcumulado = 0d;

            for(Asiento_Cuenta x : listaValidos){
                debeAcumulado += x.getDebe();
                haberAcumulado += x.getHaber();
            }
        
            if(verificarPartidaDoble(debeAcumulado, haberAcumulado)){
                // Insertar asiento
                String sql = "";
                PreparedStatement ps = null;
                MyConnection mycon = new MyConnection();
                Connection con = mycon.getMyConnection();
                
                try {
                    con.setAutoCommit(false);
                    sql = "INSERT INTO asiento VALUES(?,?,?);";
                    Asiento asiento = new Asiento();
                    asiento.setId_asiento(ultimoIdAsiento);
                    asiento.setFecha(java.sql.Date.valueOf(fechaActualString()));
                    asiento.setLeyenda(txtLeyenda1.getText());

                    ps = con.prepareStatement(sql);
                    ps.setLong(1, asiento.getId_asiento() );
                    ps.setDate(2,asiento.getFecha());
                    ps.setString(3, txtLeyenda1.getText());
                    ps.executeUpdate();
                
                    
                    
                    sql = "INSERT INTO asiento_cuenta(id_cuenta,id_asiento,saldo_parcial,debe,haber) VALUES(?,?,?,?,?);";

                    ps = con.prepareStatement(sql);
                    for(Asiento_Cuenta ac:listaValidos){
                        ps.setLong(1, ac.getId_cuenta());
                        ps.setLong(2, ultimoIdAsiento);
                        ps.setDouble(3, ac.getSaldo_parcial());
                        ps.setDouble(4, ac.getDebe());
                        ps.setDouble(5, ac.getHaber());
                        ps.executeUpdate();
                    }
                    
                    sql = "UPDATE cuenta SET saldo_actual = ? WHERE id_cuenta = ?;";
                    ps = con.prepareStatement(sql);
                    for(Asiento_Cuenta ac:listaValidos){
                        ps.setDouble(1, ac.getSaldo_parcial());
                        ps.setLong(2, ac.getId_cuenta());
                        ps.executeUpdate();
                    }
                    
                    
                    con.commit();
                    JOptionPane.showMessageDialog(null, "Insercion exitosa");
                    reiniciarForm();

                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error al insertar asiento "+e.getMessage());
                } finally{
                    try{
                        ps.close();
                    } catch(Exception e){}
                    try{
                        con.close();
                    } catch (Exception e ) {}
                }

            } else{
                    int opcion = JOptionPane.showConfirmDialog(null,"Desea reiniciar el formulario?", "Error en los datos",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(opcion == JOptionPane.YES_OPTION){
                            reiniciarForm();
                    } else if (opcion == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(null, "Revise sus datos");
                        restaurarMatriz();
                        listaValidos = new ArrayList<Asiento_Cuenta>();
                    } else if (opcion == JOptionPane.CLOSED_OPTION){
                        JOptionPane.showMessageDialog(null, "Revise sus datos");
                        restaurarMatriz();  
                        listaValidos = new ArrayList<Asiento_Cuenta>();
                    }
                }
            
            //ANDAAAAA
            
            
        } else {
            int opcion = JOptionPane.showConfirmDialog(null,"Desea reiniciar los datos?", "Ningun movimiento es válido",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(opcion == JOptionPane.YES_OPTION){
                    restaurarMatriz();
                    vaciarTodosCampos();
                    listaValidos = new ArrayList<Asiento_Cuenta>();
                    movimientosValidosLista();
                } else if (opcion == JOptionPane.NO_OPTION){
                    restaurarMatriz();
                    listaValidos = new ArrayList<Asiento_Cuenta>();
                    movimientosValidosLista();
                } else if (opcion == JOptionPane.CANCEL_OPTION){
                    restaurarMatriz();
                    listaValidos = new ArrayList<Asiento_Cuenta>();
                    movimientosValidosLista();
                }
            
            
        }
        
       
        
    }//GEN-LAST:event_btnIngresarAsientosActionPerformed

    private void txtDebe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDebe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebe1ActionPerformed

    private void txtHaber1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber1KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber1.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe1.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber1KeyTyped

    private void txtDebe2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe2KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe2.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe1.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe2KeyTyped

    private void txtHaber2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber2KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber2.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtHaber2.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber2KeyTyped

    private void txtDebe3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe3KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe3.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe1.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe3KeyTyped

    private void txtHaber3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber3KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber3.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe1.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber3KeyTyped

    private void txtDebe4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe4KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe4.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe4.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe4KeyTyped

    private void txtHaber4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber4KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber4.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtHaber4.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber4KeyTyped

    private void txtDebe5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe5KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe5.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe5.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe5KeyTyped

    private void txtHaber5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber5KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber5.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtHaber5.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber5KeyTyped

    private void txtDebe6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe6KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe6.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe6.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe6KeyTyped

    private void txtHaber6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber6KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber6.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtHaber6.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber6KeyTyped

    private void txtDebe7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe7KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe7.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe7.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe7KeyTyped

    private void txtHaber7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber7KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber7.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtHaber7.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber7KeyTyped

    private void txtDebe8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebe8KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtDebe8.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtDebe8.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtDebe8KeyTyped

    private void txtHaber8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaber8KeyTyped
        int c = evt.getKeyChar();
        
        if(c == 46 && txtHaber8.getText().indexOf(".") > -1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cuantos puntos queres poner pa?");
            txtHaber8.setText("");
        }
        
        if(c != 127 && c != 8 && c != 46){
            if(c < 48 || c > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numero y puntos");
            }  
        }
    }//GEN-LAST:event_txtHaber8KeyTyped

    private void txtCuenta1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta1KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
                
            } 
        }
    }//GEN-LAST:event_txtCuenta1KeyTyped

    private void txtCuenta2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta2KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        }
    }//GEN-LAST:event_txtCuenta2KeyTyped

    private void txtCuenta3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta3KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        } 
    }//GEN-LAST:event_txtCuenta3KeyTyped

    private void txtCuenta4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta4KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        }
    }//GEN-LAST:event_txtCuenta4KeyTyped

    private void txtCuenta5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta5KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        }
    }//GEN-LAST:event_txtCuenta5KeyTyped

    private void txtCuenta6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta6KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        }
    }//GEN-LAST:event_txtCuenta6KeyTyped

    private void txtCuenta7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta7KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        }
    }//GEN-LAST:event_txtCuenta7KeyTyped

    private void txtCuenta8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuenta8KeyTyped
        if(evt.getKeyChar() != 127 && evt.getKeyChar() != 8){
            if(evt.getKeyChar() < 48 || evt.getKeyChar() > 57  ){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Solo numeros");
            }  
        }
    }//GEN-LAST:event_txtCuenta8KeyTyped

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        SystemMainForm form = new SystemMainForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnTodasCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasCuentasActionPerformed
        String sql="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtCuentas.setModel(model);
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
    }//GEN-LAST:event_btnTodasCuentasActionPerformed

    private void btnRecibeSaldoSeleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibeSaldoSeleccionadaActionPerformed
        String sql="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        
        try {
            int fila_seleccionada = jtCuentas.getSelectedRow();
            String codigoX = jtCuentas.getValueAt(fila_seleccionada, 0).toString();
            if(!"".equals(codigoX)){
                sql="SELECT recibe_saldo FROM cuenta WHERE codigo ="+codigoX+";";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next()){
                    if(rs.getBoolean("recibe_saldo")){
                        JOptionPane.showMessageDialog(null, "La cuenta seleccionada puede recibir saldo");
                    } else JOptionPane.showMessageDialog(null, "La cuenta seleccionada NO puede recibir saldo");
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta");
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
    }//GEN-LAST:event_btnRecibeSaldoSeleccionadaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Haber;
    private javax.swing.JLabel Haber1;
    private javax.swing.JButton btnBuscarCodigo;
    private javax.swing.JButton btnBuscarNombre;
    private javax.swing.JButton btnCopiarCodigoPortapapeles;
    private javax.swing.JButton btnIngresarAsientos;
    private javax.swing.JButton btnRecibeSaldoSeleccionada;
    private javax.swing.JButton btnTodasCuentas;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtCuentas;
    private javax.swing.JTextField txtCodigoBuscarCuenta;
    private javax.swing.JTextField txtCuenta1;
    private javax.swing.JTextField txtCuenta2;
    private javax.swing.JTextField txtCuenta3;
    private javax.swing.JTextField txtCuenta4;
    private javax.swing.JTextField txtCuenta5;
    private javax.swing.JTextField txtCuenta6;
    private javax.swing.JTextField txtCuenta7;
    private javax.swing.JTextField txtCuenta8;
    private javax.swing.JTextField txtDebe1;
    private javax.swing.JTextField txtDebe2;
    private javax.swing.JTextField txtDebe3;
    private javax.swing.JTextField txtDebe4;
    private javax.swing.JTextField txtDebe5;
    private javax.swing.JTextField txtDebe6;
    private javax.swing.JTextField txtDebe7;
    private javax.swing.JTextField txtDebe8;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtHaber1;
    private javax.swing.JTextField txtHaber2;
    private javax.swing.JTextField txtHaber3;
    private javax.swing.JTextField txtHaber4;
    private javax.swing.JTextField txtHaber5;
    private javax.swing.JTextField txtHaber6;
    private javax.swing.JTextField txtHaber7;
    private javax.swing.JTextField txtHaber8;
    private javax.swing.JTextField txtLeyenda1;
    private javax.swing.JTextField txtNombreBuscarCuenta;
    private javax.swing.JTextField txtNumero1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.view.libros;

import app.a133.connection.MyConnection;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victo
 */
public class LibroDiarioForm extends javax.swing.JFrame {

    /**
     * Creates new form LibroDiarioForm
     */
    public LibroDiarioForm() {
        initComponents();
        setLocationRelativeTo(null);
        formatoTabla();
    }
    public LibroDiarioForm(String anio, String mes, String dia){
        initComponents();
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        setLocationRelativeTo(null);
        lblFecha.setText(anio+"/"+mes+"/"+dia);
        formatoTabla();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        try {
            String sql = "SELECT razon_social,cuit,domicilio_fiscal FROM empresa WHERE id_empresa = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                lblNombre.setText(rs.getString("razon_social"));
                lblCuit.setText("CUIT: "+rs.getString("cuit").substring(0, 2)+"-"+rs.getString("cuit").substring(2, 10)+"-"+rs.getString("cuit").substring(10));
                lblDireccion.setText("Dirección: "+rs.getString("domicilio_fiscal"));
            }
        } catch (Exception e) {
        } finally{
            try{rs.close();} catch(Exception e){}
            try{ps.close();} catch(Exception e){}
            try{con.close();} catch(Exception e){}
        }
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        MyConnection mycon2 = new MyConnection();
        Connection con2 = mycon2.getMyConnection();
        try {
            String fechaString = anio+"-"+mes+"-"+dia;
            System.out.println(fechaString);
            String sql2 = "SELECT ac.id_asiento_cuenta,c.codigo,c.nombre,ac.debe,ac.haber,a.leyenda FROM cuenta c INNER JOIN asiento_cuenta ac USING(id_cuenta) INNER JOIN asiento a USING(id_asiento) WHERE a.fecha = '"+fechaString+"';";
            ps2 = con2.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            
            ResultSetMetaData rsMD = rs2.getMetaData();
            
            DefaultTableModel model = new DefaultTableModel();
            jtMovimientos.setModel(model);
            
            int numberColumns = rsMD.getColumnCount();
            
            model.addColumn("#");
            model.addColumn("Cuenta #");
            model.addColumn("Cuenta");
            model.addColumn("Debe");
            model.addColumn("Haber");
            model.addColumn("Leyenda");
            
            formatoTabla();
            
            while(rs2.next()){
                Object[] rows = new Object[numberColumns];
                for (int i = 0; i<numberColumns; i++) {
                    rows[i] = rs2.getObject(i+1);
                }
                model.addRow(rows);
            }
            
        } catch (Exception e) {
        } finally{
            try{rs2.close();} catch(Exception e){}
            try{ps2.close();} catch(Exception e){}
            try{con2.close();} catch(Exception e){}
        }
        
    }

    private String anio;
    private String mes;
    private String dia;
    
    
    private void formatoTabla(){
                
        int[] weights = {10,30,120,50,50,240};
            
        for(int i = 0; i < jtMovimientos.getColumnCount(); i++){
            jtMovimientos.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(240, 240, 240));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(new Font("Segoe UI",Font.BOLD,14));
        headerRenderer.setOpaque(true);
        headerRenderer.setForeground(Color.BLACK);
        
        jtMovimientos.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        
        DefaultTableCellRenderer centrarHeader = new DefaultTableCellRenderer();
        centrarHeader.setBackground(new Color(240, 240, 240));
        centrarHeader.setForeground(Color.BLACK);
        centrarHeader.setFont(new Font("Segoe UI",Font.BOLD,14));
        centrarHeader.setOpaque(true);
        centrarHeader.setForeground(Color.BLACK);
        centrarHeader.setHorizontalAlignment(SwingConstants.CENTER);
        jtMovimientos.getColumnModel().getColumn(1).setHeaderRenderer(centrarHeader);
        jtMovimientos.getColumnModel().getColumn(2).setHeaderRenderer(centrarHeader);
        jtMovimientos.getColumnModel().getColumn(3).setHeaderRenderer(centrarHeader);
        jtMovimientos.getColumnModel().getColumn(4).setHeaderRenderer(centrarHeader);
        jtMovimientos.getColumnModel().getColumn(5).setHeaderRenderer(centrarHeader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblCuit = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMovimientos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("EMPRESA");

        lblCuit.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblCuit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuit.setText("CUIT");

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("Direccion");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LIBRO DIARIO");

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("FECHA");

        jtMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Cuenta #", "Cuenta", "Debe", "Haber", "Leyenda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMovimientos.setRowHeight(20);
        jtMovimientos.setSelectionBackground(new java.awt.Color(102, 255, 102));
        jtMovimientos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jtMovimientos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LibroDiarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroDiarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroDiarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroDiarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroDiarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMovimientos;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.view.libros;

import app.a133.connection.MyConnection;
import app.a133.model.LibroDiarioFila;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;

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
        setTitle("Libro Diario");
        setLocationRelativeTo(null);
        lblFecha.setText(anio+"/"+mes+"/"+dia);
        formatoTabla();
        lblPeriodo.setText(anio);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        try {
            String sql = "SELECT razon_social,cuit,domicilio_fiscal,telefono,mail FROM empresa WHERE id_empresa = 1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                lblNombre.setText(rs.getString("razon_social"));
                lblCuit.setText("CUIT: "+rs.getString("cuit").substring(0, 2)+"-"+rs.getString("cuit").substring(2, 10)+"-"+rs.getString("cuit").substring(10));
                lblDireccion.setText("Dirección: "+rs.getString("domicilio_fiscal"));
                lblTelefono.setText("Telefono: "+rs.getString("telefono"));
                lblMail.setText("Mail: "+rs.getString("mail"));
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
            String sql2 = "SELECT ac.id_asiento_cuenta AS ID_AC,c.codigo AS CODIGO_CUENTA,c.nombre AS NOMBRE_CUENTA,ac.debe AS DEBE,ac.haber AS HABER,a.leyenda AS LEYENDA FROM cuenta c INNER JOIN asiento_cuenta ac USING(id_cuenta) INNER JOIN asiento a USING(id_asiento) WHERE a.fecha = '"+fechaString+"';";
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
                
                LibroDiarioFila l = new LibroDiarioFila();
                l.setId_asiento_cuenta(rs2.getLong("ID_AC"));
                l.setCodigo_cuenta(rs2.getString("CODIGO_CUENTA"));
                if(rs2.getDouble("DEBE") == 0.0){
                    l.setNombre_cuenta("    "+rs2.getString("NOMBRE_CUENTA"));}
                else l.setNombre_cuenta(rs2.getString("NOMBRE_CUENTA"));
                l.setDebe(rs2.getDouble("DEBE"));
                l.setHaber(rs2.getDouble("HABER"));
                l.setLeyenda(rs2.getString("LEYENDA"));
                filas.add(l);
                
                for (int i = 0; i<numberColumns; i++) {
                    if(i==2){
                        if(rs2.getDouble("DEBE")==0.0){
                            rows[i] = "    "+rs2.getObject(i+1);
                        } else {
                           rows[i] = rs2.getObject(i+1); 
                        }
                    }else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    if(i==3){
                       if(rs2.getDouble("DEBE")==0.0){
                           rows[i] = "";
                       } 
                    }
                    if(i==4){
                       if(rs2.getDouble("HABER")==0.0){
                           rows[i] = "";
                       } 
                    }
                    
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
    private List<LibroDiarioFila> filas = new ArrayList<LibroDiarioFila>();
    
    
    private void formatoTabla(){
                
        int[] weights = {5,30,120,50,50,245};
            
        for(int i = 0; i < jtMovimientos.getColumnCount(); i++){
            jtMovimientos.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        
        DefaultTableCellRenderer idHD = new DefaultTableCellRenderer();
        idHD.setBackground(new Color(200,200,200));
        idHD.setForeground(Color.BLACK);
        idHD.setFont(new Font("Segoe UI",Font.BOLD,14));
        idHD.setOpaque(true);
        idHD.setForeground(Color.BLACK);
        
        jtMovimientos.getColumnModel().getColumn(0).setHeaderRenderer(idHD);
        
        DefaultTableCellRenderer cuentaHR = new DefaultTableCellRenderer();
        cuentaHR.setBackground(new Color(200,200,200));
        cuentaHR.setForeground(Color.BLACK);
        cuentaHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        cuentaHR.setOpaque(true);
        cuentaHR.setForeground(Color.BLACK);
        cuentaHR.setHorizontalAlignment(SwingConstants.LEFT);
 
        DefaultTableCellRenderer cuentaCR = new DefaultTableCellRenderer();
        cuentaCR.setHorizontalAlignment(SwingConstants.LEFT);
        
        jtMovimientos.getColumnModel().getColumn(1).setHeaderRenderer(cuentaHR);
        jtMovimientos.getColumnModel().getColumn(1).setCellRenderer(cuentaCR);
        jtMovimientos.getColumnModel().getColumn(2).setHeaderRenderer(cuentaHR);
        jtMovimientos.getColumnModel().getColumn(2).setCellRenderer(cuentaCR);
        
        DefaultTableCellRenderer montosHD = new DefaultTableCellRenderer();
        montosHD.setBackground(new Color(200,200,200));
        montosHD.setForeground(Color.BLACK);
        montosHD.setFont(new Font("Segoe UI",Font.BOLD,14));
        montosHD.setOpaque(true);
        montosHD.setForeground(Color.BLACK);
        montosHD.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer montosCR = new DefaultTableCellRenderer();
        
        montosCR.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jtMovimientos.getColumnModel().getColumn(3).setHeaderRenderer(montosHD);
        jtMovimientos.getColumnModel().getColumn(3).setCellRenderer(montosCR);
        jtMovimientos.getColumnModel().getColumn(4).setHeaderRenderer(montosHD);
        jtMovimientos.getColumnModel().getColumn(4).setCellRenderer(montosCR);
        
        DefaultTableCellRenderer leyendaHR = new DefaultTableCellRenderer();
        leyendaHR.setBackground(new Color(200,200,200));
        leyendaHR.setForeground(Color.BLACK);
        leyendaHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        leyendaHR.setOpaque(true);
        leyendaHR.setForeground(Color.BLACK);
        leyendaHR.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer leyendaCR = new DefaultTableCellRenderer();
        leyendaCR.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        jtMovimientos.getColumnModel().getColumn(5).setHeaderRenderer(leyendaHR);
        jtMovimientos.getColumnModel().getColumn(5).setCellRenderer(leyendaCR);
        

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
        jLabel1 = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnGenerarPDF = new javax.swing.JButton();
        lblTelefono = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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
        jtMovimientos.setFocusable(false);
        jtMovimientos.setRowHeight(20);
        jtMovimientos.setRowSelectionAllowed(false);
        jtMovimientos.setSelectionBackground(new java.awt.Color(102, 255, 102));
        jtMovimientos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtMovimientos.setShowGrid(true);
        jScrollPane1.setViewportView(jtMovimientos);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Periodo:");

        lblPeriodo.setText("año");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnGenerarPDF.setText("Generar PDF");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        lblTelefono.setText("Telefono");

        lblMail.setText("Mail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(29, 29, 29)
                .addComponent(lblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMail)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPeriodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGenerarPDF))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(jtMovimientos.getModel().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Ningun asiento encontrado para la fecha indicada");
                LibroDiarioGenerarForm form = new LibroDiarioGenerarForm();
                form.setVisible(true);
                this.dispose();
            }
    }//GEN-LAST:event_formWindowGainedFocus

    
    
    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        try {
            
            String fecha = dia+"-"+mes+"-"+anio;
            
            FileOutputStream archivo;
            File file = new File("C:\\Users\\victo\\Desktop\\Reportes\\Libros Diarios\\reporte"+fecha+".pdf");
            archivo = new FileOutputStream(file);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            
            doc.open();
            
            Paragraph nombre = new Paragraph(10);
            com.itextpdf.text.Font negrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,18,com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
            nombre.add(Chunk.NEWLINE);
            nombre.add(Chunk.NEWLINE);
            nombre.setFont(negrita);
            nombre.add(lblNombre.getText());
            nombre.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            
            doc.add(nombre);
            
            Paragraph cuit = new Paragraph(10);
            com.itextpdf.text.Font negrita2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,12,com.itextpdf.text.Font.BOLD, BaseColor.BLACK);
            cuit.setFont(negrita2);
            cuit.add(Chunk.NEWLINE);
            cuit.add(lblCuit.getText());
            cuit.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            
            doc.add(cuit);
            
            com.itextpdf.text.Font minus = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,8,com.itextpdf.text.Font.ITALIC, BaseColor.BLACK);
            
            Paragraph telefono = new Paragraph(8);
            telefono.setFont(minus);
            telefono.add(lblTelefono.getText());
            telefono.add(Chunk.NEWLINE);
            telefono.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            doc.add(telefono);
            
            Paragraph mail = new Paragraph(8);
            mail.setFont(minus);
            mail.add(lblMail.getText());
            mail.add(Chunk.NEWLINE);
            mail.add(Chunk.NEWLINE);
            mail.add(Chunk.NEWLINE);
            mail.add(Chunk.NEWLINE);
            mail.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            doc.add(mail);
            
            Paragraph titulo = new Paragraph(10);
            com.itextpdf.text.Font courier = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER,16,com.itextpdf.text.Font.BOLDITALIC, BaseColor.BLACK);
            titulo.setFont(courier);
            titulo.add("LIBRO DIARIO - "+fecha);
            titulo.add(Chunk.NEWLINE);
            titulo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(titulo);
            
            Paragraph periodo = new Paragraph(10);
            periodo.setFont(minus);
            periodo.add("Periodo: "+lblPeriodo.getText());
            periodo.add(Chunk.NEWLINE);
            periodo.add(Chunk.NEWLINE);
            periodo.add(Chunk.NEWLINE);
            periodo.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            doc.add(periodo);
            
            float[] weights = {1,3,8,3,3,12};
            
            PdfPTable tabla = new PdfPTable(weights);
            tabla.setWidthPercentage(100);
            PdfPCell c1 = new PdfPCell(new Phrase("#",negrita2));
            PdfPCell c2 = new PdfPCell(new Phrase("Cuenta#",negrita2));
            PdfPCell c3 = new PdfPCell(new Phrase("Cuenta",negrita2));
            PdfPCell c4 = new PdfPCell(new Phrase("Debe",negrita2));
            PdfPCell c5 = new PdfPCell(new Phrase("Haber",negrita2));
            PdfPCell c6 = new PdfPCell(new Phrase("Leyenda",negrita2));
            
            c1.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            c2.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c3.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c4.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c5.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            c6.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c6.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);
            tabla.addCell(c5);
            tabla.addCell(c6);
            
            
            for(LibroDiarioFila f: filas){
                PdfPCell ID_AC = new PdfPCell(new Phrase(""+f.getId_asiento_cuenta(),minus));
                ID_AC.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                tabla.addCell(ID_AC);
                
                PdfPCell CUENTA_CODIGO = new PdfPCell(new Phrase(f.getCodigo_cuenta(),minus));
                CUENTA_CODIGO.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                tabla.addCell(CUENTA_CODIGO);
                
                PdfPCell CUENTA_NOMBRE = new PdfPCell(new Phrase(f.getNombre_cuenta(),minus));
                CUENTA_NOMBRE.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                tabla.addCell(CUENTA_NOMBRE);
                
                PdfPCell DEBE;
                if(f.getDebe()==0.0){
                    DEBE = new PdfPCell(new Phrase(""));
                } else  DEBE = new PdfPCell(new Phrase(""+f.getDebe(),minus));
                
                DEBE.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                tabla.addCell(DEBE);
                
                PdfPCell HABER;
                if(f.getHaber()==0.0){
                    HABER = new PdfPCell(new Phrase(""));
                } else HABER = new PdfPCell(new Phrase(""+f.getHaber(),minus));
                HABER.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                tabla.addCell(HABER);
                
                PdfPCell LEYENDA = new PdfPCell(new Phrase(f.getLeyenda(),minus));
                LEYENDA.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                tabla.addCell(LEYENDA);
                
            }
            
            doc.add(tabla);
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        LibroDiarioGenerarForm form = new LibroDiarioGenerarForm();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMovimientos;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}

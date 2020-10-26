/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.a133.view.libros;
import app.a133.connection.MyConnection;
import app.a133.model.LibroMayorFila;
import app.a133.view.system.SystemMainForm;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class LibroMayorForm extends javax.swing.JFrame {

    /**
     * Creates new form LibroDiarioForm
     */
    
    public LibroMayorForm(){
        initComponents();
    }
    
    public LibroMayorForm(String codigoCuenta){
        initComponents();
        
        setTitle("Libro Mayor");
        setLocationRelativeTo(null);
        this.codigoCuenta = codigoCuenta;
        
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
            
            String sql2 = "SELECT a.id_asiento AS ID_ASIENTO, a.fecha AS FECHA, ac.debe AS DEBE, ac.haber AS HABER, ac.saldo_parcial AS SALDO_PARCIAL, a.leyenda AS LEYENDA FROM cuenta c INNER JOIN asiento_cuenta ac USING(id_cuenta) INNER JOIN asiento a USING(id_asiento) WHERE c.codigo = '"+codigoCuenta+"';";
            ps2 = con2.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            
            ResultSetMetaData rsMD = rs2.getMetaData();
            
            DefaultTableModel model = new DefaultTableModel();
            jtMovimientos.setModel(model);
            
            int numberColumns = rsMD.getColumnCount();
            
            model.addColumn("Asiento #");
            model.addColumn("Fecha");
            model.addColumn("Debe");
            model.addColumn("Haber");
            model.addColumn("Saldo");
            model.addColumn("Leyenda");
            
            formatoTabla();
            
            while(rs2.next()){
                Object[] rows = new Object[numberColumns];
                
                LibroMayorFila l = new LibroMayorFila();
                l.setIdAsientoRelacionado(rs2.getLong("ID_ASIENTO"));
                l.setFecha(rs2.getString("FECHA"));
                l.setDebe(rs2.getDouble("DEBE"));
                l.setHaber(rs2.getDouble("HABER"));
                l.setSaldoParcial(rs2.getDouble("SALDO_PARCIAL"));
                l.setLeyenda(rs2.getString("LEYENDA"));
                filas.add(l);
                anioParaPeriodo = rs2.getString("FECHA").substring(0,4);
                
                for (int i = 0; i<numberColumns; i++) { 
                    
                    if(i==2){
                       if(rs2.getDouble("DEBE")==0.0){
                           rows[i] = "";
                       } else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    } 
                    else if (i==3){
                       if(rs2.getDouble("HABER")==0.0){
                           rows[i] = "";
                       } else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    }
                    else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    
                }
                model.addRow(rows);
                lblPeriodo.setText(anioParaPeriodo);
            }                    
        } catch (Exception e) {
        } finally{
            try{rs2.close();} catch(Exception e){}
            try{ps2.close();} catch(Exception e){}
            try{con2.close();} catch(Exception e){}
            
        }
        setearNombreCuenta(codigoCuenta);
    }

    private void setearNombreCuenta(String codigo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnection mycon = new MyConnection();
        Connection con = mycon.getMyConnection();
        try {
            String sql = "SELECT nombre FROM cuenta WHERE codigo = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if(rs.next()){
                nombreCuenta = rs.getString("nombre");
                lblCuenta.setText(nombreCuenta);
            } 
        } catch (Exception e) {
        }
    }
    
    public LibroMayorForm(String codigoCuenta,String anioDesde, String anioHasta, String mesDesde, String mesHasta, String diaDesde, String diaHasta){
        initComponents();
        
        setTitle("Libro Mayor");
        setLocationRelativeTo(null);
        this.codigoCuenta = codigoCuenta;
        this.anioDesde = anioDesde;
        this.anioHasta = anioHasta;
        this.mesDesde = mesDesde;
        this.mesHasta = mesHasta;
        this.diaDesde = diaDesde;
        this.diaHasta = diaHasta;
        
        fechaDesde = this.anioDesde+"-"+this.mesDesde+"-"+this.diaDesde;
        fechaHasta = this.anioHasta+"-"+this.mesHasta+"-"+this.diaHasta;
        
        
        
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
            
            String sql2 = "SELECT a.id_asiento AS ID_ASIENTO, a.fecha AS FECHA, ac.debe AS DEBE, ac.haber AS HABER, ac.saldo_parcial AS SALDO_PARCIAL, a.leyenda AS LEYENDA FROM cuenta c INNER JOIN asiento_cuenta ac USING(id_cuenta) INNER JOIN asiento a USING(id_asiento) WHERE c.codigo = '"+codigoCuenta+"' AND a.fecha BETWEEN '"+fechaDesde+"' AND '"+fechaHasta+"';";
            ps2 = con2.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            
            ResultSetMetaData rsMD = rs2.getMetaData();
            
            DefaultTableModel model = new DefaultTableModel();
            jtMovimientos.setModel(model);
            
            int numberColumns = rsMD.getColumnCount();
            
            model.addColumn("Asiento #");
            model.addColumn("Fecha");
            model.addColumn("Debe");
            model.addColumn("Haber");
            model.addColumn("Saldo");
            model.addColumn("Leyenda");
            
            formatoTabla();
            
            while(rs2.next()){
                Object[] rows = new Object[numberColumns];
                
                LibroMayorFila l = new LibroMayorFila();
                l.setIdAsientoRelacionado(rs2.getLong("ID_ASIENTO"));
                l.setFecha(rs2.getString("FECHA"));
                l.setDebe(rs2.getDouble("DEBE"));
                l.setHaber(rs2.getDouble("HABER"));
                l.setSaldoParcial(rs2.getDouble("SALDO_PARCIAL"));
                l.setLeyenda(rs2.getString("LEYENDA"));
                filas.add(l);
                anioParaPeriodo = rs2.getString("FECHA").substring(0,4);
                
                
                
                for (int i = 0; i<numberColumns; i++) { 
                    
                    if(i==2){
                       if(rs2.getDouble("DEBE")==0.0){
                           rows[i] = "";
                       } else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    } 
                    else if (i==3){
                       if(rs2.getDouble("HABER")==0.0){
                           rows[i] = "";
                       } else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    }
                    else{
                        rows[i] = rs2.getObject(i+1);
                    }
                    
                }
                model.addRow(rows);
                
            }
            
            lblPeriodo.setText(anioParaPeriodo);
        } catch (Exception e) {
        } finally{
            try{rs2.close();} catch(Exception e){}
            try{ps2.close();} catch(Exception e){}
            try{con2.close();} catch(Exception e){}
            
        }
        setearNombreCuenta(codigoCuenta);
        
    }
    
    private String codigoCuenta;
    private List<LibroMayorFila> filas = new ArrayList<LibroMayorFila>();
    
    private String anioDesde;
    private String mesDesde;
    private String diaDesde;
    
    private String fechaDesde;
    
    private String anioHasta;
    private String mesHasta;
    private String diaHasta;
    
    private String fechaHasta;
    
    private String anioParaPeriodo;
    
    private String nombreCuenta;
    
    
    private void formatoTabla(){
                
        int[] weights = {5,10,50,50,50,245};
            
        for(int i = 0; i < jtMovimientos.getColumnCount(); i++){
            jtMovimientos.getColumnModel().getColumn(i).setPreferredWidth(weights[i]);
        }
        
        DefaultTableCellRenderer asientoHR = new DefaultTableCellRenderer();
        asientoHR.setBackground(new Color(200,200,200));
        asientoHR.setForeground(Color.BLACK);
        asientoHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        asientoHR.setOpaque(true);
        asientoHR.setForeground(Color.BLACK);
        
        jtMovimientos.getColumnModel().getColumn(0).setHeaderRenderer(asientoHR);
        
        
        DefaultTableCellRenderer fechaHR = new DefaultTableCellRenderer();
        fechaHR.setBackground(new Color(200,200,200));
        fechaHR.setForeground(Color.BLACK);
        fechaHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        fechaHR.setOpaque(true);
        fechaHR.setForeground(Color.BLACK);
        fechaHR.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer fechaCR = new DefaultTableCellRenderer();
        fechaCR.setHorizontalAlignment(SwingConstants.CENTER);
        jtMovimientos.getColumnModel().getColumn(1).setCellRenderer(fechaCR);
        jtMovimientos.getColumnModel().getColumn(1).setHeaderRenderer(fechaHR);
        
 
        DefaultTableCellRenderer debeHR = new DefaultTableCellRenderer();
        debeHR.setBackground(new Color(200,200,200));
        debeHR.setForeground(Color.BLACK);
        debeHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        debeHR.setOpaque(true);
        debeHR.setForeground(Color.BLACK);
        debeHR.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer debeCR = new DefaultTableCellRenderer();
        debeCR.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jtMovimientos.getColumnModel().getColumn(2).setCellRenderer(debeCR);
        jtMovimientos.getColumnModel().getColumn(2).setHeaderRenderer(debeHR);
        
        DefaultTableCellRenderer haberHR = new DefaultTableCellRenderer();
        haberHR.setBackground(new Color(200,200,200));
        haberHR.setForeground(Color.BLACK);
        haberHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        haberHR.setOpaque(true);
        haberHR.setForeground(Color.BLACK);
        haberHR.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer haberCR = new DefaultTableCellRenderer();
        haberCR.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jtMovimientos.getColumnModel().getColumn(3).setCellRenderer(haberCR);
        jtMovimientos.getColumnModel().getColumn(3).setHeaderRenderer(haberHR);
        
        DefaultTableCellRenderer saldoParcialHR = new DefaultTableCellRenderer();
        saldoParcialHR.setBackground(new Color(200,200,200));
        saldoParcialHR.setForeground(Color.BLACK);
        saldoParcialHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        saldoParcialHR.setOpaque(true);
        saldoParcialHR.setForeground(Color.BLACK);
        saldoParcialHR.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer saldoParcialCR = new DefaultTableCellRenderer();
        saldoParcialCR.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jtMovimientos.getColumnModel().getColumn(4).setCellRenderer(saldoParcialCR);
        jtMovimientos.getColumnModel().getColumn(4).setHeaderRenderer(saldoParcialHR);
        
        DefaultTableCellRenderer leyendaHR = new DefaultTableCellRenderer();
        leyendaHR.setBackground(new Color(200,200,200));
        leyendaHR.setForeground(Color.BLACK);
        leyendaHR.setFont(new Font("Segoe UI",Font.BOLD,14));
        leyendaHR.setOpaque(true);
        leyendaHR.setForeground(Color.BLACK);
        leyendaHR.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer leyendaCR = new DefaultTableCellRenderer();
        leyendaCR.setHorizontalAlignment(SwingConstants.CENTER);
        
        jtMovimientos.getColumnModel().getColumn(5).setCellRenderer(leyendaCR);
        jtMovimientos.getColumnModel().getColumn(5).setHeaderRenderer(leyendaHR);
        
       
        

    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCuenta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMovimientos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCuit = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGenerarPDF = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

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

        lblCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuenta.setText("CUENTA");

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
                "Asiento #", "Fecha", "Debe", "Haber", "Saldo Parcial", "Movimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
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

        jLabel1.setText("Periodo:");

        lblPeriodo.setText("año");

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
        jLabel4.setText("LIBRO MAYOR");

        btnGenerarPDF.setText("Generar PDF");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lblCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGenerarPDF))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNombre)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblCuit)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblDireccion)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblPeriodo))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String fechaActualString(){
        java.util.Date date = new java.util.Date();
        DateFormat fechaActual = new SimpleDateFormat("yyyy-MM-dd");
	String convertido = fechaActual.format(date);
        return convertido;
    }
    
    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        try {

            File file;

            FileOutputStream archivo;
            if(fechaDesde == null){
                file = new File("C:\\Users\\victo\\Desktop\\Reportes\\Libros Mayores\\reporteCuenta"+lblCuenta.getText()+")_"+fechaActualString()+".pdf");
            } else {
                file = new File("C:\\Users\\victo\\Desktop\\Reportes\\Libros Mayores\\reporteCuenta("+lblCuenta.getText()+")_"+fechaDesde+"_"+fechaHasta+".pdf");
            }
 
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
            cuit.add(lblCuit.getText());
            cuit.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

            doc.add(cuit);

            Paragraph periodo = new Paragraph(10);
            com.itextpdf.text.Font minus = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,8,com.itextpdf.text.Font.ITALIC, BaseColor.BLACK);
            periodo.setFont(minus);
            periodo.add("Periodo: "+lblPeriodo.getText());
            periodo.add(Chunk.NEWLINE);
            periodo.add(Chunk.NEWLINE);
            periodo.add(Chunk.NEWLINE);
            periodo.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            doc.add(periodo);

            Paragraph titulo = new Paragraph(10);
            com.itextpdf.text.Font courier = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER,16,com.itextpdf.text.Font.BOLDITALIC, BaseColor.BLACK);
            titulo.setFont(courier);
            titulo.add("LIBRO MAYOR - "+lblCuenta.getText());
            titulo.add(Chunk.NEWLINE);
            titulo.add(Chunk.NEWLINE);
            titulo.add(Chunk.NEWLINE);
            titulo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(titulo);

            float[] weights = {2,3,4,4,6,15};

            PdfPTable tabla = new PdfPTable(weights);
            tabla.setWidthPercentage(100);
            PdfPCell c1 = new PdfPCell(new Phrase("#",negrita2));
            PdfPCell c2 = new PdfPCell(new Phrase("Fecha",negrita2));
            PdfPCell c3 = new PdfPCell(new Phrase("Debe",negrita2));
            PdfPCell c4 = new PdfPCell(new Phrase("Haber",negrita2));
            PdfPCell c5 = new PdfPCell(new Phrase("Saldo Parcial",negrita2));
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

            for(LibroMayorFila f: filas){
                PdfPCell ID_ASIENTO = new PdfPCell(new Phrase(""+f.getIdAsientoRelacionado(),minus));
                ID_ASIENTO.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                tabla.addCell(ID_ASIENTO);

                PdfPCell FECHA = new PdfPCell(new Phrase(f.getFecha(),minus));
                FECHA.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                tabla.addCell(FECHA);

                PdfPCell DEBE;
                if(f.getDebe()==0.0){
                    DEBE = new PdfPCell(new Phrase(""));
                } else DEBE = new PdfPCell(new Phrase(""+f.getDebe(),minus));

                DEBE.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                tabla.addCell(DEBE);

                PdfPCell HABER;
                if(f.getHaber()==0.0){
                    HABER = new PdfPCell(new Phrase(""));
                } else HABER = new PdfPCell(new Phrase(""+f.getHaber(),minus));
                HABER.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                tabla.addCell(HABER);
                
                PdfPCell SALDO = new PdfPCell(new Phrase(""+f.getSaldoParcial(),minus));
                SALDO.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                tabla.addCell(SALDO);

                PdfPCell LEYENDA = new PdfPCell(new Phrase(f.getLeyenda(),minus));
                LEYENDA.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                tabla.addCell(LEYENDA);

            }

            doc.add(tabla);

            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(jtMovimientos.getModel().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Ningun asiento encontrado para la fecha indicada");
                LibroDiarioGenerarForm form = new LibroDiarioGenerarForm();
                form.setVisible(true);
                this.dispose();
            }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        SystemMainForm form = new SystemMainForm();
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
            java.util.logging.Logger.getLogger(LibroMayorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroMayorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroMayorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroMayorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroMayorForm().setVisible(true);
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
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblCuit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeriodo;
    // End of variables declaration//GEN-END:variables
}

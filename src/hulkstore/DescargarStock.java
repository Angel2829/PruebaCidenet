/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hulkstore;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel Rodriguez
 */
public class DescargarStock extends javax.swing.JFrame {

    /**
     * Creates new form VerPorductos
     */
    DefaultTableModel DatosNum;
    String [] DatosN = new String[4];
    Conexion  conex = new Conexion();
    Connection cone2;
    public DescargarStock() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
    }
    
     void limpiar (){
    Cod1.setText("");
    nombre1.setText("");
    Descripcion1.setText("");
    Stock1.setText("");
    Cantidad.setText("");
    }
     void Tabla(){
        DatosNum = new DefaultTableModel()
                
        {
            public boolean isCellEditable(int rowIndex, int columIndex)
            {
                return false;
            }
        };
        
        Tabla.setModel(DatosNum);
        DatosNum.addColumn("COD_PRODUCTO");
        DatosNum.addColumn("PRODUCTO");
        DatosNum.addColumn("DESCRIPCION");
        DatosNum.addColumn("STOCK");
        cone2=conex.CargarBD();
        if (cone2!=null){
        try
        {
            
            Statement orden =cone2.createStatement();
            String Consultar = "Select * from  Productos order by PRODUCTOID";
            ResultSet cone=orden.executeQuery(Consultar);
            
            while (cone.next())
            {
                DatosN[0] = cone.getString("PRODUCTOID");
                DatosN[1] = cone.getString("NOMBREPRODUCTO");
                DatosN[2] = cone.getString("DESCRIPCION");
                DatosN[3] = cone.getString("STOCK");
                DatosNum.addRow(DatosN);
               
            }
          
        }
        catch (Exception err)
        {
            err.printStackTrace();
        }
    }
     }
void actualizar(){
        if (Cod1.getText().isEmpty()||nombre1.getText().isEmpty()||Descripcion1.getText().isEmpty()||Stock1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Un Producto","Alerta",JOptionPane.WARNING_MESSAGE);
           
        } else {
            
            if (Cantidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "La cantidad a Agregar debe ser mayor a (0) ","Alerta",JOptionPane.WARNING_MESSAGE);
            } else {
                
               int canti=Integer.parseInt(Stock1.getText());
               int Quit=Integer.parseInt(Cantidad.getText());
               int QuitarST=canti-Quit;
               cone2=conex.CargarBD();     
                    if (Quit>canti){
                   JOptionPane.showMessageDialog(null, "La cantidad a descontar el mayor al Stock \n no es posible realizar el descargue","Alerta",JOptionPane.WARNING_MESSAGE);
           
                    } else {
                         if (canti>0){
                                try {
                                                       Statement orden1 =cone2.createStatement();
                                                       String crear = "Update  Productos  set STOCK="+QuitarST+"where PRODUCTOID="+Cod1.getText();
                                                       orden1.executeUpdate(crear);
                                                       JOptionPane.showMessageDialog(null, "Se ha Descontado del Stock de "+nombre1.getText()+" "+Quit+" Unidades \n La cantidad actual es de "+QuitarST+" Unidades");
                                                       Tabla();
                                                       limpiar();
                                                       } 
                                                        catch (Exception ex) {
                                                        System.out.println("Error:"+ex);
                                                   }
                    }
                    else {
                         JOptionPane.showMessageDialog(null, "El Stock de este Producto es Cero (0)\n no es posible realizar el descargue","Alerta",JOptionPane.WARNING_MESSAGE);
           
                        }
           
                        }
               
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        Cod = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        Descripcion = new javax.swing.JLabel();
        Stock = new javax.swing.JLabel();
        Cod1 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JLabel();
        Stock1 = new javax.swing.JLabel();
        Descripcion1 = new javax.swing.JLabel();
        Cant = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(530, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 510, 90));

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Back.png"))); // NOI18N
        Regresar.setText("Regresar ");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 130, -1));

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Lista de Productos");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 530, 40));

        Cod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cod.setText("Cod_Producto:");
        getContentPane().add(Cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 20));

        nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombre.setText("Nombre:");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, 20));

        Descripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Descripcion.setText("Digite la Cantidad Disminuir");
        getContentPane().add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 170, 20));

        Stock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Stock.setText("Descripción:");
        getContentPane().add(Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 20));

        Cod1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(Cod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 90, 20));
        getContentPane().add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 230, 20));
        getContentPane().add(Stock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 230, 20));
        getContentPane().add(Descripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 230, 20));

        Cant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cant.setText("Stock:");
        getContentPane().add(Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, 20));

        Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadActionPerformed(evt);
            }
        });
        Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantidadKeyTyped(evt);
            }
        });
        getContentPane().add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 200, 80, -1));

        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Add New_16px.png"))); // NOI18N
        Agregar.setText("Descontar Unidades");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        getContentPane().add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/NBG.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
       
        int Fila = Tabla.getSelectedRow();
        Cod1.setText(String.valueOf(Tabla.getValueAt(Fila, 0)));
        nombre1.setText(String.valueOf(Tabla.getValueAt(Fila, 1)));
        Descripcion1.setText(String.valueOf(Tabla.getValueAt(Fila, 2)));
        Stock1.setText(String.valueOf(Tabla.getValueAt(Fila, 3)));
       
    }//GEN-LAST:event_TablaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Tabla();
    }//GEN-LAST:event_formWindowOpened

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        HulkStore volver=new HulkStore();
        volver.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadActionPerformed

    private void CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_CantidadKeyTyped

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
       actualizar();
    }//GEN-LAST:event_AgregarActionPerformed

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
            java.util.logging.Logger.getLogger(DescargarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescargarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescargarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescargarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DescargarStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Cant;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JLabel Cod;
    private javax.swing.JLabel Cod1;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JLabel Descripcion1;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Stock1;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre1;
    // End of variables declaration//GEN-END:variables
}

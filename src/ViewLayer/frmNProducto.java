/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import BusinessModelLayer.Farmacia;
import BusinessModelLayer.Producto;
import DataAccessLayer.DataAccess;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author morco
 */
public class frmNProducto extends javax.swing.JDialog {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idProducto = 0;
    private Producto producto = new Producto();
    private Farmacia farmacia = new Farmacia();

    /**
     * Creates new form frmNProducto
     */
    public frmNProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public frmNProducto() {
        initComponents();
        nombreFarmacia();
        this.setLocationRelativeTo(null);
    }

    public frmNProducto(int idProducto) {
        initComponents();
        this.idProducto = idProducto;
        nombreFarmacia();
        producto.setIdProducto(idProducto);
        producto.GetById();
        txtNombre.setText(producto.getNombre());
        txtStock.setText("" + producto.getStock());
        for (int i = 0; i < farmacia.GetAllModel().getRowCount(); i++) {
                if (farmacia.GetAllModel().getValueAt(i, 0).equals(producto.getIdFarmacia())) {
                    cbFarmacias.setSelectedIndex(i);
                    
                }
        }
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
        Date convertido = formato.parse(producto.getCaducidad());
        jdcFecha.setDate(convertido);
        } catch (Exception e) {
        }
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cbFarmacias = new javax.swing.JComboBox<>();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Caducidad");

        jLabel3.setText("Stock");

        jLabel4.setText("ID Farmacia");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jdcFecha.setDateFormatString("yyyy-MMM-dd");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pildora-de-vitamina.png"))); // NOI18N
        jLabel5.setText("Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(15, 15, 15))
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbFarmacias, 0, 269, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFarmacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        Date date = jdcFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        int idFarmacia = 0;
        for (int i = 0; i < farmacia.GetAllModel().getRowCount(); i++) {
            if (farmacia.GetAllModel().getValueAt(i, 1).equals(cbFarmacias.getItemAt(cbFarmacias.getSelectedIndex()))) {
                idFarmacia = Integer.parseInt("" + farmacia.GetAllModel().getValueAt(i, 0));
            }
        }

        if (producto.getIdProducto() > 0) {

            producto.setNombre(txtNombre.getText());
            producto.setCaducidad("" + fecha);
            producto.setStock(Integer.parseInt(txtStock.getText()));
            producto.setIdFarmacia(idFarmacia);
            producto.setActivo(1);

            if (producto.Update()) {
                JOptionPane.showMessageDialog(null, "Producto actualizado");
                this.dispose();
            }
        } else {
            if (new Producto(0, txtNombre.getText(), "" + fecha,
                    Integer.parseInt(txtStock.getText()),
                    idFarmacia,
                    1).Add()) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    public void nombreFarmacia() {
        for (int i = 0; i < farmacia.GetAllModel().getRowCount(); i++) {
            cbFarmacias.addItem("" + farmacia.GetAllModel().getValueAt(i, 1));
        }

    }
    
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
            java.util.logging.Logger.getLogger(frmNProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmNProducto dialog = new frmNProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbFarmacias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import static Controlador.UserConfig.actUser;
import Modelo.Usuario;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InterfazAgregarSaldo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazAgregarSaldo.class.getName());
    private Usuario usuario;
    
    public InterfazAgregarSaldo(){}
   
    public InterfazAgregarSaldo(Usuario actual){
        usuario = actual;
        initComponents();
        setImageLabel(lbVolverIcon,"/images/back-icon.jpg");
    }

private void setImageLabel(JLabel lb, String ruta) {
    java.net.URL imgURL = getClass().getResource(ruta); 
    if (imgURL != null) {
        ImageIcon image = new ImageIcon(imgURL);
        Icon icon;
        icon = new ImageIcon(
                image.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), java.awt.Image.SCALE_SMOOTH)
        );
        lb.setIcon(icon);
        this.repaint();
    } else {
        System.err.println("No se pudo encontrar el archivo: " + ruta);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbVolver = new javax.swing.JLabel();
        lbVolverIcon = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();
        Añadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Saldo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbVolver.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbVolver.setText("Volver");

        lbVolverIcon.setText("jLabel1");
        lbVolverIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVolverIconMouseClicked(evt);
            }
        });

        monto.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        monto.setForeground(new java.awt.Color(153, 153, 153));
        monto.setText("Ingrese el monto a depositar en su monedero");
        monto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                montoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                montoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                montoMousePressed(evt);
            }
        });

        Añadir.setBackground(new java.awt.Color(5, 153, 81));
        Añadir.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Añadir.setForeground(new java.awt.Color(255, 255, 255));
        Añadir.setText("Depositar");
        Añadir.addActionListener(this::AñadirActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbVolver)
                        .addComponent(lbVolverIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbVolverIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 360, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void montoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoMousePressed
        if(monto.getText().trim().equals("Ingrese el monto a depositar en su monedero ".trim())){
        monto.setText("");
        monto.setForeground(Color.gray);
        }
    }//GEN-LAST:event_montoMousePressed

    private void montoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoMouseClicked
          if(monto.getText().trim().equals("Ingrese el monto a depositar en su monedero ".trim())){
            monto.setText("");
            monto.setForeground(Color.black);
        }
    }//GEN-LAST:event_montoMouseClicked

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
       float nuevoMonto = Float.parseFloat(monto.getText());
       if(nuevoMonto > 0.0){
            usuario.setMonedero(usuario.getMonedero() + nuevoMonto);
            actUser(usuario);
            JOptionPane.showMessageDialog(null, "Saldo de usuario con ID " + usuario.getCedula() + " actualizado.");
            java.awt.EventQueue.invokeLater(() -> new Principal(usuario).setVisible(true));
            this.dispose();
       }else{
           JOptionPane.showMessageDialog(this,"No puedes restarte saldo");
       }
    }//GEN-LAST:event_AñadirActionPerformed

    private void lbVolverIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVolverIconMouseClicked
        java.awt.EventQueue.invokeLater(() -> new Principal(usuario).setVisible(true));
        this.dispose();
    }//GEN-LAST:event_lbVolverIconMouseClicked

    private void montoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoMouseExited
        if("".equals(monto.getText())){
            monto.setText("Ingrese el monto a depositar en su monedero");
            monto.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_montoMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new InterfazAgregarSaldo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbVolver;
    private javax.swing.JLabel lbVolverIcon;
    private javax.swing.JTextField monto;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import static Controlador.ManejoImagenes.cargarUsuarioImagen;
import static Controlador.UserConfig.actUser;
import Modelo.Usuario;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SaldoPana extends javax.swing.JFrame {
    //El usuario que enviara el dinero y el que recibe el dinero
    Usuario emisor,receptor;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SaldoPana.class.getName());

    
    public SaldoPana(Usuario user) {
         emisor = user;
         receptor = new Usuario();
        initComponents();
        this.setSize(495,260);
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

        bg = new javax.swing.JPanel();
        panelPana = new javax.swing.JPanel();
        lbPana = new javax.swing.JLabel();
        lbCI = new javax.swing.JLabel();
        textCI = new javax.swing.JTextField();
        textMonto = new javax.swing.JTextField();
        lbMonto = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        lbVolverIcon = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SaldoPana");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setPreferredSize(new java.awt.Dimension(480, 240));

        panelPana.setBackground(new java.awt.Color(255, 255, 255));
        panelPana.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelPana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPana.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbPana.setText("Invita a tus amigos, se un verdadero pana!");
        panelPana.add(lbPana, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        lbCI.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbCI.setText("Cedula de tu pana: ");
        panelPana.add(lbCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        textCI.setBackground(new java.awt.Color(204, 204, 204));
        textCI.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textCI.setForeground(new java.awt.Color(102, 102, 102));
        textCI.setText("cedula");
        textCI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textCIMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textCIMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textCIMousePressed(evt);
            }
        });
        panelPana.add(textCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 118, -1));

        textMonto.setBackground(new java.awt.Color(204, 204, 204));
        textMonto.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textMonto.setForeground(new java.awt.Color(102, 102, 102));
        textMonto.setText("cantidad");
        textMonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textMontoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textMontoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textMontoMousePressed(evt);
            }
        });
        panelPana.add(textMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 118, -1));

        lbMonto.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbMonto.setText("Monto que le enviaras:  ");
        panelPana.add(lbMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        btEnviar.setBackground(new java.awt.Color(204, 204, 204));
        btEnviar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btEnviar.setForeground(new java.awt.Color(102, 102, 102));
        btEnviar.setText("Enviar");
        btEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btEnviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btEnviarMouseExited(evt);
            }
        });
        btEnviar.addActionListener(this::btEnviarActionPerformed);
        panelPana.add(btEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        lbVolverIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbVolverIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVolverIconMouseClicked(evt);
            }
        });
        panelPana.add(lbVolverIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 20));

        lbUser.setText(emisor.getNombre() + " tienes un saldo disponible de: " + String.format("%.2f", emisor.getMonedero()));
        panelPana.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPana, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelPana, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnviarMouseEntered
          btEnviar.setForeground(Color.white);
          btEnviar.setBackground(new Color(0,153,81));
    }//GEN-LAST:event_btEnviarMouseEntered

    private void btEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnviarMouseExited
        btEnviar.setForeground(new Color(102,102,102));
        btEnviar.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btEnviarMouseExited

    private void lbVolverIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVolverIconMouseClicked
       java.awt.EventQueue.invokeLater(() -> new Principal(emisor).setVisible(true));
       this.dispose();
    }//GEN-LAST:event_lbVolverIconMouseClicked

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        String ID = textCI.getText().trim();
        String txtMonto = textMonto.getText().trim();

        //Campos vacios
        if(ID.isEmpty() || ID.equalsIgnoreCase("cedula") || 
           txtMonto.isEmpty() || txtMonto.equalsIgnoreCase("cantidad")){

            JOptionPane.showMessageDialog(this,"Debes llenar todos los campos");

        } else {
            try {
                float monto = Float.parseFloat(txtMonto);

                //Saldo insuficiente
                if(monto > emisor.getMonedero()){
                    JOptionPane.showMessageDialog(this,"Saldo insuficiente");
                }
                
                //Intenta pasarse dinero a si mismo
                else if(ID.equals(emisor.getCedula())){
                    JOptionPane.showMessageDialog(this,"No te puedes enviar dinero a ti mismo");
                }

                //Monto negativo
                else if(monto < 0){
                    JOptionPane.showMessageDialog(this,"Valor invalido, ingrese un saldo positivo para continuar la operación");
                }

                //Ingreso los datos correctamente
                else {

                    //Cargamos al usuario receptor
                    int res = cargarUsuarioImagen(ID, receptor);

                    //Verificamos que se haya cargado correctamente
                    if(res != 0){

                        //Calculamos y establecemos los montos
                        receptor.setMonedero(receptor.getMonedero() + monto);
                        emisor.setMonedero(emisor.getMonedero() - monto);
                        lbUser.setText(emisor.getNombre() + " tienes un saldo disponible de: " + String.format("%.2f", emisor.getMonedero()));

                        actUser(emisor);
                        actUser(receptor);

                        JOptionPane.showMessageDialog(this,"Se envio correctamente el saldo a tu pana");
                    }

                    //El usuario receptor no existe en sistema
                    else{
                        JOptionPane.showMessageDialog(this,"Tu pana no se encuentra en sistema :(");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El monto debe ser un número válido");
            }
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void textCIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textCIMouseClicked
        if(textCI.getText().trim().equals("cedula")){
            textCI.setText(" ");
            textCI.setForeground(Color.black);
        }
    }//GEN-LAST:event_textCIMouseClicked

    private void textCIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textCIMousePressed
        if(textCI.getText().trim().equals("cedula")){
            textCI.setText(" ");
            textCI.setForeground(Color.black);
        }
    }//GEN-LAST:event_textCIMousePressed

    private void textCIMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textCIMouseExited
        if(textCI.getText().trim().equals("")){
            textCI.setText("cedula");
            textCI.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_textCIMouseExited

    private void textMontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMontoMouseClicked
         if(textMonto.getText().trim().equals("cantidad")){
            textMonto.setText(" ");
            textMonto.setForeground(Color.black);
        }
    }//GEN-LAST:event_textMontoMouseClicked

    private void textMontoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMontoMousePressed
         if(textMonto.getText().trim().equals("cantidad")){
            textMonto.setText(" ");
            textMonto.setForeground(Color.black);
        }
    }//GEN-LAST:event_textMontoMousePressed

    private void textMontoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMontoMouseExited
         if(textMonto.getText().trim().equals("")){
            textMonto.setText("cantidad");
            textMonto.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_textMontoMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SaldoPana(new Usuario()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btEnviar;
    private javax.swing.JLabel lbCI;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbPana;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lbVolverIcon;
    private javax.swing.JPanel panelPana;
    private javax.swing.JTextField textCI;
    private javax.swing.JTextField textMonto;
    // End of variables declaration//GEN-END:variables
}

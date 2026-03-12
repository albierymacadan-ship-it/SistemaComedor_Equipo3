
package Vista;

import static Controlador.ManejoImagenes.cargarUsuarioImagen;
import static Controlador.UserConfig.actUser;
import Modelo.Usuario;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class InterfazCambiarContraseña extends javax.swing.JFrame {
    
    private boolean isVisible = false;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazCambiarContraseña.class.getName());

   
    public InterfazCambiarContraseña() {
        initComponents();
        setImageLabel(lbPrivacityIcon,"/images/Vof-icon.png");
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

        bgGeneral = new javax.swing.JPanel();
        bgElementos = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        lbPW1 = new javax.swing.JLabel();
        textPW1 = new javax.swing.JPasswordField();
        lbPW2 = new javax.swing.JLabel();
        textPW2 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lbPrivacityIcon = new javax.swing.JLabel();
        btCambio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recuperar Contraseãna");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(460, 410));
        setResizable(false);

        bgGeneral.setPreferredSize(new java.awt.Dimension(450, 370));
        bgGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgElementos.setBackground(new java.awt.Color(255, 255, 255));
        bgElementos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitle.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Restablecer Contraseña");
        bgElementos.add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lbID.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbID.setText("Cedula: ");
        bgElementos.add(lbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        textID.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textID.setForeground(new java.awt.Color(153, 153, 153));
        textID.setText("ej123456");
        textID.setBorder(null);
        textID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textIDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textIDMouseExited(evt);
            }
        });
        bgElementos.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 110, 20));

        lbPW1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbPW1.setText("Ingrese su nueva clave: ");
        bgElementos.add(lbPW1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        textPW1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textPW1.setForeground(new java.awt.Color(153, 153, 153));
        textPW1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textPW1.setText("********");
        textPW1.setBorder(null);
        textPW1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textPW1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textPW1MouseExited(evt);
            }
        });
        bgElementos.add(textPW1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 135, 20));

        lbPW2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbPW2.setText("Confirmar contraseña: ");
        bgElementos.add(lbPW2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        textPW2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textPW2.setForeground(new java.awt.Color(153, 153, 153));
        textPW2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textPW2.setText("********");
        textPW2.setBorder(null);
        textPW2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textPW2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textPW2MouseExited(evt);
            }
        });
        bgElementos.add(textPW2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 135, 20));
        bgElementos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 110, 10));
        bgElementos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, -1));
        bgElementos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        lbPrivacityIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrivacityIcon.setText("ver");
        lbPrivacityIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPrivacityIconMouseClicked(evt);
            }
        });
        bgElementos.add(lbPrivacityIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 40, 30));

        btCambio.setBackground(new java.awt.Color(0, 153, 81));
        btCambio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btCambio.setForeground(new java.awt.Color(255, 255, 255));
        btCambio.setText("Cambiar");
        btCambio.addActionListener(this::btCambioActionPerformed);
        bgElementos.add(btCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 120, -1));

        bgGeneral.add(bgElementos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 380, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textIDMouseClicked
        if(textID.getText().equals("ej123456")){
            textID.setText("");
            textID.setForeground(Color.black);
        } 
    }//GEN-LAST:event_textIDMouseClicked

    private void textIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textIDMouseExited
        if(textID.getText().equals("")){
            textID.setText("ej123456");
            textID.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textIDMouseExited

    private void textPW1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPW1MouseClicked
            textPW1.setText("");
            textPW1.setForeground(Color.black);
    }//GEN-LAST:event_textPW1MouseClicked

    private void textPW1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPW1MouseExited
        if(String.valueOf(textPW1.getPassword()).equals("")){
            textPW1.setText("ej123456");
            textPW1.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textPW1MouseExited

    private void textPW2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPW2MouseClicked
        textPW2.setText("");
        textPW2.setForeground(Color.black);
    }//GEN-LAST:event_textPW2MouseClicked

    private void textPW2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPW2MouseExited
         if(String.valueOf(textPW2.getPassword()).equals("")){
            textPW2.setText("ej123456");
            textPW2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textPW2MouseExited

    private void lbPrivacityIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPrivacityIconMouseClicked
        if (isVisible) {
                    textPW1.setEchoChar('•');
                    textPW2.setEchoChar('•');
                    setImageLabel(lbPrivacityIcon,"/images/Von-icon.png");
                } else {
                    textPW1.setEchoChar((char) 0);
                    textPW2.setEchoChar((char) 0);
                    setImageLabel(lbPrivacityIcon,"/images/Vof-icon.png");
                }
                isVisible = !isVisible; 
    }//GEN-LAST:event_lbPrivacityIconMouseClicked

    private void btCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCambioActionPerformed
       String ID = textID.getText().trim();
       Usuario actual = new Usuario();
       boolean isValid = true;
       
       //Validaciones copiadas del registro
       
        //VALIDACION DE QUE LA CEDULA SOLO CONTENGA NUMEROS VERIFICANDO LA EXISTENCIA DE ALGUNA LETRA 
        if(textID.getText().trim().matches(".*[a-zA-Z].*") || textID.getText().contains(" ")){
            isValid = false;
            JOptionPane.showMessageDialog(null,"La cedula no puede contener letras o espaciadores ");
            textID.setText("");     
        }
        
        //VALIDACION DE QUE LA CEDULA NO EMPIECE POR 0 CORTANDO LA CADENA EN LA PRIMERA POSICION
        if(textID.getText().substring(0,1).equals("0")){
            isValid = false;
            JOptionPane.showMessageDialog(null, "La cedula no puede empezar con 0");
            
        }
        //VALIDACION DE QUE LA CEDULA NO SOBREPASE LOS 9 DIGITOS
        if(textID.getText().length() >= 9){
            isValid = false;
            JOptionPane.showMessageDialog(null,"La cedula no puede tener mas de 9 digitos");
        }
        
         //VALIDACION POR ESPACIOS EN LA CONTRASEÑA
         if(String.valueOf(textPW1.getPassword()).contains(" ") ||
            String.valueOf(textPW2.getPassword()).contains(" ")){
             isValid = false;
            JOptionPane.showMessageDialog(null,"La contraseña no puede contener espacios");
        }
         
        //VALIDACION POR LIMITE DE CARACTERES EN LA CONTRASEÑA
        if(String.valueOf(textPW1.getPassword()).length() > 15 || 
           String.valueOf(textPW2.getPassword()).length() > 15){
            isValid = false;
                JOptionPane.showMessageDialog(null,"La contraseña no puede tener mas de 16 caracteres");
        }     
       
       //Si cumplio con todas las condiciones, ahora si procedemos a actualizar la contraseña
       if(isValid){
           
           String nueva1 = String.valueOf(textPW1.getPassword());
           String nueva2 = String.valueOf(textPW2.getPassword());
           
           //Reusamos esta funcion ya que cumple con la funcionalidad que estamos buscando
           int res = cargarUsuarioImagen(ID,actual);
           
           //Si es distinto de 0 es porque si existe el usuario
           if(res != 0){
           
           //Seteamos la nueva contraseña
           actual.setPassword(nueva1);
           
           //Actualizamos en la DB
           actUser(actual);
           
           //Mensaje de exito y redireccionamos al login 
           JOptionPane.showMessageDialog(this,"Se ha reestablecido su clave con exito");
           java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
           this.dispose();
           
            }else{
           //Si el resultado es 0 segun la funcion no se consiguio el usuario en DB
           JOptionPane.showMessageDialog(this,"El usuario no existe");
            }
       }
    }//GEN-LAST:event_btCambioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new InterfazCambiarContraseña().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgElementos;
    private javax.swing.JPanel bgGeneral;
    private javax.swing.JButton btCambio;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbPW1;
    private javax.swing.JLabel lbPW2;
    private javax.swing.JLabel lbPrivacityIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField textID;
    private javax.swing.JPasswordField textPW1;
    private javax.swing.JPasswordField textPW2;
    // End of variables declaration//GEN-END:variables
}


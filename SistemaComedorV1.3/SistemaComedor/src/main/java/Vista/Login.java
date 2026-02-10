/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.Principal;
import Modelo.Datos;
import static Controlador.ArchivosUsuarios.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import Modelo.Usuario;
import Modelo.Usuario;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    private Datos dato;
    public Login() {
        initComponents();
        dato = new Datos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        inipanel = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        botonRegister = new javax.swing.JButton();
        botonLogin = new javax.swing.JButton();
        labelPassword = new javax.swing.JLabel();
        textfieldCI = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelUser1 = new javax.swing.JLabel();
        textfieldPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        labelRecovery = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocationByPlatform(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inipanel.setBackground(new java.awt.Color(255, 255, 255));
        inipanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        inipanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitle.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Iniciar Sesión");
        inipanel.add(labelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        botonRegister.setBackground(new java.awt.Color(204, 204, 204));
        botonRegister.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonRegister.setForeground(new java.awt.Color(102, 102, 102));
        botonRegister.setText("Registrarse");
        botonRegister.setBorder(null);
        botonRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonRegisterMouseExited(evt);
            }
        });
        botonRegister.addActionListener(this::botonRegisterActionPerformed);
        inipanel.add(botonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 120, 30));

        botonLogin.setBackground(new java.awt.Color(0, 153, 51));
        botonLogin.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonLogin.setForeground(new java.awt.Color(255, 255, 255));
        botonLogin.setText("Ingresar");
        botonLogin.setBorder(null);
        botonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonLogin.addActionListener(this::botonLoginActionPerformed);
        inipanel.add(botonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 120, 30));

        labelPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelPassword.setText("CONTRASEÑA");
        inipanel.add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 80, -1));

        textfieldCI.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        textfieldCI.setForeground(new java.awt.Color(102, 102, 102));
        textfieldCI.setText("Ingrese su cedula");
        textfieldCI.setBorder(null);
        textfieldCI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textfieldCIMousePressed(evt);
            }
        });
        inipanel.add(textfieldCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 220, -1));
        inipanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 160, -1));

        labelUser1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelUser1.setText("USUARIO");
        inipanel.add(labelUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, -1));

        textfieldPassword.setForeground(new java.awt.Color(102, 102, 102));
        textfieldPassword.setText("********");
        textfieldPassword.setBorder(null);
        textfieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textfieldPasswordMouseClicked(evt);
            }
        });
        inipanel.add(textfieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 180, 20));
        inipanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 160, 10));

        labelRecovery.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelRecovery.setForeground(new java.awt.Color(153, 153, 153));
        labelRecovery.setText("Olvidaste tu contraseña?");
        labelRecovery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRecovery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRecoveryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRecoveryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRecoveryMouseExited(evt);
            }
        });
        inipanel.add(labelRecovery, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(469, 469, 469))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(inipanel, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(inipanel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegisterMouseEntered
              //Cuando pase el mouse por encima
                botonRegister.setBackground(new Color(0,153,51));
                botonRegister.setForeground(Color.white);
                botonLogin.setBackground(new Color(204,204,204));
                botonLogin.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_botonRegisterMouseEntered

    private void botonRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegisterMouseExited
        // Cuando el mouse salga
                botonRegister.setBackground(new Color(204,204,204));
                botonRegister.setForeground(new Color(102,102,102));
                botonLogin.setBackground(new Color(0,153,51));
                botonLogin.setForeground(Color.white);
    }//GEN-LAST:event_botonRegisterMouseExited

    private void labelRecoveryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecoveryMouseEntered
        labelRecovery.setFont(new Font("Calibri", 1,14));
    }//GEN-LAST:event_labelRecoveryMouseEntered

    private void labelRecoveryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecoveryMouseExited
        labelRecovery.setForeground(new Color(153,153,153));
        labelRecovery.setFont(new Font("Calibri", 0,14));
    }//GEN-LAST:event_labelRecoveryMouseExited

    private void labelRecoveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRecoveryMouseClicked
        // LLEVAR A UNA NUEVA INTERFAZ DE RECUPERACION DE CLAVE
    }//GEN-LAST:event_labelRecoveryMouseClicked

    private void botonRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegisterMouseClicked
        // LLEVAR A INTERFAZ DE REGISTRO
        java.awt.EventQueue.invokeLater(() -> new Registro().setVisible(true));
        this.setVisible(false);
    }//GEN-LAST:event_botonRegisterMouseClicked
    
        
    
    private void textfieldCIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textfieldCIMousePressed
    if(textfieldCI.getText().equals("Ingrese su cedula")){
        textfieldCI.setText("");
        textfieldCI.setForeground(Color.black);
    }
        if(String.valueOf(textfieldPassword.getPassword()).isEmpty()){
        textfieldPassword.setText("********");
        textfieldPassword.setForeground(Color.gray);
    }
    }//GEN-LAST:event_textfieldCIMousePressed

    private void textfieldPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textfieldPasswordMouseClicked
        if(String.valueOf(textfieldPassword.getPassword()).equals("********")){
        textfieldPassword.setText("");
        textfieldPassword.setForeground(Color.black);
        }
        if(textfieldCI.getText().isEmpty()){
        textfieldCI.setText("Ingrese su cedula");
        textfieldCI.setForeground(Color.gray);
        }
        
    }//GEN-LAST:event_textfieldPasswordMouseClicked

    private void botonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoginActionPerformed
 try {
    String ci = textfieldCI.getText();
    String pass = new String(textfieldPassword.getPassword());
    Usuario userCargado = new Usuario();

    // Cambiamos el texto por el objeto 'dato' que es lo que pide la función de tu amigo
    int rol = Controlador.ArchivosUsuarios.validarYCargarUsuario(dato.getUsers(), ci, pass, userCargado);

    if (rol == 2) {
        JOptionPane.showMessageDialog(this, "Bienvenido Administrador: " + userCargado.getNombre());
        new Vista.InterfazAdmin(userCargado).setVisible(true);
        this.dispose();
    } else if (rol == 1) {
        JOptionPane.showMessageDialog(this, "Bienvenido: " + userCargado.getNombre());
        new Vista.Principal(userCargado).setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Cédula o Contraseña incorrecta");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error en el sistema: " + e.getMessage());
}
    }//GEN-LAST:event_botonLoginActionPerformed

    private void botonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegisterActionPerformed
        // 1. Creamos la ventana de Registro
    Registro ventanaRegistro = new Registro();
    
    // 2. La hacemos visible
    ventanaRegistro.setVisible(true);
    
    // 3. Cerramos (o escondemos) el Login para que no estorbe
    this.dispose();
    }//GEN-LAST:event_botonRegisterActionPerformed
    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonLogin;
    private javax.swing.JButton botonRegister;
    private javax.swing.JPanel inipanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelRecovery;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JTextField textfieldCI;
    private javax.swing.JPasswordField textfieldPassword;
    // End of variables declaration//GEN-END:variables
}

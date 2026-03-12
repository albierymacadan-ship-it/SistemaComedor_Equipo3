
package Vista;

import static Controlador.ManejoImagenes.*;
import Modelo.Usuario;
import java.awt.Color;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class LoginFaceID extends javax.swing.JFrame {

  public String ruta;
  
  private void setRuta(String nuevaruta){
  this.ruta = nuevaruta;
  }
  
  private String getRuta(){
  return this.ruta;
  }
          
    public LoginFaceID() {
        initComponents();
        setImageLabel(lbBackIcon,"/images/back-icon.jpg");
        setImageLabel(lbUploadIcon,"/images/upload-icon.png");
        lbUploadIcon.setOpaque(false);
        lbUploadIcon.setBorder(null);
        lbUploadIcon.setBackground(new Color(0,0,0,0));
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

        jScrollBar1 = new javax.swing.JScrollBar();
        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbBack = new javax.swing.JLabel();
        lbBackIcon = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        textfieldID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbUser = new javax.swing.JLabel();
        lbUploadIcon = new javax.swing.JLabel();
        btFoto = new javax.swing.JButton();
        lbIngresoFID = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginFaceID");
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));

        lbBack.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbBack.setText("Volver");

        lbBackIcon.setText("Volver");
        lbBackIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackIconMouseClicked(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbTitulo.setText("Iniciar Sesión");

        textfieldID.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        textfieldID.setForeground(new java.awt.Color(102, 102, 102));
        textfieldID.setText("Ingrese su cedula");
        textfieldID.setBorder(null);
        textfieldID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textfieldIDMousePressed(evt);
            }
        });
        textfieldID.addActionListener(this::textfieldIDActionPerformed);

        lbUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbUser.setText("CEDULA");

        lbUploadIcon.setText("CargarFoto");

        btFoto.setBackground(new java.awt.Color(0, 153, 81));
        btFoto.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btFoto.setForeground(new java.awt.Color(255, 255, 255));
        btFoto.setText("CARGAR FOTO");
        btFoto.addActionListener(this::btFotoActionPerformed);

        lbIngresoFID.setBackground(new java.awt.Color(153, 153, 153));
        lbIngresoFID.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbIngresoFID.setForeground(new java.awt.Color(204, 204, 204));
        lbIngresoFID.setText("INGRESAR");
        lbIngresoFID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbIngresoFIDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbIngresoFIDMouseExited(evt);
            }
        });
        lbIngresoFID.addActionListener(this::lbIngresoFIDActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbBack)
                            .addComponent(lbBackIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addComponent(lbTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbUploadIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 180, Short.MAX_VALUE)
                .addComponent(lbIngresoFID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBackIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitulo))
                .addGap(18, 18, 18)
                .addComponent(lbUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUploadIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lbIngresoFID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbBackIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackIconMouseClicked
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
        this.dispose();
    }//GEN-LAST:event_lbBackIconMouseClicked

    private void textfieldIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textfieldIDMousePressed
        if(textfieldID.getText().equals("Ingrese su cedula")){
            textfieldID.setText("");
            textfieldID.setForeground(Color.black);
        }      
    }//GEN-LAST:event_textfieldIDMousePressed

    private void textfieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldIDActionPerformed

    private void btFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFotoActionPerformed
        String rutaObtenida = cargarImagen();
        if(rutaObtenida != null){
            setRuta(rutaObtenida);
            btFoto.setText("Cargada");
            lbIngresoFID.setBackground(new Color(0,153,81));
        }else{
            JOptionPane.showMessageDialog(this,"Debes seleccionar un archivo con fomato valido");
        }
        
    }//GEN-LAST:event_btFotoActionPerformed

    private void lbIngresoFIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIngresoFIDMouseEntered
        lbIngresoFID.setBackground(new Color(0,153,81));
        lbIngresoFID.setForeground(Color.white);
    }//GEN-LAST:event_lbIngresoFIDMouseEntered

    private void lbIngresoFIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIngresoFIDMouseExited
        lbIngresoFID.setBackground(new Color(153,153,153));
        lbIngresoFID.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_lbIngresoFIDMouseExited

    private void lbIngresoFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbIngresoFIDActionPerformed
        if(" ".equals(textfieldID.getText()) || getRuta() == null){
            JOptionPane.showMessageDialog(this,"Debes llenar todos los campos");
        }else{
            try {
                int res = AutenticacionFacial(textfieldID.getText(),getRuta());
                //SI EL RESULTADO DE LA AUTENTICACION ES VALIDO
                    if(res == 1){
                        Usuario nuevo = new Usuario();
                       int rol = cargarUsuarioImagen(textfieldID.getText(),nuevo);
                        
                        if (rol == 2) {
                            JOptionPane.showMessageDialog(this, "Bienvenido Administrador: " + nuevo.getNombre());
                            new Vista.InterfazAdmin(nuevo).setVisible(true);
                            this.dispose();
                        } else if (rol == 1) {
                            nuevo.setEstado("online");
                            JOptionPane.showMessageDialog(this, "Bienvenido: " + nuevo.getNombre());
                            new Vista.Principal(nuevo).setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Cédula incorrecta");
                             btFoto.setText("Cargar Foto");
                             lbIngresoFID.setBackground(new Color(153,153,153));
                        }
                    }
                    else if(res == 2){
                        JOptionPane.showMessageDialog(this, "No tiene cargada su imagen, inicie sesion de forma normal");
                        btFoto.setText("Cargar Foto");
                        lbIngresoFID.setBackground(new Color(153,153,153));
                    }
                    else if(res == 3){
                        JOptionPane.showMessageDialog(this, "No se cargo una imagen en el campo, vuelvalo a intentar");
                        btFoto.setText("Cargar Foto");
                        lbIngresoFID.setBackground(new Color(153,153,153));
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Su imagen no coincide con la de su perfil");
                        btFoto.setText("Cargar Foto");
                        lbIngresoFID.setBackground(new Color(153,153,153));
                    }
            } catch (IOException ex) {
                System.getLogger(LoginFaceID.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }//GEN-LAST:event_lbIngresoFIDActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> new LoginFaceID().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btFoto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbBackIcon;
    private javax.swing.JButton lbIngresoFID;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUploadIcon;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTextField textfieldID;
    // End of variables declaration//GEN-END:variables
}

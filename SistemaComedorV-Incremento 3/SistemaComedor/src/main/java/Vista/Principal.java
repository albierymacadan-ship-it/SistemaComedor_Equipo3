package Vista;

import Controlador.ArchivosMenu;
import static Controlador.ManejoImagenes.cargarYCopiarImagen;
import static Controlador.UserConfig.actUser;
import Modelo.CCB;
import Modelo.LOG;
import Modelo.Menu;
import Modelo.Plato;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class Principal extends javax.swing.JFrame {
    
    Usuario usuario = new Usuario();
    Menu elmenu;
    public LOG registro;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    //CONSTRUCTOR
    public Principal(Usuario nuevo) {
    
    //Asignar el usuario que viene del Login
    this.usuario = nuevo;
    
    //Inicializar el objeto Menu y asegurar el archivo
    this.elmenu = new Menu();
    
    //Inicializamos el log
    this.registro = new LOG();
    
    //Cargamos el log
    registro.cargarLOG();
     

    String rutaMenu = elmenu.dato.getMenus(); 
    System.out.println("Iniciando secuencia de apertura...");
    
    // LLAMADA A LA FUNCIÓN DE CREACIÓN
    ArchivosMenu.crearArchivoMenu(rutaMenu);
    
    ArchivosMenu.leerMenu(elmenu, (java.util.ArrayList<Plato>) elmenu.platos);
    initComponents();
    mostrarMenu(elmenu,usuario,elmenu.costo);
 
    if (scrollPaneMenu != null) {
        scrollPaneMenu.getVerticalScrollBar().setUnitIncrement(20);
    }
    System.out.println("Interfaz Principal cargada correctamente.");
    
   
}
    //CONTRUCTOR VACIO
    private Principal(){}
    
    //FUNCION QUE PERMITE ACTUALIZAR EL MONEDERO DESDE OTRAS INTERFACES
    public void actualizarMonedero(float nuevoValor){
    this.lbSaldo.setText("Monedero: " + String.valueOf(usuario.getMonedero()));
    }
    
    //FUNCION QUE CREA LOS PANELES DEL JSCROLLPANE PARA EL MENU
    public void mostrarMenu(Menu menuObjeto, Usuario actual, CCB a) {
    //Crear contenedor
    JPanel contenedor = new JPanel();
    
    // Layaut vertical para que las tarjetas se apilen hacia abajo
    contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
    contenedor.setBackground(new Color(245, 245, 245)); // Gris claro 

    // Recorrer la lista de platos que tiene el menu
    for (Plato p : menuObjeto.platos) {
        // Creamos una instancia de nuestra tarjeta personalizada
        PanelPlato tarjeta = new PanelPlato(p,actual,a,this);
        
        // Añadir la tarjeta al contenedor
        contenedor.add(tarjeta);
        
        // separar las los contenedores entre cada tarjeta
        contenedor.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    //  Meter todo el contenedor dentro del ScrollPane
    scrollPaneMenu.setViewportView(contenedor);

    //  Refrescar para que aparezca en pantalla
    contenedor.revalidate();
    contenedor.repaint();
}

    @SuppressWarnings("unchecked")

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        bg = new javax.swing.JPanel();
        BarraPane = new javax.swing.JPanel();
        botonExit = new javax.swing.JButton();
        labelUCV = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        estadoPane = new javax.swing.JPanel();
        labelEstado = new javax.swing.JLabel();
        lbSaldo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelMenus = new javax.swing.JLabel();
        scrollPaneMenu = new javax.swing.JScrollPane();
        labelMenuSemanal = new javax.swing.JLabel();
        separator2 = new javax.swing.JSeparator();
        labelTitulo = new javax.swing.JLabel();
        CofigCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraPane.setBackground(new java.awt.Color(102, 102, 102));
        BarraPane.setPreferredSize(new java.awt.Dimension(801, 700));

        botonExit.setBackground(new java.awt.Color(153, 153, 153));
        botonExit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonExit.setForeground(new java.awt.Color(255, 255, 255));
        botonExit.setText(" Salir");
        botonExit.addActionListener(this::botonExitActionPerformed);

        labelUCV.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        labelUCV.setForeground(new java.awt.Color(255, 255, 255));
        labelUCV.setText("Comedor UCV");

        labelTipo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelTipo.setForeground(new java.awt.Color(255, 255, 255));
        labelTipo.setText(usuario.getTipo());

        estadoPane.setBackground(new java.awt.Color(0, 255, 153));
        estadoPane.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        labelEstado.setBackground(new java.awt.Color(0, 0, 0));
        labelEstado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEstado.setText(usuario.getEstado());

        javax.swing.GroupLayout estadoPaneLayout = new javax.swing.GroupLayout(estadoPane);
        estadoPane.setLayout(estadoPaneLayout);
        estadoPaneLayout.setHorizontalGroup(
            estadoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );
        estadoPaneLayout.setVerticalGroup(
            estadoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        lbSaldo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbSaldo.setForeground(new java.awt.Color(255, 255, 255));
        lbSaldo.setText("Saldo diponible: " + String.format("%.2f", usuario.getMonedero()));

        javax.swing.GroupLayout BarraPaneLayout = new javax.swing.GroupLayout(BarraPane);
        BarraPane.setLayout(BarraPaneLayout);
        BarraPaneLayout.setHorizontalGroup(
            BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarraPaneLayout.createSequentialGroup()
                        .addComponent(labelUCV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(BarraPaneLayout.createSequentialGroup()
                        .addComponent(labelTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(lbSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(269, Short.MAX_VALUE))))
        );
        BarraPaneLayout.setVerticalGroup(
            BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BarraPaneLayout.createSequentialGroup()
                        .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUCV)
                            .addComponent(botonExit))
                        .addGap(9, 9, 9)
                        .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(estadoPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        bg.add(BarraPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 740, 110));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        labelMenus.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelMenus.setText("Menú de la Semana");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(labelMenus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(scrollPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelMenus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 740, 350));

        labelMenuSemanal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        labelMenuSemanal.setForeground(new java.awt.Color(0, 153, 81));
        labelMenuSemanal.setText("Menú Semanal");
        labelMenuSemanal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.add(labelMenuSemanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 30));
        bg.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 90, 10));

        labelTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        labelTitulo.setText("Menú Principal");
        bg.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        CofigCombo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        CofigCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Configuración", "Cargar Foto", "Monedero","Saldo Pana"}));
        CofigCombo.addActionListener(this::CofigComboActionPerformed);
        bg.add(CofigCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 140, 30));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExitActionPerformed
        usuario.setEstado("offline");
        actUser(usuario);
        Login ventanaLogin = new Login();
        ventanaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonExitActionPerformed

    private void CofigComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CofigComboActionPerformed
        String seleccion = CofigCombo.getSelectedItem().toString();
        
        switch(seleccion){
            case "Configuracion" -> {
            }
            case "Cargar Foto" -> {
                try {
                    cargarYCopiarImagen(usuario.getCedula());
                } catch (IOException ex) {
                    System.getLogger(Principal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }

            case "Monedero" -> {
                java.awt.EventQueue.invokeLater(() -> new InterfazAgregarSaldo(usuario).setVisible(true));
                this.dispose();
            }
            case "Saldo Pana" -> {
                java.awt.EventQueue.invokeLater(() -> new SaldoPana(usuario).setVisible(true));
                this.dispose();
            }
            default -> JOptionPane.showMessageDialog(this,"No se reconoce la opción");
            
        }
    }//GEN-LAST:event_CofigComboActionPerformed

  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Principal(new Usuario()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraPane;
    private javax.swing.JComboBox<String> CofigCombo;
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonExit;
    private javax.swing.JPanel estadoPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelMenuSemanal;
    private javax.swing.JLabel labelMenus;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUCV;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JScrollPane scrollPaneMenu;
    private javax.swing.JSeparator separator2;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import Controlador.ArchivosMenu;
import Modelo.CCB;
import Modelo.Menu;
import Modelo.Plato;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;



public final class Principal extends javax.swing.JFrame {
    
    Usuario usuario = new Usuario();
    
    Menu elmenu;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    public Principal(Usuario nuevo) {
    // 1. Asignar el usuario que viene del Login
    this.usuario = nuevo;
    
    // 2. Inicializar el objeto Menu y asegurar el archivo
    this.elmenu = new Menu();
    

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
    
    private Principal() {}
   
    public void actualizarMonedero(float nuevoValor){
    this.lbSaldo.setText("Monedero: " + String.valueOf(usuario.getMonedero()));
    }
    // Esto va dentro de tu clase principal (JFrame)
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
        labelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelMenus = new javax.swing.JLabel();
        scrollPaneMenu = new javax.swing.JScrollPane();
        labelMenuSemanal = new javax.swing.JLabel();
        labelTurno = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        separator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraPane.setBackground(new java.awt.Color(102, 102, 102));

        botonExit.setBackground(new java.awt.Color(153, 153, 153));
        botonExit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonExit.setForeground(new java.awt.Color(255, 255, 255));
        botonExit.setText(" Salir");
        botonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonExitMouseClicked(evt);
            }
        });
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
        labelEstado.setForeground(new java.awt.Color(255, 255, 255));
        labelEstado.setText(usuario.getTipo());

        javax.swing.GroupLayout estadoPaneLayout = new javax.swing.GroupLayout(estadoPane);
        estadoPane.setLayout(estadoPaneLayout);
        estadoPaneLayout.setHorizontalGroup(
            estadoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estadoPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        estadoPaneLayout.setVerticalGroup(
            estadoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, estadoPaneLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(labelEstado))
        );

        lbSaldo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbSaldo.setForeground(new java.awt.Color(255, 255, 255));
        lbSaldo.setText("Monedero: " + String.valueOf(usuario.getMonedero()));

        javax.swing.GroupLayout BarraPaneLayout = new javax.swing.GroupLayout(BarraPane);
        BarraPane.setLayout(BarraPaneLayout);
        BarraPaneLayout.setHorizontalGroup(
            BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraPaneLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarraPaneLayout.createSequentialGroup()
                        .addComponent(labelTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estadoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelUCV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(lbSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(botonExit)
                .addGap(117, 117, 117))
        );
        BarraPaneLayout.setVerticalGroup(
            BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraPaneLayout.createSequentialGroup()
                .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarraPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelUCV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTipo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estadoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BarraPaneLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(BarraPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bg.add(BarraPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 780, -1));

        labelTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        labelTitulo.setText("Menú Principal");
        bg.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        labelMenus.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelMenus.setText("Menú de la Semana");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(labelMenus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(scrollPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelMenus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 780, 370));

        labelMenuSemanal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        labelMenuSemanal.setForeground(new java.awt.Color(0, 153, 81));
        labelMenuSemanal.setText("Menú Semanal");
        labelMenuSemanal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.add(labelMenuSemanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 30));

        labelTurno.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        labelTurno.setForeground(new java.awt.Color(153, 153, 153));
        labelTurno.setText("Reservar Turno");
        labelTurno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTurnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTurnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTurnoMouseExited(evt);
            }
        });
        bg.add(labelTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 100, 30));
        bg.add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 90, 10));
        bg.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, 10));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseClicked
        //Ir a la interfaz principal
    }//GEN-LAST:event_botonExitMouseClicked

    private void labelTurnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTurnoMouseEntered
        labelTurno.setForeground(new Color(0,153,81));
        labelMenuSemanal.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_labelTurnoMouseEntered

    private void labelTurnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTurnoMouseExited
         labelMenuSemanal.setForeground(new Color(0,153,81));
        labelTurno.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_labelTurnoMouseExited

    private void labelTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTurnoMouseClicked
        // REDIRIGIR A INTERFAZ DE RESERVAR MENU
    }//GEN-LAST:event_labelTurnoMouseClicked

    private void botonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Principal(new Usuario()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraPane;
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
    private javax.swing.JLabel labelTurno;
    private javax.swing.JLabel labelUCV;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JScrollPane scrollPaneMenu;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    // End of variables declaration//GEN-END:variables
}

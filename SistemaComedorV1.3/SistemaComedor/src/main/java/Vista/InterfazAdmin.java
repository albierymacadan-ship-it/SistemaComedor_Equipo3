package Vista;
import Controlador.FuncionesAdministrador;
import Controlador.ArchivosMenu;
import Modelo.Administrador;
import Modelo.Menu;
import Modelo.Plato;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InterfazAdmin extends javax.swing.JFrame {
    
    Administrador admin;
    FuncionesAdministrador accion;
    Menu menu;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazAdmin.class.getName());

   
    public InterfazAdmin(Usuario usuario) {
        
       admin = new Administrador(usuario);
       menu = new Menu();
       initComponents(); 
       //Precargar el Menu para validaciones de escritura(Agregar menus)
       ArchivosMenu.leerMenu(menu, (ArrayList<Plato>) menu.platos);
        // Esto centra la ventana en tu pantalla
        this.setLocationRelativeTo(null); 
        this.setTitle("Panel de Administrador: " + usuario.getNombre());
        
         if (scrollPaneMenu != null) {
        scrollPaneMenu.getVerticalScrollBar().setUnitIncrement(20);
        }
    }
    
    public void previsualizarMenu(InterfazAdmin interfaz, Administrador admin, Menu objetoMenu){
    //Crear contenedor
    JPanel contenedor = new JPanel();
    
    // Layaut vertical para que las tarjetas se apilen hacia abajo
    contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
    contenedor.setBackground(new Color(245, 245, 245)); // Gris claro 

    // Recorrer la lista de platos que tiene el menu
    for (Plato p : objetoMenu.platos){
        // Creamos una instancia de nuestra tarjeta personalizada
        PanelPlatoAdmin tarjeta = new PanelPlatoAdmin(p,menu.costo,interfaz);
        
        // Añadir la tarjeta al contenedor
        contenedor.add(tarjeta);
        
        // separar las los contenedores entre cada tarjeta
        contenedor.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    //  Meter todo el contenedor dentro del ScrollPane
    interfaz.scrollPaneMenu.setViewportView(contenedor);

    //  Refrescar para que aparezca en pantalla
    contenedor.revalidate();
    contenedor.repaint();
}
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        panelGestion = new javax.swing.JPanel();
        lbIDplato = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lbCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lbDesayuno = new javax.swing.JLabel();
        lbAlmuerzo = new javax.swing.JLabel();
        lbPostre = new javax.swing.JLabel();
        txtDesayuno = new javax.swing.JTextField();
        txtAlmuerzo = new javax.swing.JTextField();
        txtPostre = new javax.swing.JTextField();
        lbDia = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnAgregarMenu = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        PanelControlCostos = new javax.swing.JPanel();
        lbFCF = new javax.swing.JLabel();
        txtCostoFijo = new javax.swing.JTextField();
        lbCV = new javax.swing.JLabel();
        txtCostoVar = new javax.swing.JTextField();
        btnActualizarCostos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPaneMenu = new javax.swing.JScrollPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interfaz Administrador");
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 640));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(610, 600));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGestion.setBackground(new java.awt.Color(204, 204, 204));
        panelGestion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Gestión de menú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18)))); // NOI18N
        panelGestion.setToolTipText("");

        lbIDplato.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbIDplato.setText("ID Plato:");
        lbIDplato.setToolTipText("");

        txtID.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtID.setToolTipText("");
        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbCantidad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbCantidad.setText("Cantidad:");
        lbCantidad.setToolTipText("");

        txtCantidad.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCantidad.setToolTipText("");
        txtCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbDesayuno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbDesayuno.setText("Desayuno:");
        lbDesayuno.setToolTipText("");

        lbAlmuerzo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbAlmuerzo.setText("Almuerzo:");
        lbAlmuerzo.setToolTipText("");

        lbPostre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbPostre.setText("Postre:");
        lbPostre.setToolTipText("");

        txtDesayuno.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtDesayuno.setToolTipText("");
        txtDesayuno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtAlmuerzo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAlmuerzo.setToolTipText("");
        txtAlmuerzo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAlmuerzo.addActionListener(this::txtAlmuerzoActionPerformed);

        txtPostre.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPostre.setToolTipText("");
        txtPostre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbDia.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbDia.setText("Día:");
        lbDia.setToolTipText("");

        txtDia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtDia.setToolTipText("");
        txtDia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbFecha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbFecha.setText("Fecha:");
        lbFecha.setToolTipText("");

        txtFecha.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFecha.setToolTipText("");
        txtFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtFecha.addActionListener(this::txtFechaActionPerformed);

        btnAgregarMenu.setBackground(new java.awt.Color(0, 151, 83));
        btnAgregarMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAgregarMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMenu.setText("Agregar al Menú");
        btnAgregarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarMenu.addActionListener(this::btnAgregarMenuActionPerformed);

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Plato");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnEliminar1.setBackground(new java.awt.Color(255, 204, 0));
        btnEliminar1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEliminar1.setText("Previsualizar");
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseExited(evt);
            }
        });
        btnEliminar1.addActionListener(this::btnEliminar1ActionPerformed);

        javax.swing.GroupLayout panelGestionLayout = new javax.swing.GroupLayout(panelGestion);
        panelGestion.setLayout(panelGestionLayout);
        panelGestionLayout.setHorizontalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addComponent(lbIDplato)
                        .addGap(11, 11, 11)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lbDesayuno)
                        .addGap(1, 1, 1)
                        .addComponent(txtDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addComponent(lbCantidad)
                        .addGap(6, 6, 6)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lbAlmuerzo)
                        .addGap(2, 2, 2)
                        .addComponent(txtAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addComponent(lbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(lbPostre)
                        .addGap(20, 20, 20)
                        .addComponent(txtPostre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addComponent(btnAgregarMenu)
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelGestionLayout.setVerticalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIDplato)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDesayuno)
                    .addComponent(txtDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlmuerzo)
                    .addComponent(txtAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDia)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPostre)
                    .addComponent(txtPostre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        bg.add(panelGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 264, -1, -1));

        PanelControlCostos.setBackground(new java.awt.Color(204, 204, 204));
        PanelControlCostos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Gentión de costos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18)))); // NOI18N

        lbFCF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbFCF.setText("Costos Fijos:");

        lbCV.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbCV.setText("Costos Variables:");

        txtCostoVar.addActionListener(this::txtCostoVarActionPerformed);

        btnActualizarCostos.setBackground(new java.awt.Color(0, 151, 83));
        btnActualizarCostos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnActualizarCostos.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCostos.setText("Actualizar Costos");
        btnActualizarCostos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCostos.addActionListener(this::btnActualizarCostosActionPerformed);

        javax.swing.GroupLayout PanelControlCostosLayout = new javax.swing.GroupLayout(PanelControlCostos);
        PanelControlCostos.setLayout(PanelControlCostosLayout);
        PanelControlCostosLayout.setHorizontalGroup(
            PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlCostosLayout.createSequentialGroup()
                .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelControlCostosLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbCV))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelControlCostosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbFCF)))
                .addGap(18, 18, 18)
                .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCostoVar, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(txtCostoFijo))
                .addGap(46, 46, 46)
                .addComponent(btnActualizarCostos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelControlCostosLayout.setVerticalGroup(
            PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlCostosLayout.createSequentialGroup()
                .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelControlCostosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFCF)
                            .addComponent(txtCostoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCV)
                            .addComponent(txtCostoVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelControlCostosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnActualizarCostos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        bg.add(PanelControlCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 55, -1, -1));

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Cerrar Sesión");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        bg.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 125, 37));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 236, 523, 10));

        scrollPaneMenu.setBackground(new java.awt.Color(204, 204, 204));
        scrollPaneMenu.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Previsualización de menú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18)))); // NOI18N
        bg.add(scrollPaneMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 420, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCostosActionPerformed
        // TODO add your handling code here:
        try {
    // Tomamos los números de las cajitas
    int fijos = Integer.parseInt(txtCostoFijo.getText());
    int variables = Integer.parseInt(txtCostoVar.getText());
    
    // Le pedimos a la clase CCB que los guarde
    admin.getCostos().setCF(fijos);
    admin.getCostos().setCV(variables);
    menu.costo.setCF(fijos);
    menu.costo.setCV(variables);
            
    javax.swing.JOptionPane.showMessageDialog(this, "¡Costos actualizados correctamente!");
        } catch (NumberFormatException e) {
          javax.swing.JOptionPane.showMessageDialog(this, "Error: Por favor introduce solo números enteros.");
}
    }//GEN-LAST:event_btnActualizarCostosActionPerformed

    private void txtCostoVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoVarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtAlmuerzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlmuerzoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlmuerzoActionPerformed

    private void btnAgregarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMenuActionPerformed
       
        try {
    //Plato que se cargara al menu
    Plato nuevo = new Plato();
    nuevo.setID(txtID.getText());
    nuevo.setCantidad(Integer.parseInt(txtCantidad.getText()));
    nuevo.setDesayuno(txtDesayuno.getText());
    nuevo.setAlmuerzo(txtAlmuerzo.getText());
    nuevo.setPostre(txtPostre.getText());
    nuevo.setDiaSemana(txtDia.getText());
    nuevo.setFecha(txtFecha.getText());
    //Reusamos la funcion escribir en menu de los menus
    
        boolean existe = false;
        for (Plato cargado : menu.platos) {
            // Validamos de que no hayan platos repetidos(identicos puede haber el mismo menu en diferentes fechas)
            if (cargado.getID().equalsIgnoreCase(nuevo.getID()) && 
                cargado.getFecha().equals(nuevo.getFecha())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            //Si el elemento ya no existe entoces añado el menu
            //Asi se evitan añadir elementos duplicados
           ArchivosMenu.agregarMenuArchivo(admin.getDatos(), nuevo);
        }
    
    javax.swing.JOptionPane.showMessageDialog(this, "Plato guardado en el ");
    
    //Restablesco los valores para que los formularios queden limpios
    txtID.setText("");
    txtAlmuerzo.setText("");
        } catch (HeadlessException | NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Revisa que el ID y la Cantidad sean correctos.");
          }
    }//GEN-LAST:event_btnAgregarMenuActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        new Vista.Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        accion.EliminarPlato(this,txtID.getText());
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(Color.red);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(Color.red);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnEliminar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1MouseEntered

    private void btnEliminar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1MouseExited

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        ArchivosMenu.leerMenu(menu, (ArrayList<Plato>) menu.platos);
        previsualizarMenu(this, admin, menu);
    }//GEN-LAST:event_btnEliminar1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelControlCostos;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnActualizarCostos;
    private javax.swing.JButton btnAgregarMenu;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAlmuerzo;
    private javax.swing.JLabel lbCV;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbDesayuno;
    private javax.swing.JLabel lbDia;
    private javax.swing.JLabel lbFCF;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbIDplato;
    private javax.swing.JLabel lbPostre;
    private javax.swing.JPanel panelGestion;
    public javax.swing.JScrollPane scrollPaneMenu;
    private javax.swing.JTextField txtAlmuerzo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCostoFijo;
    private javax.swing.JTextField txtCostoVar;
    private javax.swing.JTextField txtDesayuno;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPostre;
    // End of variables declaration//GEN-END:variables
}

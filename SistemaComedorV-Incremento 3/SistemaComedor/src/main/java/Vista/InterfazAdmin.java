package Vista;
import Controlador.FuncionesAdministrador;
import Controlador.ArchivosMenu;
import static Controlador.ManejoImagenes.AutenticacionFacial;
import static Controlador.ManejoImagenes.cargarImagen;
import static Controlador.ManejoImagenes.cargarUsuarioImagen;
import static Controlador.UserConfig.actUser;
import Modelo.Administrador;
import Modelo.Menu;
import Modelo.Plato;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfazAdmin extends javax.swing.JFrame {
    
    public String ruta;
    Administrador admin;
    FuncionesAdministrador accion;
    Menu menu;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazAdmin.class.getName());

   
    public InterfazAdmin(Usuario usuario) {
        
       admin = new Administrador(usuario);
       menu = new Menu();
       initComponents(); 
       this.setSize(980,610);
       //Precargar el Menu para validaciones de escritura(Agregar menus)
       ArchivosMenu.leerMenu(menu, (ArrayList<Plato>) menu.platos);
        // Esto centra la ventana en tu pantalla
        this.setLocationRelativeTo(null); 
        this.setTitle("Panel de Administrador: " + usuario.getNombre());
        
         if (scrollPaneMenu != null) {
        scrollPaneMenu.getVerticalScrollBar().setUnitIncrement(20);
        }
    }
    
    private void setRuta(String nuevaruta){
    this.ruta = nuevaruta;
    }
    
    private String getRuta(){
    return this.ruta;
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
        scrollPaneMenu = new javax.swing.JScrollPane();
        panelGestioUsuario = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        textCI = new javax.swing.JTextField();
        bExonerado = new javax.swing.JButton();
        lbScan = new javax.swing.JLabel();
        botonBecario1 = new javax.swing.JButton();
        bExonerado1 = new javax.swing.JButton();
        botonBecario = new javax.swing.JButton();
        textTarifa = new javax.swing.JTextField();
        lbTarifa = new javax.swing.JLabel();

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
        setPreferredSize(new java.awt.Dimension(1000, 750));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 750));

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setPreferredSize(new java.awt.Dimension(1000, 750));

        panelGestion.setBackground(new java.awt.Color(153, 153, 153));
        panelGestion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de menú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(18, 18, 18)
                        .addComponent(txtPostre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnAgregarMenu)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116))
        );
        panelGestionLayout.setVerticalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(18, 18, 18)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDia)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPostre)
                        .addComponent(txtPostre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        PanelControlCostos.setBackground(new java.awt.Color(153, 153, 153));
        PanelControlCostos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de costos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

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
            .addGroup(PanelControlCostosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCV)
                    .addComponent(lbFCF, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCostoVar)
                    .addComponent(txtCostoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarCostos)
                .addGap(30, 30, 30))
        );
        PanelControlCostosLayout.setVerticalGroup(
            PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlCostosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelControlCostosLayout.createSequentialGroup()
                        .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFCF)
                            .addComponent(txtCostoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelControlCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCV)
                            .addComponent(txtCostoVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelControlCostosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnActualizarCostos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        scrollPaneMenu.setBackground(new java.awt.Color(204, 204, 204));
        scrollPaneMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Previzualización de menú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

        panelGestioUsuario.setBackground(new java.awt.Color(153, 153, 153));
        panelGestioUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
        panelGestioUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setText("Escanear Usuario");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        panelGestioUsuario.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        textCI.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textCI.addActionListener(this::textCIActionPerformed);
        panelGestioUsuario.add(textCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 116, -1));

        bExonerado.setBackground(new java.awt.Color(0, 153, 81));
        bExonerado.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bExonerado.setForeground(new java.awt.Color(255, 255, 255));
        bExonerado.setText("Agregar Exonerado");
        bExonerado.addActionListener(this::bExoneradoActionPerformed);
        panelGestioUsuario.add(bExonerado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        lbScan.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbScan.setText("Cedula (necesario para todas las funcionalidades)");
        panelGestioUsuario.add(lbScan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 280, -1));

        botonBecario1.setBackground(new java.awt.Color(255, 51, 51));
        botonBecario1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonBecario1.setForeground(new java.awt.Color(255, 255, 255));
        botonBecario1.setText("Eliminar Becario");
        botonBecario1.setToolTipText("");
        botonBecario1.addActionListener(this::botonBecario1ActionPerformed);
        panelGestioUsuario.add(botonBecario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 143, -1));

        bExonerado1.setBackground(new java.awt.Color(255, 51, 51));
        bExonerado1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bExonerado1.setForeground(new java.awt.Color(255, 255, 255));
        bExonerado1.setText("Eliminar Exonerado");
        bExonerado1.addActionListener(this::bExonerado1ActionPerformed);
        panelGestioUsuario.add(bExonerado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        botonBecario.setBackground(new java.awt.Color(0, 153, 81));
        botonBecario.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonBecario.setForeground(new java.awt.Color(255, 255, 255));
        botonBecario.setText("Agregar Becario");
        botonBecario.addActionListener(this::botonBecarioActionPerformed);
        panelGestioUsuario.add(botonBecario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 143, -1));

        textTarifa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        textTarifa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTarifa.addActionListener(this::textTarifaActionPerformed);
        panelGestioUsuario.add(textTarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 120, -1));

        lbTarifa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbTarifa.setText("Tarifa(Solo para funcinalidad de becarios)");
        panelGestioUsuario.add(lbTarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelControlCostos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGestioUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneMenu))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(panelGestioUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(PanelControlCostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelGestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void bExoneradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExoneradoActionPerformed
        //Validamos la entrada
        if(textCI.getText().matches("^[1-9][0-9]{7,}$")){
            //Proceder a agregarlo a exonerado
            Usuario usuarioModificado = new Usuario();
           int rol = cargarUsuarioImagen(textCI.getText(), usuarioModificado);
           
           //Ahora verificamos que en efecto sea un estudiante
           if(rol == 1 && usuarioModificado.getTipo().equals("Estudiante")){
               
               //Actualizamos el tipo
               usuarioModificado.setTipo("Exonerado");
               
               //Actualizamos el estado del usuario
               actUser(usuarioModificado);
               JOptionPane.showMessageDialog(this,"El usuario " + textCI.getText() + " se ha vuelto Exonerado con exito ");
               textCI.setText("");
               textTarifa.setText("");
           }
           
           //Si en efecto esta en DB pero no es un estudiante
           else{
               JOptionPane.showMessageDialog(this, """
                                                   La cedula ingresada no pertenece a un estudiante 
                                                   por lo que no puede ser ni exonerado ni becario""");
           }
        }
        else{
            JOptionPane.showMessageDialog(this,"Debes añadir un formato valido de cedula\n minimo 8 digitos y no puede empezar con 0");
        }
    }//GEN-LAST:event_bExoneradoActionPerformed

    private void textCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCIActionPerformed

    private void bExonerado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExonerado1ActionPerformed
        //Validamos la entrada
        if(textCI.getText().matches("^[1-9][0-9]{7,}$")){
            //Proceder a agregarlo a exonerado
            Usuario usuarioModificado = new Usuario();
           int rol = cargarUsuarioImagen(textCI.getText(), usuarioModificado);
           
           //Ahora verificamos que en efecto sea un estudiante
           if(rol == 1 && usuarioModificado.getTipo().equals("Exonerado")){
               
               //Actualizamos el tipo
               usuarioModificado.setTipo("Estudiante");
               
               //Actualizamos el estado del usuario
               actUser(usuarioModificado);
               JOptionPane.showMessageDialog(this,"El usuario " + textCI.getText() + "se ha eliminado de los Exonerados con exito ");
               textCI.setText("");
               textTarifa.setText("");
           }
           
           //Si en efecto esta en DB pero no es un estudiante
           else{
               JOptionPane.showMessageDialog(this, """
                                                   La cedula ingresada no pertenece a un Exonerado 
                                                   por lo que no puedes modificar su estado""");
           }
        }
        else{
            JOptionPane.showMessageDialog(this,"Debes añadir un formato valido de cedula\n minimo 8 digitos y no puede empezar con 0");
        }
    }//GEN-LAST:event_bExonerado1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Que el campo no este vacio
        if(textCI.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Debes agregar la cedula del usuario que deseas verificar");
        }
        else if(textCI.getText().matches("^[1-9][0-9]{7,}$")){
            String rutaObtenida = cargarImagen();
            if(rutaObtenida != null){
                setRuta(rutaObtenida);           
            }
            else{
                JOptionPane.showMessageDialog(this,"Debes seleccionar un archivo con fomato valido");
            }
                try {
                    int res = AutenticacionFacial(textCI.getText(),getRuta());
                    
                    //El unico resultado valido es 1 (La imagen cargada coincide con la DB)
                    switch (res) {
                        case 1 -> JOptionPane.showMessageDialog(this, "La imagen del usuario coincide, autenticación aprobada");
                        case 2 -> JOptionPane.showMessageDialog(this, "El usuario no tiene una foto cargada, autenticación denegada");
                        case 3 -> JOptionPane.showMessageDialog(this, "No se cargo una imagen, vuelvalo a intentar");
                        default -> JOptionPane.showMessageDialog(this, "La imagen no coincide con la de su perfil, autenticación denegada");
                    }
                } 
                catch (IOException ex) {
                    System.getLogger(LoginFaceID.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
        }
        else{
            JOptionPane.showMessageDialog(this,"Debes añadir un formato valido de cedula\n minimo 8 digitos y no puede empezar con 0");
        }
        
                
       
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonBecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBecarioActionPerformed
        //Validamos la entrada
        if(textCI.getText().matches("^[1-9][0-9]{7,}$")){
            //Esta expresion regular valida que el numero sea > 0 y < 25(Porcentaje minimo para los estudiantes)
            if(textTarifa.getText().matches("^([1-9]|1[0-9]|2[0-4])$")){
                //Proceder a agregarlo a exonerado
                Usuario usuarioModificado = new Usuario();
               int rol = cargarUsuarioImagen(textCI.getText(), usuarioModificado);

               //Ahora verificamos que en efecto sea un estudiante
               if(rol == 1 && usuarioModificado.getTipo().equals("Estudiante")){

                   //Actualizamos el tipo
                   usuarioModificado.setTipo("Becario");
                           FuncionesAdministrador.guardarBecario(menu.dato.getBecarios(),usuarioModificado.getCedula(),Float.parseFloat(textTarifa.getText().trim()));
                   //Actualizamos el estado del usuario
                   actUser(usuarioModificado);
                   textCI.setText("");
                   textTarifa.setText("");
                   JOptionPane.showMessageDialog(this,"El usuario " + textCI.getText() + " se ha vuelto Becario con exito ");
               }

               //Si en efecto esta en DB pero no es un estudiante
               else{
                   JOptionPane.showMessageDialog(this, """
                                                       La cedula ingresada no pertenece a un estudiante 
                                                       por lo que no puede ser ni exonerado ni becario""");
               }
           }
            else{
                    JOptionPane.showMessageDialog(this,"Debes añadir un formato valido de tarifa un numero entero positivo mayor a 0 y menor a 25");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Debes añadir un formato valido de cedula\n minimo 8 digitos y no puede empezar con 0");
        }
    }//GEN-LAST:event_botonBecarioActionPerformed

    private void botonBecario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBecario1ActionPerformed
        //Validamos la entrada
        if(textCI.getText().matches("^[1-9][0-9]{7,}$")){
            //Proceder a agregarlo a exonerado
            Usuario usuarioModificado = new Usuario();
           int rol = cargarUsuarioImagen(textCI.getText(), usuarioModificado);
           
           //Ahora verificamos que en efecto sea un estudiante
           if(rol == 1 && usuarioModificado.getTipo().equals("Becario")){
               
               //Actualizamos el tipo
               usuarioModificado.setTipo("Estudiante");
               
               //Actualizamos el estado del usuario
               if(FuncionesAdministrador.eliminarBecario(menu.dato.getBecarios(),usuarioModificado.getCedula())){
               actUser(usuarioModificado);
               JOptionPane.showMessageDialog(this,"El usuario " + textCI.getText() + " se ha eliminado de los Becario con exito ");
               textCI.setText("");
               textTarifa.setText("");
               }
           }
           
           //Si en efecto esta en DB pero no es un estudiante
           else{
               JOptionPane.showMessageDialog(this, """
                                                   La cedula ingresada no pertenece a un Becario 
                                                   por lo que no puedes modificar su estado""");
           }
        }
        else{
            JOptionPane.showMessageDialog(this,"Debes añadir un formato valido de cedula\n minimo 8 digitos y no puede empezar con 0");
        }
    }//GEN-LAST:event_botonBecario1ActionPerformed

    private void textTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTarifaActionPerformed

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(() -> new InterfazAdmin(new Usuario()).setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelControlCostos;
    private javax.swing.JButton bExonerado;
    private javax.swing.JButton bExonerado1;
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonBecario;
    private javax.swing.JButton botonBecario1;
    private javax.swing.JButton btnActualizarCostos;
    private javax.swing.JButton btnAgregarMenu;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlmuerzo;
    private javax.swing.JLabel lbCV;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbDesayuno;
    private javax.swing.JLabel lbDia;
    private javax.swing.JLabel lbFCF;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbIDplato;
    private javax.swing.JLabel lbPostre;
    private javax.swing.JLabel lbScan;
    private javax.swing.JLabel lbTarifa;
    private javax.swing.JPanel panelGestioUsuario;
    private javax.swing.JPanel panelGestion;
    public javax.swing.JScrollPane scrollPaneMenu;
    private javax.swing.JTextField textCI;
    private javax.swing.JTextField textTarifa;
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

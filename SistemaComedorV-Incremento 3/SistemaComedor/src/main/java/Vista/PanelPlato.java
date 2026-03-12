
package Vista;

import static Controlador.UserConfig.actUser;
import Modelo.CCB;
import static Modelo.CCB.calcularBecarioCCB;
import Modelo.Plato;
import static Modelo.CCB.calcularCCB;
import Modelo.Usuario;
import java.awt.Color;
import javax.swing.JOptionPane;



public class PanelPlato extends javax.swing.JPanel {
    
private final Plato plato;
private final Usuario usuario;
private final CCB costoBandeja;
private final Principal modificador;
private boolean reservado = false;

float costo;
String Scosto;

public PanelPlato(Plato platoRecibido, Usuario actual , CCB x, Principal ventana) {
    this.usuario = actual;
    this.plato = platoRecibido;
    this.costoBandeja = x;
    this.modificador = ventana;
    
    if(usuario.getTipo().equals("Becario")){
    costo = calcularBecarioCCB(costoBandeja,plato,usuario);
    }
    else{
    costo = calcularCCB(costoBandeja,plato,usuario.getTipo());
    }
    initComponents();
    if(actual.getTipo().equals("Exonerado")){
        lbCosto.setText("Exonerado");
    }
}


public void realizarCambioMonedero(Principal ventanaPrincipal, float valor){
ventanaPrincipal.actualizarMonedero(valor);
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDiaSemana = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonReserva = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaMenu = new javax.swing.JTextArea();
        lbCosto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbDiaSemana.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbDiaSemana.setForeground(new java.awt.Color(0, 153, 81));
        lbDiaSemana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiaSemana.setText(plato.getDiaSemana());

        lbFecha.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText(plato.getFecha());

        botonReserva.setBackground(new java.awt.Color(153, 153, 153));
        botonReserva.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        botonReserva.setForeground(new java.awt.Color(255, 255, 255));
        botonReserva.setText("Reservar");
        botonReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonReservaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonReservaMouseExited(evt);
            }
        });
        botonReserva.addActionListener(this::botonReservaActionPerformed);

        areaMenu.setBackground(new java.awt.Color(204, 204, 204));
        areaMenu.setColumns(20);
        areaMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        areaMenu.setRows(5);
        jScrollPane4.setViewportView(areaMenu);
        areaMenu.setText("\n\n   Desayuno: " + plato.getDesayuno() +
            " \n\n   Almuerzo: " + plato.getAlmuerzo() + " \n\n   Postre: "
            + plato.getPostre());

        lbCosto.setBackground(new java.awt.Color(0, 0, 0));
        lbCosto.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbCosto.setForeground(new java.awt.Color(102, 102, 102));
        lbCosto.setText("Costo: " + String.format("%.2f", costo));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                        .addComponent(botonReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(lbCosto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lbCosto)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReservaActionPerformed
        if(reservado == false){
            
            //Si el usuario es exonerado solo se hace la reserva
            if(usuario.getTipo().equals("Exonerado")){
                usuario.setTurno(true);
                modificador.registro.insertToLog(usuario, plato);
                actUser(usuario);
                //se modifica la cantidad de platos
                int Ncantidad = plato.getCantidad();
                plato.setCantidad(Ncantidad - 1);
                botonReserva.setBackground(new Color(0,153,81));
                botonReserva.setForeground(Color.white);
                botonReserva.setText("Reservado");
                reservado = true;
            }
            
            //Si no lo es funciona como antes
            else if(usuario.getMonedero() > costo){
                //se descuenta el dinero
                usuario.setMonedero(usuario.getMonedero() - costo);
                usuario.setTurno(true);
                realizarCambioMonedero(modificador ,usuario.getMonedero());
                modificador.registro.insertToLog(usuario,plato);
                actUser(usuario);
                //se modifica la cantidad de platos
                int Ncantidad = plato.getCantidad();
                plato.setCantidad(Ncantidad - 1);
                botonReserva.setBackground(new Color(0,153,81));
                botonReserva.setForeground(Color.white);
                botonReserva.setText("Reservado");
                reservado = true;
            }else{
            JOptionPane.showMessageDialog(null,"No tienes suficiente dinero en el monedero para reservar");
            }
        }
       else if(reservado == true){
            
            usuario.setMonedero(usuario.getMonedero() + costo);
                realizarCambioMonedero(modificador ,usuario.getMonedero());
                usuario.setTurno(false);
                modificador.registro.insertToLog(usuario,plato);
                actUser(usuario);
                //se modifica la cantidad de platos
                int Ncantidad = plato.getCantidad();
                plato.setCantidad(Ncantidad + 1);
                botonReserva.setBackground(new Color(153,153,153));
                botonReserva.setForeground(Color.white);
                botonReserva.setText("Reservar");
                reservado = false;        
        }
    }//GEN-LAST:event_botonReservaActionPerformed

    private void botonReservaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReservaMouseEntered
        if(reservado == true){
            botonReserva.setBackground(Color.red);
            botonReserva.setText("Anular");
        }
        else if(reservado == false){
            botonReserva.setBackground(new Color(0,153,81));
        }
    }//GEN-LAST:event_botonReservaMouseEntered

    private void botonReservaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReservaMouseExited
        if(reservado == true){
            botonReserva.setBackground(new Color(0,153,81));
            botonReserva.setText("Reservado");
        }
        else if(reservado == false){
            botonReserva.setBackground(new Color(153,153,153));
        }
    }//GEN-LAST:event_botonReservaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMenu;
    private javax.swing.JButton botonReserva;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCosto;
    private javax.swing.JLabel lbDiaSemana;
    private javax.swing.JLabel lbFecha;
    // End of variables declaration//GEN-END:variables
}

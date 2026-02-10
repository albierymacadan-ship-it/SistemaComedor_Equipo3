
package Vista;

import Modelo.CCB;
import Modelo.Plato;
import static Modelo.CCB.calcularCCB;



public class PanelPlatoAdmin extends javax.swing.JPanel {

private Plato plato;
private CCB costoBandeja;
private InterfazAdmin modificador;

float costoEstudiante, costoProfesor, costoEmpleado;
String Scosto;

public PanelPlatoAdmin(Plato platoRecibido, CCB x, InterfazAdmin ventana) {
    this.plato = platoRecibido;
    this.costoBandeja = x;
    this.modificador = ventana;
    costoEstudiante = calcularCCB(costoBandeja,plato,"Estudiante");
    costoProfesor = calcularCCB(costoBandeja,plato,"Profesor");
    costoEmpleado = calcularCCB(costoBandeja,plato,"Empleado");
    initComponents();   
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDiaSemana = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaMenu = new javax.swing.JTextArea();
        lbCostoEstudiante = new javax.swing.JLabel();
        lbCostoProfesor = new javax.swing.JLabel();
        lbCostoProfesor1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbDiaSemana.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbDiaSemana.setForeground(new java.awt.Color(0, 153, 81));
        lbDiaSemana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiaSemana.setText(plato.getDiaSemana());

        lbFecha.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText(plato.getFecha());

        areaMenu.setBackground(new java.awt.Color(204, 204, 204));
        areaMenu.setColumns(20);
        areaMenu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        areaMenu.setRows(5);
        jScrollPane4.setViewportView(areaMenu);
        areaMenu.setText("\n ID: " + plato.getID() + "  Cantidad: " + plato.getCantidad() + "\n\n   Desayuno: " + plato.getDesayuno() +
            " \n\n   Almuerzo: " + plato.getAlmuerzo() + " \n\n   Postre: "
            + plato.getPostre());

        lbCostoEstudiante.setBackground(new java.awt.Color(0, 0, 0));
        lbCostoEstudiante.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbCostoEstudiante.setForeground(new java.awt.Color(102, 102, 102));
        lbCostoEstudiante.setText("Costo Estudiante " + String.format("%.2f", costoEstudiante));

        lbCostoProfesor.setBackground(new java.awt.Color(0, 0, 0));
        lbCostoProfesor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbCostoProfesor.setForeground(new java.awt.Color(102, 102, 102));
        lbCostoProfesor.setText("Costo Profesor " + String.format("%.2f", costoProfesor));

        lbCostoProfesor1.setBackground(new java.awt.Color(0, 0, 0));
        lbCostoProfesor1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbCostoProfesor1.setForeground(new java.awt.Color(102, 102, 102));
        lbCostoProfesor1.setText("Costo Empleado " + String.format("%.2f", costoEmpleado));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCostoProfesor)
                                    .addComponent(lbCostoEstudiante)
                                    .addComponent(lbCostoProfesor1)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCostoEstudiante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCostoProfesor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCostoProfesor1)))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMenu;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCostoEstudiante;
    private javax.swing.JLabel lbCostoProfesor;
    private javax.swing.JLabel lbCostoProfesor1;
    private javax.swing.JLabel lbDiaSemana;
    private javax.swing.JLabel lbFecha;
    // End of variables declaration//GEN-END:variables
}

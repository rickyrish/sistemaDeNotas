/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.conexiondb;

/**
 *
 * @author ricardo
 */
public class ingresoPromedio extends javax.swing.JFrame {
   String idalumno;
   String idCurso;
    /**
     * Creates new form ingresoPromedio
     */
    public ingresoPromedio(String idalumno,String idcurso) {
        initComponents();
        this.idCurso=idcurso;
        this.idalumno=idalumno;
        
          try {
            try
{
Class.forName("com.mysql.jdbc.Driver");
} catch (Exception e)
{
e.printStackTrace();
}
     Connection conexion = DriverManager.getConnection (
             "jdbc:mysql://"+conexiondb.getDbserver()+"/"+conexiondb.getDbname(),conexiondb.getDbuser(), conexiondb.getDbpass());
          Statement s = conexion.createStatement(); 
             ResultSet rs = s.executeQuery ("SELECT * FROM nota WHERE  `Alumno_idAlumno` ="+idalumno+" AND `Curso_idCurso` ="+idcurso+" LIMIT 0 , 1");
         
          
           
           
             while(rs.next()){
              sparcial.setValue(rs.getInt("parcial"));
              sfinal.setValue(rs.getInt("final"));
                 
             }
             
             
            
            
            
        s.close();
        conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(agregarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sparcial = new javax.swing.JSpinner();
        sfinal = new javax.swing.JSpinner();
        tpromedio = new javax.swing.JTextField();
        bguardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Examen Parcial:");

        jLabel2.setText("Examen Final:");

        jLabel3.setText("Promedio Final:");

        sparcial.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        sparcial.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sparcialStateChanged(evt);
            }
        });

        sfinal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        sfinal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sfinalStateChanged(evt);
            }
        });

        tpromedio.setEditable(false);

        bguardar.setText("Guardar");
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpromedio))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sparcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sparcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bguardar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tpromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sparcialStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sparcialStateChanged
        // TODO add your handling code here:
             // TODO add your handling code here:
         float p=Integer.parseInt(sparcial.getValue().toString());
        float f=Integer.parseInt(sfinal.getValue().toString());
        
       float pro=(p+f)/2;
       tpromedio.setText(""+pro);
    }//GEN-LAST:event_sparcialStateChanged

    private void sfinalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sfinalStateChanged
        // TODO add your handling code here:
               float p=Integer.parseInt(sparcial.getValue().toString());
        float f=Integer.parseInt(sfinal.getValue().toString());
        
       float pro=(p+f)/2;
       tpromedio.setText(""+pro);
    }//GEN-LAST:event_sfinalStateChanged

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        // TODO add your handling code here:
          try {
            try
{
Class.forName("com.mysql.jdbc.Driver");
} catch (Exception e)
{
e.printStackTrace();
}
     Connection conexion = DriverManager.getConnection (
             "jdbc:mysql://"+conexiondb.getDbserver()+"/"+conexiondb.getDbname(),conexiondb.getDbuser(), conexiondb.getDbpass());
          Statement s = conexion.createStatement(); 
         
          
            int executeUpdate = s.executeUpdate ("UPDATE `nota` SET  `parcial` =  "+sparcial.getValue().toString()+",`final` = "+sfinal.getValue().toString()+" "
                    + "WHERE `Alumno_idAlumno` ="+idalumno+" AND  `Curso_idCurso` ="+idCurso);
       
            if(executeUpdate==1){
                javax.swing.JOptionPane.showMessageDialog(null, "Se Actualizo la informacion");
            }else if(executeUpdate==0){
                javax.swing.JOptionPane.showMessageDialog(null, "Error!! no se puedo ingresar la información");
            }
        s.close();
        conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(modificarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bguardarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ingresoPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new ingresoPromedio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner sfinal;
    private javax.swing.JSpinner sparcial;
    private javax.swing.JTextField tpromedio;
    // End of variables declaration//GEN-END:variables
}

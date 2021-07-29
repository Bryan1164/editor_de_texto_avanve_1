/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrirarchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author 24DD018LA
 */
public class frm_abrirarchivos extends javax.swing.JFrame {
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;

    /**
     * Creates new form frm_abrirarchivos
     */
    public frm_abrirarchivos() {
        initComponents();
    }

    public String AbrirArchivo(File archivo){
        String documento ="";
        try{
        entrada = new FileInputStream(archivo);    
        int ascci;
        while((ascci=entrada.read())!=-1){
            char caracter =(char)ascci;
            documento+=caracter;
        }
        }catch(Exception e){
        }
        return documento;
    }
    
    public String GuardarArchivo(File Archivo,String documento){
    String mensaje =null ;
    try{
        salida = new FileOutputStream(archivo);
        byte[] bytxt=documento.getBytes();
        salida.write(bytxt);
        mensaje="Archivo Guardado";
    }catch(Exception ex){}
    return mensaje;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextPane();
        btn_guardar = new javax.swing.JButton();
        btn_abrirArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(txt_area);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save (1).png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_abrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/open2.png"))); // NOI18N
        btn_abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_abrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_abrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txt_area.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
             if(mensaje!=null){
                 JOptionPane.showMessageDialog(null, mensaje);
                }else{
                   JOptionPane.showMessageDialog(null,"Archivo No Compartible");
                }
            }else{
                 JOptionPane.showMessageDialog(null,"Guardar Documento de Texto ");
                }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirArchivoActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null,"Abrir")==JFileChooser.APPROVE_OPTION){
        archivo=seleccionar.getSelectedFile();
        if(archivo.canRead())   {
            if(archivo.getName().endsWith("txt")){
                String documento =AbrirArchivo(archivo);
                txt_area.setText(documento);
                }else{
                JOptionPane.showMessageDialog(null, "Archivo no Compartible");
                }
            }
        }
    }//GEN-LAST:event_btn_abrirArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_abrirarchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_abrirarchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_abrirarchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_abrirarchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_abrirarchivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrirArchivo;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txt_area;
    // End of variables declaration//GEN-END:variables
}

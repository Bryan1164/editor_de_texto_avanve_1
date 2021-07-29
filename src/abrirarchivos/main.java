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
public class main {
    
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
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
 

    public static void main(String[] args) {
        // TODO code application logic here
        frm_abrirarchivos ac = new frm_abrirarchivos();
        ac.setVisible(true);
   
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smpaint2d;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author pparrilla
 */
public class VentanaInternaCamara extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInternaCamara
     */
    private VentanaInternaCamara() {
        initComponents();
        camara = Webcam.getDefault();
        Dimension resoluciones[] = camara.getViewSizes();
        Dimension maxRes = resoluciones[resoluciones.length-1];
        camara.setViewSize(maxRes);
        if (camara != null) {
            WebcamPanel areaVisual = new WebcamPanel(camara);
            if (areaVisual!= null) {
                areaVisual.setFitArea(false);
                getContentPane().add(areaVisual, BorderLayout.CENTER);
                pack();
            }
            
        }
    }
    
    public static VentanaInternaCamara getInstance(){
        VentanaInternaCamara v = new VentanaInternaCamara();
        return (v.camara!=null?v:null);
    }
    
    public void close(){
        camara.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    Webcam camara = null;
}
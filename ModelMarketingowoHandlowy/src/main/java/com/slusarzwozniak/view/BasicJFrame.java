/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.view;

import com.slusarzwozniak.interfaces.IObserver;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Dominik
 */
public abstract class BasicJFrame extends javax.swing.JFrame implements IObserver{
    
    protected void setStyle() throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
}

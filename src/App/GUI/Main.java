/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.GUI;

import javax.swing.UIManager;

/**
 *
 * @author Phuc Toan
 */
public class Main {
    public static void main(String[] args) {
        new GiaoDienGUI().setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
    }
}

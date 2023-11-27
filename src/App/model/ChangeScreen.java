/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.model;

import App.GUI.AffineGUI;
import App.GUI.CaeserCipherGUI;
import App.GUI.HillGUI;
import App.GUI.RSA_GUI;
import App.GUI.SubstitutionGUI;
import App.GUI.VigenereGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Phuc Toan
 */
public class ChangeScreen {
    private JPanel pnRoot;
    private String kindSelected = "";
    private ArrayList<DanhMuc> list = null;

    public ChangeScreen(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void setView(JPanel pnItem, JLabel lblItem) {

        pnRoot.removeAll();
        pnRoot.setLayout(new BorderLayout());
        pnRoot.add(new CaeserCipherGUI());
        pnRoot.validate();
        pnRoot.repaint();
    }

    public void setEvent(ArrayList<DanhMuc> list) {
        this.list = list;
        for (DanhMuc item : list) {
            item.getLbl().addMouseListener(new LabelEvent(item.getKind(), item.getPn(), item.getLbl()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel pnItem;
        private JLabel lblItem;

        public LabelEvent(String kind, JPanel pnItem, JLabel lblItem) {
            this.kind = kind;
            this.pnItem = pnItem;
            this.lblItem = lblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Caesar Cipher":
                    node = new CaeserCipherGUI();
                    break;
                case "Affine":
                    node = new AffineGUI();
                    break;
                case "Substitution":
                    node = new SubstitutionGUI();
                    break;
                case "Vigenere":
                    node = new VigenereGUI();
                    break;
                case "Hill":
                    node = new HillGUI();
                    break;
                case "RSA":
                    node = new RSA_GUI();
                    break;
                default:
                    break;
            }
            pnRoot.removeAll();
            pnRoot.setLayout(new BorderLayout());
            pnRoot.add(node);
            pnRoot.validate();
            pnRoot.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            pnItem.setBackground(new Color(244,249,249));
            lblItem.setBackground(new Color(244,249,249));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pnItem.setBackground(new Color(244,249,249));
            lblItem.setBackground(new Color(244,249,249));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                pnItem.setBackground(new Color(204,242,244));
                lblItem.setBackground(new Color(204,242,244));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMuc item : list) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getPn().setBackground(new Color(244,249,249));
                item.getLbl().setBackground(new Color(244,249,249));
            } else {
                item.getPn().setBackground(new Color(204,242,244));
                item.getLbl().setBackground(new Color(204,242,244));
            }
        }
    }
}

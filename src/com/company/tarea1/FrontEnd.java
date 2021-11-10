package com.company.tarea1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {
    public FrontEnd(String titulo){
        super(titulo);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 300);
        super.setLayout(new GridLayout(8,2));
    }

    public void  build(){
        Implementacion letraNum = new Implementacion();

        //CREATE COMPONENTS
        JLabel lblMonto = new JLabel("Monto");
        JTextField txtMonto = new JTextField();

        JButton convertir = new JButton("Convertir");
        JButton borrar = new JButton("Borrar");


        convertir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String monto = txtMonto.getText();
                String Convertir = letraNum.Convertir(monto);
                JOptionPane.showMessageDialog(null, Convertir);
            }
        });

        borrar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMonto.setText("");
            }
        });

        //ADD INTO THE CONTAINER
        super.add(lblMonto);
        super.add(txtMonto);
        super.add(convertir);
        super.add(borrar);

    }
}

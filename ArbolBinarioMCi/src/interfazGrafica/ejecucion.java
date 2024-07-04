/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author macas
 */
public class ejecucion {
    
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("\nRecorrido PreOrden: ");
        //arbol.recorrerPreOrden();
        System.out.println("\nRecorrido InOrden: ");
        //arbol.recorrerInOrden();
        System.out.println("\nRecorrido PostOrden: ");
        //arbol.recorrerPostOrden();
        
        System.out.println("Eliminando nodo con valor de 17");
        //arbol.borrarNodo(17);
        
        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        VistaArbol panel = new VistaArbol(arbol);
        frame.add(panel, BorderLayout.CENTER);


        
        JPanel controlPanel = new JPanel();
        JTextField valorField = new JTextField(5);
        JTextField valorEliminarField = new JTextField(5);
        JButton addButton = new JButton("Añadir Nodo");
        JButton deleteButton = new JButton("Eliminar Nodo");
        JButton inButton = new JButton("InOrden");
        JButton inButton2 = new JButton("InOrden");
        JButton postButton = new JButton("postOrden");
        JButton preButton = new JButton("preOrden");
        JTextArea txtArea =  new JTextArea("");
        txtArea.setPreferredSize(new Dimension(200, 300));
        arbol.setViewTree(panel);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int valor = Integer.parseInt(valorField.getText());
                    arbol.agregarNodo(valor);
                    valorField.setText("");
                    panel.repaint();
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int valor = Integer.parseInt(valorEliminarField.getText());
                arbol.borrarNodo(valor);
                valorEliminarField.setText("");
                panel.repaint();
            }
        });
        
        
        inButton.addActionListener(e -> new Thread(() -> arbol.recorrerInOrden()).start());
        postButton.addActionListener(e -> new Thread(() -> arbol.recorrerPostOrden()).start());
        preButton.addActionListener(e -> new Thread(() -> arbol.recorrerPreOrden()).start());
        
        inButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                txtArea.setText(arbol.getAux());
            }
        });
        
        controlPanel.add(txtArea);
        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorField);
        controlPanel.add(addButton);
        controlPanel.add(inButton);
        controlPanel.add(inButton2);
        controlPanel.add(postButton);
        controlPanel.add(preButton);
        
        controlPanel.add(valorEliminarField);
        controlPanel.add(deleteButton);
        
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}



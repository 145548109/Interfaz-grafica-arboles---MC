package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ejecucion {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        VistaArbol panel = new VistaArbol(arbol);
        frame.add(panel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JTextField valorField = new JTextField(5);
        JButton addButton = new JButton("Añadir Nodo");
        JButton inButton = new JButton("InOrden");
        JButton postButton = new JButton("postOrden");
        JButton preButton = new JButton("preOrden");
        JTextField valorEliminarField = new JTextField(5);
        JButton deleteButton = new JButton("Eliminar Nodo");
        
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
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(valorEliminarField.getText());
                arbol.borrarNodo(valor);
                valorEliminarField.setText("");
                panel.repaint();
            }
        });

        inButton.addActionListener(e -> new Thread(() -> {
            arbol.recorrerInOrden();
        }).start());

        postButton.addActionListener(e -> new Thread(() -> {
            arbol.recorrerPostOrden();
        }).start());

        preButton.addActionListener(e -> new Thread(() -> {
            arbol.recorrerPreOrden();
        }).start());

        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorField);
        controlPanel.add(addButton);
        controlPanel.add(new JLabel("Eliminar:"));
        controlPanel.add(valorEliminarField);
        controlPanel.add(deleteButton);
        controlPanel.add(inButton);
        controlPanel.add(postButton);
        controlPanel.add(preButton);

        frame.add(controlPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}

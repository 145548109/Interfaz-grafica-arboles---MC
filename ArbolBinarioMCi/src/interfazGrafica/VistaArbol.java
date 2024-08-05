package interfazGrafica;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;

public class VistaArbol extends JPanel {

    private ArbolBinario arbol;
    private NodoArbol aux;
    private int radio = 20;
    private int verticalSeparation = 50;
    private JTextArea recorridoArea;

    // Define los colores
    private final Color circleColor = new Color(0, 100, 0); // Verde oscuro
    private final Color lineColor = new Color(139, 69, 19); // Café
    private final Color numberColor = Color.WHITE; // Blanco

    public VistaArbol(ArbolBinario arbol) {
        this.arbol = arbol;
        setLayout(new BorderLayout());
        
        recorridoArea = new JTextArea(5, 20);
        recorridoArea.setEditable(false);
        recorridoArea.setBorder(BorderFactory.createTitledBorder("Recorridos"));
        
        JScrollPane scrollPane = new JScrollPane(recorridoArea);
        add(scrollPane, BorderLayout.SOUTH); // Mueve el JTextArea más abajo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arbol.getNodoRaiz() != null) {
            dibujarNodo(g, arbol.getNodoRaiz(), getWidth() / 2, 30, getWidth() / 4, aux);
        }
    }

    private void dibujarNodo(Graphics g, NodoArbol nodo, int x, int y, int hSeparation, NodoArbol aux) {
        if (nodo == null) {
            return;
        }
        
        if (nodo.equals(aux)) {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(circleColor);
        }

        g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);

        g.setColor(numberColor);
        g.drawString(Integer.toString(nodo.valor), x - 6, y + 4);

        g.setColor(lineColor);
        if (nodo.getNodoIzquierdo() != null) {
            g.drawLine(x - radio, y + radio, x - hSeparation + radio, y + verticalSeparation - radio);
            dibujarNodo(g, nodo.getNodoIzquierdo(), x - hSeparation, y + verticalSeparation, hSeparation / 2, aux);
        }

        if (nodo.getNodoDerecho() != null) {
            g.drawLine(x + radio, y + radio, x + hSeparation - radio, y + verticalSeparation - radio);
            dibujarNodo(g, nodo.getNodoDerecho(), x + hSeparation, y + verticalSeparation, hSeparation / 2, aux);
        }
    }
    
    public void updateView(NodoArbol nodo){
        this.aux = nodo;        
        repaint();
    }
    
    public void actualizarRecorrido(String recorrido) {
        recorridoArea.setText(recorrido);
    }
}

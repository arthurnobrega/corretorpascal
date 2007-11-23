package gui;

/**
 * Esta classe contém métodos que serão utilizados para editar a 
 * visualização de todas as janelas do programa.
 * 
 * @author arthurthiago
 *
 */
public class Janelas {
	    
      /**
      * Centraliza na tela um diálogo, um frame ou outro container.
      * @param container O container.
      */
     public static void alinharContainer(java.awt.Container container) {
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         int componentWidth = container.getWidth();
         int componentHeight = container.getHeight();
         container.setBounds((screenSize.width - componentWidth) / 2, (screenSize.height
        		 - componentHeight) / 2, componentWidth, componentHeight);
     }	

}

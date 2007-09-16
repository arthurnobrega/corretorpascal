package gui;

/**
 * Esta classe cont�m m�todos que ser�o utilizados para editar a 
 * visualiza��o de todas as janelas do programa.
 * 
 * @author arthurthiago
 *
 */
public class Janelas {
	    
      /**
      * Centraliza na tela um di�logo, um frame ou outro container.
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

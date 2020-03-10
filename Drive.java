package Calc_rpn_package;

public class Drive {
	/**
     * The main entry point into the application.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
    	    public void run() {
                    Calculadora.criar_gui();
    	    } // run
    	});
        } // main
}
  

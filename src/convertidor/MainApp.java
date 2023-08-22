package convertidor;

import javax.swing.SwingUtilities;

public class MainApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            ConversorLogica conversorLogica = new ConversorLogica();
            ApiComunicador apiComunicador = new ApiComunicador();
            ConversorGUI conversorGUI = new ConversorGUI(conversorLogica, apiComunicador);
            conversorGUI.init();
        });

	}

}

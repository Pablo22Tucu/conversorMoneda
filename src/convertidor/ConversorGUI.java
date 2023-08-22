package convertidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField cantidadTextField;
	private JLabel resultadoLabel;
	public ConversorGUI(ConversorLogica conversorLogica, ApiComunicador apiComunicador) {
		final ConversorLogica finalConversorLogica = conversorLogica;
		setTitle("Conversor de Monedas con API");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLayout(new FlowLayout());

		conversorLogica = new ConversorLogica();
		String[] monedas = finalConversorLogica.getMonedas();

		JComboBox<String> deMoneda = new JComboBox<>(monedas);
		JComboBox<String> aMoneda = new JComboBox<>(monedas);
		JLabel de = new JLabel("De:");
		JLabel a = new JLabel("A:");
		JLabel cantidad = new JLabel("Cantidad:");
		cantidadTextField = new JTextField(8);
		JButton convertirButton = new JButton("Convertir");
		resultadoLabel = new JLabel();

		convertirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String monedaSeleccionada1 = (String) deMoneda.getSelectedItem();
				double cantidadSelec = Double.parseDouble(cantidadTextField.getText());
				String monedaSeleccionada2 = (String) aMoneda.getSelectedItem();

				double resultado = finalConversorLogica.convertirMonedas(monedaSeleccionada1, cantidadSelec, monedaSeleccionada2);
				String resultadoFormateado = String.format("%.2f", resultado);

				resultadoLabel.setText(cantidadSelec + " " + monedaSeleccionada1 + " son equivalentes a: " + resultadoFormateado + " " + monedaSeleccionada2);
			}
		});

		add(de);
		add(deMoneda);
		add(a);
		add(aMoneda);
		add(cantidad);
		add(cantidadTextField);
		add(convertirButton);
		add(resultadoLabel);
		
	}

	public void init() {
		setVisible(true);
	}
}

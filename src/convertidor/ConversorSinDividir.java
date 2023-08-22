//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URLEncoder;
//import java.text.DecimalFormat;
//import java.util.HashMap;
//import java.util.Map;
//import org.json.*;
//
//public class ConversorSinDividir extends JFrame {
//	private JTextField cantidadTextField;
//	private JLabel resultadoLabel;
//	// private ConversorLogica conversorLogica;
//
//	public ConversorSinDividir() {
//		setTitle("Conversor de Monedas con API");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(500, 300);
//		setLayout(new FlowLayout());
//
//		String[] monedas = { "AFGANI AFGANO", "ARIARY MALGACHE", "BAHT", "BALBOA", "BIRR ETÍOPE", "BITCOIN", "BOLÍVAR",
//				"BOLÍVAR SOBERANO (NUEVO)", "BOLIVIANO", "CEDI", "CHELÍN KENIANO", "CHELÍN SOMALÍ", "CHELÍN TANZANO",
//				"CHELÍN UGANDÉS", "COLÓN COSTARRICENSE", "CÓRDOBA ORO", "CORONA DANESA", "CORONA ISLANDESA",
//				"CORONA NORUEGA", "CORONA SUECA", "CZECH KORUNA", "DALASI", "DINAR", "DINAR ARGELINO", "DINAR BAREINÍ",
//				"DINAR IRAQUÍ", "DINAR JORDANO", "DINAR KUWAITÍ", "DINAR LIBIO", "DINAR SERBIO", "DINAR TUNECINO",
//				"DIRHAM DE EAU", "DÍRHAM MARROQUÍ", "DOBRA", "DÓLAR AUSTRALIANO", "DÓLAR BAHAMEÑO", "DÓLAR BELICEÑO",
//				"DÓLAR BERMUDEÑO", "DÓLAR CANADIENSE", "DÓLAR DE BARBADOS", "DÓLAR DE BRUNEI", "DÓLAR DE HONG KONG",
//				"DÓLAR DE ISLAS SALOMÓN", "DÓLAR DE LAS ISLAS CAYMAN", "DÓLAR DE NAMIBIA", "DÓLAR DE SINGAPUR",
//				"DÓLAR DE SURINAM", "DÓLAR DE TAIWÁN (NUEVO)", "DÓLAR DE TRINIDAD Y TOBAGO",
//				"DÓLAR DEL CARIBE ORIENTAL", "DÓLAR ESTADOUNIDENSE", "DÓLAR FIYIANO", "DÓLAR GUYANÉS",
//				"DÓLAR JAMAIQUINO", "DÓLAR LIBERIANO", "DÓLAR NEOZELANDÉS", "DÓLAR ZIMBABUENSE", "DONG", "DRAM ARMENIO",
//				"ESCUDO CABOVERDIANO", "EURO", "FLORÍN ANTILLANO NEERLANDÉS", "FLORÍN ARUBEÑO", "FORINTO HÚNGARO",
//				"FRANCO BURUNDÉS", "FRANCO CFA DE ÁFRICA CENTRAL", "FRANCO CFA DE ÁFRICA OCCIDENTAL", "FRANCO CFP",
//				"FRANCO COMORENSE", "FRANCO CONGOLEÑO", "FRANCO GUINEANO", "FRANCO RUANDÉS", "FRANCO SUIZO",
//				"FRANCO YIBUTIANO", "GOURDE", "GRIVNIA", "GUARANÍ", "KINA", "KIP LAOSIANO", "KUNA", "KWACHA MALAUÍ",
//				"KWACHA ZAMBIANO", "KWACHA ZAMBIANO (NUEVO)", "KWANZA ANGOLEÑO", "KYAT BIRMANO", "LARI", "LAT LETON",
//				"LEK", "LEMPIRA", "LEONE", "LEONE (NUEVO)", "LEU MOLDAVO", "LEU RUMANO", "LEV", "LIBRA DE GUERNESEY",
//				"LIBRA DE JERSEY", "LIBRA DE SANTA HELENA", "LIBRA EGIPCIA", "LIBRA ESTERLINA", "LIBRA GIBRALTAREÑA",
//				"LIBRA LIBANESA", "LIBRA MALVINENSE", "LIBRA MANESA", "LIBRA SIRIA", "LIBRA SUDANESA",
//				"LIBRA SURSUDANESA", "LILANGENI", "LIRA TURCA", "LITA LITUANA", "LOTI", "MANAT AZERBAIYANO",
//				"MANAT TURCOMANO", "MARCO BOSNIOHERZEGOVINO", "METICAL MOZAMBIQUEÑO", "NAIRA", "NAKFA",
//				"NGULTRUM BUTANÉS", "ORO GRAMO", "PA’ANGA", "PATACA", "PESO ARGENTINO", "PESO CHILENO",
//				"PESO COLOMBIANO", "PESO CONVERTIBLE", "PESO CUBANO", "PESO DOMINICANO", "PESO FILIPINO",
//				"PESO MEXICANO", "PESO URUGUAYO", "PLATA GRAMO", "PULA", "QUETZAL", "RAND", "REAL BRASILEÑO",
//				"RENMINBI", "RIAL IRANÍ", "RIAL OMANÍ", "RIAL YEMENÍ", "RIEL CAMBOYANO", "RINGGIT MALAYO",
//				"RIYAL CATARÍ", "RIYAL SAUDÍ", "RUBLO BIELORRUSO", "RUBLO BIELORRUSO (NUEVO)", "RUBLO RUSO",
//				"RUPIA DE MALDIVAS", "RUPIA DE MAURICIO", "RUPIA DE SEYCHELLES", "RUPIA DE SRI LANKA", "RUPIA INDIA",
//				"RUPIA INDONESIA", "RUPIA NEPALÍ", "RUPIA PAKISTANÍ", "SDR (DERECHO ESPECIAL DE RETIRO)",
//				"SÉQUEL (NUEVO)", "SOL (NUEVO)", "SOM", "SOM UZBEKO", "SOMONI", "TAKA", "TALA", "TENGE KAZAJO",
//				"TUGRIK", "UGUIYA", "UNIDAD DE FOMENTO", "VATU", "WON", "WON NORCOREANO", "YEN", "ZLOTY" };
//		String[] codigos = { "AFN", "MGA", "THB", "PAB", "ETB", "BTC", "VEF", "VES", "BOB", "GHS", "KES", "SOS", "TZS",
//				"UGX", "CRC", "NIO", "DKK", "ISK", "NOK", "SEK", "CZK", "GMD", "MKD", "DZD", "BHD", "IQD", "JOD", "KWD",
//				"LYD", "RSD", "TND", "AED", "MAD", "STD", "AUD", "BSD", "BZD", "BMD", "CAD", "BBD", "BND", "HKD", "SBD",
//				"KYD", "NAD", "SGD", "SRD", "TWD", "TTD", "XCD", "USD", "FJD", "GYD", "JMD", "LRD", "NZD", "ZWL", "VND",
//				"AMD", "CVE", "EUR", "ANG", "AWG", "HUF", "BIF", "XAF", "XOF", "XPF", "KMF", "CDF", "GNF", "RWF", "CHF",
//				"DJF", "HTG", "UAH", "PYG", "PGK", "LAK", "HRK", "MWK", "ZMK", "ZMW", "AOA", "MMK", "GEL", "LVL", "ALL",
//				"HNL", "SLE", "SLL", "MDL", "RON", "BGN", "GGP", "JEP", "SHP", "EGP", "GBP", "GIP", "LBP", "FKP", "IMP",
//				"SYP", "SDG", "SSP", "SZL", "TRY", "LTL", "LSL", "AZN", "TMT", "BAM", "MZN", "NGN", "ERN", "BTN", "XAU",
//				"TOP", "MOP", "ARS", "CLP", "COP", "CUC", "CUP", "DOP", "PHP", "MXN", "UYU", "XAG", "BWP", "GTQ", "ZAR",
//				"BRL", "CNY", "IRR", "OMR", "YER", "KHR", "MYR", "QAR", "SAR", "BYR", "BYN", "RUB", "MVR", "MUR", "SCR",
//				"LKR", "INR", "IDR", "NPR", "PKR", "XDR", "ILS", "PEN", "KGS", "UZS", "TJS", "BDT", "WST", "KZT", "MNT",
//				"MRO", "CLF", "VUV", "KRW", "KPW", "JPY", "PLN" };
//
//		Map<String, String> monedasCodigos = new HashMap<>();
//
//		for (int i = 0; i < monedas.length; i++) {
//			monedasCodigos.put(monedas[i], codigos[i]);
//		}
//
//		JComboBox<String> deMoneda = new JComboBox<>(monedas);
//		JComboBox<String> aMoneda = new JComboBox<>(monedas);
//		JLabel de = new JLabel("De:");
//		JLabel a = new JLabel("A:");
//		JLabel cantidad = new JLabel("Cantidad:");
//		cantidadTextField = new JTextField(8);
//		JButton convertirButton = new JButton("Convertir");
//		resultadoLabel = new JLabel("");
//		// conversorLogica = new ConversorLogica();
//
//		convertirButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String monedaSeleccionada1 = (String) deMoneda.getSelectedItem();
//				double cantidadSelec = Double.parseDouble(cantidadTextField.getText());
//				String monedaSeleccionada2 = (String) aMoneda.getSelectedItem();
//				String monedaBase = monedasCodigos.get(monedaSeleccionada1);
//				String monedaConvertir = monedasCodigos.get(monedaSeleccionada2);
//				double resultado = 0.0;
//				String resultadoFormateado = "";
//
//				if (cantidadSelec != 0) {
//					System.out.println("codigo 1: " + monedaBase + " contidad: " + cantidadSelec + " codigo 2: "
//							+ monedaConvertir);
//				} else {
//					System.out.println("El string buscado no se encontró en el array.");
//				}
//
//				if (cantidadSelec != 0) {
//					try {
//						String baseUrl = "http://api.exchangeratesapi.io/v1/latest";
//						String apiKey = "033cb3ff9dcaf315c457856ec5daaea4";
//						String symbols = monedaBase.concat(",").concat(monedaConvertir);
//
//						// Construir los parámetros codificados
//						String queryParams = String.format("access_key=%s&symbols=%s",
//								URLEncoder.encode(apiKey, "UTF-8"), URLEncoder.encode(symbols, "UTF-8"));
//
//						// Construir el objeto URI con la URL completa y parámetros
//						URI apiUri = new URI(baseUrl + "?" + queryParams);
//
//						// Abrir una conexión HTTP hacia la URL
//						HttpURLConnection connection = (HttpURLConnection) apiUri.toURL().openConnection();
//						connection.setRequestMethod("GET");
//						int responseCode = connection.getResponseCode();
//
//						if (responseCode == HttpURLConnection.HTTP_OK) {
//							// Leer la respuesta JSON y realizar el procesamiento
//							BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//							String inputLine;
//							StringBuilder response = new StringBuilder();
//
//							while ((inputLine = in.readLine()) != null) {
//								response.append(inputLine);
//							}
//							in.close();
//
//							// Convertir la respuesta JSON a un objeto JSONObject
//							JSONObject jsonResponse = new JSONObject(response.toString());
//
//							// Obtener el valor del tipo de cambio del JSONObject
//							double resultado1 = jsonResponse.getJSONObject("rates").getDouble(monedaBase);
//							double resultado2 = jsonResponse.getJSONObject("rates").getDouble(monedaConvertir);
//
//							// la api devuelve los resultados en base al euro, procedemos con el calculo
//							double cambio1 = cantidadSelec / resultado1;
//							resultado = cambio1 * resultado2;
//							DecimalFormat decimalFormat = new DecimalFormat("#.##");
//							resultadoFormateado = decimalFormat.format(resultado);
//
//							// Mostrar el tipo de cambio al cliente
//							System.out.println("Tipo de cambio: " + resultadoFormateado);
//
//						} else {
//							System.out.println(
//									"La solicitud no se realizó correctamente. Código de respuesta: " + responseCode);
//						}
//
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//
//					resultadoLabel.setText(cantidadSelec + " " + monedaSeleccionada1 + " son equivalentes a: "
//							+ resultadoFormateado + " " + monedaSeleccionada2);
//
//				} else {
//					System.out.println("Ninguna moneda seleccionada.");
//				}
//			}
//		});
//
//		add(de);
//		add(deMoneda);
//		add(a);
//		add(aMoneda);
//		add(cantidad);
//		add(cantidadTextField);
//		add(convertirButton);
//		add(resultadoLabel);
//
//		setVisible(true);
//	}
//
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> new ConversorSinDividir());
//	}
//}

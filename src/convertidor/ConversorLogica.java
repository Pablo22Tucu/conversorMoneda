package convertidor;


import java.util.HashMap;
import java.util.Map;

public class ConversorLogica {
	private final ApiComunicador apiComunicador;
	private final Map<String, String> monedasCodigos;

	public ConversorLogica() {
		apiComunicador = new ApiComunicador();
		monedasCodigos = new HashMap<>();
		String[] monedas = getMonedas();
		String[] codigos = getCodigos();

		for (int i = 0; i < monedas.length; i++) {
			monedasCodigos.put(monedas[i], codigos[i]);
		}
	}
	public String [] getCodigos() {
		String[] codigos = {"AFN", "MGA", "THB", "PAB", "ETB",
				"BTC", "VEF", "VES", "BOB", "GHS", "KES", "SOS", "TZS", "UGX", "CRC", "NIO",
				"DKK", "ISK", "NOK", "SEK", "CZK", "GMD", "MKD", "DZD", "BHD", "IQD", "JOD",
				"KWD", "LYD", "RSD", "TND", "AED", "MAD", "STD", "AUD", "BSD", "BZD", "BMD",
				"CAD", "BBD", "BND", "HKD", "SBD", "KYD", "NAD", "SGD", "SRD", "TWD", "TTD",
				"XCD", "USD", "FJD", "GYD", "JMD", "LRD", "NZD", "ZWL", "VND", "AMD", "CVE",
				"EUR", "ANG", "AWG", "HUF", "BIF", "XAF", "XOF", "XPF", "KMF", "CDF", "GNF",
				"RWF", "CHF", "DJF", "HTG", "UAH", "PYG", "PGK", "LAK", "HRK", "MWK", "ZMK",
				"ZMW", "AOA", "MMK", "GEL", "LVL", "ALL", "HNL", "SLE", "SLL", "MDL", "RON",
				"BGN", "GGP", "JEP", "SHP", "EGP", "GBP", "GIP", "LBP", "FKP", "IMP", "SYP",
				"SDG", "SSP", "SZL", "TRY", "LTL", "LSL", "AZN", "TMT", "BAM", "MZN", "NGN",
				"ERN", "BTN", "XAU", "TOP", "MOP", "ARS", "CLP", "COP", "CUC", "CUP", "DOP",
				"PHP", "MXN", "UYU", "XAG", "BWP", "GTQ", "ZAR", "BRL", "CNY", "IRR", "OMR",
				"YER", "KHR", "MYR", "QAR", "SAR", "BYR", "BYN", "RUB", "MVR", "MUR", "SCR",
				"LKR", "INR", "IDR", "NPR", "PKR", "XDR", "ILS", "PEN", "KGS", "UZS", "TJS",
				"BDT", "WST", "KZT", "MNT", "MRO", "CLF", "VUV", "KRW", "KPW", "JPY", "PLN"};
		return codigos;
	}


	public String[] getMonedas() {
		String[] monedas = {"AFGANI AFGANO", "ARIARY MALGACHE", "BAHT", "BALBOA",
				"BIRR ETÍOPE", "BITCOIN", "BOLÍVAR", "BOLÍVAR SOBERANO (NUEVO)", "BOLIVIANO",
				"CEDI", "CHELÍN KENIANO", "CHELÍN SOMALÍ", "CHELÍN TANZANO",
				"CHELÍN UGANDÉS", "COLÓN COSTARRICENSE", "CÓRDOBA ORO", "CORONA DANESA",
				"CORONA ISLANDESA", "CORONA NORUEGA", "CORONA SUECA", "CZECH KORUNA",
				"DALASI", "DINAR", "DINAR ARGELINO", "DINAR BAREINÍ", "DINAR IRAQUÍ",
				"DINAR JORDANO", "DINAR KUWAITÍ", "DINAR LIBIO", "DINAR SERBIO",
				"DINAR TUNECINO", "DIRHAM DE EAU", "DÍRHAM MARROQUÍ", "DOBRA",
				"DÓLAR AUSTRALIANO", "DÓLAR BAHAMEÑO", "DÓLAR BELICEÑO", "DÓLAR BERMUDEÑO",
				"DÓLAR CANADIENSE", "DÓLAR DE BARBADOS", "DÓLAR DE BRUNEI",
				"DÓLAR DE HONG KONG", "DÓLAR DE ISLAS SALOMÓN", "DÓLAR DE LAS ISLAS CAYMAN",
				"DÓLAR DE NAMIBIA", "DÓLAR DE SINGAPUR", "DÓLAR DE SURINAM",
				"DÓLAR DE TAIWÁN (NUEVO)", "DÓLAR DE TRINIDAD Y TOBAGO",
				"DÓLAR DEL CARIBE ORIENTAL", "DÓLAR ESTADOUNIDENSE", "DÓLAR FIYIANO",
				"DÓLAR GUYANÉS", "DÓLAR JAMAIQUINO", "DÓLAR LIBERIANO", "DÓLAR NEOZELANDÉS",
				"DÓLAR ZIMBABUENSE", "DONG", "DRAM ARMENIO", "ESCUDO CABOVERDIANO", "EURO",
				"FLORÍN ANTILLANO NEERLANDÉS", "FLORÍN ARUBEÑO", "FORINTO HÚNGARO",
				"FRANCO BURUNDÉS", "FRANCO CFA DE ÁFRICA CENTRAL",
				"FRANCO CFA DE ÁFRICA OCCIDENTAL", "FRANCO CFP", "FRANCO COMORENSE",
				"FRANCO CONGOLEÑO", "FRANCO GUINEANO", "FRANCO RUANDÉS", "FRANCO SUIZO",
				"FRANCO YIBUTIANO", "GOURDE", "GRIVNIA", "GUARANÍ", "KINA", "KIP LAOSIANO",
				"KUNA", "KWACHA MALAUÍ", "KWACHA ZAMBIANO", "KWACHA ZAMBIANO (NUEVO)",
				"KWANZA ANGOLEÑO", "KYAT BIRMANO", "LARI", "LAT LETON", "LEK", "LEMPIRA",
				"LEONE", "LEONE (NUEVO)", "LEU MOLDAVO", "LEU RUMANO", "LEV",
				"LIBRA DE GUERNESEY", "LIBRA DE JERSEY", "LIBRA DE SANTA HELENA",
				"LIBRA EGIPCIA", "LIBRA ESTERLINA", "LIBRA GIBRALTAREÑA", "LIBRA LIBANESA",
				"LIBRA MALVINENSE", "LIBRA MANESA", "LIBRA SIRIA", "LIBRA SUDANESA",
				"LIBRA SURSUDANESA", "LILANGENI", "LIRA TURCA", "LITA LITUANA", "LOTI",
				"MANAT AZERBAIYANO", "MANAT TURCOMANO", "MARCO BOSNIOHERZEGOVINO",
				"METICAL MOZAMBIQUEÑO", "NAIRA", "NAKFA", "NGULTRUM BUTANÉS", "ORO GRAMO",
				"PA’ANGA", "PATACA", "PESO ARGENTINO", "PESO CHILENO", "PESO COLOMBIANO",
				"PESO CONVERTIBLE", "PESO CUBANO", "PESO DOMINICANO", "PESO FILIPINO",
				"PESO MEXICANO", "PESO URUGUAYO", "PLATA GRAMO", "PULA", "QUETZAL", "RAND",
				"REAL BRASILEÑO", "RENMINBI", "RIAL IRANÍ", "RIAL OMANÍ", "RIAL YEMENÍ",
				"RIEL CAMBOYANO", "RINGGIT MALAYO", "RIYAL CATARÍ", "RIYAL SAUDÍ",
				"RUBLO BIELORRUSO", "RUBLO BIELORRUSO (NUEVO)", "RUBLO RUSO",
				"RUPIA DE MALDIVAS", "RUPIA DE MAURICIO", "RUPIA DE SEYCHELLES",
				"RUPIA DE SRI LANKA", "RUPIA INDIA", "RUPIA INDONESIA", "RUPIA NEPALÍ",
				"RUPIA PAKISTANÍ", "SDR (DERECHO ESPECIAL DE RETIRO)", "SÉQUEL (NUEVO)",
				"SOL (NUEVO)", "SOM", "SOM UZBEKO", "SOMONI", "TAKA", "TALA", "TENGE KAZAJO",
				"TUGRIK", "UGUIYA", "UNIDAD DE FOMENTO", "VATU", "WON", "WON NORCOREANO",
				"YEN", "ZLOTY"};
		return monedas;    
	}




	public double convertirMonedas(String monedaBase, double cantidad, String monedaConvertir) {
		String codigoMonedaBase = monedasCodigos.get(monedaBase);
		String codigoMonedaConvertir = monedasCodigos.get(monedaConvertir);

		if (codigoMonedaBase == null || codigoMonedaConvertir == null) {
			System.out.println("Moneda no encontrada en el mapa.");
			return 0.0;
		}

		double tipoCambio = apiComunicador.obtenerTipoCambio(codigoMonedaBase, codigoMonedaConvertir);

		return cantidad * tipoCambio;
	}
}

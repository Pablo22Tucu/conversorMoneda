package convertidor;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;

public class ApiComunicador {
	private final String API_BASE_URL = "http://api.exchangeratesapi.io/v1/latest";
	private final String API_KEY = System.getenv("EXCHANGE_API_KEY"); // Variable de Entorno para almacenar API_KEY
	

	public double obtenerTipoCambio(String monedaBase, String monedaConvertir) {
		try {
			String symbols = monedaBase.concat(",").concat(monedaConvertir);

			String queryParams = String.format("access_key=%s&symbols=%s",
					URLEncoder.encode(API_KEY, "UTF-8"),
					URLEncoder.encode(symbols, "UTF-8")
					);
			

			URI apiUri = new URI(API_BASE_URL + "?" + queryParams);
			HttpURLConnection connection = (HttpURLConnection) apiUri.toURL().openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				JSONObject jsonResponse = new JSONObject(response.toString());
				double tipoCambioBase = jsonResponse.getJSONObject("rates").getDouble(monedaBase);
				double tipoCambioConvertir = jsonResponse.getJSONObject("rates").getDouble(monedaConvertir);

				return tipoCambioConvertir / tipoCambioBase;
			} else {
				System.out.println("La solicitud no se realizó correctamente. Código de respuesta: " + responseCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0.0;
	}
}

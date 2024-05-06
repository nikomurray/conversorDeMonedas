import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Convertidor {
    int cambio;
    int valorAconvertir;
    String moneda;
    String monedaAconvertir;

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public void setMonedaAconvertir(String monedaAconvertir) {
        this.monedaAconvertir = monedaAconvertir;
    }

    public Convertidor(int cambio, int valorAconvertir) {
        this.cambio = cambio;
        this.valorAconvertir = valorAconvertir;
    }

    public void convertir_valor(){
        switch (cambio){
            case 1:
                System.out.println("Convertir " + valorAconvertir + " Dolar =>> Peso Argentino");
                setMoneda("USD");
                setMonedaAconvertir("ARS");
                break;
            case 2:
                System.out.println("Convertir "+ valorAconvertir + " Peso Argentino =>> Dolar");
                setMoneda("ARS");
                setMonedaAconvertir("USD");
                break;
            case 3:
                System.out.println("Convertir "+ valorAconvertir +" Dolar =>> Real Brasileño");
                setMoneda("USD");
                setMonedaAconvertir("BRL");
                break;
            case 4:
                System.out.println("Convertir "+ valorAconvertir +" Real Brasileño =>> Dolar");
                setMoneda("BRL");
                setMonedaAconvertir("USD");
                break;
            case 5:
                System.out.println("Convertir "+ valorAconvertir +" Dolar =>> Peso Colombiano");
                setMoneda("USD");
                setMonedaAconvertir("COP");
                break;
            case 6:
                System.out.println("Convertir "+ valorAconvertir +" Peso Colombiano =>> Dolar");
                setMoneda("COP");
                setMonedaAconvertir("USD");
                break;
        }
    }

    public void solicitarInfo(){
        try {
            // URL de la api que queremos consumir
            URL url = new URL("https://v6.exchangerate-api.com/v6/19a05854891b0b2938b03b23/latest/" + moneda);

            // Abrir una conexion HTTP
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Configurarmos el método de solicitud
            con.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response = "";
            String line;
            while ((line = reader.readLine()) != null) {
                response += line;
            }
            reader.close();

            // Cerramos la conexion
            con.disconnect();

            // Convertir JSON a objetos Java
            Gson gson = new Gson();
            Data data = gson.fromJson(response,Data.class);
            Double conversion = data.getRate(monedaAconvertir) * valorAconvertir;
            System.out.println(valorAconvertir + moneda + " = " + conversion + monedaAconvertir );


        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Ha ocurrido un error al comunicarse con el servidor");
        }

    }

}

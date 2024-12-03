import dto.ApiResponse;
import entity.Moneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        List<Moneda> monedas = cargarMonedas();
        menu(monedas);
    }

    private static void convertirMoneda(Moneda origen, Moneda destino, Double valor) {
        String o = origen.getCodigo();
        String d = destino.getCodigo();

        HttpClient cliente = HttpClient.newBuilder()
                .build();

        URI url = URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/"+o+"/"+d+"/"+valor+"");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url.toString()))
                .build();

        try{
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static List<Moneda> cargarMonedas() {
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda("peso argentino", "ARS"));
        monedas.add(new Moneda("boliviano", "BOB"));
        monedas.add(new Moneda("real brasileño", "BRL"));
        monedas.add(new Moneda("peso chileno", "CLP"));
        monedas.add(new Moneda("peso colombiano", "COP"));
        monedas.add(new Moneda("colón costarricense", "CRC"));
        monedas.add(new Moneda("peso cubano", "CUP"));
        monedas.add(new Moneda("dólar estadounidense", "USD")); // usado en Ecuador y Panamá
        monedas.add(new Moneda("quetzal guatemalteco", "GTQ"));
        monedas.add(new Moneda("lempira hondureña", "HNL"));
        monedas.add(new Moneda("córdoba nicaragüense", "NIO"));
        monedas.add(new Moneda("balboa panameña", "PAB"));
        monedas.add(new Moneda("guaraní paraguayo", "PYG"));
        monedas.add(new Moneda("sol peruano", "PEN"));
        monedas.add(new Moneda("peso dominicano", "DOP"));
        monedas.add(new Moneda("peso uruguayo", "UYU"));
        monedas.add(new Moneda("bolívar venezolano", "VES"));
        return monedas;
    }

    private static void menu(List<Moneda> m) {
        Scanner s1 = new Scanner(System.in);
        int opc;
        do{
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("seleccione la moneda a convertir");
            mostrarMonedas(m);
            System.out.println("0. Salir");

            opc = s1.nextInt();

            switch(opc){
                case 0:
                    System.out.println("Adios, vuelva pronto"); break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        int idxMonedaOrigen = opc - 1;
                        Moneda origen = m.get(idxMonedaOrigen);

                        System.out.print("Seleccione la moneda destino ");
                        mostrarMonedas(m);

                        int idxMonedaDestino = s1.nextInt() - 1;
                        Moneda destino = m.get(idxMonedaDestino);

                        double valor;
                        System.out.println("Seleccione el valor a convertir: ");
                        valor = s1.nextDouble();
                        convertirMoneda(origen, destino, valor);
            }
        } while (opc != 0);
    }

    private static void mostrarMonedas(List<Moneda> m) {
        for (int i = 0; i < m.size(); i++) {
            System.out.println((i+1) + ". "+m.get(i).getCodigo());
        }
    }
}

package aplicacion;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.google.gson.Gson;

public class Pais{
    private String nombre;
    private String bandera;
    private String capital;
    public static int contador=0;
    public static Pais[] registro=new Pais[254];
    public Pais(String nombre, String bandera, String capital){
        this.nombre=nombre;
        this.bandera=bandera;
        this.capital=capital;  
        registro[contador]=this;
        contador++;
    }
    public String getNombre() {
        return nombre;}
    public String getBandera() {
        return bandera;}
    public String getCapital() {
        return capital;}
    public static void cargarDatos() {
        try{
            InputStream is = Pais.class.getResourceAsStream("/aplicacion/datos.json");

        // 2. Verificar que el archivo se encontró
        if (is == null) {
            System.out.println("¡ERROR! No se encontró /aplicacion/datos.json");
            return;
        }

        // 3. Leer el JSON (ya no necesitas FileInputStream)
        InputStreamReader lector = new InputStreamReader(is, "UTF-8");
        Gson gson = new Gson();
        Pais[] tmp = gson.fromJson(lector, Pais[].class);

        if (tmp != null) {
            for (Pais p : tmp) {
                new Pais(p.getNombre(), p.getBandera(), p.getCapital());
            }
        }
        
        lector.close();
        is.close();
        System.out.println("Se cargaron " + contador + " banderas desde json");

        } catch (Exception e) {
        System.out.println("Error del json");
        e.printStackTrace();
        }
    }
}
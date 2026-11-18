package aplicacion;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


public abstract class Pregunta{
    protected Pais pais;
    protected String enunciado;
    protected List<Pais> opciones;
    
    public Pregunta(){
        this.opciones= new ArrayList<>();
        opcionesRandom();
    }

    private void opcionesRandom(){
        Random rand = new Random();
        int indiceCorrecto = rand.nextInt(Pais.contador);
        pais=Pais.registro[indiceCorrecto];
        opciones.add(pais);
        while (opciones.size()<4) {
            int indiceRandom=rand.nextInt(Pais.contador);
            Pais paisRandom=Pais.registro[indiceRandom];
            if (!opciones.contains(paisRandom)) {
                opciones.add(paisRandom);
            }
        }
        Collections.shuffle(opciones);
    }
    public void setEnunciado(String s){
        enunciado=s;
    }
    

    public String getEnunciado() {
        return enunciado;
    }

    public List<Pais> getOpciones() {
        return opciones;
    }
    public Pais getPais(){
        return pais;
    }
    public boolean verificarRespuesta(Pais selec) {
        return selec.equals(pais);
    }

}
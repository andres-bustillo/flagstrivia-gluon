package aplicacion;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Scenecontroller {
    private static int malas=0;
    private static int buenas=0;
  //  private Stage stage;
  //  private Scene escena;
  //  private Parent root;

    public static void Next(Stage stage, Pregunta q,Pais p){
        if (q.verificarRespuesta(p)){
            buenas++;
        }
        else{
            malas++;
        }
        PreguntaBandera p1 = new PreguntaBandera();
        String ruta = "/aplicacion/banderas/" + p1.getPais().getBandera();
        Image ib = new Image(Scenecontroller.class.getResource(ruta).toExternalForm());
        ImageView vb= new ImageView(ib);
        vb.setFitHeight(150); 
        vb.setPreserveRatio(true);

        Label etiqueta=new Label(p1.getEnunciado());
        Label inc=new Label("incorrectas: "+String.valueOf(malas));
        Label cor=new Label("correctas: "+String.valueOf(buenas));
        Button botonx =new Button("salir");
        Button boton1=new Button(p1.getOpciones().get(0).getNombre());
        Button boton2=new Button(p1.getOpciones().get(1).getNombre());
        Button boton3= new Button(p1.getOpciones().get(2).getNombre());
        Button boton4 =new Button(p1.getOpciones().get(3).getNombre());
        botonx.setOnAction(e -> Scenecontroller.Menu(stage));
        boton1.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(0)));
        boton2.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(1)));
        boton3.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(2)));
        boton4.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(3)));
        VBox raiz=new VBox(inc,cor,vb,etiqueta,botonx,boton1,boton2,boton3,boton4);
        raiz.setAlignment(Pos.CENTER);
        Scene escena=new Scene(raiz,Color.MEDIUMPURPLE);
        escena.getStylesheets().add(Scenecontroller.class.getResource("estilos.css").toExternalForm());
        stage.setScene(escena);
        stage.show();
    }  

    public static void Menu(Stage stage){

        Label etiqueta=new Label("Flags Trivia!");
        Button boton1=new Button("Comenzar");
        boton1.setOnAction(e -> Scenecontroller.Trivia1(stage));
        VBox raiz=new VBox(etiqueta,boton1);
        raiz.setAlignment(Pos.CENTER);
        Scene escena=new Scene(raiz,Color.MEDIUMPURPLE);
        escena.getStylesheets().add(Scenecontroller.class.getResource("/aplicacion/estilos.css").toExternalForm());
        stage.setScene(escena);
        stage.show();
    }
    public static void Trivia1(Stage stage){
        PreguntaBandera p1 = new PreguntaBandera();
        String ruta= "/aplicacion/banderas/" + p1.getPais().getBandera();
        Image ib=new Image(Scenecontroller.class.getResource(ruta).toExternalForm());
        ImageView vb= new ImageView(ib);
        vb.setFitHeight(150); 
        vb.setPreserveRatio(true);

        Label etiqueta=new Label(p1.getEnunciado());
        Label inc=new Label("incorrectas: "+String.valueOf(malas));
        Label cor=new Label("correctas: "+String.valueOf(buenas));
        Button botonx =new Button("salir");
        Button boton1=new Button(p1.getOpciones().get(0).getNombre());
        Button boton2=new Button(p1.getOpciones().get(1).getNombre());
        Button boton3= new Button(p1.getOpciones().get(2).getNombre());
        Button boton4 =new Button(p1.getOpciones().get(3).getNombre());
        botonx.setOnAction(e -> Scenecontroller.Menu(stage));
        boton1.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(0)));
        boton2.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(1)));
        boton3.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(2)));
        boton4.setOnAction(e -> Next(stage,p1,p1.getOpciones().get(3)));
        VBox raiz=new VBox(inc,cor,vb,etiqueta,botonx,boton1,boton2,boton3,boton4);
        raiz.setAlignment(Pos.CENTER);
        Scene escena=new Scene(raiz,Color.MEDIUMPURPLE);
        escena.getStylesheets().add(Scenecontroller.class.getResource("estilos.css").toExternalForm());
        stage.setScene(escena);
        stage.show();
    }
}

package aplicacion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class App extends Application {

    @Override
    public void start(Stage stage){
        Pais.cargarDatos();
        Label etiqueta=new Label("Flags Trivia!");
        Button boton1 = new Button("Comenzar");
        boton1.setOnAction(e -> Scenecontroller.Trivia1(stage));
        VBox raiz=new VBox(etiqueta,boton1);
        raiz.setAlignment(Pos.CENTER);
        Scene escena=new Scene(raiz);
        escena.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        Image icon = new Image(getClass().getResource("banderas/mx.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setTitle("Flags Trivia");
        stage.setWidth(600);
        stage.setHeight(1000);
        stage.setResizable(false);
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] cross){
        launch(cross); 
    }
}
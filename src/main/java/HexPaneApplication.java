import javafx.application.Application;
import javafx.stage.Stage;

public class HexPaneApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HexGridPane<Tile> hexGridPane = new HexGridPane<>(42);

        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
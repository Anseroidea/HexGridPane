import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.util.Objects;

public class HexPaneApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HexGridPane<Tile> hexGridPane = new HexGridPane<>(100);
        for (int i = -3; i < 4; i++) {
            for (int j = 0; j < 7 - Math.abs(i); j++) {
                hexGridPane.add(new Tile(SwingFXUtils.toFXImage(ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("Water.png"))), null)), i, j);
            }
        }
        primaryStage.setScene(new Scene(new StackPane(hexGridPane.toPane())));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
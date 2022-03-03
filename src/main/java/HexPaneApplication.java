import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class HexPaneApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HexGridPane<Tile> hexGridPane = new HexGridPane<>(42);
        BufferedImage i = ImageIO.read(new File("C:\\Users\\slhscs216\\Downloads\\testbar.png"));
        ImageView im = new ImageView(SwingFXUtils.toFXImage(i, null));
        im.setRotate(90);
        primaryStage.setScene(new Scene(new AnchorPane(im)));
        double height = i.getHeight();
        System.out.println(height);
        double width = i.getWidth();

        im.setLayoutY(width/2 - height/2);
        im.setLayoutX(-height/2);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
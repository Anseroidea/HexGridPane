import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        double height = i.getHeight();
        System.out.println(height);
        double width = i.getWidth();
        AnchorPane ap = new AnchorPane(new StackPane(im));
        VBox vb = new VBox(ap);
        Slider sl = new Slider();
        sl.setMin(0);
        sl.setMax(360);
        sl.valueProperty().addListener((observable, oldValue, newValue) -> {
            im.setRotate(newValue.doubleValue());
            
        });
        vb.getChildren().add(sl);
        primaryStage.setScene(new Scene(new StackPane(vb)));


        im.setLayoutY(width/2 - height/2);
        im.setLayoutX(-height/2);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
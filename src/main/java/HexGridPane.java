import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.*;

public class HexGridPane<T extends Displayable> extends HexGrid<T>{

    private int radius;

    public <T> HexGridPane(int r){
        super();
        radius = r;
    }

    public AnchorPane toPane(){
        AnchorPane ap = new AnchorPane();
        Map<Integer, List<T>> map = getMap();
        double maxX = map.keySet().stream().map(r -> (radius/2. * Math.sqrt(3)) * Math.abs(r) + radius * Math.sqrt(3) * map.get(r).size()).max(Comparator.naturalOrder()).get();
        double maxY = new TreeSet<>(map.keySet()).last() * (radius + radius/2.);
        ap.setPrefSize(maxX, maxY);
        Integer min = new TreeSet<>(map.keySet()).first();
        for (Integer r : map.keySet()){
            for (int c = 0; c < map.get(r).size(); c++){
                if (map.get(r).get(c) != null){
                    double rowCoord = (r - (min)) * (radius + radius/2.);
                    double colCoord = (radius/2. * Math.sqrt(3)) * Math.abs(r) + radius * Math.sqrt(3) * c;
                    ImageView im = new ImageView(map.get(r).get(c).getImage());
                    im.setLayoutX(rowCoord);
                    im.setLayoutY(colCoord);
                    ap.getChildren().add(im);
                }
            }
        }
        return ap;
    }






}
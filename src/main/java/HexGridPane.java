import javafx.scene.layout.AnchorPane;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HexGridPane<T extends Displayable> extends HexGrid<T>{

    private int radius;

    public <T> HexGridPane(int r){
        super();
        radius = r;
    }

    public AnchorPane toPane(){
        AnchorPane ap = new AnchorPane();
        Map<Integer, List<T>> map = getMap();
        Integer min = new TreeSet<>(map.keySet()).first();
        for (Integer r : map.keySet()){
            for (T t : map.get(r)){
                System.out.println();
            }
        }
        return ap;
    }






}
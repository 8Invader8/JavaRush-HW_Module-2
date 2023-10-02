package island.map;

import island.IslandFormOfLife;

import java.util.HashMap;

public class Field extends Island{
    private HashMap<IslandFormOfLife, Integer> field = new HashMap<>();


    public HashMap<IslandFormOfLife, Integer> getFieldHashMap(){
        return field;
    }


    public void setFieldHashMap(HashMap<IslandFormOfLife,Integer> field){
        this.field = field;
    }
}

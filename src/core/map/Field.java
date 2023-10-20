package core.map;

import core.IslandFormOfLife;

import java.util.HashMap;

public class Field {
    protected static HashMap<IslandFormOfLife, Integer> field = new HashMap<>();

    public HashMap<IslandFormOfLife, Integer> getFieldHashMap(){
        return field;
    }

    public void setFieldHashMap(HashMap<IslandFormOfLife,Integer> field){
        this.field = field;
    }
}

package Anket.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IDE {
    private Map<String, Integer> ideMap = Collections.synchronizedMap(new HashMap<>());

    public IDE() {
        ideMap.put("idea", 0);
        ideMap.put("eclipse", 0);
        ideMap.put("netbeans", 0);
    }

    public Map<String, Integer> getIdeMap() {
        return ideMap;
    }

    public IDE setIdeMap(Map<String, Integer> ideMap) {
        this.ideMap = ideMap;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IDE{");
        sb.append("ideMap=").append(ideMap);
        sb.append('}');
        return sb.toString();
    }
}

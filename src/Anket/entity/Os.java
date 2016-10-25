package Anket.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Os {
    private Map<String, Integer> osMap = Collections.synchronizedMap(new HashMap<>());

    public Os() {
        osMap.put("windows", 0);
        osMap.put("iOs", 0);
        osMap.put("linux", 0);
    }

    public Map<String, Integer> getOsMap() {
        return osMap;
    }

    public Os setOsMap(Map<String, Integer> osMap) {
        this.osMap = osMap;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Os{");
        sb.append("osMap=").append(osMap);
        sb.append('}');
        return sb.toString();
    }
}

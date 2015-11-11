package org.iperlon.rules.core.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class RulesContext {

    private Map<String, Object> mapOfVariables = new HashMap();


    public RulesContext add(String name, Object value) {
        mapOfVariables.put(name, value);
        return this;
    }

    public <T> T get(String name, Class<T> requiredClass) {
        return (T)mapOfVariables.get(name);
    }

    public Object get(String name) {
        return mapOfVariables.get(name);
    }

}

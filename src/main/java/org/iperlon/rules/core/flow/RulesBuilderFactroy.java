package org.iperlon.rules.core.flow;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class RulesBuilderFactroy {


    public FlowBuilder get(String name) {
        FlowBuilder rulesBuilder = new FlowBuilder(name);
        return rulesBuilder;
    }




}

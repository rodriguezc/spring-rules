package org.iperlon.rules.core.examples.flow;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.domain.Rule;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class AccompaniedRuleImpl implements Rule {

    @Context(value = "accompagnated", required = true)
    private Boolean accompagnated;

    @Override
    public String name() {
        return "Accompagnated rule";
    }

    @Override
    public boolean when() {
        return Boolean.TRUE.equals(accompagnated);
    }

    @Override
    public String then() {
       return null;
    }
}

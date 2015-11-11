package org.iperlon.rules.core.examples.flow;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.domain.Rule;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class AccompaniedRuleImpl implements Rule {

    @Context(value = "accompanied", required = true)
    private Boolean accompanied;

    @Override
    public String name() {
        return "Accompanied rule";
    }

    @Override
    public boolean when() {
        return Boolean.TRUE.equals(accompanied);
    }

    @Override
    public String then() {
       return null;
    }
}

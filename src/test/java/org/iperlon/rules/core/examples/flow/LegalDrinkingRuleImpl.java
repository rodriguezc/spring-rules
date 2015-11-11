package org.iperlon.rules.core.examples.flow;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.domain.Rule;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class LegalDrinkingRuleImpl implements Rule {

    @Context(value = "age", required = true)
    private Integer age;

    @Override
    public String name() {
        return "legal drinking rule";
    }

    @Override
    public boolean when() {
        return age > 17;
    }

    @Override
    public String then() {
       return null;
    }
}

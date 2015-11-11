package org.iperlon.rules.core.examples.flow;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.domain.Rule;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class KnownClientRuleImpl implements Rule {

    @Context(value = "clientName", required = true)
    private String clientName;

    @Override
    public String name() {
        return "client known rule";
    }

    @Override
    public boolean when() {
        return "charlie".equals(clientName);
    }

    @Override
    public String then() {
        return null;
    }
}

package org.iperlon.rules.core.transitions;

import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.domain.RuleResult;

/**
 * Created by rodriguezc on 06.11.2015.
 */
public class RuleExecutionTransition implements RuleTransition {


    @Override
    public boolean applies(RuleResult lastRule) {
        return true;
    }

}

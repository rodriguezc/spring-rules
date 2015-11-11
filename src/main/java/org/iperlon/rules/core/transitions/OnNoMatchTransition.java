package org.iperlon.rules.core.transitions;

import org.iperlon.rules.core.domain.RuleResult;

/**
 * Created by rodriguezc on 11.11.2015.
 */
public class OnNoMatchTransition implements RuleTransition {

    public OnNoMatchTransition() {
    }

    @Override
    public boolean applies(RuleResult lastRule) {
        return !lastRule.isMatch();
    }

}

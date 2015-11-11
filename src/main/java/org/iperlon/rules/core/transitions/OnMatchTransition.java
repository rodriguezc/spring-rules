package org.iperlon.rules.core.transitions;

import org.iperlon.rules.core.domain.RuleResult;

/**
 * Created by rodriguezc on 11.11.2015.
 */
public class OnMatchTransition implements RuleTransition {

    public OnMatchTransition() {
    }

    @Override
    public boolean applies(RuleResult lastRule) {
        return lastRule.isMatch();
    }

}

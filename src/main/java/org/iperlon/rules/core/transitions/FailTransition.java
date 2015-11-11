package org.iperlon.rules.core.transitions;

import org.iperlon.rules.core.domain.RuleResult;

/**
 * Created by rodriguezc on 11.11.2015.
 */
public class FailTransition implements RuleTransition {

    private RuleTransition ruleTransition;
    public FailTransition(RuleTransition ruleTransition) {
        this.ruleTransition = ruleTransition;

    }

    @Override
    public boolean applies(RuleResult lastRule) {
        return ruleTransition.applies(lastRule);
    }
}

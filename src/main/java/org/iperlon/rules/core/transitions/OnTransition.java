package org.iperlon.rules.core.transitions;

import org.iperlon.rules.core.domain.RuleResult;

/**
 * Created by rodriguezc on 11.11.2015.
 */
public class OnTransition implements RuleTransition {

    private String outcome;

    public OnTransition(String outcome) {
        this.outcome = outcome;
    }

    @Override
    public boolean applies(RuleResult lastRule) {
        if(outcome.equals(lastRule.getOutcome())) {
            return true;
        }
        return false;
    }

}

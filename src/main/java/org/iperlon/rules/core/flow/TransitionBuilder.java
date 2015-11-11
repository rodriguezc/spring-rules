package org.iperlon.rules.core.flow;

import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.engine.RuleAndTransition;
import org.iperlon.rules.core.transitions.FailTransition;
import org.iperlon.rules.core.transitions.RuleTransition;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class TransitionBuilder {

    private FlowBuilder parent;

    private RuleTransition ruleTransition;

    public TransitionBuilder(FlowBuilder parent, RuleTransition ruleTransition) {
        this.parent = parent;
        this.ruleTransition =ruleTransition;
    }

    public FlowBuilder then(Rule rule) {
        RuleAndTransition ruleAndTransition = new RuleAndTransition(rule, ruleTransition);
        parent.getRuleAndtransitionList().add(ruleAndTransition);
        return parent;
    }

    public FlowBuilder fail() {
        RuleAndTransition ruleAndTransition = new RuleAndTransition(null, new FailTransition(ruleTransition));
        parent.getRuleAndtransitionList().add(ruleAndTransition);
        return parent;
    }
}

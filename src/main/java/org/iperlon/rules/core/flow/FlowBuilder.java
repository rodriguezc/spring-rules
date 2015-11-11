package org.iperlon.rules.core.flow;

import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.engine.RuleAndTransition;
import org.iperlon.rules.core.engine.RulesGame;
import org.iperlon.rules.core.engine.SimpleRulesGame;
import org.iperlon.rules.core.transitions.OnMatchTransition;
import org.iperlon.rules.core.transitions.OnNoMatchTransition;
import org.iperlon.rules.core.transitions.OnTransition;
import org.iperlon.rules.core.transitions.RuleExecutionTransition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class FlowBuilder {

    private String name;

    private List<RuleAndTransition> ruleAndtransitionList = new ArrayList<RuleAndTransition>();

    public FlowBuilder(String name) {
        this.name = name;
    }


    public List<RuleAndTransition> getRuleAndtransitionList() {
        return ruleAndtransitionList;
    }

    public FlowBuilder start(Rule rule) {
        RuleExecutionTransition ruleExecutionTransition = new RuleExecutionTransition();
        ruleAndtransitionList.add(new RuleAndTransition(rule, ruleExecutionTransition));
        return this;
    }


    public FlowBuilder next(Rule rule) {
        RuleExecutionTransition ruleExecTransition = new RuleExecutionTransition();
        ruleAndtransitionList.add(new RuleAndTransition(rule, ruleExecTransition));
        return this;
    }

    public TransitionBuilder onMatch() {
        OnMatchTransition onMatchTransition = new OnMatchTransition();
        return new TransitionBuilder(this, onMatchTransition);
    }

    public TransitionBuilder onNoMatch() {
        OnNoMatchTransition onNoMatchTransition = new OnNoMatchTransition();
        return new TransitionBuilder(this, onNoMatchTransition);
    }

    public TransitionBuilder on(String outcome) {
        OnTransition onTransition = new OnTransition(outcome);
        return new TransitionBuilder(this, onTransition);
    }

    public RulesGame build() {
        return new SimpleRulesGame(name,  ruleAndtransitionList);
    }
}

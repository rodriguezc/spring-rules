package org.iperlon.rules.core.engine;

import org.iperlon.rules.core.domain.RuleExecution;
import org.iperlon.rules.core.domain.RuleExecutionStatus;
import org.iperlon.rules.core.domain.RuleResult;
import org.iperlon.rules.core.domain.RulesContext;
import org.iperlon.rules.core.scope.RulesGameSynchronizationManager;

import java.util.List;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class SimpleRulesGame implements RulesGame {

    private String name;


    private List<RuleAndTransition> ruleAndTransitionList = null;


    public SimpleRulesGame(String name) {
        this.name = name;
    }

    public SimpleRulesGame(String name,  List<RuleAndTransition> ruleAndTransitionList) {
        this.name = name;
        this.ruleAndTransitionList = ruleAndTransitionList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RuleExecution execute(RulesContext rulesContext, boolean executeActions) {
        RulesGameSynchronizationManager.setCurrentContext(rulesContext);
        RuleExecution ruleExecution = new RuleExecution();
        ruleExecution.setStatus(RuleExecutionStatus.COMPLETED);
        RuleResult lastRuleExecution = null;
        try {
            for(RuleAndTransition ruleAndTransition : ruleAndTransitionList) {
                lastRuleExecution = ruleAndTransition.execute(lastRuleExecution, executeActions);
                if(RuleExecutionStatus.FAILED.equals(lastRuleExecution.getStatus())) {
                    ruleExecution.setStatus(RuleExecutionStatus.FAILED);
                }
            }
        }
        finally {
            RulesGameSynchronizationManager.removeCurrentContext();
            RulesGameSynchronizationManager.removeCurrentRule();
        }
        return ruleExecution;
    }
}

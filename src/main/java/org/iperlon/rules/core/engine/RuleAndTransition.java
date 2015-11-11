package org.iperlon.rules.core.engine;

import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.domain.RuleExecutionStatus;
import org.iperlon.rules.core.domain.RuleResult;
import org.iperlon.rules.core.scope.RulesGameSynchronizationManager;
import org.iperlon.rules.core.transitions.FailTransition;
import org.iperlon.rules.core.transitions.RuleTransition;

/**
 * Created by rodriguezc on 11.11.2015.
 */
public class RuleAndTransition {

    private Rule rule;
    private RuleTransition ruleTransition;

    public RuleAndTransition(Rule rule, RuleTransition ruleTransition) {
        this.rule = rule;
        this.ruleTransition = ruleTransition;
    }

    public RuleResult execute(RuleResult lastRuleResult, boolean executeActions) {

        System.out.println("Evaluating transition "+ruleTransition.getClass().getSimpleName()+"...");
        if(!ruleTransition.applies(lastRuleResult)) {
            System.out.println("Transition "+ruleTransition.getClass().getSimpleName()+" not applied. Skipping rule execution");
            return lastRuleResult;
        }

        RuleResult ruleResult = new RuleResult();
        if(ruleTransition instanceof FailTransition) {
            System.out.println("Fail Transition . Global status setted to failed.");
            ruleResult.setStatus(RuleExecutionStatus.FAILED);
        } else {
            System.out.println("Transition "+ruleTransition.getClass().getSimpleName()+" applies. Executing rule "+rule.name());
            if (rule.when()) {
                System.out.println( rule.name()+": rule condition  satisfied. Execution rule...");
                String outcome = null;
                if(executeActions) {
                    outcome = rule.then();
                }
                ruleResult.setOutcome(outcome);
                ruleResult.setMatch(true);
                ruleResult.setStatus(RuleExecutionStatus.COMPLETED);
                System.out.println( rule.name()+": rule execution finished with outcome "+outcome);


            } else {
                System.out.println( rule.name()+": rule condition not satisfied. Skipping rule execution");
            }
        }
        RulesGameSynchronizationManager.removeCurrentRule();
        return ruleResult;
    }
}

package org.iperlon.rules.core.scope;

import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.domain.RulesContext;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class RulesGameSynchronizationManager {

    private static ThreadLocal<RulesContext> executionHolder = new ThreadLocal<>();
    private static ThreadLocal<Rule> ruleExecutionHolder = new ThreadLocal<>();


    public static RulesContext getCurrentContext() {
        return executionHolder.get();
    }

    public static Rule getCurrentRule() {
        return ruleExecutionHolder.get();
    }

    public static void removeCurrentContext() {
        executionHolder.remove();
    }

    public static void removeCurrentRule() {
        ruleExecutionHolder.remove();
    }

    public static void setCurrentContext(RulesContext rulesContext) {
        executionHolder.set(rulesContext);
    }

    public static void setCurrentRule(Rule rule) {
        ruleExecutionHolder.set(rule);
    }

}

package org.iperlon.rules.core.engine;

import org.iperlon.rules.core.domain.RuleExecution;
import org.iperlon.rules.core.domain.RulesContext;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public interface RulesGame {

    String getName();

    RuleExecution execute(RulesContext rulesContext, boolean executeActions);
}

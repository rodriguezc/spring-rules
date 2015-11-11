package org.iperlon.rules.core.transitions;


import org.iperlon.rules.core.domain.RuleResult;

/**
 * Created by rodriguezc on 06.11.2015.
 */
public interface RuleTransition {

    boolean applies(RuleResult lastRule);



}

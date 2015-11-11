package org.iperlon.rules.core.examples.sequence;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.annotations.RuleScope;
import org.iperlon.rules.core.domain.Rule;
import org.springframework.stereotype.Component;

/**
 * Created by rodriguezc on 05.11.2015.
 */
@Component("rule2")
@RuleScope
public class Rule2Impl implements Rule {

    @Context("sequenceContext")
    private SequenceContext sequenceContext;

    @Override
    public String name() {
        return "Rule2";
    }

    @Override
    public boolean when() {
        return true;
    }

    @Override
    public String then() {
        sequenceContext.setRule2Executed(true);
        return null;
    }
}

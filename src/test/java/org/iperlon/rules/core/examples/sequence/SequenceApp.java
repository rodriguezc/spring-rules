package org.iperlon.rules.core.examples.sequence;

import org.iperlon.rules.core.annotations.RuleScope;
import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.engine.RulesGame;
import org.iperlon.rules.core.examples.flow.AccompaniedRuleImpl;
import org.iperlon.rules.core.examples.flow.KnownClientRuleImpl;
import org.iperlon.rules.core.examples.flow.LegalDrinkingRuleImpl;
import org.iperlon.rules.core.flow.RulesBuilderFactroy;
import org.iperlon.rules.core.scope.RuleScopeImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by rodriguezc on 05.11.2015.
 */
@SpringBootApplication
public class SequenceApp {

    //Start of configuration--------------------------------------------------------------------------------------------
    //Register custom rule scope
    @Bean
    public RuleScopeImpl ruleScope() {
        return new RuleScopeImpl();
    }

    @Bean
    public RulesBuilderFactroy rulesBuilderFactroy() {
        return new RulesBuilderFactroy();
    }
    //End of configuration----------------------------------------------------------------------------------------------

    @Bean
    public RulesGame sequenceRuleGame(RulesBuilderFactroy rulesBuilderFactroy,
                                                   @Qualifier("rule1") Rule rule1,
                                                   @Qualifier("rule2") Rule rule2,
                                                   @Qualifier("rule3") Rule rule3,
                                                   @Qualifier("rule4") Rule rule4

                                      ) {
        return rulesBuilderFactroy.get("helloWorldRulesGame")
                .start(rule1)
                .next(rule2)
                .next(rule3)
                .next(rule4)
                .build();
    }
}

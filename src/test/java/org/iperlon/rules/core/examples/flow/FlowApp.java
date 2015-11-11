package org.iperlon.rules.core.examples.flow;

import org.iperlon.rules.core.domain.Rule;
import org.iperlon.rules.core.flow.RulesBuilderFactroy;
import org.iperlon.rules.core.engine.RulesGame;
import org.iperlon.rules.core.scope.RuleScopeImpl;
import org.iperlon.rules.core.annotations.RuleScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by rodriguezc on 05.11.2015.
 */
@SpringBootApplication
public class FlowApp {

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
    public RulesGame purchaseAutorisationRulesGame(RulesBuilderFactroy rulesBuilderFactroy,
                                                   @Qualifier("knownClientRule") Rule knownClientRule,
                                                   @Qualifier("legalDrinkingRule") Rule legalDrinkingRule,
                                                   @Qualifier("accompaniedRule") Rule accompaniedRule
    ) {
        return rulesBuilderFactroy.get("helloWorldRulesGame")
                .start(knownClientRule)
                    .onNoMatch().fail()
                .next(legalDrinkingRule)
                    .onNoMatch().then(accompaniedRule).onNoMatch().fail()
                .build();
    }

    @Bean
    @RuleScope
    public Rule knownClientRule() {
        return new KnownClientRuleImpl();
    }

    @Bean
    @RuleScope
    public Rule legalDrinkingRule() {
        return new LegalDrinkingRuleImpl();
    }

    @Bean
    @RuleScope
    public Rule accompaniedRule() {
        return new AccompaniedRuleImpl();
    }

}

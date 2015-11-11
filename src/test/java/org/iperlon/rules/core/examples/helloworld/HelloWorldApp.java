package org.iperlon.rules.core.examples.helloworld;

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
public class HelloWorldApp {

    //Start of configuration--------------------------------------------------------------------------------------------
    //Register custom rule scope
    @Bean
    public RuleScopeImpl ruleScope() {
        return new RuleScopeImpl();
    }

    @Bean
    public RulesBuilderFactroy rulesBuilderFactroy(){
        return new RulesBuilderFactroy();
    }
    //End of configuration----------------------------------------------------------------------------------------------

    @Bean
    public RulesGame ruleGame(RulesBuilderFactroy rulesBuilderFactroy,
                              @Qualifier("helloWorldRule") Rule helloWorldRule) {
        return rulesBuilderFactroy.get("helloWorldRulesGame").start(helloWorldRule).build();
    }

    @Bean
    @RuleScope
    public Rule helloWorldRule() {
        return new HelloWorldRuleImpl();
    }
}

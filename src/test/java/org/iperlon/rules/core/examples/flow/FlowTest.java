package org.iperlon.rules.core.examples.flow;

import org.iperlon.rules.core.domain.RuleExecution;
import org.iperlon.rules.core.domain.RuleExecutionStatus;
import org.iperlon.rules.core.domain.RulesContext;
import org.iperlon.rules.core.engine.RulesGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rodriguezc on 05.11.2015.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlowApp.class)
public class FlowTest {

    @Autowired
    RulesGame purchaseAutorisationRulesGame;

    @Test
    public void canTakeABeerIsAndAdultTest() throws Exception {
        RulesContext rulesContext = new RulesContext();
        rulesContext.add("accompagnated", Boolean.FALSE);
        rulesContext.add("age",18);
        rulesContext.add("clientName","charlie");
        RuleExecution ruleExecution = purchaseAutorisationRulesGame.execute(rulesContext, false);
        Assert.assertEquals(RuleExecutionStatus.COMPLETED, ruleExecution.getStatus());
    }

    @Test
    public void canTakeABeerIsAChildButAccompaniedTest() throws Exception {
        RulesContext rulesContext = new RulesContext();
        rulesContext.add("accompagnated", Boolean.TRUE);
        rulesContext.add("age",16);
        rulesContext.add("clientName","charlie");
        RuleExecution ruleExecution = purchaseAutorisationRulesGame.execute(rulesContext, false);
        Assert.assertEquals(RuleExecutionStatus.COMPLETED, ruleExecution.getStatus());
    }

    @Test
    public void canTakeABeerIsAChildAndNotAccompaniedTest() throws Exception {
        RulesContext rulesContext = new RulesContext();
        rulesContext.add("accompagnated", Boolean.FALSE);
        rulesContext.add("age",16);
        rulesContext.add("clientName","charlie");
        RuleExecution ruleExecution = purchaseAutorisationRulesGame.execute(rulesContext, false);
        Assert.assertEquals(RuleExecutionStatus.FAILED, ruleExecution.getStatus());
    }

    @Test
    public void canTakeABeerIsNotAClient() throws Exception {
        RulesContext rulesContext = new RulesContext();
        rulesContext.add("clientName","charlot");
        rulesContext.add("accompagnated", Boolean.FALSE);
        rulesContext.add("age",21);
        RuleExecution ruleExecution = purchaseAutorisationRulesGame.execute(rulesContext, false);
        Assert.assertEquals(RuleExecutionStatus.FAILED, ruleExecution.getStatus());
    }


}

package org.iperlon.rules.core.examples.sequence;

import org.iperlon.rules.core.domain.RuleExecution;
import org.iperlon.rules.core.domain.RuleExecutionStatus;
import org.iperlon.rules.core.domain.RulesContext;
import org.iperlon.rules.core.engine.RulesGame;
import org.iperlon.rules.core.examples.helloworld.HelloWorldApp;
import org.iperlon.rules.core.examples.helloworld.Message;
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
@SpringApplicationConfiguration(classes = SequenceApp.class)
public class SequenceTest {

    @Autowired
    RulesGame rulesGame;

    @Test
    public void sequenceTest() throws Exception {
        SequenceContext sequenceContext = new SequenceContext();

        RulesContext rulesContext = new RulesContext();
        rulesContext.add("sequenceContext", sequenceContext);
        RuleExecution ruleExecution = rulesGame.execute(rulesContext, true);

        Assert.assertEquals(RuleExecutionStatus.COMPLETED, ruleExecution.getStatus());
        Assert.assertTrue(sequenceContext.isRule1Executed());
        Assert.assertTrue(sequenceContext.isRule2Executed());
        Assert.assertTrue(sequenceContext.isRule3Executed());
        Assert.assertTrue(sequenceContext.isRule4Executed());


    }
}

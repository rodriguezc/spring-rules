package org.iperlon.rules.core.examples.helloworld;

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
@SpringApplicationConfiguration(classes = HelloWorldApp.class)
public class HelloWorldTest {

    @Autowired
    RulesGame rulesGame;

    @Test
    public void helloWorldTest() throws Exception {
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);

        RulesContext rulesContext = new RulesContext();
        rulesContext.add("message",message);

        RuleExecution ruleExecution = rulesGame.execute(rulesContext, true);
        Assert.assertEquals(RuleExecutionStatus.COMPLETED, ruleExecution.getStatus());

        Assert.assertEquals(Message.GOODBYE, message.getStatus().intValue());
    }
}

package org.iperlon.rules.core.examples.helloworld;

import org.iperlon.rules.core.annotations.Context;
import org.iperlon.rules.core.domain.Rule;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public class HelloWorldRuleImpl implements Rule {

    @Context("message")
    private Message message;

    @Override
    public String name() {
        return "Hello World";
    }

    @Override
    public boolean when() {
        return message.HELLO == message.getStatus();
    }

    @Override
    public String then() {
        System.out.println(message.getMessage());
        message.setMessage("oodbyte cruel world");
        message.setStatus(Message.GOODBYE);
        return null;
    }
}

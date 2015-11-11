package org.iperlon.rules.core.examples.sequence;

/**
 * Created by rodriguc on 11.11.2015.
 */
public class SequenceContext {

    private boolean rule1Executed;
    private boolean rule2Executed;
    private boolean rule3Executed;
    private boolean rule4Executed;

    public boolean isRule1Executed() {
        return rule1Executed;
    }

    public void setRule1Executed(boolean rule1Executed) {
        this.rule1Executed = rule1Executed;
    }

    public boolean isRule2Executed() {
        return rule2Executed;
    }

    public void setRule2Executed(boolean rule2Executed) {
        this.rule2Executed = rule2Executed;
    }

    public boolean isRule3Executed() {
        return rule3Executed;
    }

    public void setRule3Executed(boolean rule3Executed) {
        this.rule3Executed = rule3Executed;
    }

    public boolean isRule4Executed() {
        return rule4Executed;
    }

    public void setRule4Executed(boolean rule4Executed) {
        this.rule4Executed = rule4Executed;
    }
}

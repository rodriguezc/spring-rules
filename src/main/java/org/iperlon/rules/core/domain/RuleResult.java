package org.iperlon.rules.core.domain;

/**
 * Created by rodriguezc on 11.11.2015.
 */
public class RuleResult {

    private boolean match;

    private String outcome;

    private RuleExecutionStatus status;

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public RuleExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(RuleExecutionStatus status) {
        this.status = status;
    }
}

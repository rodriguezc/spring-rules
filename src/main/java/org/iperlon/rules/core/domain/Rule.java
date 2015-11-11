package org.iperlon.rules.core.domain;

/**
 * Created by rodriguezc on 05.11.2015.
 */
public interface Rule {

    String name();

    boolean when();

    String then();
}

package com.bslnd.seva.card.repository;

public interface Repository<S, ID> {

    void save(S sevadar);

    S findByName(ID name);
}

package com.bslnd.seva.card.service;

import com.bslnd.seva.card.model.LocalDataModel;
import com.bslnd.seva.card.model.Sevadar;

import java.io.IOException;

public interface DataService {

    /**
     * Saves sevadar details.
     *
     * @param sevadar
     * @return true or false
     */
    boolean save(Sevadar sevadar) throws IOException;
}

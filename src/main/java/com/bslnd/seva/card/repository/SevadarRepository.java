package com.bslnd.seva.card.repository;

import com.bslnd.seva.card.model.Sevadar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SevadarRepository implements Repository<Sevadar, String> {

    private List<Sevadar> allSevadars;

    @Autowired
    public SevadarRepository(List<Sevadar> allSevadars) {
        this.allSevadars = allSevadars;
    }

    @Override
    public void save(Sevadar sevadar) {
        allSevadars.add(sevadar);
    }

    @Override
    public Sevadar findByName(String name) {
        return allSevadars.stream().filter(sevadar -> sevadar.getFullName().equals(name)).findFirst().orElse(null);
    }
}

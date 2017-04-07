package edu.hibernatexmpl.service;

import edu.hibernatexmpl.model.Tyre;
import edu.hibernatexmpl.repository.TyresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyresService {

    @Autowired
    private TyresRepository tyresRepository;

    public Tyre findById(int id) {
        return tyresRepository.findById(id);
    }

    public List<Tyre> findAll() {
        return tyresRepository.findAll();
    }

    public void save(Tyre tyre) {
        tyresRepository.save(tyre);
    }
}

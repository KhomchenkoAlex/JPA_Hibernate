package edu.hibernatexmpl.service;

import edu.hibernatexmpl.model.Engine;
import edu.hibernatexmpl.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {

    @Autowired
    private EngineRepository engineRepository;

    public Engine findById(int id) {
        return engineRepository.findById(id);
    }

    public List<Engine> findAll() {
        return engineRepository.findAll();
    }

    public void save(Engine engine) {
        engineRepository.save(engine);
    }
}

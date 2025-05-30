package com.example.ss15.service;

import com.example.ss15.model.CV;
import com.example.ss15.repository.CVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SVServiceImpl implements CVService {
    @Autowired
    private CVDAO cvDAO;

    @Override
    public List<CV> findAll() {
        return cvDAO.findAll();
    }

    @Override
    public CV findById(Long id) {
        return cvDAO.findById(id).orElse(null);
    }

    @Override
    public CV save(CV resume) {
        return cvDAO.save(resume);
    }

    @Override
    public void deleteById(Long id) {
        cvDAO.deleteById(id);
    }
}


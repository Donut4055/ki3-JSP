package com.example.ss15.service;

import com.example.ss15.model.CV;
import com.example.ss15.repository.CVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CVServiceImpl implements CVService {
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
    public CV save(CV sv) {
        if (sv.getId() == null) {
            if (cvDAO.existsByEmail(sv.getEmail())) {
                throw new RuntimeException("Email đã tồn tại!");
            }
            return cvDAO.save(sv);
        } else {
            if (cvDAO.existsByEmailExceptId(sv.getEmail(), sv.getId())) {
                throw new RuntimeException("Email đã tồn tại!");
            }
            return cvDAO.save(sv);
        }
    }

    @Override
    public void deleteById(Long id) {
        cvDAO.deleteById(id);
    }
}



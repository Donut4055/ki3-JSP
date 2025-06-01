package com.example.ss15.repository;

import com.example.ss15.model.CV;
import com.example.ss15.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CVDAO {

    // Lấy tất cả CV
    public List<CV> findAll() {
        List<CV> list = new ArrayList<>();
        String sql = "{call get_all_cvs()}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                list.add(mapCV(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Optional<CV> findById(Long id) {
        String sql = "{call get_cv_by_id(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setLong(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapCV(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public CV save(CV cv) {
        if (cv.getId() == null) {
            String sql = "{call insert_cv(?, ?, ?, ?, ?, ?)}";
            try (Connection conn = ConnectionDB.getConnection();
                 CallableStatement cs = conn.prepareCall(sql)) {
                cs.setString(1, cv.getFullName());
                cs.setString(2, cv.getEmail());
                cs.setString(3, cv.getPhoneNumber());
                cs.setString(4, cv.getEducation());
                cs.setString(5, cv.getExperience());
                cs.setString(6, cv.getSkills());
                cs.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "{call update_cv(?, ?, ?, ?, ?, ?, ?)}";
            try (Connection conn = ConnectionDB.getConnection();
                 CallableStatement cs = conn.prepareCall(sql)) {
                cs.setLong(1, cv.getId());
                cs.setString(2, cv.getFullName());
                cs.setString(3, cv.getEmail());
                cs.setString(4, cv.getPhoneNumber());
                cs.setString(5, cv.getEducation());
                cs.setString(6, cv.getExperience());
                cs.setString(7, cv.getSkills());
                cs.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cv;
    }

    public void deleteById(Long id) {
        String sql = "{call delete_cv(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setLong(1, id);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private CV mapCV(ResultSet rs) throws SQLException {
        CV cv = new CV();
        cv.setId(rs.getLong("id"));
        cv.setFullName(rs.getString("full_name"));
        cv.setEmail(rs.getString("email"));
        cv.setPhoneNumber(rs.getString("phone_number"));
        cv.setEducation(rs.getString("education"));
        cv.setExperience(rs.getString("experience"));
        cv.setSkills(rs.getString("skills"));
        return cv;
    }

    public boolean existsByEmail(String email) {
        String sql = "SELECT 1 FROM cv WHERE email = ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existsByEmailExceptId(String email, Long id) {
        String sql = "SELECT 1 FROM cv WHERE email = ? AND id <> ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setLong(2, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

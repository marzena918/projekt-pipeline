package com.example.Wool_Amore;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class WoolRepository {

    private final JdbcTemplate jdbcTemplate;

    public WoolRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Art> getAll() {
        String sql = "SELECT ID, Name, Price FROM art";
        return jdbcTemplate.query(sql, new ArtRowMapper());
    }

    public Art getById(long id) {
        String sql = "SELECT ID, Name, Price FROM art WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ArtRowMapper());
    }

    public void deleteArt(long id) {
        String sql = "DELETE FROM art WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateArt(Art art) {
        String sql = "UPDATE art SET Name = ?, Price = ? WHERE ID = ?";
        jdbcTemplate.update(sql, art.getName(), art.getPrice(), art.getID());
    }

    public void save(Art art) {
        String sql = "INSERT INTO art (Name, Price) VALUES (?, ?)";
        jdbcTemplate.update(sql, art.getName(), art.getPrice());
    }





}



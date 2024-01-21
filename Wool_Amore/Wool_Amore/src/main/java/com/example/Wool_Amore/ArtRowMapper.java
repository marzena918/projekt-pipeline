package com.example.Wool_Amore;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtRowMapper implements RowMapper<Art> {

    @Override
    public Art mapRow(ResultSet rs, int rowNum) throws SQLException {
        Art art = new Art();
        art.setID(rs.getLong("ID"));
        art.setName(rs.getString("Name"));
        art.setPrice(rs.getString("Price"));
        // Ustawianie innych pól, jeśli to konieczne
        return art;
    }


}

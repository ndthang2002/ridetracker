package com.pluralsight.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pluralsight.model.Ride;

public class RideRowMapper<T> implements RowMapper<Ride> {
 
  @Override
  public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
     Ride ride = new Ride();
     ride.setId(rs.getInt(1));
     ride.setName(rs.getString(2));
     ride.setDuration(rs.getInt(3));
    return ride;
  }
}


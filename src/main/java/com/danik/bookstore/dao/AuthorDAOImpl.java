package com.danik.bookstore.dao;

import com.danik.bookstore.config.ConnectionFactory;
import com.danik.bookstore.model.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class AuthorDAOImpl implements AuthorDAO{

    @Override
    public Author getById(int authorId) {
        DataSource ds = ConnectionFactory.getDataSource();
        String query = "select a.id, a.name, a.birth_date, a.country_code from authors a where a.id = ?";

        try(Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement(query)
        ){
            st.setInt(1, authorId);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    //book
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    Date birthDate = rs.getDate(3);
                    String countryCode = rs.getString(4);

                    return new Author(id, name, birthDate, countryCode);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException("No author for id: "+authorId);
    }

}


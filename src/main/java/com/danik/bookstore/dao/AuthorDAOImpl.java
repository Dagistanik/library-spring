package com.danik.bookstore.dao;

import com.danik.bookstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.Date;

@Component
public class AuthorDAOImpl implements AuthorDAO{

    @Resource
    DataSource dataSource;

    @Override
    public Author getById(int authorId) {
        String query = "select a.id, a.name, a.birth_date, a.country_code from authors a where a.id = ?";

        try(Connection con = dataSource.getConnection();
            PreparedStatement st = con.prepareStatement(query)
        ){
            st.setInt(1, authorId);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    //author
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


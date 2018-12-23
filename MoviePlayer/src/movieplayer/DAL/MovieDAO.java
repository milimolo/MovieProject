/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.DAL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import movieplayer.BE.Movie;

/**
 *
 * @author bonde
 */
public class MovieDAO
{
    private final ConnectionDAO cb;

    public MovieDAO()
    {
        cb = new ConnectionDAO();
    }
    
    public List<Movie> getAllMovies() throws SQLException
    {
        List<Movie> movies = new ArrayList<>();
        
        try (Connection con = cb.getConnection())
        {
            Statement statement = con.createStatement();
        }
        return movies;
    }
    
}

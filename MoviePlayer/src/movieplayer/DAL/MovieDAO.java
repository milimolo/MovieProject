/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
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
            ResultSet rs = statement.executeQuery("SELECT * FROM Movie;");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int duration = rs.getInt("duration");
                int year = rs.getInt("year");
                String filePath = rs.getString("filePath");
                Movie movie = new Movie(id, title, duration, year, filePath);
                movies.add(movie);
            }
        }
        return movies;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.BLL;

import java.sql.SQLException;
import movieplayer.BE.Movie;
import movieplayer.DAL.MTDalException;
import movieplayer.DAL.MovieDAO;
import movieplayer.DAL.MovieMetaData;

/**
 *
 * @author bonde
 */
public class MovieManager
{
    private MovieMetaData mmd;
    private MovieDAO mdao;

    public MovieManager()
    {
        mmd = new MovieMetaData();
        mdao = new MovieDAO();
    }
    
    public Movie createMovie(String title, int duration, int year, String filepath) throws SQLException
    {
        return mdao.createMovie(title, duration, year, filepath);
    }
}

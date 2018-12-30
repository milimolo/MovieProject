/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer;

import java.io.IOException;
import java.sql.SQLException;
import movieplayer.BE.Movie;
import movieplayer.DAL.MovieDAO;



/**
 *
 * @author bonde
 */
public class Tester
{

    private static MovieDAO mdao;

    public Tester()
    {
        mdao = new MovieDAO();
    }
    
   
    
    public static void main(String[] args) throws SQLException
    {
        Movie movie = mdao.createMovie("James Bond", 100, 1998, "james cameron");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.GUI;

import java.io.File;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import movieplayer.BE.Movie;
import movieplayer.BLL.MovieManager;
import movieplayer.DAL.MTDalException;

/**
 *
 * @author bonde
 */
public class AddMovieModel
{
    private ObservableList<Movie> movieList;
    private MovieManager mm;
    private String trueTrueFilePath;
    
    public AddMovieModel() throws SQLException
    {
        movieList = FXCollections.observableArrayList();
        movieList.addAll(mm.getAllMovies());
    }
    
    
    public void createMovie (String title, int duration, int year, String filepath) throws SQLException
    {
        Movie movie = mm.createMovie(title, duration, year, filepath);
        
    }
    
    public void initializeFile()
    {
        String filePath;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File (*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        if (file != null)
        {
            filePath = file.toURI().toString();
            String trueFilePath = filePath.replaceFirst("file:/", "");
            trueTrueFilePath = trueFilePath.replace("%20", " ");

        }
    }
    
    public String getDuration() throws MTDalException
    {
        int duration = mm.getDurationInSec(trueTrueFilePath);
        int seconds = duration % 60;
        int minutes = (duration - seconds) / 60;

        String mp4Seconds;
        String mp4Minutes = "" + minutes;
        if (seconds < 10)
        {
            mp4Seconds = "0" + seconds;
        } else
        {
            mp4Seconds = "" + seconds;
        }

        String formattedTime = mp4Minutes + ":" + mp4Seconds;
        return formattedTime;
    }
    
    public int getDurationInSec() throws MTDalException
    {
        return mm.getDurationInSec(trueTrueFilePath);
    }
    
    
}

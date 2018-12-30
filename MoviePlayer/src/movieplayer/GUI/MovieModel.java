/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.GUI;

import java.io.File;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import movieplayer.BE.Movie;
import movieplayer.BLL.MovieManager;

/**
 *
 * @author bonde
 */
public class MovieModel
{
    private MovieManager mm;
    private ObservableList<Movie> movieList;
    private String trueTrueFilePath;
    
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
    
    public void createSong(String title, int duration, int year, String filepath) throws SQLException
    {
        Movie movie = mm.createMovie(title, duration, year, filepath);
        movieList.add(movie);
    }
}

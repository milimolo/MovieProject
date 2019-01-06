/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.GUI;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import movieplayer.BLL.MovieManager;
import movieplayer.DAL.MTDalException;

/**
 * FXML Controller class
 *
 * @author bonde
 */
public class AddMovieController implements Initializable
{

    private AddMovieModel amm;
    private MovieManager mm;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtYear;
    @FXML
    private TextField txtDuration;
    @FXML
    private TextField txtFilepath;
    private String trueTrueFilePath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void chooseFile(ActionEvent event) throws MTDalException
    {
        try{
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
            txtDuration.setText(getDuration());
            txtFilepath.setText(trueTrueFilePath);
        } catch (MTDalException ex)
        {
            
        }
        
    }

    @FXML
    private void saveMovie(ActionEvent event) throws SQLException
    {
        String title;
        int duration;
        String filepath;
        int year = 0;
        try
        {
            
                title = txtTitle.getText();
                duration = amm.getDurationInSec();
                filepath = txtFilepath.getText();
                amm.createMovie(title, duration, year, filepath);
            

            Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage.close();
        } catch (MTDalException ex)
        {
            
        }
    }

    @FXML
    private void cancelMovie(ActionEvent event)
    {
    }
    
    public void initializeModel(AddMovieModel movieModel)
    {
        this.amm = movieModel;
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
    
}

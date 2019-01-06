/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author bonde
 */
public class MovieViewController implements Initializable
{
    private MediaPlayer mediaPlayer;
    private String filePath;
    private AddMovieModel amm;
    
    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider durationSlider;
    @FXML
    private Slider volumeSlider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }    

    @FXML
    private void play(ActionEvent event)
    {
        mediaPlayer.play();
    }

    @FXML
    private void chooseFiles(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a Fle(*.mp4", "*.mp4");
        
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();
        
        if(filePath != null)
        {
            Media media = new Media (filePath);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            
            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();
        }
        
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                durationSlider.setValue(newValue.toSeconds());
                durationSlider.maxProperty().bind(Bindings.createDoubleBinding(() -> mediaPlayer.getTotalDuration().toSeconds(), mediaPlayer.totalDurationProperty()));
            }
        });
        controlSound();
    }

    @FXML
    private void pause(ActionEvent event)
    {
        mediaPlayer.pause();
    }

    @FXML
    private void exit(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    private void stop(ActionEvent event)
    {
        mediaPlayer.stop();
    }
    
    /*
    Sets the volume of the video to 100, but also allows changes to the volume by clicking it.
    */
    private void controlSound() {
        volumeSlider.setValue(mediaPlayer.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volumeSlider.getValue() / 100);
            }
        });
    }

    @FXML
    private void setDuration(MouseEvent event)
    {
        mediaPlayer.seek(Duration.seconds(durationSlider.getValue()));
    }

    @FXML
    private void addMovie(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/movieplayer/GUI/AddMovie.fxml"));
        Parent root = (Parent) loader.load();
            
        AddMovieController amcont = loader.getController();
        amcont.initializeModel(amm);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
    }
    
}
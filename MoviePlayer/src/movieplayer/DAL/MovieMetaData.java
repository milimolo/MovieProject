/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.DAL;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;

/**
 *
 * @author bonde
 */
public class MovieMetaData
{
    public int getDurationInSec(String filepath) throws MTDalException
    {
        File file = new File(filepath);
        AudioFile audiofile;
        try
        {
            audiofile = AudioFileIO.read(file);
        } 
        catch (org.jaudiotagger.tag.TagException ex)
        {
            throw new MTDalException();
        } 
        catch (ReadOnlyFileException ex)
        {
            throw new MTDalException();
        }
        catch (InvalidAudioFrameException ex)
        {
            throw new MTDalException();
        } 
        catch (CannotReadException ex)
        {
            throw new MTDalException("Could not read the file.", ex);
        } 
        catch (IOException ex)
        {
            throw new MTDalException("Could not find MP4 file.", ex);
        }
        int duration = 0;
        try 
        {
         duration = audiofile.getAudioHeader().getTrackLength();
        } 
        catch (NullPointerException ex) {
            throw new MTDalException("The duration was not initiliazed.", ex);
        }
        return duration;
    }
}

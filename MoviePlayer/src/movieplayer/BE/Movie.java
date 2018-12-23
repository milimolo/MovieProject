/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieplayer.BE;

/**
 *
 * @author bonde
 */
public class Movie
{
    private int id;
    private String title;
    private int duration;
    private int year;
    private String filePath;
    private String formattedLength;

    public Movie(int id, String title, int duration, int year, String filePath)
    {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.year = year;
        this.filePath = filePath;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getDuration()
    {
        return duration;
    }
    
    public int getYear()
    {
        return year;
    }
    
    /**
     * Gets the movie file destination
     * @return the filepath
     */
    public String getFilepath()
    {
        return filePath;
    }
    
    /**
     * Sets movie file destination
     * @param filepath the filepath getting assigned to a movie
     */
    public void setFilepath(String filepath)
    {
        this.filePath = filePath;
    }
    
    /**
     * Gets a movie duration formatted so it is displayed in both minutes and
     * seconds
     * @return the movies formatted duration as a string
     */
    public String getFormattedLength() {
        int seconds = duration % 60;
        int minutes = (duration - seconds) / 60;

        String mp3Seconds;
        String mp3Minutes = "" + minutes;
        if (seconds < 10)
        {
            mp3Seconds = "0" + seconds;
        } else
        {
            mp3Seconds = "" + seconds;
        }

        formattedLength = mp3Minutes + ":" + mp3Seconds;
        return formattedLength;
    }
}

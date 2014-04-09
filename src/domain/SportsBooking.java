/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author Uffe
 */
public class SportsBooking {
    
    String reservationsNumber;
    String sportsID;
    String sportDate;
    String SportType;
    Boolean trainer;
    String time;

    public SportsBooking(String reservationsNumber, String sportsID, String sportDate, String SportType, Boolean trainer, String time) {
        this.reservationsNumber = reservationsNumber;
        this.sportsID = sportsID;
        this.sportDate = sportDate;
        this.SportType = SportType;
        this.trainer = trainer;
        this.time = time;
    }

    public String getReservationsNumber() {
        return reservationsNumber;
    }

    public String getSportsID() {
        return sportsID;
    }

    public String getSportDate() {
        return sportDate;
    }

    public void setSportDate(String sportDate) {
        this.sportDate = sportDate;
    }

    public String getSportType() {
        return SportType;
    }

    public void setSportType(String SportType) {
        this.SportType = SportType;
    }

    public Boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
    
}

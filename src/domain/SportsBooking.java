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
    int trainer;
    int counter = 0;

    public SportsBooking(String reservationsNumber, String sportsID, String SportType, String sportDate, int trainer) {
        this.reservationsNumber = reservationsNumber;
        this.sportsID = sportsID;
        this.sportDate = sportDate;
        this.SportType = SportType;
        this.trainer = trainer;

    }

    public String getReservationsNumber() {
        return reservationsNumber;
    }

    public String getSportsID() {
        return sportsID;
    }

    public String getSportsDate() {
        return sportDate;
    }

    public void setSportDate(String sportDate) {
        this.sportDate = sportDate;
    }

    public String getSportsType() {
        return SportType;
    }

    public void setSportType(String SportType) {
        this.SportType = SportType;
    }

    public int getTrainer() {
        return trainer;
    }

    public void setTrainer(int trainer) {
        this.trainer = trainer;
    }

}

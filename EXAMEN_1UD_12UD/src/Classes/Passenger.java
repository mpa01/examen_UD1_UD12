/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Enums.EmbarkationPort;
import Enums.Gender;
import java.time.LocalDate;

/**
 *
 * @author Mark
 */
public class Passenger implements Comparable<Passenger>{
    private int passengerId;                  
    private boolean survived;                 
    private String name;                      
    private Gender gender;                   
    private LocalDate birthdate;                 
    private Ticket ticket;                   
    private EmbarkationPort embarkationPort;  
    
    public Passenger(int passengerId, boolean survived, String name, Gender gender, LocalDate birthdate, Ticket ticket, EmbarkationPort embarkationPort) {
        setPassengerId(passengerId);
        setSurvived(survived);
        setName(name);
        setBirthdate(birthdate);
        setTicket(ticket);
        setEmbarkationPort(embarkationPort);
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if(gender.equals("female") || gender.equals("male"))
            this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }   

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public EmbarkationPort getEmbarkationPort() {
        return embarkationPort;
    }

    public void setEmbarkationPort(EmbarkationPort embarkationPort) {
        this.embarkationPort = embarkationPort;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.passengerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passenger other = (Passenger) obj;
        return this.passengerId == other.passengerId;
    }

    @Override
    public String toString() {
        return "Passenger{" + "passengerId=" + passengerId + ", survived=" + survived + ", name=" + name + ", gender=" + gender + ", birthdate=" + birthdate + ", ticket=" + ticket + ", embarkationPort=" + embarkationPort + '}';
    }
    
    @Override
    public int compareTo(Passenger p){
        return this.name.compareTo(p.name);
    }
}

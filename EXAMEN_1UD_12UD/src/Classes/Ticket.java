/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Objects;

/**
 *
 * @author Mark
 */
public class Ticket {
    private String ticketId;
    private double fare;
    private String cabinId;
    private int classId;
    
    public Ticket(String ticketId, double fare, String cabindId, int classId){
    
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabinId() {
        return cabinId;
    }

    public void setCabinId(String cabinId) {
        this.cabinId = cabinId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.ticketId);
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
        final Ticket other = (Ticket) obj;
        return Objects.equals(this.ticketId, other.ticketId);
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId + ", fare=" + fare + ", cabinId=" + cabinId + ", classId=" + classId + '}';
    }
    
    
}

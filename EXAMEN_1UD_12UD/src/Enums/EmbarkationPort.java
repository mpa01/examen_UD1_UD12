/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author Mark
 */
public enum EmbarkationPort {
C("Cherbourg"),
Q("Queenstown"),
S("Southampton");
    
    private String puerto;
    
    EmbarkationPort(String port){
        setPuerto(puerto);
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    
    
}

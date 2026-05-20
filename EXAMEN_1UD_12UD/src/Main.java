
import Classes.Passenger;
import Classes.Ticket;
import Utils.CargaDeDatos;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Mark
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    CargaDeDatos gestor = new CargaDeDatos();
    String arxiu = "C:\\temp\\Titanic_Passengers.csv";
    String arxiuLog = "C:\\temp\\Titanic_Passengers.log";
    
    Set<Ticket> tickets = new HashSet<>();
    Set<Passenger> passengers = new HashSet<>();
    
    try{
        passengers = gestor.LeerArchivo(arxiu, arxiuLog);
            
    } catch(Exception e){
        System.err.println("Error general: " + e.getMessage());
    }

    //Llista dels noms 'name' dels 'passengers' que varen sobreviure ('survived)', ordenats per ordre alfabètic
    List<String> solucio1 = passengers.stream()
            .filter(p -> p.isSurvived())
            .sorted(Comparator.comparing(Passenger::getName))
            .map(p -> p.getName())
            .toList();
           
        System.out.println("PASSATGERS SUPERVIVENTS:");
        System.out.println(solucio1);
        
    //Llista dels noms 'name' dels 'passengers' amb camarot assignat (not null) i que no varen sobreviure, ordenats per TicketID
    List<String> solucio2 = passengers.stream()
        .filter(p -> !p.isSurvived())
        .filter(p -> p.getTicket() != null &&
                p.getTicket().getCabinId() != null &&
                !p.getTicket().getCabinId().trim().isEmpty())
        .sorted(Comparator.comparing(passenger -> passenger.getTicket().getTicketId()))
        .map(p -> p.getName())
        .toList();
    
        System.out.println("PASSATGERS AMB CAMAROT INFORMAT:");
        System.out.println(solucio2);
        
        
    //Llista els Tickets de 'ClasseId'=1
    List<String> solucio3 = passengers.stream()
            .filter(passenger -> passenger.getTicket().getClassId() == 1)
            .map(p -> p.getName())
            .toList();
        System.out.println("LLISTA DE TICKETS AMB CLASSE 1:");
        System.out.println(solucio3);
        
    //Passatgers que ocupaven el 'TicketId'="1601"
    List<String> solucio4 = passengers.stream()
            .filter(passenger -> passenger.getTicket().getTicketId().equals("1601"))
            .map(p -> p.getName())
            .toList();
        
        System.out.println("PASSATGERS EN TICKET='1601':");
        System.out.println(solucio4);
    //Ràtio de persones supervivents, és a dir: 'núm supervivents classe x / total passatgers' per a cada classe (1, 2, 3)

    
    }
    
}

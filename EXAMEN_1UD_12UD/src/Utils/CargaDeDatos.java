/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Classes.Passenger;
import Classes.Ticket;
import Enums.EmbarkationPort;
import Enums.Gender;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static javax.print.attribute.Size2DSyntax.MM;
import static javax.swing.text.html.HTML.Tag.DD;

/**
 *
 * @author Mark
 */
public class CargaDeDatos {
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    
    public Set<Passenger> LeerArchivo(String archivo,String archivoLog){
        try(Stream<String> lineas = Files.lines(Paths.get(archivo));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoLog))){
            int[] numLinea = {0};
            
            return  lineas.filter(linea -> !linea.startsWith("#"))
                    .map(linea -> parsePassenger(linea, numLinea[0]++, bufferedWriter))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet()); 
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    private Passenger parsePassenger(String linea, int numLinea, BufferedWriter bufferedWriter){
        try{
            String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            
            if (partes.length <= 4 || partes[4].trim().isEmpty()) {
            bufferedWriter.write("Línea " + numLinea + ": Error, la fecha de nacimiento está vacía.\n");
            return null;
        }
            int _passengerId = Integer.parseInt(partes[0].trim());
            boolean _survived = partes[1].trim().equals("1");
            String _name = partes[2].trim();
            Gender _gender = Gender.valueOf(partes[3].trim().toUpperCase());
            LocalDate _birthdate = LocalDate.parse(partes[4].trim(), FORMATO_FECHA);
            Ticket _ticket = parseTicket( linea, numLinea, bufferedWriter);
            EmbarkationPort _embarkationPort;
            try{
             _embarkationPort = EmbarkationPort.valueOf(partes[11].trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                // Si es 'X' o cualquier cosa que no sea Q, S o C, se escribe en el log
                bufferedWriter.write("Línea " + numLinea + ": Puerto de embarque inválido ('" + partes[11].trim() + "').\n");
                return null; // El Stream lo descarta automáticamente
            }
            
            return new Passenger(_passengerId, _survived, _name, _gender, _birthdate, _ticket, _embarkationPort);
            
        } catch(NumberFormatException e){
            System.err.println("Formato incorrecto" + e.getMessage());
        } catch (IllegalArgumentException e){
            System.err.println("Illegal Argument" + e.getMessage());
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }
        return null;
    }
    
    private Ticket parseTicket(String linea, int numLinea, BufferedWriter bufferedWriter) throws IOException{
        try{
            String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            
            String _ticketId = partes[7].trim();
            double _fare = Double.parseDouble(partes[8].trim());
            String _cabinId = partes[9].trim(); 
            int _classId = Integer.parseInt(partes[10].trim());
            
            return new Ticket(_ticketId, _fare, _cabinId, _classId);
            
        } catch(NumberFormatException e){
            System.err.println("Formato incorrecto" + e.getMessage());
        } catch (IllegalArgumentException e){
            System.err.println("Illegal Argument" + e.getMessage());
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }
}

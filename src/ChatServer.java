import ea.*;
import java.util.*;



public class ChatServer implements Runnable, Empfaenger{
    /**
     * Der Kern-Server aus der Engine. Kümmert sich um 
     * die Netzwerk-Kommunikation.
     */
    private Server server;
    //private ArrayList<ClientHandler> handlers = new ArrayList<>();

    public ChatServer() {
        //Port 40089 ist willkürlich gewählt. Wichtig ist,
        //  - dass die Portnummer größer als 1024 ist.
        //  - dass der Client dieselbe Portnummer hat.
        server = new Server(40089);
        server.globalenEmpfaengerSetzen(this);

        //new Thread(this).start();
    }

    /**
     * In dieser Run-Methode wartet ein eigener Thread nur auf neu andockende Clients,
     * um diese dann durch einen eigenen ClientHandler zu bedienen.
     */
    @Override
    public void run() {
        //Dauerschleife
        while(!Thread.interrupted()) {
            //Gib mir die nächste Verbindung
            //   (warte ggf. solange, bis eine neue Verbindung zustandekommt)
            NetzwerkVerbindung verbindung = server.naechsteVerbindungAusgeben();
            
            
            //handlers.add(new ClientHandler(verbindung));
        }
    }

    @Override
    public void empfangeString(String s) {
        //ToDo: Der Server soll alle Empfangenen Nachrichten an alle Clients zurückschicken
        server.sendeString(s);
    }








    //Diese Methoden müssen implementiert werden, sind aber für das Projekt unwichtig:
    @Override
    public void empfangeInt(int i) {

    }

    @Override
    public void empfangeByte(byte b) {

    }

    @Override
    public void empfangeDouble(double v) {

    }

    @Override
    public void empfangeChar(char c) {

    }

    @Override
    public void empfangeBoolean(boolean b) {

    }

    @Override
    public void verbindungBeendet() {

    }
}

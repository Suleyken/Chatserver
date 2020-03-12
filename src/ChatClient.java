import ea.*;

public class ChatClient
extends Client {
    private String name;
    private boolean konsolenausgabe;
    
    public ChatClient(String name, boolean konsolenausgabe) {
        //Verbinde dich mit der IP-Adresse 172.0.0.1, das ist der eigene PC
        //Port 40089 ist willkürlich gewählt. Wichtig ist,
        //  - dass die Portnummer größer als 1024 ist.
        //  - dass der Client dieselbe Portnummer hat.
        super("localhost", 40089);
        this.name = name;
        this.konsolenausgabe = konsolenausgabe;

        //Warten, bis die Verbindung zum Server steht:
        //   Achtung: Wenn kein Server gefunden werden kann,
        //            friert dieser Konstruktor ein!
        warteAufVerbindung();
    }

    public void schickeNachricht(String nachricht) {
        super.sendeString("["+this.name+"]: "+nachricht);
    }

    @Override
    public void empfangeString(String string) {
        //empfangenen String einfach an der Konsole ausgeben
        if (konsolenausgabe) {
            System.out.println(this.name+" empfängt: "+string);
        }
    }
}

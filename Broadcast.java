import ea.*;

public class Broadcast
extends Server
{
    
    
    
    public Broadcast(int port) 
    {
        super(port);
    }
    
    
 
   
    @Override
    public void empfangeString (String string) 
    {
        sendeString(string);
    }
 
    
    @Override
    public void verbindungBeendet () 
    {
        sendeString("Info an alle: Ein Client hat gerade die Verbindung abgebrochen.");
    }

    @Override
    public void empfangeInt (int i) {
    }
 
    @Override
    public void empfangeByte (byte b) {
    }
 
    @Override
    public void empfangeDouble (double d) {
    }
 
    @Override
    public void empfangeChar (char c) {
    }
 
    @Override
    public void empfangeBoolean (boolean b) {
    }
}


import ea.*;


public class MeinClient
extends Client 
{
    
    
    public MeinClient(String ipAdresse,int port) 
    {
        super(ipAdresse, port);
    }
    
    
    public void sendeNachrichtAnServer(String nachricht) 
    {
        super.sendeString(nachricht);
    }
        
    
   
    @Override
    public void empfangeInt(int i) 
    {
        System.out.println("[Integer empfangen:] " + i);
    }
    
    
    @Override
    public void empfangeString(String string) 
    {
       System.out.println("[String empfangen:] " + string);
    }
}




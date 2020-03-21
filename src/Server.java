import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;

/**
 * code ungefähr eins zu eins kopiert von https://www.instructables.com/id/Creating-a-Chat-Server-Using-Java/
 * Nur das klitzekleine Stückchen Eigenleistung, bei stundenlanger Frustration herauszufinden, dass die Nachrichten nicht zurück
 * an den Client kommen, weil da statt .println() .write() in der Vorlage steht.
 * So ein Scheiß kostet mich schon wieder viel zu lange.
 * Und jetzt muss ich das noch irgendwie so hinkriegen, dass man da in der Testklasse auf "los" drücken kann und dann ein server mit zwei Clients läuft...
 */
public class Server {

    private static ArrayList<ClientThread> clients;
    private static ServerSocket serverSocket;

    public static void acceptClients() {
        clients = new ArrayList<>();
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                new Thread(client).start();
                clients.add(client);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(9876);
            acceptClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientThread extends Server implements Runnable{
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (!socket.isClosed()) {
                    String input = in.readLine();
                    if (input != null) {
                        System.out.println("input received: "+input);
                        for (ClientThread client : clients) {
                            //this.getOut().println(input);
                            client.getOut().println(input);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public PrintWriter getOut() {
            return out;
        }
    }
}

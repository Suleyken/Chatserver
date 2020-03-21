import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 9876);
            new Thread(new ServerThread(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerThread implements Runnable {
        private Socket socket;
        private BufferedReader serverIn;
        private BufferedReader userIn;
        private PrintWriter out;


        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Client's Serverthread is running!");
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                userIn = new BufferedReader(new InputStreamReader(System.in));

                while (!socket.isClosed()) {
                    if (serverIn.ready()) {
                        String input = serverIn.readLine();
                        if (input != null) {
                            System.out.println(input);
                        }
                    }
                    if (userIn.ready()) {
                        out.println(this.toString() + ": " + userIn.readLine());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

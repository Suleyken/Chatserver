public class Test {
    public Test() {
        new Thread(new ServerWrapper()).start();
        //new ClientWrapper();
        //new ClientWrapper();

    }

    private static class ServerWrapper implements Runnable {
        public void run() {
            Server.main(new String[0]);
        }
    }

    private static class ClientWrapper implements Runnable{
        public void run() {
            Client.main(new String[0]);
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}

public class Test {

    private ChatServer s;
    private ChatClient c1;
    private ChatClient c2;

    public Test() {
        s = new ChatServer();
        c1 = new ChatClient("Boro", true);
        c2 = new ChatClient("Emmerich", false);

        c1.schickeNachricht("Hallo");
        c2.schickeNachricht("Auch hallo.");
        c1.schickeNachricht("Wie geht es dir?");
        c2.schickeNachricht("Mir geht es super.");
        c1.verbindungSchliessen();
        c2.verbindungSchliessen();
    }

    public static void main(String[] args) {
        new Test();
    }
}

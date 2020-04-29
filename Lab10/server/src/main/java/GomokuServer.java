import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GomokuServer {
    private Map<String, Game> games = new HashMap<>();
    private int SIZE = 15;  // all games have this size
    // Define the port on which the server is listening

    public static final int PORT = 8100;

    public GomokuServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                //if gets "create <id>" from client
                if (request.startsWith("create")) {
                    String id = request.split(" ")[1];
                    Game game = new Game(this.SIZE);
                    game.setGameId(id);
                    Player player = new Player(socket, false); //create black player
                    game.setP1(player);
                    if (games.get(id) == null) {
                        games.put(id, game);
                        System.out.println("joc cu id = " + id + " a fost creat");
                    } else {
                        System.out.println("jocul nu a putut fi creat. id = " + id);
                    }
                }

                //if gets "join <id>" from client
                if (request.startsWith("join")) {
                    String id = request.split(" ")[1];
                    Game game = games.get(id);
                    Player player = new Player(socket, true); //create white player
                    game.setP2(player);
                    game.start();
                    games.remove(id);
                }

            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GomokuServer server = new GomokuServer();
    }
}
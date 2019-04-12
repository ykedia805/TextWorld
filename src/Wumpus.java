import java.util.HashMap;

public class Wumpus extends Creature {
    public Wumpus(Graph.Node currentRoom, Player player){
        super(currentRoom, player);
    }
    public void move() {
        if (checkForNeighbors() || currentRoom.getName().equals(player.getCurrentRoom().getName())) {
            while (checkForFarther()) {
                randomizeRoom();
            }
        }
    }

    public boolean checkForNeighbors() {
        HashMap<String, Graph.Node> playerNeighbors = player.getCurrentRoom().getNeighbors();
        HashMap<String, Graph.Node> wumpusNeighbors = currentRoom.getNeighbors();
        for (String playerNeighbor : playerNeighbors.keySet()) {
            for (String wumpusNeigbor : wumpusNeighbors.keySet()) {
                if (wumpusNeigbor.equals(playerNeighbor)) return true;
            }
        }
        return false;
    }
    public boolean checkForFarther(){
        if(player.getCurrentRoom().getNeigbbor(currentRoom.getName()) == null){
            return true;
        }
        return false;
    }
}




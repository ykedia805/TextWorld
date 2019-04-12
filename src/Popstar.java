
import java.util.HashMap;

public class Popstar extends Creature {
    public Popstar(Graph.Node currentRoom, Player player){
        super(currentRoom, player);
    }
    public void move() {
        if (checkForNeighbors() || currentRoom.getName().equals(player.getCurrentRoom().getName())) {
            if (currentRoom.getNeigbbor(player.getCurrentRoom().getName()) != null) {
                currentRoom = player.getCurrentRoom();
            } else {
                while (checkForCloser()) {
                    randomizeRoom();
                }
            }
        }
    }

    public boolean checkForNeighbors() {
        HashMap<String, Graph.Node> playerNeighbors = player.getCurrentRoom().getNeighbors();
        HashMap<String, Graph.Node> popstarNeighbors = currentRoom.getNeighbors();
        for (String playerNeighbor : playerNeighbors.keySet()) {
            for (String popstarNeigbor : popstarNeighbors.keySet()) {
                if (popstarNeigbor.equals(playerNeighbor)) return true;
            }
        }
        return false;
    }
    public boolean checkForCloser(){
        if(player.getCurrentRoom().getNeigbbor(currentRoom.getName()) != null){
            return true;
        }
        return false;
    }
}


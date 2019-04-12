
import java.util.ArrayList;
import java.util.HashMap;

    public abstract class Creature {
        protected Graph.Node currentRoom;
        protected Player player;

        protected Creature(Graph.Node currentRoom, Player player){
            this.currentRoom = currentRoom;
            this.player = player;
        }
        protected abstract void move();

        protected void randomizeRoom(){
            HashMap<String, Graph.Node> map = currentRoom.getNeighbors();
            ArrayList<Graph.Node> rooms = new ArrayList<>(map.values());
            currentRoom = rooms.get((int)Math.random()*rooms.size());
        }
        protected Graph.Node getCurrentRoom(){
            return currentRoom;
        }

        public String toString() {
            String name = this.getClass().toString();
            return name.substring(name.indexOf(" ") + 1);
        }

    }


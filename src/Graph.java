import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    //private List<Node> nodes;
    private HashMap<String, Node> nodes;
    protected ArrayList<Creature> creatures;

    public Graph() {
        nodes = new HashMap<>();
        creatures = new ArrayList<>();
    }

    public void addNode(String name, String description) {
        Node n = new Node(name, description);
        nodes.put(name, n);
    }

    public void addUndirectedEdge(String node1, String node2) {
        Node n1 = getNode(node1);
        Node n2 = getNode(node2);

        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public void addDirectedEdge(String node1, String node2) {
        Node n1 = getNode(node1);
        Node n2 = getNode(node2);
        n1.addNeighbor(n2);
    }

    public Node getNode(String name) {
        return nodes.get(name);
//        for(int i = 0; i < nodes.size(); i++) {
//            if (nodes.get(i).getName().equals(name)) {
//                return nodes.get(i);
//            }
//        }
//        return null;
    }
    public void addCreature(Creature creature){
        creatures.add(creature);
    }
    public void removeCreature(Creature creature){
        creatures.remove(creature);
    }
    public ArrayList<Creature> getCreatureList(){
        return creatures;
    }

    public class Node {
        private String name;
        private String description;
        private ArrayList<Item> items;
        // private ArrayList<Node> neighbors;
        private HashMap<String, Node> neighbors;


        public Node(String name, String description) {
            neighbors = new HashMap<>();
            items = new ArrayList<>();
            this.name = name;
            this.description = description;

        }

        private void addNeighbor(Node n) {
            neighbors.put(n.getName(), n);
        }

        public String getNeighborNames() {
            String names = "";
//            for(int i = 0; i < neighbors.size(); i++){
//                names += neighbors.get(i).getName() + " ";
//            }
//            return names;
            for (String key : neighbors.keySet()) {
                names += (key) + ", " + getNode(key).getDescription() + " \n";
            }
            return names;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public Node getNeigbbor(String name) {
            return neighbors.get(name);
//            for (int i = 0; i < neighbors.size(); i++){
//                if (neighbors.get(i).getName().equals(name)){
//                    return neighbors.get(i);
//                }
//            }
//            return null;
        }
        public HashMap<String, Graph.Node> getNeighbors(){
            return neighbors;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Item> getItems() {
            return items;
        }
        public ArrayList<Creature> getCreatures(){
            ArrayList<Creature> creaturesInRoom = new ArrayList<>();
            for(int i = 0; i < creatures.size(); i++) {
                if (creatures.get(i).getCurrentRoom().getName().equals(name)) creaturesInRoom.add(creatures.get(i));
            }
            return creaturesInRoom;
        }

        public void displayItems() {
            System.out.println(items.toString());
        }

        public void addItem(String name) {
            Item i = new Item(name, "");
            items.add(i);
        }

        public void addItem(String name, String description) {
            Item i = new Item(name, description);
            items.add(i);
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public Item removeItem(String name) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(name)) return items.get(i);
            }
            return null;
        }

        public boolean destroyItem(String name) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(name)) items.remove(i);
            }
            return true;
        }


    }

}


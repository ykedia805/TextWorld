import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Item> items;
    Graph.Node currentRoom;

    public Player(String name, Graph.Node currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        items = new ArrayList<>();
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void displayInventory() {
        System.out.println(items.toString());
    }

    public Graph.Node getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        if (moveToRoom(currentRoom.getName())) this.currentRoom = currentRoom;
    }

    public boolean moveToRoom(String name) {
        for (int i = 0; i < this.currentRoom.getNeighbors().size(); i++) {
            if (currentRoom.getNeighbors().get(i).getName().equals(name)) return true;
        }
        return false;
    }
}



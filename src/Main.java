import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", " a long and thin dark hallway");
        g.addNode("closet", "A small well lit closet");
        g.addNode("dungeon", "an underground torture room");
        g.addNode("room", "an underground torture room");
        g.addNode("bedroom", "an underground torture room");
        g.addNode("kitchen", "an underground torture room");
        g.addNode("backyard", "an underground torture room");
        g.addNode("patio", "an underground torture room");
        g.addNode("bathroom", "an underground torture room");
        g.addNode("frontyard", "an underground torture room");



        g.addUndirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("hall", "bedroom");
        g.addUndirectedEdge("frontyard", "kitchen");
        g.addUndirectedEdge("kitchen", "hall");
        g.addUndirectedEdge("hall", "room");
        g.addUndirectedEdge("room", "backyard");
        g.addUndirectedEdge("dungeon", "closet");
        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
//        g.addUndirectedEdge("hall", "closet");
        Player p = new Player("Gus", g.getNode("hall"));
        String response = "";

        for(int i = 0; i < 10; i++) {
            Creature c = new Chicken(g.getNode("hall"), p);
            c.randomizeRoom();
            Creature d = new Wumpus(g.getNode("hall"), p);
            d.randomizeRoom();
            Creature f = new Popstar(g.getNode("closet"), p);
            f.randomizeRoom();
            g.addCreature(c);
            g.addCreature(d);
            g.addCreature(f);
        }


        Scanner in = new Scanner(System.in);
        System.out.println("You can type 'go <roomname>' to go to that room \n 'look' to see all the neighboring rooms. \n  'add <roomname>, <description>' to add a new neighbor. \n 'take <itemName> to take an item. \n 'drop <itemName> to drop item in the room. \n 'quit' to quit");
        do{
            System.out.println("You are currently in the " + p.getCurrentRoom().getName());
            response = in.nextLine();
            String [] words = response.split(" ");
            String firstWord = words[0];
            for(int i = 0; i < g.getCreatureList().size(); i++){
                g.getCreatureList().get(i).move();
            }

            if(firstWord.equals("go")){
                Graph.Node nextRoom = p.getCurrentRoom().getNeigbbor(words[1]);
                if(nextRoom == null){
                    System.out.println("You can't go to " + words[1] + " try again");
                } else{
                    p.setCurrentRoom(nextRoom);
                }

            } else if( firstWord.equals("look")){
                System.out.println("In the room there is a " + p.getCurrentRoom().getItems().toString());
                System.out.println("There are " + p.getCurrentRoom().getCreatures());
                System.out.println("You can go to the " + p.getCurrentRoom().getNeighborNames());



            } else if(firstWord.equals("add")){
                g.addNode(response.substring(0, response.indexOf(",")), response.substring(response.indexOf(",") + 2));
                g.addUndirectedEdge(p.getCurrentRoom().getName(), words[1]);

            } else if(firstWord.equals("quit")){
                System.out.println("You have quit the game.");
                response = "quit";
            } else if (firstWord.equals("take")){
                if (p.removeItem(words[1]) == null) {
                    System.out.println("This item is not in the room.");

                }
                p.addItem(p.getCurrentRoom().removeItem(words[1]));
                System.out.println("You took " + words[1] + " from the "+  p.getCurrentRoom());
            } else if (firstWord.equals("drop")){
                if (p.removeItem(words[1]) == null) {
                    System.out.println("You do not have this item.");

                }
                p.getCurrentRoom().addItem(p.removeItem(words[1]));
                System.out.println("You put " + words[1] + " in the "+  p.getCurrentRoom());
            }
            for(int i = 0; i < g.getCreatureList().size(); i++){
                g.getCreatureList().get(i).move();
            }




        } while (!response.equals("quit"));
    }
}



public class Chicken extends Creature {
    public Chicken(Graph.Node currentRoom, Player player){
        super(currentRoom, player);
    }
    @Override
    public void move() {
        randomizeRoom();
    }


}


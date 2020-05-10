import oop.ex2.SpaceShipPhysics;

/**
 * The Basher spaceship is quite greedy when it comes to its energy level (which goes up when it collides with another
 * ship while being shielded). The Basher is constantly checking how close he is to other spaceships and will
 * when he sees he is a decently close distance to another Spaceship, he will activate his shields and attempt to
 * collide into the spaceship of closest vicinity.
 */
public class BasherSpaceship extends SpaceShip {
    @Override
    public void doAction(SpaceWars game){
        isShieldOn();
        SpaceShip closestShip = game.getClosestShipTo(this);
        SpaceShipPhysics closestShipPhysics = closestShip.getPhysics();
        boolean accelerateShip = true;
        int shipTurn;
            if (ship.angleTo(closestShipPhysics) < 0) {shipTurn = -1;
            } else {shipTurn = 1;}
        if (distanceFromShip(closestShipPhysics) < 0.19) {shieldOn();}
        moveShip(accelerateShip ,shipTurn);
        rechargeShip();
        addRound();
    }
}

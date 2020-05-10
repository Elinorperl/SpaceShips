import oop.ex2.SpaceShipPhysics;

/**
 * The aggressive spaceship calculates the ship closest to him and tries to bombard it with shots.
 */
public class AggressiveSpaceship extends SpaceShip {
    @Override
    public void doAction(SpaceWars game) {
        isShieldOn();
        SpaceShip closestShip = game.getClosestShipTo(this);
        SpaceShipPhysics closestShipPhysics = closestShip.getPhysics();
        boolean accelerateShip = true;
        int shipTurn;
        if (ship.angleTo(closestShipPhysics) < 0) {
            shipTurn = -1;
        } else {
            shipTurn = 1;
        }
        if (distanceFromShip(closestShipPhysics) < 0.21) {
            fire(game);
        }
        moveShip(accelerateShip, shipTurn);
        rechargeShip();
        addRound();
    }
}

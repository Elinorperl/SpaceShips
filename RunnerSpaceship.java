import oop.ex2.SpaceShipPhysics;
import java.lang.Math;


/**
 * As you can see, the runner is the "scardey cat" of the bunch - he runs away from any ship in his path - and even
 * more so if he feels threatened, he even teleports away from the area.
 */
    public class RunnerSpaceship extends SpaceShip {
        @Override
        public void doAction(SpaceWars game) {
            isShieldOn();
            SpaceShip closestShip = game.getClosestShipTo(this);
            SpaceShipPhysics closestShipPhysics = closestShip.getPhysics();
            boolean accelerateShip = true;
            if ((Math.abs(ship.angleTo(closestShipPhysics)) < 0.23) || (distanceFromShip(closestShipPhysics) < 0.25)) {
                teleport();
            } if (ship.angleTo(closestShipPhysics) < 0) {
                moveShip(accelerateShip, 1);
            } else {moveShip(accelerateShip, -1);}
            rechargeShip();
            addRound();
        }
    }


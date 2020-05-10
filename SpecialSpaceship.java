import oop.ex2.SpaceShipPhysics;
import javax.swing.*;
import java.awt.*;

/**
 * Our special spaceship acts as a "sneak attack" spaceship, attacking other spaceships while invisible.
 */

public class SpecialSpaceship extends SpaceShip {
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
        } if (distanceFromShip(closestShipPhysics) < 0.21) {fire(game);}
        moveShip(accelerateShip, shipTurn);
        rechargeShip();
        addRound();
    }

    /**
     * The spaceship's invisibility was implemented by applying a black picture (so that it blends into the background
     * of the GUI).
     */
    private Image becomeInvisible() {
        return new ImageIcon(SpecialSpaceship.class.getResource("black.gif"), "").getImage();
    }

    @Override
    public Image getImage() {return becomeInvisible();}

}

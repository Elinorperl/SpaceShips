import oop.ex2.GameGUI;
import java.awt.*;

/**
 * This class is an inherited class of Spaceship - a class defining the interconnected qualities of each spaceship.
 * This class is controlled by a user -allowing the user to control all aspects of the ship, when the shield is
 * implemented, where the ship moves, and if it will teleport.
 */

public class HumanSpaceship extends SpaceShip {
    @Override
    public void doAction(SpaceWars game) {
        isShieldOn();
        boolean accelerate = false;
        int turn = 0;
        if (game.getGUI().isUpPressed()) {
            accelerate = true;
        }
        if (game.getGUI().isLeftPressed()) {
            turn = 1;
            }
        else if (game.getGUI().isRightPressed()) {
            turn = -1;
            }
        moveShip(accelerate, turn);
        if (game.getGUI().isShieldsPressed()) {
            shieldOn();
        } if (game.getGUI().isShotPressed()) {
            fire(game);
        } if (game.getGUI().isTeleportPressed()) {
            teleport();
        }rechargeShip();
        addRound();
    }

    /**
     * This function overrides the "getImage" function that is implemented in the "Spaceship" class, creating a special
     * image for the HumanSpaceship.
     */

    @Override
    public Image getImage() {
        if (shipShield) {
            return GameGUI.SPACESHIP_IMAGE_SHIELD;
        } else {
            return GameGUI.SPACESHIP_IMAGE;
        }
    }
}

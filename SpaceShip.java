import java.awt.Image;
import oop.ex2.*;

/**
 * The API spaceships need to implement for the SpaceWars game. 
 * It is your decision whether SpaceShip.java will be an interface, an abstract class,
 *  a base class for the other spaceships or any other option you will choose.
 *
 * @author oop
 */
public abstract class SpaceShip{

    int health = 22;
    int currentEnergy = 190;
    int maximalEnergy = 210;
    int roundCounter = 0;
    int HITVALUE = 10;
    int SHOOTVALUE = 19;
    int TELEPORTVALUE = 140;
    int SHIELDCOLLIDEVALUE = 18;
    int SHIELDVALUE = 3;
    boolean shipShield = false;
    SpaceShipPhysics ship = new SpaceShipPhysics();

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
    }

    /**
     * This method is called every time a collision with this ship occurs
     */
    public void collidedWithAnotherShip(){
        if ((!shipShield)){
            health--;
            maximalEnergy -= HITVALUE;
            if (currentEnergy > maximalEnergy){
                currentEnergy = maximalEnergy;
            }
        }else if (shipShield){
            currentEnergy += SHIELDCOLLIDEVALUE;
            maximalEnergy += SHIELDCOLLIDEVALUE;
        }
    }

    /**
     * This method is called whenever a ship has died. It resets the ship's
     * attributes, and starts it at a new random position.
     */
    public void reset(){
        if (isDead())
            health = 22;
            currentEnergy = 190;
            maximalEnergy = 210;
            roundCounter = 0;
            shipShield = false;
            ship = new SpaceShipPhysics();
        }

    /**
     * Checks if this ship is dead.
     *
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        if (health == 0){ return true;}
        return false;
    }

    /**
     * Gets the physics object that controls this ship.
     *
     * @return ship - the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {return ship;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        { if (!shipShield)
            maximalEnergy -= HITVALUE;
            if (currentEnergy > maximalEnergy) {
                currentEnergy = maximalEnergy;
            }
        }
    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (shipShield) {
            return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
        } else {
            return GameGUI.ENEMY_SPACESHIP_IMAGE;
        }
    }


    /**
     * Attempts to fire a shot.
     *
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
        if (currentEnergy > SHOOTVALUE && roundCounter == 0) {
            game.addShot(getPhysics());
            roundCounter = 1;
            currentEnergy -= SHOOTVALUE;
        }
    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        if (currentEnergy > SHIELDVALUE){
            shipShield = true;
            currentEnergy -= SHIELDVALUE;}
    }

    /**
     * Attempts to teleport.
     */
    public void teleport() {
        if (currentEnergy > TELEPORTVALUE){
            ship = new SpaceShipPhysics();
            currentEnergy -= TELEPORTVALUE;
        }
    }

    /**
     * Moves the ships
     * @param accelerate - boolean, if the spaceship should accelerate or not.
     * @param direction - int, representing the direction in which the spaceship should continue.
     */
    public void moveShip (boolean accelerate, int direction) {
        ship.move(accelerate, direction);
    }

    /**
     * "Reacharges" the ship each round by adding to the ship's current energy level - until it reaches the maximal
     * energy in which case it will stay equivalent to the maximal.
     */
    public void rechargeShip () {
        currentEnergy++;
        if (currentEnergy > maximalEnergy)
            currentEnergy = maximalEnergy;

    }

    /**
     * Checks the distance between our ship and another surrounding ship.
     * @param other - another spaceship on the board.
     * @return distance between the ships.
     */

    public double distanceFromShip(Physics other){return ship.distanceFrom(other);}

    /**
     * Counts up the amount of rounds initialized in the game.
     */
    public void addRound(){
        if (roundCounter!=0)
        roundCounter++;
        if(roundCounter==8)
    roundCounter = 0;
    }

    /**
     * This function checks if the shield is on, and will reset it.
     */
    public void isShieldOn(){
        if (shipShield) {
            shipShield = false;}
    }

}

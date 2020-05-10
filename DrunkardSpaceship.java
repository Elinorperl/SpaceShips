import java.util.Random;

/**
 * Our drunken friend has had a wild night partying and has (illegally!) taken the keys to his spaceship
 * and gone off driving. The results are inevitably disastrous and has caused the drunken driver to proceed his
 * driving in a random manner, with a disregard of who is in his way or his general surroundings.
 */
public class DrunkardSpaceship extends SpaceShip {
    Random random = new Random();
    private final int DECIDINGFACTOR = 0;
    private final int TELEPORTER = 149;
    private final int SHIELDER = 164;
    private final int FIREAWAY = 128;
    private final int TRYLEFT = random.nextInt(5)+1;
    private final int TRYRIGHT = random.nextInt(5)+1;

    /**
     * This function overrides it's super class function, making the drunkard act in certain ways - using random
     * movements to define what he acts upon.
     * @param random - number picked at random.
     * @param number - a random number according to action
     * @return true if the the equations proves true, false otherwise.
     */
    public boolean randomDoAction (int random, int number){
        return random%number == DECIDINGFACTOR;
    }

    @Override
    public void doAction(SpaceWars game) {
        isShieldOn();
        int randomRange = random.nextInt(500) + 1;
        if (randomDoAction(randomRange,TELEPORTER)) {teleport();}
        if (randomDoAction(randomRange,SHIELDER)) {shieldOn();}
        if (randomDoAction(randomRange,FIREAWAY)) {fire(game);}
        if (randomDoAction(randomRange,TRYLEFT)) {moveShip(true, 1);
        } else if (randomDoAction(randomRange,TRYRIGHT)) {moveShip(true, -1);
        } else {moveShip(true,DECIDINGFACTOR);}
        rechargeShip();
        addRound();
    }
}

import oop.ex2.*;

public class SpaceShipFactory {

    /**
     * According to the configuration input, creates one of the 6 spaceships.
     * @param args - The arguments that were input by user.
     * @return spaceShipType - the relevant ship, according to input.
     */

    public static SpaceShip[] createSpaceShips(String[] args) {
    SpaceShip[] spaceShipType = new SpaceShip[args.length];
    for (int i = 0; i < args.length; i++) {
        switch (args[i]) {
            case "h":
                spaceShipType[i] = new HumanSpaceship();
                break;
            case "r":
                spaceShipType[i] = new RunnerSpaceship();
                break;
            case "b":
                spaceShipType[i] = new BasherSpaceship();
                break;
            case "a":
                spaceShipType[i] = new AggressiveSpaceship();
                break;
            case "d":
                spaceShipType[i] = new DrunkardSpaceship();
                break;
            case "s":
                spaceShipType[i] = new SpecialSpaceship();
                break;
        }
    } return spaceShipType;

    }
}

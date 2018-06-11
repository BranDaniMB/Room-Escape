package files;

import game.Chrono;

/**
 *
 * @author Jermy
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PropertiesConfig.getInstance().readConfig();
        PropertiesConfig.getInstance().addConfig("Num", "65");
        new Chrono().start();
    }
    
}

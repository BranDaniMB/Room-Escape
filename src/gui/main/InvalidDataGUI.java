package gui.main;

/**
 *
 * @author BranDaniMB
 */
public class InvalidDataGUI extends Exception {

    /**
     * Creates a new instance of <code>InvalidDataGUI</code> without detail
     * message.
     */
    public InvalidDataGUI() {
    }

    /**
     * Constructs an instance of <code>InvalidDataGUI</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDataGUI(String msg) {
        super(msg);
    }
}

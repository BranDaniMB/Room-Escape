
package objects;

/**
 *
 * @author Jermy
 */
public class Padlock {

    private boolean open;
    private Riddle riddle;
    private String idPadlock;

    public Padlock(Riddle riddle, String idPadlock) {
        this.open = false;
        this.riddle = riddle;
        this.idPadlock = idPadlock;
    }

    public String getIdPadlock() {
        return idPadlock;
    }

    public void setIdPadlock(String idPadlock) {
        this.idPadlock = idPadlock;
    }
    
    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Riddle getRiddle() {
        return riddle;
    }

    public void setRiddle(Riddle riddle) {
        this.riddle = riddle;
    }

    public boolean tryUnlockTrack(String msj) {
        return riddle.getTrackLock().tryUnlock(msj);
    }

    public boolean tryOpen(String txt) {
        if (txt.equals(riddle.getAnswer())) {
            open = true;
            return true;
        }
        return false;
    }
}

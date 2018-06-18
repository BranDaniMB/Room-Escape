package objects;

import java.io.Serializable;

/**
 *
 * @author Jermy
 */
public class TrackLocked implements Cloneable, Serializable {

    private boolean unlock;
    private String answer;
    private String question;
    private String track;

    public TrackLocked(String answer, String question, String track) {
        this.unlock = false;
        this.answer = answer;
        this.question = question;
        this.track = track;
    }
    
    public boolean isUnlock() {
        return unlock;
    }

    public void setUnlock(boolean unlock) {
        this.unlock = unlock;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTrack() {
        if (unlock) {
            return track;
        }
        return "";
    }

    public void setTrack(String track) {
        this.track = track;
    }
    
    public boolean tryUnlock(String msj) {
        if (msj.equals(answer)) {
            unlock = true;
            return unlock;
        }
        return unlock;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new TrackLocked(answer, question, track);
    }

    @Override
    public String toString() {
        return "TrackLocked{" + "unlock=" + unlock + ", answer=" + answer + ", question=" + question + ", track=" + track + '}';
    }
    
}

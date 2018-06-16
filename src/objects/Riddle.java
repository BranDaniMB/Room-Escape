package objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro Rodriguez
 */
public class Riddle implements Cloneable, Serializable {

    private ArrayList<String> tracks;
    private String question;
    private String answer;
    private TrackLock trackLock;

    public Riddle(String question, String answer, ArrayList tracks, TrackLock trackLock) {
        this.question = question;
        this.answer = answer;
        this.tracks = tracks;
        this.trackLock = trackLock;
    }

    public TrackLock getTrackLock() {
        return trackLock;
    }

    public void setTrackLock(TrackLock trackLock) {
        this.trackLock = trackLock;
    }

    public Riddle() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int size() {
        return tracks.size();
    }

    public boolean add(String e) {
        return tracks.add(e);
    }

    public ArrayList<String> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<String> tracks) {
        this.tracks = tracks;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList copy() {
        ArrayList aux = new ArrayList();
        for (int i = 0; i < tracks.size(); i++) {
            aux.add(tracks.get(i).toString());
        }
        return aux;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Riddle(question, answer, copy(), (TrackLock) trackLock.clone());
    }

    public boolean isCorrect(String msg) {
        return (answer.equals(msg));
    }
}

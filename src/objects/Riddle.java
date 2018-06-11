package objects;

import java.util.ArrayList;

/**
 *
 * @author Pedro Rodriguez
 */
public class Riddle implements Cloneable {

    private ArrayList<String> tracks;
    private String question;
    private String answer;

    public Riddle(String question, String answer, ArrayList tracks) {
        this.question = question;
        this.answer = answer;
        this.tracks = tracks;
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
        return new Riddle(question, answer, copy());
    }

    public boolean isCorrect(String msg) {
        return (answer.equals(msg));
    }
}

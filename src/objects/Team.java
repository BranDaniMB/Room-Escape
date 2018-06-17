package objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Jermy
 */
public class Team implements Comparable<Team>, Serializable {

    private String teamName;
    private TreeSet<Player> playersList;
    private LocalDate dateInscription;
    private String bestTimeSingle;
    private String bestTimeMultiplayer;
    private boolean playing;

    public Team() {
        this.teamName = "";
        this.playersList = new TreeSet<>();
        this.dateInscription = null;
        this.bestTimeSingle = "30:00";
        this.bestTimeMultiplayer = "30:00";
        this.playing = false;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TreeSet<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(TreeSet<Player> playersList) {
        this.playersList = playersList;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getBestTimeSingle() {
        return bestTimeSingle;
    }

    public void setBestTimeSingle(String bestTimeSingle) {
        if ((this.bestTimeSingle.compareTo(bestTimeSingle)) > 0) {
            this.bestTimeSingle = bestTimeSingle;
        }
    }

    public String getBestTimeMultiplayer() {
        return bestTimeMultiplayer;
    }

    public void setBestTimeMultiplayer(String bestTimeMultiplayer) {
        if ((this.bestTimeMultiplayer.compareTo(bestTimeMultiplayer)) > 0) {
            this.bestTimeMultiplayer = bestTimeMultiplayer;
        }
    }

    public synchronized boolean isPlaying() {
        return playing;
    }

    public synchronized void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int size() {
        return playersList.size();
    }

    public boolean add(Player e) {
        return playersList.add(e);
    }

    @Override
    public int compareTo(Team o) {
        return teamName.compareTo(o.teamName);
    }

    public Player searchPlayer(String id) {

        Iterator<Player> iterator = playersList.iterator();
        while (iterator.hasNext()) {
            Player aux = iterator.next();
            if (aux.getId().equals(id)) {
                return aux;
            }
        }
        return null;
    }

    public String printPlayers() {
        String txt = "";
        Iterator<Player> iterator = playersList.iterator();
        while (iterator.hasNext()) {
            txt += iterator.next().getId() + "\n";
        }
        return txt;
    }

    @Override
    public String toString() {
        String txt = "Nombre: " + this.teamName + "\nJugadores: ";

        Iterator<Player> iterator = playersList.iterator();
        while (iterator.hasNext()) {
            txt += iterator.next().getId() + ", ";
        }
        return txt;
    }
}

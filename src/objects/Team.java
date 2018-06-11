package objects;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Jermy
 */
public class Team implements Comparable<Team> {

    private String teamName;
    private TreeSet<Player> playersList;
    private LocalDate dateInscription;
    private String bestTimeSingle;
    private String bestTimeMultiplayer;
    private int playersOnline;
    private boolean playing;

    public Team() {
        this.teamName = "";
        this.playersList = new TreeSet<>();
        this.dateInscription = null;
        this.bestTimeSingle = "30:00";
        this.bestTimeMultiplayer = "30:00";
        this.playersOnline = 0;
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
        this.bestTimeSingle = bestTimeSingle;
    }

    public String getBestTimeMultiplayer() {
        return bestTimeMultiplayer;
    }

    public void setBestTimeMultiplayer(String bestTimeMultiplayer) {
        this.bestTimeMultiplayer = bestTimeMultiplayer;
    }

    public int getPlayersOnline() {
        return playersOnline;
    }

    public void setPlayersOnline(int playersOnline) {
        this.playersOnline = playersOnline;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
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

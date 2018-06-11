package objects;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author BranDaniMB
 */
public class PseudoTeam {

    private final SimpleStringProperty name;
    private final SimpleStringProperty players;
    private final SimpleStringProperty time;

    public PseudoTeam(String name, String players, String time) {
        this.name = new SimpleStringProperty(name);
        this.players = new SimpleStringProperty(players);
        this.time = new SimpleStringProperty(time);

    }

    public String getName() {
        return name.get();
    }

    public String getPlayers() {
        return players.get();
    }

    public String getTime() {
        return time.get();
    }
}

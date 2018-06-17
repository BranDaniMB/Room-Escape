/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import listManager.TeamList;
import objects.Player;
import objects.Subteam;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class GameCreate extends Thread {

    private ArrayList<Team> teams;
    private ArrayList<Subteam> subTeams;

    private TreeMap<Team, Subteam> list;

    public void setList(TreeMap<Team, Subteam> list) {
        this.list = list;
    }

    public GameCreate() {
        teams = new ArrayList<>();
        subTeams = new ArrayList<>();
    }

    public void createSingleGame() throws InvalidDataException {
        Entry<Team, Subteam> entry = list.pollFirstEntry();
        entry.getKey().setPlaying(true);

        Iterator<Player> iterator = entry.getValue().getPlayers().iterator();

        while (iterator.hasNext()) {
            iterator.next().setSelected(true);
        }
        new Game().createSingleGame(entry.getKey(), entry.getValue().size());
    }

    public void runMultiplayerGame() throws InvalidDataException {
        Entry<Team, Subteam> entry;
        do {
            entry = list.pollFirstEntry();

            if (entry == null) {
                break;
            }
            teams.add(entry.getKey());
            subTeams.add(entry.getValue());
        } while (true);
        new Game(teams, subTeams).createMultiplayerGame();
    }

    public void delete() {
        this.subTeams = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.list = null;
    }
}

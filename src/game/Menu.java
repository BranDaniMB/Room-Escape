package game;

import builderteam.BuilderDirector;
import builderteam.InvalidDataException;
import gui.main.InitGUI;
import objects.PseudoTeam;
import objects.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import javafx.application.Application;
import listManager.ListRoomRiddle;
import listManager.TeamList;
import objects.Player;
import objects.Subteam;

/**
 *
 * @author Jermy
 */
public class Menu {

    private final BuilderDirector buildTeam;
    private final TeamList teamList;
    private LinkedList<Team> listOfTeamsToPlay;
    private TreeMap<Team, Subteam> list;
    private Team currentSelectionTeam;

    public Menu() {
        teamList = TeamList.getInstance();
        buildTeam = new BuilderDirector();
        listOfTeamsToPlay = new LinkedList<>();
        currentSelectionTeam = null;
    }

    public void registerTeamProcess(String name, String id, LocalDate date) throws InvalidDataException {
        teamList.add(buildTeam.createTeam(null, name, id, date));
    }

    public ArrayList<PseudoTeam> listByName() {
        return passListToPseudoTeam(teamList.orderByName());
    }

    public ArrayList<PseudoTeam> listByInscription() {
        return passListToPseudoTeam(teamList.orderByInscription());
    }

    public ArrayList<PseudoTeam> listByTime() {
        return passListToPseudoTeam(teamList.orderByTime());
    }

    public ArrayList<PseudoTeam> passListToPseudoTeam(List<Team> list) {
        ArrayList<PseudoTeam> newList = new ArrayList<>();

        for (Team team : list) {
            newList.add(new PseudoTeam(team.getTeamName(), team.printPlayers(), team.getBestTimeSingle(), team.getDateInscription().toString()));
        }
        return newList;
    }

    public void saveAllData() {
        RoomEscape.FILES_MANAGER_LIST.writeFile("Files/TeamList.ser", TeamList.getInstance().getTeamsList());
        RoomEscape.FILES_MANAGER_LIST_RIDDLES.writeFile("Files/RiddlesList.ser", ListRoomRiddle.getInstance().getListRiddle());
        System.out.println("Save all data.");
    }

    public void AddToList(String listPlayerToPlay) {
        Subteam team = new Subteam();
        String[] s = listPlayerToPlay.split("-");
        for (String item : s) {
            team.add(currentSelectionTeam.searchPlayer(item));
        }

        list.put(currentSelectionTeam, team);
    }

    public Team getCurrentSelectionTeam() {
        return currentSelectionTeam;
    }

    public int getTeamsToPlaySize() {
        return listOfTeamsToPlay.size();
    }

    public void getNextTeam() {
        this.currentSelectionTeam = listOfTeamsToPlay.poll();
    }

    public String getSelectablePlayers() {
        String txt = "";
        Iterator<Player> iterator = currentSelectionTeam.getPlayersList().iterator();

        while (iterator.hasNext()) {
            txt += iterator.next().toString() + "-";
        }

        return txt;
    }

    public void addsTeamsToPlay(String text) {
        String[] s = text.split("-");

        for (String item : s) {
            listOfTeamsToPlay.add(teamList.searchTeam(item));
        }
    }

    public String getSelectableTeams() {
        String list = "";
        if (teamList.size() > 0) {
            Iterator<Team> iterator = teamList.getTeamsList().iterator();

            while (iterator.hasNext()) {
                list += iterator.next().getTeamName() + "-";
            }
        } else {
            list = "No hay equipos, añade alguno para jugar.";
        }

        return list;
    }

    public void runGui() {
        Application.launch(InitGUI.class, "id");
    }
}

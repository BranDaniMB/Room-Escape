package game;

import builderteam.BuilderDirector;
import builderteam.InvalidDataException;
import gui.main.InitGUI;
import objects.PseudoTeam;
import objects.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import listManager.ListRoomRiddle;
import listManager.TeamList;

/**
 *
 * @author Jermy
 */
public class Menu {

    private final BuilderDirector buildTeam;
    private final TeamList teamList;

    public Menu() {
        teamList = TeamList.getInstance();
        buildTeam = new BuilderDirector();
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

    public void runGui() {
        Application.launch(InitGUI.class, "id");
    }
}

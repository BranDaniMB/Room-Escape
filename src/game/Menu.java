package game;

import builderteam.BuilderDirector;
import builderteam.InvalidDataException;
import objects.PseudoTeam;
import objects.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import listManager.TeamList;

/**
 *
 * @author Jermy
 */
public class Menu {

    private final BuilderDirector buildTeam = new BuilderDirector();
    private final TeamList teamList = TeamList.getInstance();

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
            newList.add(new PseudoTeam(team.getTeamName(), team.printPlayers(), team.getBestTimeMultiplayer(), team.getDateInscription().toString()));
        }
        return newList;
    }
}

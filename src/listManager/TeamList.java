/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import objects.Team;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Jermy
 */
public class TeamList {

    private TreeSet<Team> teamsList;
    private PrintOrder printMethod;
    private int teamsPlaying;

    private TeamList() {
        teamsList = new TreeSet<>();
    }

    public static TeamList getInstance() {
        return TeamList2Holder.INSTANCE;
    }

    private static class TeamList2Holder {

        private static final TeamList INSTANCE = new TeamList();
    }

    public TreeSet<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(TreeSet<Team> teamsList) {
        this.teamsList = teamsList;
    }

    public PrintOrder getPrintMethod() {
        return printMethod;
    }

    public void setPrintMethod(PrintOrder printMethod) {
        this.printMethod = printMethod;
    }

    public int getTeamsPlaying() {
        return teamsPlaying;
    }

    public void setTeamsPlaying(int teamsPlaying) {
        this.teamsPlaying = teamsPlaying;
    }

    public int size() {
        return teamsList.size();
    }

    public boolean add(Team e) {
        return teamsList.add(e);
    }

    public Team searchTeam(String name) {

        Iterator<Team> iterator = teamsList.iterator();
        while (iterator.hasNext()) {
            Team aux = iterator.next();
            if (aux.getTeamName().equals(name)) {
                return aux;
            }
        }
        return null;
    }

    public boolean existId(String id) {
        Iterator<Team> iterator = teamsList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().searchPlayer(id) != null) {
                return true;
            }
        }
        return false;
    }

    public List<Team> orderByName() {
        List<Team> teams = new ArrayList<>(teamsList);
        printMethod = new SortName();
        printMethod.orderList(teams);
        return teams;
    }

    public List<Team> orderByInscription() {
        List<Team> teams = new ArrayList<>(teamsList);
        printMethod = new SortInscription();
        printMethod.orderList(teams);
        return teams;
    }

    public List<Team> orderByTime() {
        List<Team> teams = new ArrayList<>(teamsList);
        printMethod = new SortTime();
        printMethod.orderList(teams);
        return teams;
    }

    public List<Team> orderList() {
        List<Team> teams = new ArrayList<>(teamsList);
        printMethod.orderList(teams);
        return teams;
    }
}

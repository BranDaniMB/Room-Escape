/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jermy
 */
public class BuilderTeam {

    private Team team;
    private TeamList teamList;
    private Pattern pattern;
    private Matcher matcher;

    public BuilderTeam(TeamList teamList) {
        this.team = new Team();
        this.teamList = teamList;
    }

    public Team getTeam() {
        String txt = "";
        if (true) {

        }
        if (true) {

        }
        if (true) {
        }
        if (true) {

        }
        return team;
    }

    public void buildName(String name) {
        pattern = Pattern.compile("[A-Za-z\\s]{2,10}");
        matcher = pattern.matcher(name);
        if (!matcher.find()) {
            team.setTeamName(name);
        }
    }

    public void buildPlayers(String id) {
        pattern = Pattern.compile("");
        matcher = pattern.matcher(id);
        if (!matcher.find()) {
            team.add(new Player(id, false));
        }
    }

    public void buildInscrption(Date date) {
        if (date != null) {
            team.setDateInscription(date);
        }
    }

}

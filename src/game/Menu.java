package game;

import builderteam.BuilderDirector;
import builderteam.InvalidDataException;
import files.PropertiesConfig;
import gui.main.InitGUI;
import objects.PseudoTeam;
import objects.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import javafx.application.Application;
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
    private String mode;

    public Menu() {
        teamList = TeamList.getInstance();
        buildTeam = new BuilderDirector();
        listOfTeamsToPlay = new LinkedList<>();
        currentSelectionTeam = null;
        list = new TreeMap<>();
        mode = null;
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

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }

    public void saveAllData() {
        RoomEscape.FILES_MANAGER_LIST.writeFile("Files/TeamList.ser", TeamList.getInstance().getTeamsList());
        System.out.println("Save all data.");
    }

    public void AddToList(String listPlayerToPlay) throws InvalidDataException {
        Subteam team = new Subteam();
        String[] s = listPlayerToPlay.split("-");

        if (s.length > PropertiesConfig.getInstance().getProperties("maxPlayers") || s.length < PropertiesConfig.getInstance().getProperties("minPlayers")) {
            throw new InvalidDataException("Debe contener de 2 a 5 jugadores.");
        }

        for (String item : s) {
            Player p = currentSelectionTeam.searchPlayer(item);
            if (p != null) {
                team.add(p);
            } else {
                throw new InvalidDataException("Jugador inexistente.");
            }
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
        this.currentSelectionTeam = listOfTeamsToPlay.pollFirst();
    }

    public String getSelectablePlayers() {
        String txt = "";

        if (currentSelectionTeam.getPlayersList().size() > 0) {
            Iterator<Player> iterator = currentSelectionTeam.getPlayersList().iterator();

            while (iterator.hasNext()) {
                Player p = iterator.next();
                if (!p.isSelected()) {
                    txt += p.getId() + "-";
                }
            }
        } else {
            txt = "No hay jugadores disponibles en este equipo.";
        }

        return txt;
    }

    public void addsTeamsToPlay(String text) throws InvalidDataException {
        String[] s = text.split("-");

        switch (mode) {
            case GameRoom.TYPE_GAME_SINGLE:
                if (s.length < 1 || s.length > 1) {
                    throw new InvalidDataException("Solo debe elegir un equipo.");
                }
                break;
            case GameRoom.TYPE_GAME_MULTIPLAYER:
                if (s.length < PropertiesConfig.getInstance().getProperties("minTeamsPlaying") || s.length > PropertiesConfig.getInstance().getProperties("maxTeamsPlaying")) {
                    throw new InvalidDataException("Debe escoger a minimo 2 equipos y máximo 5 equipos.");
                }
                break;
            default:
                throw new InvalidDataException("Modo incorrecto.");
        }

        for (String item : s) {
            Team t = teamList.searchTeam(item);

            if (t != null) {
                listOfTeamsToPlay.add(t);
            } else {
                throw new InvalidDataException("Ese equipo no existe.");
            }
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

    public void finalizeSelection() {
        currentSelectionTeam = null;
        list = new TreeMap<>();
        listOfTeamsToPlay = new LinkedList<>();
        mode = null;
    }

    public void runGui() {
        Application.launch(InitGUI.class, "id");
    }

    public void initGame() throws InvalidDataException {
        Game game = new Game(list);

        switch (mode) {
            case GameRoom.TYPE_GAME_SINGLE:
                game.createSingleGame();
                break;
            case GameRoom.TYPE_GAME_MULTIPLAYER:
                game.createMultiplayerGame();
                break;
            default:
                throw new InvalidDataException("Modo incorrecto");
        }
        finalizeSelection();
    }
}

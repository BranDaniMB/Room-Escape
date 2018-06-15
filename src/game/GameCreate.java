/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import java.util.ArrayList;
import listManager.TeamList;
import objects.Player;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class GameCreate extends Thread {

    private ArrayList<Team> teams;

    public void createSingleGame(String TeamName, String players) throws InvalidDataException {
        Team team = selectToPlayTeam(TeamName, players);
        new Game().createSingleGame(team);
    }

    public void runMultiplayerGame() throws InvalidDataException {
        if (teams.size() < PropertiesConfig.getInstance().getProperties("minTeamsPlaying")) {
            throw new InvalidDataException("Debe registrar a minimo 2 equipos");
        }
        if (teams.size() > PropertiesConfig.getInstance().getProperties("minTeamsPlaying")) {
            throw new InvalidDataException("Debe registrar a minimo 2 equipos y máximo 5 equipos");
        }
        new Game(teams).creatMultiplayerGame();
    }

    public void addTeam(String teamName, String players) throws InvalidDataException {
        teams.add(selectToPlayTeam(teamName, players));
    }

    private Team selectToPlayTeam(String teamName, String players) throws InvalidDataException {
        Team aux = null;
        selectTeam(teamName, aux);
        String[] player = players.split("-");
        if (player.length < PropertiesConfig.getInstance().getProperties("minPlayers")) {
            throw new InvalidDataException("Debe contener al menos 2 jugadores");
        }
        if (player.length >= PropertiesConfig.getInstance().getProperties("maxPlayers")) {
            throw new InvalidDataException("Debe contener de 2 a 5 jugadores no más");
        }
        for (int i = 0; i < player.length; i++) {
            selectPlayer(player[i].toString(), aux);
        }
        return aux;
    }

    private void selectPlayer(String name, Team team) throws InvalidDataException {
        Player player = team.searchPlayer(name);
        if (player.isSelected()) {
            throw new InvalidDataException("Jugador ya seleccionado\n Eliga diferentes jugadores");
        }
        if ((team.getPlayersOnline() == PropertiesConfig.getInstance().getProperties("maxPlayers")) && !player.isSelected()) {
            throw new InvalidDataException("Ya se encuentran los jugadores completos");
        }
        if (player == null) {
            throw new InvalidDataException("Jugador No existe");
        }
        player.setSelected(true);
        team.setPlayersOnline(team.getPlayersOnline() + 1);
    }

    private void selectTeam(String name, Team aux) throws InvalidDataException {
        aux = TeamList.getInstance().searchTeam(name);
        if (aux == null) {
            throw new InvalidDataException("Equipo Inexistente");
        }
        if (aux.isPlaying()) {
            throw new InvalidDataException("Equipo ya esta jugando");
        }
        if ((teams.size() == PropertiesConfig.getInstance().getProperties("maxTeamsPlaying")) && !aux.isPlaying()) {
            throw new InvalidDataException("Ya se encuentran los equipos completos");
        }
        aux.setPlaying(true);
        TeamList.getInstance().setTeamsPlaying(TeamList.getInstance().getTeamsPlaying() + 1);
    }

    public void multiplayerMode() {

    }

    public void singleMode() {

    }
}

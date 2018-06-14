/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import gui.main.InitGUI;
import javafx.application.Application;
import listManager.TeamList;
import objects.Player;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class GameCreate extends Thread {

    public  void selectToPlay(String TeamName, String players) throws InvalidDataException {
        Team aux = null;
        selectTeam(TeamName, aux);
        String[] player = players.split("-");
        if (player.length == 1) {
            throw new InvalidDataException("Debe contener al menos 2 jugadores");
        }
        for (int i = 0; i < player.length; i++) {
            selectPlayer(player[i].toString(), aux);
        }
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
        if ((TeamList.getInstance().getTeamsPlaying() == PropertiesConfig.getInstance().getProperties("maxTeamsPlaying")) && !aux.isPlaying()) {
            throw new InvalidDataException("Ya se encuentran los equipos completos");
        }
        aux.setPlaying(true);
        TeamList.getInstance().setTeamsPlaying(TeamList.getInstance().getTeamsPlaying() + 1);
    }

    public void multiplayerMode() throws InterruptedException {

    }

    public void starPlay() {
    }

    @Override
    public void run() {
        Application.launch(InitGUI.class, "room1");
    }
}

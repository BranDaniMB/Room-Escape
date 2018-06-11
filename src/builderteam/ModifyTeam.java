package builderteam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import objects.Player;
import objects.Team;
import listManager.TeamList;

/**
 *
 * @author Jermy
 */
public class ModifyTeam {

    private Pattern pattern;
    private Matcher matcher;
    private Team currentTeam;
    private boolean existTeam = false;

    public Team ModifyTeam(String name) throws InvalidDataException {
        currentTeam = TeamList.getInstance().searchTeam(name);
        if (currentTeam == null) {
            throw new InvalidDataException("Equipo inexistente");
        }
        existTeam = true;
        return currentTeam;
    }

    public void changeName(String name) throws InvalidDataException {
        if (existTeam) {
            pattern = Pattern.compile("^[a-zA-Z ]{2,10}$");
            matcher = pattern.matcher(name);
            if (matcher.find()) {
                if (TeamList.getInstance().searchTeam(name) == null) {
                    currentTeam.setTeamName(name);
                } else {
                    throw new InvalidDataException("Este equipo ya existe.");
                }
            } else {
                throw new InvalidDataException("El nombre del equipo debe tener entre dos y diez caracteres y no puede "
                        + "contener números ni caracteres especiales (solamente el espacio)");
            }
        } else {
            throw new InvalidDataException("No haz elegido un equipo.");
        }
    }

    public void addPlayers(String id) throws InvalidDataException {
        if (existTeam) {
            pattern = Pattern.compile("^[a-zA-Z0-9]{3,8}$");
            matcher = pattern.matcher(id);
            if (matcher.find()) {
                if (!TeamList.getInstance().existId(id)) {
                    currentTeam.add(new Player(id));
                } else {
                    throw new InvalidDataException("Id ya registrado");
                }
            } else {
                throw new InvalidDataException("Nombre de jugador incorrecto " + id + "\n");
            }
        } else {
            throw new InvalidDataException("No haz elegido un equipo.");
        }
    }

    public void changePlayerId(String currentName, String newName) throws InvalidDataException {
        if (existTeam) {
            Player aux = currentTeam.searchPlayer(currentName);
            if (aux == null) {
                throw new InvalidDataException("Jugador inexistente");
            }
            pattern = Pattern.compile("^[a-zA-Z0-9]{3,8}$");
            matcher = pattern.matcher(newName);
            if (matcher.find()) {
                if (!TeamList.getInstance().existId(newName)) {
                    aux.setId(newName);
                } else {
                    throw new InvalidDataException("Id ya registrado");
                }
            } else {
                throw new InvalidDataException("Nombre de jugador incorrecto " + newName + "\n");
            }
        } else {
            throw new InvalidDataException("No haz elegido un equipo.");
        }
    }

    public void finalizeChange() {
        this.currentTeam = null;
        this.existTeam = false;
    }
}

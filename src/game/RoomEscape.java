package game;

import files.FilesManagerList;
import files.FilesManagerListRiddles;
import files.PropertiesConfig;
import gui.rooms.Room1;
import java.util.ArrayList;
import listManager.ListRoomRiddle;
import listManager.TeamList;
import objects.Riddle;
import objects.RoomRiddle;
import objects.TrackLocked;

/**
 *
 * @author Jermy
 */
public class RoomEscape {

    final static FilesManagerList FILES_MANAGER_LIST = new FilesManagerList();
    final static FilesManagerListRiddles FILES_MANAGER_LIST_RIDDLES = new FilesManagerListRiddles();

    public static void main(String[] args) {
        TeamList.getInstance().setTeamsList(FILES_MANAGER_LIST.readFile("Files/TeamList.ser"));
        ListRoomRiddle.getInstance().setListRiddle(FILES_MANAGER_LIST_RIDDLES.readFile("Files/RiddlesList.ser"));
        PropertiesConfig.getInstance().readConfig();
        chargeRiddles();
        FILES_MANAGER_LIST_RIDDLES.writeFile("Files/RiddlesList.ser", ListRoomRiddle.getInstance().getListRiddle());
        new Menu().runGui();
    }

    public static void chargeRiddles() {
        //#1.1
        RoomRiddle roomRiddle = new RoomRiddle(new Room1());
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("Es tangible");
        tracks.add("Es parte del día a día humano");
        roomRiddle.addRiddleGame(new Riddle("En mí trabajan mujeres y hombres: ellos me muelen, "
                + "ellas me escogen; \nsi estoy presente hay gran contento y si no estoy hay gran descontento en donde no estoy.",
                "pan", tracks, new TrackLocked("si", "¿Es comestible?", "Es buen acompañamiento casi para cualquier cosa.")));
        //#1.2
        tracks = new ArrayList<>();
        tracks.add("Con el viento me voy");
        tracks.add("Con el agua hago buen complemento");
        roomRiddle.addRiddleGame(new Riddle("Blanca soy, y como dice mi vecina, útil siempre soy en la cocina.", "harina", tracks,
                new TrackLocked("cuatro", "¿Cantidad de mesas?", "Me miden por tazas")));
        //#1.3
        tracks = new ArrayList<>();
        tracks.add("Es blanco por fuera");
        tracks.add("No tengo un buen olor");
        roomRiddle.addRiddleGame(new Riddle("¿Tiene dientes y no come, tiene cabeza y no es hombre?", "ajo", tracks,
                new TrackLocked("cinco", "¿Cantidad de notas?", "Estoy cubierto con una especie de hojas")));
        //#1.4
        tracks = new ArrayList<>();
        tracks.add("Soy transparente");
        tracks.add("Indispensable para la humanos");
        roomRiddle.addRiddleGame(new Riddle("¿Cuánto más me lavo, más sucia estoy?", "agua", tracks,
                new TrackLocked("horno", "¿El objeto mas importante de la sala?", "Soy vida")));
        ListRoomRiddle.getInstance().addRiddle(roomRiddle);

        //#2.1
        roomRiddle = new RoomRiddle(new Room1());
        tracks.add("Soy sumamente útil");
        tracks.add("Tiene diferentes tamaños");
        roomRiddle.addRiddleGame(new Riddle("¿Sube llena, baja vacía, y si no se da prisa, la sopa se enfría?", "cuchara", tracks,
                new TrackLocked("cinco", "¿Cantidad de sacos?", "En toda cocina hay")));
        //#2.2
        tracks = new ArrayList<>();
        tracks.add("Casi siempre anda con uno");
        tracks.add("Es de metal");
        roomRiddle.addRiddleGame(new Riddle("¿Chiquita como un ratón, guarda la casa como un león?", "llave", tracks,
                new TrackLocked("ocho", "¿Cantidad de bombillos?", "Es única")));
        //"2.3
        tracks = new ArrayList<>();
        tracks.add("Soy suave");
        tracks.add("Soy bastante confortable");
        roomRiddle.addRiddleGame(new Riddle("¿es muy usado?", "sillón", tracks,
                new TrackLocked("ocho", "¿Cantidad de tazas?", "Todos descansan en mí, casi no me muevo")));
        //2.4
        tracks = new ArrayList<>();
        tracks.add("Guardo suciedad");
        tracks.add("Siempre andamos por el suelo de alcobas y de salones");
        roomRiddle.addRiddleGame(new Riddle("Tengo una forma geométrica", "alfombra", tracks,
                new TrackLocked("cajeros", "¿Hay dos presentes?", "A veces estoy en las entras o en salas de estar")));
        ListRoomRiddle.getInstance().addRiddle(roomRiddle);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import gui.rooms.Room1;
import gui.rooms.Room2;
import gui.rooms.Room3;
import listManager.ListRoomRiddle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import objects.Riddle;
import objects.RoomRiddle;
import objects.TrackLocked;

/**
 *
 * @author Jermy
 */
public class FilesManagerListRiddles {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    private void openReader(String fileName) throws IOException {
        reader = new ObjectInputStream(new FileInputStream(fileName));
    }

    private ArrayList<RoomRiddle> read() throws IOException, ClassNotFoundException {
        return (ArrayList<RoomRiddle>) reader.readObject();
    }

    private void closeReader() throws IOException {
        reader.close();
    }

    private void openWriter(String fileName) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    private void write(ArrayList<RoomRiddle> element) throws IOException {
        writer.writeObject(element);
    }

    private void closeWriter() throws IOException {
        writer.close();
    }

    public ArrayList<RoomRiddle> readFile(String fileName) {
        ArrayList<RoomRiddle> listRiddle = new ArrayList<>();
        try {
            openReader(fileName);
            listRiddle = read();
            closeReader();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Creando archivos");
            ArrayList<RoomRiddle> roomRiddles = chargeRiddles();
            writeFile("Files/RiddlesList.ser", roomRiddles);
            System.err.println("Creados");
            return roomRiddles;
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return listRiddle;
    }

    private void writeFile(String fileName, ArrayList<RoomRiddle> listRiddle) {
        try {
            openWriter(fileName);
            write(listRiddle);
            closeWriter();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private ArrayList<RoomRiddle> chargeRiddles() {
        ArrayList<RoomRiddle> listRiddles = new ArrayList<>();
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
        listRiddles.add(roomRiddle);

        //#2.1
        roomRiddle = new RoomRiddle(new Room2());
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
        listRiddles.add(roomRiddle);

        //#3.1
        roomRiddle = new RoomRiddle(new Room3());
        tracks.add("Soy indispensable para desplazarse");
        tracks.add("A veces en mi interior tengo mal olor");
        roomRiddle.addRiddleGame(new Riddle("¿Dos hermanitos muy igualitos, si llegan a viejos abren los ojitos?", "zapatos", tracks,
                new TrackLocked("secadora", "¿Esta frente al espejo?", "Tengo un compañero inseparable")));
        //#3.2
        tracks = new ArrayList<>();
        tracks.add("Todas las personas me usan");
        tracks.add("Las mujeres les en canta comprarme");
        roomRiddle.addRiddleGame(new Riddle("Yo te protejo del frío y de los rayos del sol; no soy gorra ni sombrero, pero te cubro mejor", "ropa", tracks,
                new TrackLocked("cajero", "¿Esta en el escritorio", "Segunda la temporada tengo un estilo")));
        //"3.3
        tracks = new ArrayList<>();
        tracks.add("Protejo del frio o de sustancias");
        tracks.add("Soy de latex o de lana");
        roomRiddle.addRiddleGame(new Riddle("Dos guaridas cálidas con sus escondrijos, para dos hermanos y sus quintillizos", "guantes", tracks,
                new TrackLocked("palmeras", "Hay dos en el escenario", "Los doctores casi siempre me usan")));
        //3.4
        tracks = new ArrayList<>();
        tracks.add("Para ir al trabajo me usan");
        tracks.add("Nunca paso de moda");
        roomRiddle.addRiddleGame(new Riddle("Casi siempre me veo bien con cualquier atuendo", "pantalón", tracks,
                new TrackLocked("naranja", "¿Color del abrigo del mostrador?", "Aunque tenemos dos piernas no podemos caminar")));
        listRiddles.add(roomRiddle);

        return listRiddles;
    }
}

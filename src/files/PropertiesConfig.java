/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Jermy
 */
public class PropertiesConfig {

    private final Properties properties;

    public PropertiesConfig() {
        properties = new Properties();
    }

    public static PropertiesConfig getInstance() {
        return PropertiesConfigHolder.INSTANCE;
    }

    private static class PropertiesConfigHolder {

        private static final PropertiesConfig INSTANCE = new PropertiesConfig();
    }

    public void readConfig() {
        try {
            properties.load(new FileReader("config.properties"));
        } catch (IOException e) {
            System.err.println("Archivo no encontrado\nCreando archivo");
            writeConfig();
        }
        System.out.println("Configuraciones adquiridas");
    }

    private void writeConfig() {
        try {
            properties.setProperty("timeLimit", "1800");
            properties.setProperty("maxTeamsPlaying", "5");
            properties.setProperty("minTeamsPlaying", "2");
            properties.setProperty("maxPlayers", "5");
            properties.setProperty("minPlayers", "2");
            properties.setProperty("padlocksCount", "4");
            properties.store(new FileWriter("config.properties"), "Config");
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el archivo");
        }
        System.out.println("Configuraciones guardadas con exito");
    }

    public void addConfig(String key, String value) {
        try {
            properties.setProperty(key, value);
            properties.store(new FileWriter("config.properties"), "Config");
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el archivo");
        }
        System.out.println("Configuracion guardadas con exito");
    }

    public int getProperties(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public Properties getProperties() {
        return properties;
    }
}

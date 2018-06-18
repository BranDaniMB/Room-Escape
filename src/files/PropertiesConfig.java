
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
 * Config
 * Save the game's general settings and add new ones
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

    /**
     * Reading of configurations
     * Read the file settings.
     */
    public void readConfig() {
        try {
            properties.load(new FileReader("Files/config.properties"));
        } catch (IOException e) {
            System.err.println("Archivo no encontrado\nCreando archivo");
            writeConfig();
        }
        System.out.println("Configuraciones adquiridas");
    }

    /**
     * Write configurations.
     * Save the new settings in the file.
     */
    private void writeConfig() {
        try {
            properties.setProperty("timeLimit", "1800");
            properties.setProperty("maxTeamsPlaying", "5");
            properties.setProperty("minTeamsPlaying", "2");
            properties.setProperty("maxPlayers", "5");
            properties.setProperty("minPlayers", "2");
            properties.setProperty("padlocksCount", "4");
            properties.store(new FileWriter("Files/config.properties"), "Config");
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el archivo");
        }
        System.out.println("Configuraciones guardadas con exito");
    }

    /**
     * Add configurations
     * Add new settings to the file, using a key and a value
     * @param key
     * @param value 
     */
    public void addConfig(String key, String value) {
        try {
            properties.setProperty(key, value);
            properties.store(new FileWriter("Files/config.properties"), "Config");
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el archivo");
        }
        System.out.println("Configuracion guardadas con exito");
    }

    /**
     * Get a configuration
     * returns a specific configuration using a key
     * @param key
     * @return 
     */
    public int getProperties(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

     /**
     * Get a configuration
     * returns a specific configuration
     * @return 
     */
    public Properties getProperties() {
        return properties;
    }
}

package ru.sbt.browser;

import java.net.MalformedURLException;
import java.net.URL;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        try {
            URL url = new URL(pluginRootDirectory + "/" + pluginName + "/");

            PluginClassLoader loader = new PluginClassLoader(new URL[]{url});

            return (Plugin) loader.loadClass(pluginClassName).newInstance();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Путь к плагинам не распознан", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Класс плагина не обнаружен", e);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось вызвать конструктор плагина", e);
        }
    }
}

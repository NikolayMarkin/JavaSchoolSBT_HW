package ru.sbt.browser;

import ru.sbt.browser.Plugin;
import ru.sbt.browser.PluginManager;

public class Main {
    public static void main(String[] args) {
        PluginManager manager =
                new PluginManager("file://C:/Data/java_projects/JavaSchoolSBT_HW/HW07/classes");

        Plugin superPlugin = manager.load("superplugin", "ru.sbt.browser.plugins.superplugin.PluginImpl");
        superPlugin.doUsefull();

        Plugin puperPlugin = manager.load("superpuperplugin", "ru.sbt.browser.plugins.superpuperplugin.PluginImpl");
        puperPlugin.doUsefull();
    }
}

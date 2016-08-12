package ru.sbt.browser.plugins.superpuperplugin;

import ru.sbt.browser.Plugin;

public class PluginImpl implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("SuperPuperPluginImpl doUsefull.");

        TestPluginClass test = new TestPluginClass();

    }
}

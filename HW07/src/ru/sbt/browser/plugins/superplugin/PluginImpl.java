package ru.sbt.browser.plugins.superplugin;

import ru.sbt.browser.Plugin;

public class PluginImpl implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("SuperPluginImpl doUsefull.");
        Utils utils = new Utils();
        TestPluginClass test = new TestPluginClass();
        utils.doSomeSuperthing();
    }
}

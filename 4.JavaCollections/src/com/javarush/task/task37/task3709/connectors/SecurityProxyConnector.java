package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private String resourceString;
    private SecurityChecker securityChecker = new SecurityCheckerImpl();
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        this.resourceString = resourceString;
        simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        } else {
            System.out.println("Can't be connected to " + resourceString);
        }
    }
}

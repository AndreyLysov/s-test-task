package org.listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;

import static java.lang.System.getProperty;
import static java.util.Objects.isNull;

public class ThreadSetupListener implements IAlterSuiteListener {

    @Override
    public void alter(List<XmlSuite> suites) {
        suites
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no XML suite"))
                .setThreadCount(
//                        Default thread count is '3'
                        Integer.parseInt(getProperty("threadCount")));
    }
}

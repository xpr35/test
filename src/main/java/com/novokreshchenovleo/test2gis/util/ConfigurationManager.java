package com.novokreshchenovleo.test2gis.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;

public class ConfigurationManager {

    private static final Logger log = LogManager.getLogger(ConfigurationManager.class);
    private static volatile Configuration configuration;

    public static Configuration getConfiguration(String fileName) {
        if (configuration == null) {
            synchronized (ConfigurationManager.class) {
                if (configuration == null) {
                    try {
                        configuration = Yaml.loadType(new File(fileName), Configuration.class);
                        System.out.println(configuration);
                    } catch (FileNotFoundException e) {
                        log.error("Cannot find configuration file");
                    }
                }
            }
        }
        return configuration;
    }
}

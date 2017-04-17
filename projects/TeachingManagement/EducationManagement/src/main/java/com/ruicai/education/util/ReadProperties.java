package com.ruicai.education.util;

import org.apache.log4j.pattern.PropertiesPatternConverter;
import sun.applet.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wy on 2017/4/17.
 */
public class ReadProperties {
    public static String read(String key) {
        Properties properties = new Properties();
        InputStream stream = ReadProperties.class.getClassLoader().getResourceAsStream("dictionary.properties");
        try {
            properties.load(stream);
            return (String) properties.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

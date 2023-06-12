package ru.netology.sprongdao.dao.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class ScriptReader {

    private final String SCRIPT_NAME = "select_products.sql";
    private static String script;

    public ScriptReader() {
        try (InputStream is = new ClassPathResource(SCRIPT_NAME).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            script = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getScript() {
        return script;
    }
}

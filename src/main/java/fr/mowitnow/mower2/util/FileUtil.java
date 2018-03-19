package fr.mowitnow.mower2.util;

import fr.mowitnow.mower2.model.BusinessException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
    public static String readFile(String fileName) throws BusinessException {
        //read file into stream, try-with-resources
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            for(String line : lines){
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new BusinessException("Impossible de lire le fichier d'entrée");
        }
    }
}

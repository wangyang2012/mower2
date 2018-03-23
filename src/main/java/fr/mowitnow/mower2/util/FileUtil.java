package fr.mowitnow.mower2.util;

import fr.mowitnow.mower2.model.BusinessException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public interface FileUtil {
    static List<String> readFile(String fileName) throws BusinessException {
        try {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new BusinessException("Impossible de lire le fichier d'entrée");
        }
    }
}

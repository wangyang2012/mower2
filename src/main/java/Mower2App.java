import fr.mowitnow.mower2.model.BusinessException;
import fr.mowitnow.mower2.model.Travail;
import fr.mowitnow.mower2.util.FileUtil;
import org.apache.log4j.Logger;

import java.util.List;


public class Mower2App {

    final static Logger logger = Logger.getLogger(Mower2App.class);

    public static void main(String[] args)  {
        if (args == null || args.length != 1) {
            logger.error("Veuillez renseigner le fichier d'entrée");
        } else {
            String fileName = args[0];

            // read file
            List<String> entrees = null;
            try {
                entrees = FileUtil.readFile(fileName);
            } catch (BusinessException e) {
                logger.error("Impossible de lire le fichier d'entrée");
                return;
            }

            // create Travail
            Travail travail = new Travail();

            // Déroulement
            travail.lancer(entrees);
        }
    }
}

import fr.mowitnow.mower2.model.BusinessException;
import fr.mowitnow.mower2.model.Travail;
import fr.mowitnow.mower2.util.FileUtil;

import java.util.List;


// TODO: test
// TODO: UML
// TODO: Logs
public class Mower2App {
    public static void main(String[] args)  {
        System.out.println("My application");

        if (args == null || args.length != 1) {
            System.out.println("Veuillez renseigner le fichier d'entrée");
        } else {
            String fileName = args[0];

            // read file
            List<String> entrees = null;
            try {
                entrees = FileUtil.readFile(fileName);
            } catch (BusinessException e) {
                System.out.println("Impossible de lire le fichier d'entrée");
                return;
            }

            // create Travail
            Travail travail = new Travail();

            // Déroulement
            travail.lancer(entrees);
        }

    }
}

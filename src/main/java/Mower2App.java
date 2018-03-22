import fr.mowitnow.mower2.model.BusinessException;
import fr.mowitnow.mower2.model.Travail;
import fr.mowitnow.mower2.util.FileUtil;

public class Mower2App {
    public static void main(String[] args)  {
        System.out.println("My application");

        if (args == null || args.length != 1) {
            System.out.println("Veuillez renseigner le fichier d'entrée");
        } else {
            String fileName = args[0];

            // read file
            String entrees = null;
            try {
                entrees = FileUtil.readFile(fileName);
            } catch (BusinessException e) {
                System.out.println("Impossible de lire le fichier d'entrée");
                return;
            }

            // create Travail
            Travail travail = new Travail();

            // DÃ©roulement
            travail.lancer(entrees);
        }

    }
}

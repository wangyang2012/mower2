import fr.mowitnow.mower2.model.Position;
import fr.mowitnow.mower2.model.Travail;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Mower2Test {
	@Test
	public void appTest() {
		List<String> entrees = new ArrayList<>();
		entrees.add("5 5");
		entrees.add("1 2 N");
		entrees.add("GAGAGAGAA");
		entrees.add("3 3 E");
		entrees.add("AADAADADDA");

		// create Travail
		Travail travail = new Travail();

		// Déroulement
		travail.lancer(entrees);

		Assert.assertEquals(new Position(1,3), travail.getTondeuses().get(0).getPosition());
		Assert.assertEquals(Character.valueOf('N'), travail.getTondeuses().get(0).getOrientation());
		Assert.assertEquals(new Position(5,1), travail.getTondeuses().get(1).getPosition());
		Assert.assertEquals(Character.valueOf('E'), travail.getTondeuses().get(1).getOrientation());
		
	}

}

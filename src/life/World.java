package life;

import java.util.HashSet;
import java.util.Set;

public class World {

	private Set<Cell> livingCells = new HashSet<Cell>();

	public Set<Cell> getLivingCells() {

		return livingCells;
	}

	public void addLivingCells(Set<Cell> cells)
	{
		livingCells.addAll(cells);
	}

}

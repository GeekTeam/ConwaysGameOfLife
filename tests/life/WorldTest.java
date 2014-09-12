package life;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WorldTest {

	World world = new World();
	private Set<Cell> cells;

	@Test
	public void isIntitialisedWithNoLivingCells() {

		assertThat(world.getLivingCells(), empty());
	}

	@Test
	public void canAddLivingCellsToTheWorld() {

		cells = makeSetOfCells(new Cell());

		world.addLivingCells(cells);

		assertThat(world.getLivingCells(), hasSize(1));
	}

	@Test
	public void canAddMultipleSetOfLivingCellsToTheWorld() {

		cells = makeSetOfCells(new Cell());
		world.addLivingCells(cells);

		cells = makeSetOfCells(new Cell());
		world.addLivingCells(cells);

		assertThat(world.getLivingCells(), hasSize(2));
	}

	private Set<Cell> makeSetOfCells(Cell... cellsArray) {

		Set<Cell> cells = new HashSet<Cell>();

		for (Cell cell : cellsArray)
			cells.add(cell);

		return cells;
	}
}

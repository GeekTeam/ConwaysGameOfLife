package life;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WorldTest {

	World world = new World();
	private Set<Cell> cells;

	@Test
	public void isIntitialisedWithNoLivingCells() {

		assertTrue(world.isEmpty());
	}

	@Test
	public void canHaveLivingCellsAddedToIt() {

		cells = makeSetOfCells(new Cell(1, 2));

		world.addLivingCells(cells);

		assertThat(world.containsLivingCell(new Cell(1, 2)), equalTo(true));
	}

	@Test
	public void canHaveMultipleSetOfLivingCellsAddedToIt() {

		cells = makeSetOfCells(new Cell(1, 2));
		world.addLivingCells(cells);

		cells = makeSetOfCells(new Cell(1, 3));
		world.addLivingCells(cells);

		assertTrue(world.containsLivingCell(new Cell(1, 2)));
		assertTrue(world.containsLivingCell(new Cell(1, 3)));
	}

	@Test
	public void isEmptyInTheNextGenerationWhenEmptyInitially() {

		world.evolve();

		assertTrue(world.isEmpty());
	}

	@Test
	public void isEmptyInTheNextGenerationWhenInitializedWithOneCell() {

		cells = makeSetOfCells(new Cell(1, 2));
		world.addLivingCells(cells);

		world.evolve();

		assertTrue(world.isEmpty());
	}

	@Test
	public void isEmptyInTheNextGenerationWhenInitializedWithTwoNeighbouringCells() {

		cells = makeSetOfCells(new Cell(1, 2), new Cell(2, 3));
		world.addLivingCells(cells);

		world.evolve();

		assertTrue(world.isEmpty());
	}

	@Test
	public void isEmptyInTheNextGenerationWhenInitializedWithTwoDistantCells() {

		cells = makeSetOfCells(new Cell(1, 2), new Cell(5, 3));
		world.addLivingCells(cells);

		world.evolve();

		assertTrue(world.isEmpty());
	}

	@Test
	public void containsACellInTheNextGenerationWhenPreviouslyItHadTwoNeighbours() {

		cells = makeSetOfCells(new Cell(1, 2), new Cell(1, 3), new Cell(1,4));
		world.addLivingCells(cells);

		world.evolve();

		assertTrue(world.containsLivingCell(new Cell(1, 3)));
	}

	private Set<Cell> makeSetOfCells(Cell... cellsArray) {

		Set<Cell> cells = new HashSet<Cell>();

		for (Cell cell : cellsArray)
			cells.add(cell);

		return cells;
	}
}

package life;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void isEqualToAnotherCellIfCoordinatesAreEqual()
	{
		assertThat(new Cell(2, 4), equalTo(new Cell(2, 4)));
	}

	@Test
	public void isDifferentFromAnotherCellIfCoordinatesDifferent()
	{
		assertThat(new Cell(2, 4), not(equalTo(new Cell(2, 5))));
	}

}

package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void TestEmptyDeck() {

		Deck d = new Deck();
		for (int i = 0; i < 52; i++) {
			d.Draw();
		}
		assertNull(d.Draw().geteRank());
		assertNull(d.Draw().geteSuit());
	}

	@Test
	public void TestDrawSuit() {

		Deck d = new Deck();
		for (int i = 0; i < 13; i++) {
			assertNotNull(d.Draw(pkgEnum.eSuit.HEARTS).geteRank());
		}
		assertNull(d.Draw(pkgEnum.eSuit.HEARTS).geteSuit());
	}

	@Test
	public void TestDrawRank() {
		Deck d = new Deck();
		for (int i = 0; i < 4; i++) {
			assertNotNull(d.Draw(pkgEnum.eRank.ACE).geteSuit());
		}
		assertNull(d.Draw(pkgEnum.eRank.ACE).geteSuit());
	}

	@Test
	public void TestDeckRankCount() {
		Deck d = new Deck();
		assertEquals(d.rankCount(pkgEnum.eRank.ACE), 4);
		d.Draw(pkgEnum.eRank.ACE);
		assertEquals(d.rankCount(pkgEnum.eRank.ACE), 3);
	}

	@Test
	public void TestDeckSuitCount() {
		Deck d = new Deck();
		assertEquals(d.suitCount(pkgEnum.eSuit.SPADES), 13);
		d.Draw(pkgEnum.eSuit.SPADES);
		assertEquals(d.suitCount(pkgEnum.eSuit.SPADES), 12);
	}

}

package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;
import pkgException.*;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() {
		try {
			if (cardsInDeck.size() > 0)
				return cardsInDeck.remove(0);
			else
				throw new DeckException(this);
		} catch (DeckException c) {
			return new Card(null, null);
		}
	}

	public Card Draw(eSuit suit) {
		try {
			int count = 0;
			for (Card c : cardsInDeck) {
				if (c.geteSuit() == suit)
					return cardsInDeck.remove(count);
				else
					count++;
			}
			throw new DeckException(this);
		} catch (DeckException c) {
			return new Card(null, null);
		}
	}

	public Card Draw(eRank rank) {
		try {
			int count = 0;
			for (Card c : cardsInDeck) {
				if (c.geteRank() == rank)
					return cardsInDeck.remove(count);
				else
					count++;
			}
			throw new DeckException(this);
		} catch (DeckException c) {
			return new Card(null, null);
		}
	}

	public int suitCount(eSuit suit) {
		Stream<Card> cardsOfeSuit = cardsInDeck.stream().filter(c -> c.geteSuit() == suit);
		return (int) cardsOfeSuit.count();
	}

	public int rankCount(eRank rank) {
		Stream<Card> cardsOfeRank = cardsInDeck.stream().filter(c -> c.geteRank() == rank);
		return (int) cardsOfeRank.count();
	}

	public int cardCheck(eRank rank, eSuit suit) {
		if ((cardsInDeck.stream().filter(c -> c.geteRank() == rank && c.geteSuit() == suit)).count() > 0)
			return 1;
		return 0;
	}
}

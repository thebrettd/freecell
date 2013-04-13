import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void deckConstructorTest(){
        Deck deck = new Deck(1);
        assertTrue(deck.size() == 52);

        deck = new Deck(6);
        assertTrue(deck.size() == (52 * 6));

    }

    //Will fail randomly if first card does not change after a shuffle
    @Test
    public void deckShuffleTest(){
        Deck deck = new Deck(1);
        Card c1 = deck.draw();
        deck.replace(c1);

        deck.shuffle();
        assertTrue(deck.size() == 52);

        Card c2 = deck.draw();

        assertFalse(c1.equals(c2));

        for(int i=0;i<deck.size();i++){
            assertNotNull(deck.draw());
        }
    }

}

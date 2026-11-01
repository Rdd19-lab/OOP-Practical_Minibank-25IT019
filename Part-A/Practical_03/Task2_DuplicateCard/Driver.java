public class Driver {
    public static void main(String[] args) {
        Card[] cards = {new Card("Ace", "Spades"), new Card("Queen", "Hearts"),
                new Card("Ace", "Spades"), new Card("King", "Clubs")};
        for (int i = 0; i < cards.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (cards[i].equals(cards[j])) { duplicate = true; break; }
            }
            if (duplicate) {
                System.out.println("Duplicate found: " + cards[i]);
                break;
            }
        }
    }
}

import java.util.Objects;

public class Card {
    private final String rank, suit;
    public Card(String rank, String suit) { this.rank = rank; this.suit = suit; }
    @Override public String toString() { return rank + " of " + suit; }
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card other)) return false;
        return Objects.equals(rank, other.rank) && Objects.equals(suit, other.suit);
    }
    @Override public int hashCode() { return Objects.hash(rank, suit); }
}

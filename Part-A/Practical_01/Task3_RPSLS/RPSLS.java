import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    static int winner(Move a, Move b) {
        if (a == b) return 0;
        boolean aWins = switch (a) {
            case ROCK -> b == Move.SCISSORS || b == Move.LIZARD;
            case PAPER -> b == Move.ROCK || b == Move.SPOCK;
            case SCISSORS -> b == Move.PAPER || b == Move.LIZARD;
            case LIZARD -> b == Move.PAPER || b == Move.SPOCK;
            case SPOCK -> b == Move.ROCK || b == Move.SCISSORS;
        };
        return aWins ? 1 : -1;
    }

    public static void main(String[] args) {
        int playerScore = 0, computerScore = 0;
        Move[] moves = Move.values();
        Random random = new Random();
        try (Scanner sc = new Scanner(System.in)) {
            for (int round = 1; round <= 5; round++) {
                System.out.print("Round " + round + " - choose ROCK, PAPER, SCISSORS, LIZARD or SPOCK: ");
                Move player = Move.valueOf(sc.next().trim().toUpperCase());
                Move computer = moves[random.nextInt(moves.length)];
                int result = winner(player, computer);
                if (result > 0) playerScore++;
                if (result < 0) computerScore++;
                String outcome = result == 0 ? "Draw" : result > 0 ? "You win" : "Computer wins";
                System.out.println("You: " + player + " | Computer: " + computer + " | " + outcome);
            }
            System.out.println("Final score: You " + playerScore + " - " + computerScore + " Computer");
            System.out.println(playerScore == computerScore ? "Overall result: Draw" :
                    playerScore > computerScore ? "Overall winner: You" : "Overall winner: Computer");
        } catch (IllegalArgumentException ex) {
            System.out.println("Choose ROCK, PAPER, SCISSORS, LIZARD or SPOCK.");
        }
    }
}

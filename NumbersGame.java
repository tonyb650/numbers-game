import java.util.Random;

public class NumbersGame {
    public static void main(String[] args){
        int guessesAllowed = 3;
        boolean continuePlaying = true;
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.printf("Can you guess the number in %d guesses or less?\n", guessesAllowed);
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        // start a new round of play
        while(continuePlaying==true){
            int guessesRemaining = guessesAllowed;
            int answer = new Random().nextInt(0,10);
            System.out.println("Let the new game begin!");
            System.out.println("Shhhh. The answer is "+answer);
            // start accepting guesses
            while(guessesRemaining>0){
                String guess = System.console().readLine();
                // if guess is 'q', then quit game
                if(guess.equals("q")){
                    System.out.println("\nHa! I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    guessesRemaining = 0; // trigger end of round
                    continuePlaying = false; // trigger end of game
                } else {
                    // guess != 'q', so continue game
                    try {
                        Integer guessInt = Integer.parseInt(guess);
                        // Is guess in range?
                        if (guessInt < 0 || guessInt >10){
                            System.out.println("Your guess is out of the acceptable range! Try again: ");
                        // Is guess incorrect?
                        } else if (guessInt != answer){
                            guessesRemaining -=1;
                            // are they out of guesses?
                            if (guessesRemaining<1) {
                                System.out.println("Sorry, You're all out of guesses :(");
                            // still has more guesses
                            } else{
                                System.out.printf("Swing and a miss! %d guess(es) left. Keep trying...\n", guessesRemaining);
                            }
                        } else {
                            // correct answer
                            System.out.println("Lucky guess! But can you do it again?");
                            guessesRemaining = 0; // trigger end of round
                        }
                    // is guess not an integer?
                    } catch (NumberFormatException e) {
                        System.out.println("Oops, that's not a valid entry! Try again:");
                    }
                }
            }
            if (continuePlaying){
                System.out.println("Round over. Type 'Y' if you want to play again.");
                String continueRequest = System.console().readLine();
                // System.out.println(continueRequest);
                if ( !continueRequest.equals("Y") && !continueRequest.equals("y")){
                    continuePlaying = false;
                    System.out.println("Thanks for playing. Shutting down...");
                }
            }
        }
    }
}
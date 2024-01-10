/*
ROCK PAPER AND SCISSORS IN JAVA
*/

import java.util.*;
import java.util.Random.*;
public class rock {
    public static void main(String[] args) {
        String [] moves={"r","p","s"};
        String Compmov=moves[new Random().nextInt(moves.length)];

        Scanner sc=new Scanner(System.in);
        String player;

        while(true){
            System.out.println("Enter your move(r,p,or s)");
            player=sc.nextLine();
            if (player.equals("r")||player.equals("p")||player.equals("s")){
                break;
            }
            else{
                System.out.println(player+" Please enter a valid answer");
            }
        }

        System.out.println("Computer played "+Compmov);

        if (player.equals(Compmov)){
            System.out.println("The game was a tie");
        }
        else if (player.equals("r")) {
            if (Compmov.equals("p")){
                System.out.println("You lose");
            } else if (Compmov.equals("s")) {
                System.out.println("You Win");
            }
        }
        else if (player.equals("p")) {
            if (Compmov.equals("s")) {
                System.out.println("You lose");
            } else if (Compmov.equals("r")) {
                System.out.println("You Win");
            }
        }
        else if (player.equals("s")) {
            if (Compmov.equals("r")) {
                System.out.println("You lose");
            } else if (Compmov.equals("p")) {
                System.out.println("You Win");
            }
        }
    }
}
/*
The Code above is for Playing Rock Paper and Scissors with computer at complete random plays taken by the computer!
Concepts used are simple and encourage the basics of java.
Namely
Random and Array Of String etc.
*/

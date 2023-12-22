import java.util.*;

public class WordScapes {
    public static void main(String[] args) {
        char[][] letters =  {{'h', 'o', 'l','i', 'd', 'a','y'},
                {'p', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i','n','g'},
                {'b', 'o', 'o', 't', 'c', 'a', 'm', 'p'},
                {'f','1', 'o', 'w', 'c', 'h', 'a', 'r', 't'},
                {'w', 'o', 'r', 'd', 's', 'c', 'a', 'p','e', 's'}};
        String[][] words = {{"hi","hay","day", "had", "lay", "dal", "lad", "lid", "hold", "lady", "hail"},
                { "go", "an", "in", "no", "on", "map", "mom","gap", "gag", "pig","man","ping","pong", "pram","prom", "ramp"},
                {"am", "at", "to", "cab","cap","cob","cop", "map", "mop", "act", "bat", "camp", "comb", "boom","pact","atom"},
                {"of","at", "or", "to","caw","cow", "how", "who","calf", "claw", "flaw","flow", "fowl","wolf","crow", "half"},
                {"we","do", "as","cap","caw","cop","cow","paw","cod", "dew","pad","cape","cope","crap","crew", "crop", "pace"}};

        Scanner sc = new Scanner(System.in);
        int lives = 5;
        System.out.println(" WELCOME TO WORDSCAPES ");
        int level = 0;
        int score = 0;

        do {
            System.out.println("Level "+(level+1));
            System.out.println("Create three words using giving letters : ");

            for (char c:letters[level] ) {
                System.out.println(c+ "\t");
            }

            System.out.println();

            int wordCount = 0;
            boolean match = false;
            String word = "";
            String oldWord = "";
            while (wordCount == 0 || wordCount < 3) {
                match = false;
                System.out.println("Word : ");
                word = sc.next();

                if (!(word.equalsIgnoreCase(oldWord))) {
                    for (String w: words[level]) {
                        if (word.equalsIgnoreCase(w)) {
                            wordCount++;
                            score++;
                            oldWord = word;
                            match=true;
                            break;
                        }
                    }
                }
                if (!(match)) {
                    System.out.println("Wrong Guess.... ");
                    lives--;
                }
                if (lives==0) {
                    System.out.println("Game Over !!!  *** Better Luck Next Time ***");
                    System.out.println("Your Score Is : "+ score);
                    break;
                }
            }
            wordCount=0;
            match=false;
            word="";

            if (lives==0) {
                break;
            }
            if (lives==4) {
                System.out.println("Thanks for playing game :) !!! ");
                System.out.println("Your Score Is : "+ score);
                break;
            }
            else {
                System.out.println("do you want to continue to next level?(y/n)");
                char choice = sc.next().charAt(0);
                if (choice == 'y' || choice == 'Y') {
                    level++;
                }
                else {
                    System.out.println("Thanks for playing game :) !!! ");
                    System.out.println("Your Score Is : "+ score);
                    break;
                }
            }
        }while (level < 5);
    }
}

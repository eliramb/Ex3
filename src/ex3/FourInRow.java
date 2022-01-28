package ex3;

public class FourInRow {


    public static void main(String[] args) {

        System.out.println("Welcome to Four in a Line!");
        while(true) {
            Game game = new Game();
            game.PrintMenu();
            if( game.UserChoice() ==0) return;
            game.Play();
        }
    }
}

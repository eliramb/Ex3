package ex3;

public class Menu {

//    public char quit;
//    public char play;
//    public char playComputer;
    public String MenuName;

    public Menu(){
//        quit = '0';
//        play='1';
//        playComputer = '2';
    }
    public Menu(String _menuName){
        MenuName = _menuName;
    }

    public void printMenu() {
        System.out.println(MenuName);
//        System.out.println(quit + ". Exit");
//        System.out.println(play + ". Play against a friend");
//        System.out.println(playComputer + ". Play against the computer");
//        System.out.print("Please choose an option:");
    }
}

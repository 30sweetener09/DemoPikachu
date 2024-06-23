package main;

import control.GameController;
import view.BackGroundMusic;

import static utils.Utils.WINDOW_HEIGHT;
import static utils.Utils.WINDOW_WIDTH;

public class Main {
    //private static BackGroundMusic backGroundMusic;

	public static void main(String[] args) {
        GameController pikachu = new GameController("Pikachu");
        pikachu.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        pikachu.setLocationRelativeTo(null);
        pikachu.start();

        BackGroundMusic musicPlayer = new BackGroundMusic("../resources/abc.wav");
        musicPlayer.stopMusic();
    }
}

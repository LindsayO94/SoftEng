package game;

import java.util.ArrayList;

import common.entity.Level;

import game.entities.*;
import game.boundary.*;

public class Main {
	public static void main(String args[]) {
		Game game = new Game();
		GameFrame f = new GameFrame(game);
		f.setVisible(true);
	}
	
	
}

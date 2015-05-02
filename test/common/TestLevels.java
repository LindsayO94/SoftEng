package common;

import common.entity.Board;
import common.entity.Level;

public class TestLevels {
	public final static String puzzleNoInactive = "{\n" + 
			"  \"levelNumber\": 1,\n" + 
			"  \"locked\": false,\n" + 
			"  \"isWon\": false,\n" + 
			"  \"highScore\": 0,\n" + 
			"  \"type\": \"Puzzle\",\n" + 
			"  \"startingConfig\": [\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ]\n" + 
			"  ],\n" + 
			"  \"frequency\": [\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1\n" + 
			"  ],\n" + 
			"  \"multiplierFrequency\": [\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1\n" + 
			"  ],\n" + 
			"  \"shuffleAllowed\": false,\n" + 
			"  \"swapAllowed\": false,\n" + 
			"  \"removeAllowed\": false,\n" + 
			"  \"numShuffle\": 1,\n" + 
			"  \"numSwap\": 1,\n" + 
			"  \"numRemove\": 1,\n" + 
			"  \"maxMoves\": 0,\n" + 
			"  \"maxTime\": 0,\n" + 
			"  \"starScore\": [\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1\n" + 
			"  ]\n" + 
			"}";
	public static final String puzzleHalfInactive = "{\n" + 
			"  \"levelNumber\": 1,\n" + 
			"  \"locked\": false,\n" + 
			"  \"isWon\": false,\n" + 
			"  \"highScore\": 0,\n" + 
			"  \"type\": \"Puzzle\",\n" + 
			"  \"startingConfig\": [\n" + 
			"    [\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\",\n" + 
			"      \"TILE_CELL\"\n" + 
			"    ],\n" + 
			"    [\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"TILE_CELL\",\n" + 
			"      \"INACTIVE_CELL\"\n" + 
			"    ]\n" + 
			"  ],\n" + 
			"  \"frequency\": [\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1\n" + 
			"  ],\n" + 
			"  \"multiplierFrequency\": [\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1\n" + 
			"  ],\n" + 
			"  \"shuffleAllowed\": false,\n" + 
			"  \"swapAllowed\": false,\n" + 
			"  \"removeAllowed\": false,\n" + 
			"  \"numShuffle\": 1,\n" + 
			"  \"numSwap\": 1,\n" + 
			"  \"numRemove\": 1,\n" + 
			"  \"maxMoves\": 0,\n" + 
			"  \"maxTime\": 0,\n" + 
			"  \"starScore\": [\n" + 
			"    1,\n" + 
			"    1,\n" + 
			"    1\n" + 
			"  ]\n" + 
			"}";;
	
	public static Board getBoard(String json) {
		Level l = LevelSaver.levelFromJsonString(json, 0);;
		return Board.makeBoard(l);
	}
}

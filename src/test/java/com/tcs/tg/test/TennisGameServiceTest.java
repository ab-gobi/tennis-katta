package com.tcs.tg.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.tcs.tennisgame.GameService;

@RunWith(Parameterized.class)
public class TennisGameServiceTest  {

	@Parameter(value=0)
    public int player1Score;
	@Parameter(value=1)
	public int player2Score;
	@Parameter(value=2)
	public String expectedScore;

    @Parameters(name= "{0}-{1} --> {2}")
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},
                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, "Win for PLAYER1"},
                { 0, 4, "Win for PLAYER2"},
                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Win for PLAYER1"},
                { 1, 4, "Win for PLAYER2"},
                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, "Win for PLAYER1"},
                { 2, 4, "Win for PLAYER2"},
                { 4, 3, "Advantage PLAYER1"},
                { 3, 4, "Advantage PLAYER2"},
                { 5, 4, "Advantage PLAYER1"},
                { 4, 5, "Advantage PLAYER2"},
                { 15, 14, "Advantage PLAYER1"},
                { 14, 15, "Advantage PLAYER2"},
                { 6, 4, "Win for PLAYER1"},
                { 4, 6, "Win for PLAYER2"},
                { 16, 14, "Win for PLAYER1"},
                { 14, 16, "Win for PLAYER2"},
        });
    }


    @Test
    public void checkAllScoresTennisGame3() {
        GameService gameService = new GameService();
        gameService.setP1N("PLAYER1");
        gameService.setP2N("PLAYER2");
        assertEquals(this.expectedScore, gameService.getScore(this.player1Score, this.player2Score));
    }

}
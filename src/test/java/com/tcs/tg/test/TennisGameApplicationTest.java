package com.tcs.tg.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.tcs.tg.TennisGameApplication;
import com.tcs.tg.controller.GameController;


@RunWith(Parameterized.class)
@WebMvcTest(GameController.class)
@ContextConfiguration(classes=TennisGameApplication.class)
@ComponentScan(value = "com.tcs.tennisgame")

public class TennisGameApplicationTest {
	
	@Parameter(value=0)
    public String player1Score;
	@Parameter(value=1)
	public String player2Score;
	@Parameter(value=2)
	public String expectedResult;

    @Parameters(name= "{0}-{1} --> {2}")
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { "0", "0", "Love-All" },
                { "a", "16", "Invalid input"},
        });
    }

		private MockMvc mockMvc;
        @Before
        public void setUp() {
         mockMvc = MockMvcBuilders.standaloneSetup(new GameController()).build();
        }
        @Test
        public void testIndex() throws Exception{
        	 MvcResult mvcResult = this.mockMvc.perform(get("/getScore/"+this.player1Score+"/"+this.player2Score)).andReturn();        	 
        	 System.out.println(mvcResult.getResponse().getContentAsString());
        	 assertEquals(mvcResult.getResponse().getContentAsString(), this.expectedResult);
        }

}


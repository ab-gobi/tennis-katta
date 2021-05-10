package com.tcs.tg.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {
	
	private String p1N;
    private String p2N;

	public String getScore(int p1,int p2) {
        String s;
        if (p1 < 4 && p2 < 4 && p1 + p2 != 6) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[p1];
            return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
        } else {
        	if (p1 == p2)
        		return "Deuce";
        	s = p1 > p2 ? p1N : p2N;
        	return ((p1-p2)*(p1-p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
	
	public void setP1N(String p1n) {
		p1N = p1n;
	}

	public void setP2N(String p2n) {
		p2N = p2n;
	}

}

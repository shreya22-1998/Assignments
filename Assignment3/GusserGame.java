/* Guesser Game Features:-

 * 1)5 players allowed to play.
 * 2)1 levels (Open Round)
 * 3)In Open Round: 3 sub round with one hint which will cost 3 points.
 * 					If guessed correct : 10 points
 * 					if guessed in range of +-3 then 5 points
 * 					if guessed in range of +- 5 then 3 points
 * 4)In Tie Round: 
 * 					If guessed correct :10 points
 * 					if guessed in range of +1 then 5 points
 * 					if guessed in range of -1 then 6 points
 * 					if guessed in range of +2 then 3 points 
 * 					if guessed in range of -2 then 4 points 
 * 					Note:players cannot guess same no.
 * 
 * Umpire Role: 
 * a) To take 4 rounds(3 open, 1 tie(Optional))
 * b) Keep track of score
 * c) For open rounds have range of no.s between[1-10]
 * d) If asked for hint then give the range of +-3 and deduct 2 points
 * e) to calculate total and declare a winner.
 * f) Check for Tie
 * 
 * Guesser Role:
 * a)to guess a no between given range by umpire
 * 
 * Players Role:
 * a)to guess the no between given range by umpire (use hint if needed)
 * 
 */

package com.ineuron.learn.assignment_three;

import java.util.*;
import java.util.Map.Entry;

class Guesser
{
	int guessNum;
	
	int guessNum(int start, int end)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser kindly guess the number in range :"+start+ " to " +end);
		guessNum=scan.nextInt();
		if(guessNum<=start || guessNum>=end) {
			System.out.println("Warning::Out Of Range!!");
			guessNum(start,end);
			}
		return guessNum;
	}	
}

class Player
{
	int guessNum;
	
	int guessNum(int n, int start, int end, boolean[] hint)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player " + n + " kindly guess the number in range :"+start+ " to " +end);
		if(hint[n-1]){
			System.out.println("To use hint press 0");
		}
		guessNum=scan.nextInt();
		if(guessNum<0 || guessNum>end) {
		System.out.println("Warning::Out Of Range!!");
		guessNum(n,start,end,hint);
		}
		
		return guessNum;
			
	}
}

class Umpire
{
	int numFromGuesser;
	int numFromPlayers[] = new int[5];
	//int score[] = new int[5];
	Player p=new Player();
	Guesser g=new Guesser();
	HashMap<Integer,Integer> score= new HashMap();
	boolean hints[] = new boolean[]{true,true,true,true,true};
	
	

	public void printScore(HashMap list) {
		Set score1=list.entrySet();
		Iterator sc1=score1.iterator();
		System.out.println("Players ==> Scores");
		while(sc1.hasNext()) {
			System.out.println(sc1.next());
		}
	}
	
	int[] hintgenerator() {
	
		int min=0, max=0 ,num1=8, num2=9;
	min=(numFromGuesser-3 > 0) ? (numFromGuesser-3):(0);
	max=(numFromGuesser+3 <= 10) ? (numFromGuesser + 3) : (10) ;
		
		int hintrange[]= {min,max};
		
		return hintrange;
	}
	
	void collectNumFromGuesser(int start, int end)
	{
		
		numFromGuesser=g.guessNum(start,end);
		
	}
	void collectNumFromPlayers(int start, int end)
	{
		
		for(int i=0;i<5;i++) {
			int gussedno=p.guessNum(i+1,start,end,hints);
			if(gussedno == 0 && hints[i]) {
				int hintrange[]=hintgenerator();
				System.out.println("*Your Hint is* : Please guess the no between "+hintrange[0]+" - "+hintrange[1]);
				hints[i]=false;
				p.guessNum(i+1,hintrange[0],hintrange[1],hints);
			}else if(gussedno == 0 && !hints[i]){
				System.out.println("Sorry!! You have already used your hint");
			}
			numFromPlayers[i]=gussedno;
		}
	}
	
	private void calculatescore(String n) {
		for(int i=0,s=0;i<5;i++) {
			if(numFromGuesser == numFromPlayers[i]) {
				 s=score.getOrDefault(i+1, 0);
				score.put(i+1,s+10);
			}
			else if(numFromPlayers[i] >=  numFromGuesser-3 && numFromPlayers[i] <=  numFromGuesser+3 ) {
				 s=score.getOrDefault(i+1, 0);
				score.put(i+1,s+5);
			}
			else if(numFromPlayers[i] >=  numFromGuesser-5 && numFromPlayers[i] <=  numFromGuesser+3 ) {
				 s=score.getOrDefault(i+1, 0);
				score.put(i+1,s+3);
			}
			else {
				 s=score.getOrDefault(i+1, 0);
				score.put(i+1,s+0);
			}
		
		}
		System.out.println("Score After "+n+ " round" );
		
		System.out.println();
		
		printScore(score);
		
		System.out.println();
		System.out.println();
	}
	
	private int calculateTieBreakerScore(int gussedval) {
		int newscore=0;
		int newval=gussedval-numFromGuesser;
		if(newval==1) newscore=5;
		if(newval==-1) newscore=6;
		if(newval==2) newscore=3;
		if(newval==-2) newscore=4;
		
		if(newval==0) newscore=10;
		
		return newscore;
	}
	
	private HashMap<Integer, Integer> tieBreakerRound(HashMap<Integer,Integer> list) {
		Arrays.fill(hints,false);
		int alreadygussedno[]=new int[5];
		Arrays.fill(alreadygussedno, 0);
		int gussedno=0;
		
		numFromGuesser=g.guessNum(0,5);
		for(Entry<Integer,Integer> e : list.entrySet()) {
			
				gussedno = p.guessNum(e.getKey(),0,5,hints);
				for(int i=0;i<alreadygussedno.length;i++) {
					if(gussedno!=alreadygussedno[i]) alreadygussedno[i]=gussedno;
					else {
						System.out.println(gussedno +" ::Sorry! please guess another no, as this is no is been already gussed");
						gussedno =p.guessNum(e.getKey(),0,5,hints);
						i=0;
					}
				}
				
				int newscore=calculateTieBreakerScore(gussedno);
				//System.out.println(e.getKey()+"="+(e.getValue()+newscore));
				list.put(e.getKey(),e.getValue()+newscore);
			}
		
		return list;
	}
	
	

	private void topScorer() {
		HashMap<Integer,Integer> topList= new HashMap();
		int cnt=0;
		
			
			int maxValue=Collections.max(score.values());
			
			for(Entry<Integer,Integer> e : score.entrySet()) {
				if(e.getValue() == maxValue) {
					cnt++;
					topList.put(e.getKey(),e.getValue());	
				}
			}
			score.clear();
		
			if(cnt>1) {
				System.out.println("There is a tie, so lets play : Tie Breaker Round");
				printScore(topList);				
				score=tieBreakerRound(topList);
				cnt=0;
				
			}
		
		if(topList.size() >1) {
			topScorer();
		}
		
		if(topList.size() ==1) {
		System.out.println("************Hey here is our Winner!!!!*************");
		printScore(topList);
		}
	
		
	}
	

	void openRound()
	{
		for(int i=0;i<1;i++) {
			collectNumFromGuesser(1,10);
			collectNumFromPlayers(1,10);
			calculatescore("Open Round "+(i+1));
		}
		
		topScorer();
		
		
	}

	
	
}

public class GusserGame {

	public static void main(String[] args) {
		Umpire u=new Umpire();
		u.openRound();
		

	}

}

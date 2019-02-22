package no.itfakultetet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListLinkedList {

	public static void main(String[] args) {

		List<Integer> tall1 = new ArrayList<Integer>();
		List<Integer> tall2 = new LinkedList<Integer>();

		long start = System.currentTimeMillis();

//		Bytt ut tall1 med tall2 og se forskjellen på 
//		ArrayList og LinkeList når vi setter inn nye rader fra 
//		begynnelsen av listen ved add(0,i) 0 = fra begynnelsen.
//		Tar vi bort 0, legges nye rader til fra slutten, og det er liten forskjell
		
		for (int i = 0; i < 3e5; i++) {
			tall2.add(0, i);

		}

		long stopp = System.currentTimeMillis();
		
		System.out.println("Vi har lagt til "+3e5+" elementer i listen");
		
		System.out.println("Tid: " + (stopp - start)+ " millisekunder");
		

	}

}
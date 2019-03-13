package it.polito.tdp.alien.model;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> dictionary = new LinkedList<Word>();	
	
	public void addWord(String aw, String t) {
		Word newWord = new Word(aw, t);
		for(Word p : dictionary) {
			if(p.getAlienWord().equals(newWord.getAlienWord())) {
				dictionary.remove(p);
				dictionary.add(newWord);
			}
		}
		dictionary.add(newWord);
	}
	
	public String translateWord(String aw) {
		String risultato = null;
		for(Word p : dictionary) {
			if(p.getAlienWord().equals(aw)) {
				risultato=p.getTranslation();
				break;
			}
		}
		return risultato;
		
	}
	
	public void resetDizionario() {
		dictionary.clear();
	}
	
	public List getDizionario() {
		return dictionary;
		
	}
	

}

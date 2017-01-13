package klondike.models;

import java.util.Stack;

public class StackCard {
	private Stack<Card> stackCard;
	
	public StackCard() {
		stackCard = new Stack<Card>();
	}
	
	@Override
	public String toString(){
		String suiteString = "";
		for(int i=0 ; i<this.stackCard.size(); i++){
			suiteString = suiteString + this.stackCard.get(i).toString();
		}
		return suiteString;
	}
	
	public Stack<Card> getStackCard(){
		return this.stackCard;
	}
}

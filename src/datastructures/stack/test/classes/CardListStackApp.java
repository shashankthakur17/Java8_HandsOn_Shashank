package datastructures.stack.test.classes;

import datastructures.contracts.Stack;
import datastructures.stack.ListStack;

public class CardListStackApp {

	public static void main(String[] args) {

		Stack<String> stackOfCards = stackCards();

		unstackCards(stackOfCards);
		
		//restack cards
		Stack<String> reStackedCards = stackCards();
		
		//how many cards are on the deck
		desckSize(reStackedCards);
		
		//do we have queen of hearts in the deck
		containsCard(reStackedCards, "Queen of Hearts");

		//do we have a joker
		containsCard(reStackedCards, "Joker");

		//go to the king of diamonds
		goToCard(reStackedCards, "King of Diamonds");

		//now how many cards are on the deck
		desckSize(reStackedCards);
}

	public static Stack<String> stackCards() {

		Stack<String> stack = new ListStack<>();
		//stack the spade suit
		stack.push("Ace of Spades");
		stack.push("2 of Spades");
		stack.push("3 of Spades");
		stack.push("4 of Spades");
		stack.push("5 of Spades");
		stack.push("6 of Spades");
		stack.push("7 of Spades");
		stack.push("8 of Spades");
		stack.push("9 of Spades");
		stack.push("10 of Spades");
		stack.push("Jack of Spades");
		stack.push("Queen of Spades");
		stack.push("King of Spades");

		//stack the diamond suit
		stack.push("Ace of Diamonds");
		stack.push("2 of Diamonds");
		stack.push("3 of Diamonds");
		stack.push("4 of Diamonds");
		stack.push("5 of Diamonds");
		stack.push("6 of Diamonds");
		stack.push("7 of Diamonds");
		stack.push("8 of Diamonds");
		stack.push("9 of Diamonds");
		stack.push("10 of Diamonds");
		stack.push("Jack of Diamonds");
		stack.push("Queen of Diamonds");
		stack.push("King of Diamonds");

		//stack the club suit
		stack.push("Ace of Clubs");
		stack.push("2 of Clubs");
		stack.push("3 of Clubs");
		stack.push("4 of Clubs");
		stack.push("5 of Clubs");
		stack.push("6 of Clubs");
		stack.push("7 of Clubs");
		stack.push("8 of Clubs");
		stack.push("9 of Clubs");
		stack.push("10 of Clubs");
		stack.push("Jack of Clubs");
		stack.push("Queen of Clubs");
		stack.push("King of Clubs");

		//stack the heart suit
		stack.push("Ace of Hearts");
		stack.push("2 of Hearts");
		stack.push("3 of Hearts");
		stack.push("4 of Hearts");
		stack.push("5 of Hearts");
		stack.push("6 of Hearts");
		stack.push("7 of Hearts");
		stack.push("8 of Hearts");
		stack.push("9 of Hearts");
		stack.push("10 of Hearts");
		stack.push("Jack of Hearts");
		stack.push("Queen of Hearts");
		stack.push("King of Hearts");

		return stack;
	}
	
	public static void unstackCards(Stack<String> stack) {
		//now pull the cards off the stack and print them
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	public static void containsCard(Stack<String> stack, String card) {
		System.out.println("Does Deck contains " + card + " = " + stack.contains(card));
	}

	public static void goToCard(Stack<String> stack, String card) {
		System.out.println("get card " + stack.access(card));
	}

	public static void desckSize(Stack<String> stack) {
		System.out.println("how many cards are on the deck = " + stack.size());
	}
}

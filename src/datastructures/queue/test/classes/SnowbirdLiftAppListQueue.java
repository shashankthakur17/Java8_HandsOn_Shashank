package datastructures.queue.test.classes;

import datastructures.contracts.Queue;
import datastructures.queue.ListQueue;

public class SnowbirdLiftAppListQueue {

	Queue<Gad2Chair> gad2LiftQueue = new ListQueue<>();

	public static void main(String[] args) {
		SnowbirdLiftAppListQueue app = new SnowbirdLiftAppListQueue();
		app.runLift();
	}

	public void runLift() {
		loadLift();

		// print out the lift size
		System.out.println(gad2LiftQueue.size());

		// does the lift contain skier Mary and Anna
		System.out.println("Lift has Mary and Anna on it: " + gad2LiftQueue.contains(new Gad2Chair("Mary", "Anna")));

		// who's at the 2nd position
		System.out.println("2nd chair has: " + gad2LiftQueue.access(2).listChairRiders());

		//System.out.println("5th chair has: " + gad2LiftQueue.access(5).listChairRiders());

		try {
			System.out.println("6th chair has: " + gad2LiftQueue.access(6).listChairRiders());
		} catch (IllegalArgumentException e) {
			System.out.println("message from Exception: \\ " + e.getMessage());
		}

		unloadLift();

		// if the lift is unloaded again, an error should occur since no one is left on
		// it
		try {
			unloadLift();
		} catch (IllegalStateException t) {
			System.out.println("Can't unload any more skiers because the lift is empty: " + t.getMessage());
		}
	}

	private void loadLift() {
		// skiers in line to get on lift
		Gad2Chair chair1 = new Gad2Chair("John", "Dave");
		Gad2Chair chair2 = new Gad2Chair("Samantha", "Kelly");
		Gad2Chair chair3 = new Gad2Chair("Mary", "Anna");
		Gad2Chair chair4 = new Gad2Chair("Robert", "Chad");
		Gad2Chair chair5 = new Gad2Chair("Sarah", "Bill");

		// load them onto the lift
		gad2LiftQueue.enQueue(chair1);
		gad2LiftQueue.enQueue(chair2);
		gad2LiftQueue.enQueue(chair3);
		gad2LiftQueue.enQueue(chair4);
		gad2LiftQueue.enQueue(chair5);
	}

	private void unloadLift() {
		Gad2Chair chair = gad2LiftQueue.deQueue();

		// should be John and Dave
		System.out.println(chair.listChairRiders());

		chair = gad2LiftQueue.deQueue();

		// should be Samantha and Kelly
		System.out.println(chair.listChairRiders());

		chair = gad2LiftQueue.deQueue();

		// should be Mary and Anna
		System.out.println(chair.listChairRiders());

		chair = gad2LiftQueue.deQueue();

		// should be Robert and Chad
		System.out.println(chair.listChairRiders());

		chair = gad2LiftQueue.deQueue();

		// should be Sarah and Bill
		System.out.println(chair.listChairRiders());
	}

	class Gad2Chair {
		private String seat1Name;
		private String seat2Name;

		public Gad2Chair(String skierInFirstSeat, String skierInSecondSeat) {
			this.seat1Name = skierInFirstSeat;
			this.seat2Name = skierInSecondSeat;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((seat1Name == null) ? 0 : seat1Name.hashCode());
			result = prime * result + ((seat2Name == null) ? 0 : seat2Name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Gad2Chair other = (Gad2Chair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (seat1Name == null) {
				if (other.seat1Name != null)
					return false;
			} else if (!seat1Name.equals(other.seat1Name))
				return false;
			if (seat2Name == null) {
                return other.seat2Name == null;
			} else return seat2Name.equals(other.seat2Name);
        }

		public String listChairRiders() {
			return this.seat1Name + ", " + this.seat2Name;
		}

		private SnowbirdLiftAppListQueue getOuterType() {
			return SnowbirdLiftAppListQueue.this;
		}
	}

}

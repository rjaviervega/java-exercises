/*
* Object Oriented Exercise
* Given an animal shelter object, provide
* methods for dequeying animals from queue
* depending on preference for Cats, Dogs or
* Older entry.
*
*/
import java.util.*;

public class AnimalShelter 
{	
	public static void main(String args[]) {
		
		System.out.println("AnimalShelter Sample");
						
		AnimalQueue a = new AnimalQueue();		
		a.enqueue(new Dog("Anthar"));
		a.enqueue(new Dog("Cobo"));		
		a.enqueue(new Dog("Simon"));				
		a.enqueue(new Cat("Cochino"));			
		
		Animal an = (Animal) a.dequeueAny();
		
		System.out.println(an.name);		
		an = (Animal) a.dequeueCat();
		System.out.println(an.name);		
	}
}


abstract class Animal 
{
	private int order;
	public String name;
	public Animal(String n) {
		name = n;
	}
	public void setOrder(int ord) {
		order = ord;
	}
	public int getOrder() {
		return order;
	}
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}	
}


class AnimalQueue 
{	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0; // Counter acts as timestamp
	
	public AnimalQueue() {		
	}
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) dogs.addLast((Dog) a);
		if (a instanceof Cat) cats.addLast((Cat) a);
	}
	
	public Animal dequeueAny() {
		Dog d = dogs.peek();
		Cat c = cats.peek();		
		if (d.isOlderThan(c)) return dequeueDog(); else return dequeueCat();		
	}
	
	public Dog dequeueDog() {
		return dogs.poll();
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
}


class Dog extends Animal 
{
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal 
{
	public Cat(String n) {
		super(n);
	}
}
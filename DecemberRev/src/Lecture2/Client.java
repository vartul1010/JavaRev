package Lecture2;

public class Client {

	public static void main(String[] args) {
		
		Graphs gph = new Graphs();
		
		gph.addVertex("A");
		gph.addVertex("B");
		gph.addVertex("C");
		gph.addVertex("D");
		gph.addVertex("E");
		gph.addVertex("F");
		gph.addVertex("G");
		
		gph.addEdge("A", "B", 10);
		gph.addEdge("A", "D", 40);
		gph.addEdge("B", "C", 10);
		gph.addEdge("C", "D", 10);
		gph.addEdge("D", "E", 2);
		gph.addEdge("E", "F", 3);
		gph.addEdge("F", "G", 3);
		gph.addEdge("G", "E", 8);
		
		gph.display();

	}

}

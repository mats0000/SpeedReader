// Ryota Matsunaga
// assignment 4
// December 10 2021
// None
// None
//I/we confirm that the above list of sources is complete AND that I/we have not talked to anyone else (e.g., CSC 207 students) about the solution to this problem.

import java.util.HashMap;
import java.util.Map;

public class ALifeSim {

	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("you should have command line arguments (iterations, cooperators, defectors, partial cooperators)");
			System.exit(1);
		}
		
		int iterations = Integer.parseInt(args[0]);
		int cooperators = Integer.parseInt(args[1]);
		int defectors = Integer.parseInt(args[2]);
		int partial = Integer.parseInt(args[3]);
		
		Map<String,Integer> m = new HashMap<>();
		m.put("Cooperator", cooperators);
		m.put("Defector", defectors);
		m.put("PartialCooperator", partial);
		
		Population p = new Population(m);
		for (int i = 0; i < iterations; i++) {
			p.update();
		}
		Map<String, Integer> hm = p.getPopulationCounts();
		System.out.println("After " + iterations + " ticks:");
		System.out.println("Cooperators = " + hm.get("Cooperator"));
		System.out.println("Defectors = " + hm.get("Defector"));
		System.out.println("Partial = " + hm.get("PartialCooperator"));
		System.out.println("Mean Cooperation Probability = " + p.calculateCooperationMean()); 
	}

}

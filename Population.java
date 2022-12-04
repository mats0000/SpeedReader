import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Population {
	
	ArrayList<Organism> population;
	
	public Population(Map<String, Integer> counts) throws IllegalArgumentException {
		population = new ArrayList<Organism>();
		for (String type : counts.keySet()) {
			if (type == "Cooperator") {
				int coopCount = counts.get(type);
				for (int i = 0; i < coopCount; i++) {
					population.add(new Cooperator());
				}
			} else if (type == "Defector") {
				int defCount = counts.get(type);
				for (int i = 0; i < defCount; i++) {
					population.add(new Defector());
				}
			} else if (type == "PartialCooperator") {
				int partcoopCount = counts.get(type);
				for (int i = 0; i < partcoopCount; i++) {
					population.add(new PartialCooperator());
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
	
	public void update() {
		for (int i = 0; i < population.size(); i++) {
			Organism org = population.get(i);
			org.update();
			Random rng = new Random();
			if (org.cooperates()) {
				org.energyLevel--;
				for (int j = 0; j < 8; j++) {
					int rand = rng.nextInt(population.size());
					population.get(rand).energyLevel++;
				}
			}
			if (org.getEnergy() > 10) {
				Organism offspring = org.reproduce();
				int rand = rng.nextInt(population.size());
				population.set(rand, offspring);
			}
		}
	}
	
	public double calculateCooperationMean() {
		double sum = 0;
		for (int i = 0; i < population.size(); i++) {
			sum += population.get(i).getCooperationProbability();
		}
		return sum / population.size();
	}
	
	public double caculateCooperationOrgMean() {
		double sum = 0;
		int size = 0;
		for (int i = 0; i < population.size(); i++) {
			if (population.get(i).getType() == "Cooperator") {
				sum += population.get(i).getCooperationProbability();
				size++;
			}
		}
		return sum / size;
	}
	
	public double caculateDefectorOrgMean() {
		double sum = 0;
		int size = 0;
		for (int i = 0; i < population.size(); i++) {
			if (population.get(i).getType() == "Defector") {
				sum += population.get(i).getCooperationProbability();
				size++;
			}
		}
		return sum / size;
	}
	
	public double caculatePartialOrgMean() {
		double sum = 0;
		int size = 0;
		for (int i = 0; i < population.size(); i++) {
			if (population.get(i).getType() == "PartialCooperator") {
				sum += population.get(i).getCooperationProbability();
				size++;
			}
		}
		return sum / size;
	}
	
	public Map<String, Integer> getPopulationCounts() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int coopCount = 0;
		int defCount = 0;
		int partCount = 0;
		
		for (int i = 0; i < population.size(); i++) {
			String type = population.get(i).getType();
			if (type == "Cooperator") coopCount++;
			else if (type == "Defector") defCount++;
			else  partCount++;
		}
		
		map.put("Cooperator", coopCount);
		map.put("Defector", defCount);
		map.put("PartialCooperator", partCount);
		
		return map;
	}
}

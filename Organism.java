
public abstract class Organism {
	int energyLevel;
	
	public Organism() {
		energyLevel = 0;
	}
	
	public void update() {
		energyLevel++;
	}
	public int getEnergy() {
		return energyLevel;
	}
	
	public void incrementEnergy() {
		energyLevel++;
	}
	
	public void decrementEnergy() {
		energyLevel--;
		if (energyLevel < 0) energyLevel = 0;
	}
	public abstract String getType();
	
	public abstract Organism reproduce();
	
	public abstract double getCooperationProbability();
	
	public abstract boolean cooperates();
}

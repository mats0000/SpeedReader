
public class Defector extends Organism{

	@Override
	public String getType() {
		return "Defector";
	}

	@Override
	public Organism reproduce() {
		this.energyLevel = 0;
		return new Defector();
	}

	@Override
	public double getCooperationProbability() {
		return 0;
	}

	@Override
	public boolean cooperates() {
		return false;
	}

}

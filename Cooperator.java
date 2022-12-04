
public class Cooperator extends Organism{

	@Override
	public String getType() {
		return "Cooperator";
	}

	@Override
	public Organism reproduce() {
		this.energyLevel = 0;
		return new Cooperator();
	}

	@Override
	public double getCooperationProbability() {
		return 1;
	}

	@Override
	public boolean cooperates() {
		return true;
	}

}

import java.util.Random;

public class PartialCooperator extends Organism{

	@Override
	public String getType() {
		return "PartialCooperator";
	}

	@Override
	public Organism reproduce() {
		this.energyLevel = 0;
		return new PartialCooperator();
	}

	@Override
	public double getCooperationProbability() {
		return 0.5;
	}

	@Override
	public boolean cooperates() {
		Random RNG = new Random();
		int rand = RNG.nextInt(2);
		return rand == 1 ? true : false;
	}

}


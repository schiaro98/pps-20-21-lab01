package lab01.tdd;

public class OddStrategy implements SelectStrategy {
	@Override
	public boolean apply(int element) {
		return element % 2 == 1;
	}
}

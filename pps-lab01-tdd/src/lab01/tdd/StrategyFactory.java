package lab01.tdd;

public interface StrategyFactory {

	SelectStrategy createEvenStrategy();

	SelectStrategy createOddStrategy();

	SelectStrategy createMultipleStrategy();

	SelectStrategy createEqualStrategy();
}

package adapter_pattern;

import java.util.Random;
import java.util.Scanner;

interface BMiCalculatorAdapter {
	double calculateBMI(double height, double weight);
}

class BMICalculator implements BMiCalculatorAdapter {

	BMICalculatorOriginal calculatorOriginal;
	
	public BMICalculator() {
		calculatorOriginal = new BMICalculatorOriginal();
	}
	
	@Override
	public double calculateBMI(double height, double weight) {
		return calculatorOriginal.calculateBMIOriginal((height / 2.54), (weight * 2.205));
	}

	
	
}
class BMICalculatorOriginal {
	
	public double calculateBMIOriginal(double heightInInches, double weightInPounds) {
		return 703 * (weightInPounds) / (heightInInches * heightInInches);
	}
}
public class Client {
 public static void main(String[] args) {
	Scanner scanner =new Scanner(System.in);
	System.out.println("Enter height in cms");
	double height = scanner.nextDouble();
	System.out.println("Enter weight in kgs");
	double weight = scanner.nextDouble();
	BMiCalculatorAdapter adapter = new BMICalculator();
	System.out.printf("%.2f", adapter.calculateBMI(height, weight));
}
}

package main;

public class Runner {
	public static void main(String[] args) {
		System.out.println(StringCalculator.add("")); // 0
		System.out.println(StringCalculator.add("1234,2,5")); // 1
		System.out.println(StringCalculator.add("1,12,2")); // 15
		System.out.println(StringCalculator.add("1,2,3")); // 6
		System.out.println(StringCalculator.add("1\n2,3")); // 6
		System.out.println(StringCalculator.add("1,3,3")); // 3
		System.out.println(StringCalculator.add("1,12")); // 3
		try {
			StringCalculator.add("-1,2"); // Throws "Negatives not allowed: -1"
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(StringCalculator.add("//;\n1,2;"));
		System.out.println(StringCalculator.add("//[|][%]\n1|2%3")); // 6
		System.out.println(StringCalculator.add("//[|||]\n1|||2|||3")); // 6
	}
}
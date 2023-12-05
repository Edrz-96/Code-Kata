package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	public static int add(String input) {
		return inputLogic(input).stream().mapToInt(Integer::intValue).sum();
	}

	private static List<Integer> inputLogic(String input) {
		List<Integer> nums = new ArrayList<>();
		if (input.isEmpty()) {
			nums.add(0);
			return nums;
		} else if (customDelimiterCheck(input)) {
			nums = Arrays.stream(splitCustomDelimiters(input)).filter(s -> !s.trim().isEmpty()).map(Integer::parseInt)
					.filter(n -> n <= 1000).collect(Collectors.toList());
			handleNegativeNumbers(nums);
			return nums;
		} else {
			nums.addAll(Arrays.stream(splitDelimiters(input)).map(Integer::parseInt).filter(n -> n <= 1000)
					.collect(Collectors.toList()));
			handleNegativeNumbers(nums);
			return nums;
		}
	}

	private static boolean customDelimiterCheck(String input) {
		return input.startsWith("//");
	}

	private static String[] splitDelimiters(String numbers) {
		return numbers.split("[,|\n]");
	}

	private static String[] splitCustomDelimiters(String numbers) {
		return numbers.split("-?//|\\||%|\\]|\\[|;|,|\\n");
	}

	private static void handleNegativeNumbers(List<Integer> nums) {
		List<Integer> negativeNumbers = nums.stream().filter(n -> n < 0).collect(Collectors.toList());
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
		}
	}
}
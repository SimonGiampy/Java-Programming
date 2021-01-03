package home.tests;


import java.io.*;

class Gauss {
	private static final int tot = 366;
	
	public static void main(String[] args) throws IOException {
		int[] values = new int[tot];
		String path = "D:\\University\\3 Year\\Ingegneria del Software\\Programming\\src\\home\\concurrency\\tests\\";
		
		File file = new File(path + "numbers.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = reader.readLine();
		int k = 0;
		while (line != null && !line.equals("")) {
			values[k] = Integer.parseInt(line);
			line = reader.readLine();
			k++;
		}
		reader.close();
		
		double[] converted = new double[tot];
		for (int i = 0; i < tot; i++) {
			converted[i] = values[i];
			//System.out.printf("%.2f ", converted[i]);
		}
		
		double[] smoothed = smooth(converted, 1);
		smoothed = smooth(smoothed, 1);
		for (int i = 0; i < tot; i++) {
			System.out.printf("%.2f ", smoothed[i]);
		}
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "output.txt"));
		for (int i = 0; i < tot; i++) {
			bufferedWriter.write(smoothed[i] + "\n");
		}
		bufferedWriter.close();
	}
	
	private static double[] smooth(double[] nums, double alpha) {
		double average = average(nums);
		double weighted = average * alpha;
		double[] smoothed = new double[tot]; //output array
		
		double current, previous, next;
		for (int i = 0; i < nums.length; i++) {
			current = nums[i];
			if (i > 0) {
				previous =smoothed[i - 1];
			} else {
				previous = nums[nums.length - 1];
			}
			if (i == nums.length - 1) {
				next = nums[0];
			} else {
				next = current;
			}
			double improved = average(new double[]{weighted, previous, current, next});
			smoothed[i] = improved;
		}
		return smoothed;
	}
	
	private static double average(double[] values) {
		double sum = 0;
		for (double x : values) {
			sum += x;
		}
		return sum / values.length;
	}
}

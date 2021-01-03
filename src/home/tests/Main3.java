package home.tests;

import java.util.ArrayList;
import java.util.List;

class Main3 {
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("key");
		names.add("ff");
		names.add("fes");
		names.add("fdsdfs");
		String key = "key";
		
		long n1 = names.stream().filter(s -> s.equals(key)).count() * 2;
		long n2 = names.stream().filter(s -> !s.equals(key)).count();
		
		int x = names.stream().map((s) -> {
			if (s.equals(key)) {
				return 2;
			} else return -1;
		}).reduce(0, Integer::sum);
		
		System.out.println(" other method = " + x);
		System.out.println(n1 - n2);
	}
}

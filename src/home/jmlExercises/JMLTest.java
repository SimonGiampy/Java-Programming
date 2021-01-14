package home.jmlExercises;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class JMLTest {
	
	
	public static void main(String[] args) {
		JMLTest1 test = new JMLTest1();
		ArrayList<String> arr = test.get();
		if (arr == null) System.out.println("null");
		else if (arr.isEmpty()) System.out.println("empty");
		else System.out.println("other");
		
		
	}
	
	static class JMLTest1 {
		ArrayList<String> arr;
		JMLTest1() {
			arr = new ArrayList<>();
		}
		ArrayList<String> get() {
			return arr;
		}
	}
}

/*

abstract class Oggetto {
	public abstract void parla();
}
class OggettoVolante extends Oggetto {
	public void parla() { System.out.println("Ciao, sono un oggetto volante"); }
	public void parla(Oggetto altro) {
		System.out.println("Ciao, chi sei?");
		altro.parla();
	}
}


class UFO extends OggettoVolante {
	public void parla(OggettoVolante altro) {
		System.out.println("Ciao, sono un oggetto volante non identificato, tu?");
		altro.parla();
	}
}

1. Oggetto o1, o2;
2. OggettoVolante o3;
3. UFO o4;
4. o1 = new Oggetto(); //wrong: abstract classes can't be instantiated
5. o2 = new OggettoVolante();  //ok
6. o3 = new UFO(); //ok
7. o4 = o3; //static UFO type

8. o2.parla();  //out = oggetto volante
9. o2.parla(o3); //out = chi sei? oggetto volante
10. o3.parla(o2); //out = sono ufo, tu? oggetto volante
11. o4 = (UFO) o2;
12. o4.parla();
13. o4 = (UFO) o3;
14. o4.parla();
15. o4.parla(o4);


 */
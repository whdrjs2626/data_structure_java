package ListPoly;

public class ArrListPolyTest {
	public static void main(String[] args) {

		ArrListPoly p1 = new ArrListPoly();
		int[] poly1 = { 9, 0, -3, 0, 5 };
		// 9x0 + 0x1 + 3x2 + 0x3 + 5x4
		int p1highestDegree = poly1.length - 1;
		p1.setPoly(p1highestDegree, poly1);
		printPolyEq(p1, 1);

		ArrListPoly p2 = new ArrListPoly();
		int[] poly2 = { 2, 0, 4 };
		// 2x0 + 0x1 + 4x2
		int p2highestDegree = poly2.length - 1;
		p2.setPoly(p2highestDegree, poly2);
		printPolyEq(p2, 3);

	}

	public static void printPolyEq(ArrListPoly p, int nTabs) {
		for (int i = 0; i < nTabs; i++) {
			System.out.printf("\t");
		}
		for (int i = p.getHighestDegree(); i >= 0; i--) {

			System.out.printf("%+d x%d\t", p.peek(i), i);
		}
		System.out.println();
	}
	}
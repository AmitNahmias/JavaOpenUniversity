public class SetTesterGadiVilner
{
	public static void main(String[] args)
	{
		Set set = new Set();
		System.out.println(set.isEmpty());
		set.addToSet(-5);
		set.addToSet(22);
		set.addToSet(23);
		set.addToSet(55);
		set.addToSet(3);
		set.addToSet(5);
		set.addToSet(5);
		set.addToSet(45);
		set.addToSet(0);
		set.addToSet(101);
		System.out.println(!set.isEmpty());
		//
		System.out.println(set.toString().equals("{3,5,23,45,55,101}"));
		System.out.println(set.isMember(45));
		set.removeFromSet(45);
		System.out.println(!set.isMember(45));
		System.out.println(set.numOfElements() == 5);

		// {1,5,23,55,101}
		Set set2 = new Set();
		set2.addToSet(43);
		set2.addToSet(1);
		set2.addToSet(55);
		set2.addToSet(5);
		set2.addToSet(57);
		set2.addToSet(103);
		System.out.println(set2.toString().equals("{1,5,43,55,57,103}"));
		Set diffSet = set.difference(set2);
		System.out.println(diffSet.toString().equals("{3,23,101}"));
		Set interSet = set.intersection(set2);
		System.out.println(interSet.toString().equals("{5,55}"));
		Set unionSet = set.union(set2);
		System.out.println(unionSet.toString().equals("{1,3,5,23,43,55,57,101,103}"));
		System.out.println(set.subSet(interSet));
		System.out.println(set.subSet(diffSet));
		System.out.println(!set.subSet(unionSet));
	}
}

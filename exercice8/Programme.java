package exercice8;

/**
 * Comparateur d'objets de type Integer.
 * <p>
 * 
 * Represente la relation d'ordre sur les entiers relatifs.
 */
class ComarateurInteger implements Comparateur {
	@Override
	public Integer compare(Object o1, Object o2) {
		if (!(o1 instanceof Integer))
			return null;
		if (!(o2 instanceof Integer))
			return null;
		return (Integer) o1 - (Integer) o2;
	}
}

/**
 * Classe de test.
 * <p>
 * 
 * Contient une methode main et des fonctions de test.
 */
class Programme {

	static void affiche(Ensemble e) {
		affiche(e, null);
	}

	static void affiche(Ensemble e, Object o) {
		String contient = "";
		if (o != null)
			contient = (e.contains(o) ? ", contient " : ", ne contient pas ") + o;
		System.out.println(e.toString() + " " + e.size() + " element" + (e.size() == 0 ? "" : "s" + contient));
	}

	static void affiche(Iterateur it) {
		System.out.print("Parcours par iterateur : debut > ");
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println("> fin.");
	}

	static void test1(Ensemble e) {
		System.out.println("Ensemble initial :");
		affiche(e);		
		System.out.println("Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...");
		for (int i = 0; i < 10; i++)
			e.add(i);
		System.out.println("Deuxième ajout de 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...");
		for (int i = 0; i < 10; i++)
			e.add(i);
		System.out.println("Ensemble mis à jour :");
		affiche(e);
	}

	static void test2(Ensemble e) {
		System.out.println("Ensemble initial :");
		affiche(e, 9);
		System.out.println("Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...");
		for (int i = 0; i < 10; i++)
			e.add(i);
		System.out.println("Ensemble mis à jour :");
		affiche(e, 9);
		System.out.println("Suppression de 9...");
		e.remove(9);
		System.out.println("Deuxième suppression de 9...");
		e.remove(9);
		System.out.println("Ensemble mis à jour :");
		affiche(e, 9);
		affiche(e, 0);
		System.out.println("Suppression de 0...");
		e.remove(0);
		System.out.println("Deuxième suppression de 0...");
		e.remove(0);
		System.out.println("Ensemble mis à jour :");
		affiche(e, 0);
		affiche(e, 4);
		System.out.println("Suppression de 4...");
		e.remove(4);
		System.out.println("Deuxième suppression de 4...");
		e.remove(4);
		System.out.println("Ensemble mis à jour :");
		affiche(e, 4);
		System.out.println("Suppression des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...");
		for (int i = 0; i < 10; i++)
			e.remove(i);
		System.out.println("Ensemble mis à jour :");
		affiche(e, 4);
	}

	static void test3(Ensemble e) {
		System.out.println("Ensemble initial :");
		affiche(e);
		affiche(e.getIterateur());
		System.out.println("Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...");
		for (int i = 0; i < 10; i++)
			e.add(i);
		System.out.println("Ensemble mis à jour :");
		affiche(e);
		affiche(e.getIterateur());
	}

	/*static void test4(Ensemble e) {
		ComarateurInteger c = new ComarateurInteger();
		System.out.println("Ensemble initial :");
		affiche(e);
		System.out.println("  -> MIN : " + e.min(c));
		System.out.println("  -> MAX : " + e.max(c));
		System.out.println("Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...");
		for (int i = 0; i < 10; i++)
			e.add(i);
		System.out.println("Ensemble mis à jour :");
		affiche(e);
		System.out.println("  -> MIN : " + e.min(c));
		System.out.println("  -> MAX : " + e.max(c));
		System.out.println("Suppression de 0...");
		e.remove(0);
		System.out.println("Suppression de 9...");
		e.remove(9);
		System.out.println("Ensemble mis à jour :");
		affiche(e);
		System.out.println("  -> MIN : " + e.min(c));
		System.out.println("  -> MAX : " + e.max(c));
		System.out.println("Ajout du caractère \'Z\' (invalide min et max)...");
		e.add('Z');
		System.out.println("Ensemble mis à jour :");
		affiche(e);
		System.out.println("  -> MIN : " + e.min(c));
		System.out.println("  -> MAX : " + e.max(c));
	}*/

	static void test5(Ensemble e) {
		System.out.println("Ensemble initial (original) :");
		affiche(e);
		System.out.println("Production du clone...");
		Ensemble c = e.clone();
		System.out.println("Clone :");
		affiche(c);
		System.out.println("Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9 dans l'original...");
		for (int i = 0; i < 10; i++)
			e.add(i);
		System.out.println("Original :");
		affiche(e);
		System.out.println("Clone :");
		affiche(c);
		System.out.println("Recreation du clone...");
		c = e.clone();
		System.out.println("Original :");
		affiche(e);
		System.out.println("Clone :");
		affiche(c);
		System.out.println("Ajout des entiers 10, 11, 12, 13 et 14 dans le clone...");
		for (int i = 10; i < 15; i++)
			c.add(i);
		System.out.println("Original :");
		affiche(e);
		System.out.println("Clone :");
		affiche(c);
		System.out.println("Suppression de 1, 2 et 3 dans l'original...");
		e.remove(1);
		e.remove(2);
		e.remove(3);
		System.out.println("Suppression de 8, 9 et 10 dans le clone...");
		c.remove(8);
		c.remove(9);
		c.remove(10);
		System.out.println("Original :");
		affiche(e);
		System.out.println("Clone :");
		affiche(c);
	}

	static void test6(Ensemble e1, Ensemble e2) {
		System.out.print("E1 = ");
		affiche(e1);
		System.out.print("E2 = ");
		affiche(e2);
		System.out.print("E1 UNION E2 : ");
		affiche(Ensemble.union(e1, e2));
		System.out.print("E1 INTER E2 : ");
		affiche(Ensemble.inter(e1, e2));
		System.out.print("E1 DIFF  E2 : ");
		affiche(Ensemble.diff(e1, e2));

		for (int i = 0; i < 7; i++)
			e1.add(i);
		for (int i = 3; i < 10; i++)
			e2.add(i);

		System.out.print("E1 = ");
		affiche(e1);
		System.out.print("E2 = ");
		affiche(e2);
		System.out.print("E1 UNION E2 : ");
		affiche(Ensemble.union(e1, e2));
		System.out.print("E1 INTER E2 : ");
		affiche(Ensemble.inter(e1, e2));
		System.out.print("E1 DIFF  E2 : ");
		affiche(Ensemble.diff(e1, e2));
	}

	public static void main(String[] args) {

		System.out.println("\n-------------------------------------------------------------");
		System.out.println("------- Tests de constructeurs, toString, add et size -------");
		System.out.println("-------------------------------------------------------------");
		test1(new TabEnsemble());

		System.out.println("\n-------------------------------------------------------------");
		System.out.println("------- Tests de remove et contains -------------------------");
		System.out.println("-------------------------------------------------------------");
		test2(new TabEnsemble());

		System.out.println("\n-------------------------------------------------------------");
		System.out.println("------- Tests d'iterateurs ----------------------------------");
		System.out.println("-------------------------------------------------------------");
		test3(new TabEnsemble());

		/*System.out.println("\n-------------------------------------------------------------");
		System.out.println("------- Tests de min et max ---------------------------------");
		System.out.println("-------------------------------------------------------------");
		test4(new TabEnsemble());*/

		System.out.println("\n-------------------------------------------------------------");
		System.out.println("------- Tests de clone --------------------------------------");
		System.out.println("-------------------------------------------------------------");
		test5(new TabEnsemble());

		System.out.println("\n-------------------------------------------------------------");
		System.out.println("------- Tests de union, inter et diff -----------------------");
		System.out.println("-------------------------------------------------------------");
		test6(new TabEnsemble(), new TabEnsemble());

	}

}

/*

-------------------------------------------------------------
------- Tests de constructeurs, toString, add et size -------
-------------------------------------------------------------
Ensemble initial :
[ ] 0 element
Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...
Deuxième ajout de 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...
Ensemble mis à jour :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements

-------------------------------------------------------------
------- Tests de remove et contains -------------------------
-------------------------------------------------------------
Ensemble initial :
[ ] 0 element
Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...
Ensemble mis à jour :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements, contient 9
Suppression de 9...
Deuxième suppression de 9...
Ensemble mis à jour :
[ 0 1 2 3 4 5 6 7 8 ] 9 elements, ne contient pas 9
[ 0 1 2 3 4 5 6 7 8 ] 9 elements, contient 0
Suppression de 0...
Deuxième suppression de 0...
Ensemble mis à jour :
[ 8 1 2 3 4 5 6 7 ] 8 elements, ne contient pas 0
[ 8 1 2 3 4 5 6 7 ] 8 elements, contient 4
Suppression de 4...
Deuxième suppression de 4...
Ensemble mis à jour :
[ 8 1 2 3 7 5 6 ] 7 elements, ne contient pas 4
Suppression des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...
Ensemble mis à jour :
[ ] 0 element

-------------------------------------------------------------
------- Tests d'iterateurs ----------------------------------
-------------------------------------------------------------
Ensemble initial :
[ ] 0 element
Parcours par iterateur : debut > > fin.
Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...
Ensemble mis à jour :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
Parcours par iterateur : debut > 0 1 2 3 4 5 6 7 8 9 > fin.

-------------------------------------------------------------
------- Tests de min et max ---------------------------------
-------------------------------------------------------------
Ensemble initial :
[ ] 0 element
  -> MIN : null
  -> MAX : null
Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9...
Ensemble mis à jour :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
  -> MIN : 0
  -> MAX : 9
Suppression de 0...
Suppression de 9...
Ensemble mis à jour :
[ 8 1 2 3 4 5 6 7 ] 8 elements
  -> MIN : 1
  -> MAX : 8
Ajout du caractère 'Z' (invalide min et max)...
Ensemble mis à jour :
[ 8 1 2 3 4 5 6 7 Z ] 9 elements
  -> MIN : null
  -> MAX : null

-------------------------------------------------------------
------- Tests de clone --------------------------------------
-------------------------------------------------------------
Ensemble initial (original) :
[ ] 0 element
Production du clone...
Clone :
[ ] 0 element
Ajout des entiers 0, 1, 2, 3, 4, 5, 6, 7, 8 et 9 dans l'original...
Original :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
Clone :
[ ] 0 element
Recreation du clone...
Original :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
Clone :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
Ajout des entiers 10, 11, 12, 13 et 14 dans le clone...
Original :
[ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
Clone :
[ 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 ] 15 elements
Suppression de 1, 2 et 3 dans l'original...
Suppression de 8, 9 et 10 dans le clone...
Original :
[ 0 9 8 7 4 5 6 ] 7 elements
Clone :
[ 0 1 2 3 4 5 6 7 14 13 12 11 ] 12 elements

-------------------------------------------------------------
------- Tests de union, inter et diff -----------------------
-------------------------------------------------------------
E1 = [ ] 0 element
E2 = [ ] 0 element
E1 UNION E2 : [ ] 0 element
E1 INTER E2 : [ ] 0 element
E1 DIFF  E2 : [ ] 0 element
E1 = [ 0 1 2 3 4 5 6 ] 7 elements
E2 = [ 3 4 5 6 7 8 9 ] 7 elements
E1 UNION E2 : [ 0 1 2 3 4 5 6 7 8 9 ] 10 elements
E1 INTER E2 : [ 6 5 4 3 ] 4 elements
E1 DIFF  E2 : [ 0 1 2 ] 3 elements

*/

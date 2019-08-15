package exercice8;

/**
 * Représente un ensemble d'objets quelconques.
 * <p>
 * 
 * Les objets ne sont présents dans un ensemble qu'en une seule occurrence. Les
 * doublons d'objets sont donc interdits.
 * <p>
 * 
 * La détection de doublons d'objets est basée sur la méthode equals.
 * <p>
 * 
 * La référence null est interdite dans un ensemble.
 */
public interface Ensemble extends Cloneable {

	/**
	 * Ajoute un objet à l'ensemble, seulement si la référence fournie n'est pas
	 * null et si l'objet n'est pas déjà présent (selon equals).
	 * 
	 * @param o référence de l'objet à ajouter dans l'ensemble
	 */
	void add(Object o);

	/**
	 * Retire un objet de l'ensemble, seulement si la référence fournie désigne un
	 * objet effectivement présent (selon equals).
	 * 
	 * @param o référence de l'objet à retirer de l'ensemble
	 */
	void remove(Object o);

	/**
	 * Indique le nombre d'éléments dans l'ensemble.
	 * 
	 * @return cardinal de l'ensemble
	 */
	int size();

	/**
	 * Indique si un objet est présent (selon equals) dans l'ensemble.
	 * 
	 * @param o référence de l'objet recherché
	 * @return vrai ou faux selon que l'objet est présent ou non
	 */
	boolean contains(Object o);

	/**
	 * Renvoie un itérateur positionné sur l'ensemble.
	 * 
	 * @return nouvel itérateur
	 */
	Iterateur getIterateur();

	/**
	 * Renvoie la plus petite valeur de l'ensemble conformément à une relation
	 * d'ordre définie par un comparateur.
	 * <p>
	 * 
	 * Tous les éléments de l'ensemble doivent être comparables selon le comparateur
	 * fourni, faute de quoi le résultat est null.
	 * 
	 * @param c comparateur à utiliser pour déterminer le min
	 * @return plus petite valeur selon c si elle existe, null sinon
	 */

	Ensemble clone();


	static Ensemble union(Ensemble e1, Ensemble e2) {
		// TODO à compléter...
		Iterateur it = e2.getIterateur();
		Ensemble tabUnion  = e1.clone();
		Object o;		
		while(it.hasNext()){
				o = it.next();
				if(!e1.contains(o)){
					tabUnion.add(o);
				}
		}
		

		return tabUnion; // <- TODO résultat à adapter
	}

	/**
	 * Fonction utilitaire d'ensemble qui représente l'intersection.
	 * 
	 * @param e1 première opérande de l'intersection
	 * @param e2 deuxième opérande de l'intersection
	 * @return ensemble contenant tous les éléments présents à la fois dans e1 et
	 *         dans e2
	 */
	static Ensemble inter(Ensemble e1, Ensemble e2) {
		// TODO à compléter...

		Iterateur it = e1.getIterateur();
		Ensemble tabUnion  = e1.clone();
		Object o;		
		while(it.hasNext()){
				o = it.next();
				if(!e2.contains(o)){
					tabUnion.remove(o);
				}
		}

		return tabUnion; // <- TODO résultat à adapter
	}

	/**
	 * Fonction utilitaire d'ensemble qui représente la différence.
	 * 
	 * @param e1 première opérande de la différence
	 * @param e2 deuxième opérande de la différence
	 * @return ensemble contenant tous les éléments présents dans e1 mais pas dans
	 *         e2
	 */
	static Ensemble diff(Ensemble e1, Ensemble e2) {
		// TODO à compléter...
		Iterateur it = e2.getIterateur();
		Ensemble tabUnion  = e1.clone();
		Object o;		
		while(it.hasNext()){
				o = it.next();
				if(e1.contains(o)){
					tabUnion.remove(o);
				}
		}

		return tabUnion; // <- TODO résultat à adapter
	}

}

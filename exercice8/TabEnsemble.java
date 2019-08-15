package exercice8;
import java.util.Arrays;

/**
 * Représente un ensemble d'objets quelconques grâce à un tableau.
 * <p>
 * 
 * Les éléments de l'ensemble sont stockés dans un tableau réalloué par blocs.
 * Quand le tableau est plein, il est réalloué avec n cases en plus. Ces n cases
 * constituent un bloc.
 * <P>
 * 
 * De même, quand les cases libres du tableau constituent un bloc entier, le
 * tableau est réalloué avec un bloc de cases en moins.
 */
public class TabEnsemble implements Ensemble {

	/**
	 * Représente un itérateur sur un ensemble de type TabEnsemble.
	 * <p>
	 * 
	 * L'itérateur est matérialisé par l'indice du prochain élément à lire dans le
	 * tableau.
	 */
	@SuppressWarnings("unused")
	private class TabEnsembleIterateur implements Iterateur {

		// ----- Attributs -----

		// TODO à définir
		private int next;
		
		// ----- Constructeur -----

		// TODO à définir
		TabEnsembleIterateur(){
			this.next = 0;
		}

		// ----- Méthodes -----

		@Override
		public boolean hasNext() {
			// TODO à compléter...
			return TabEnsemble.this.prochainIndice != this.next;
		}

		@Override
		public Object next() {
			// TODO à compléter...
			if (this.hasNext() == true)
				this.next += 1;
			return TabEnsemble.this.tab[next-1]; // <- TODO résultat à adapter
		}

	}

	// ----- Attributs -----

	// TODO à définir
	private static final int TAILLEBLOC = 5;
	private Object[] tab;
	private int prochainIndice;
	
	// ----- Constructeur -----

	// TODO à définir
	TabEnsemble(){
		this.tab = new Object[TAILLEBLOC];
		this.prochainIndice = 0;
	}

	// ----- Méthodes -----

	@Override
	public void add(Object o) {
		// TODO à compléter
		boolean got = this.contains(o);
		if (got == true){
			System.out.println("L'objet existe déjà dans l'ensemble.");
			return;
		} else {
			if (o == null){
				System.out.println("Veuillez référencer un objet non null.");
				return;
			} else {
				this.tab[prochainIndice] = o;
				this.prochainIndice++;
				if (this.prochainIndice == this.tab.length){
					this.tab = Arrays.copyOf(this.tab, this.tab.length + TAILLEBLOC);
				}
			}
		}
	}

	@Override
	public void remove(Object o) {
		boolean got = this.contains(o);
		if (got == false){
			System.out.println("L'objet n'existe pas dans l'ensemble.");
			return;
		} else {
			for(int i = 0; i < this.prochainIndice; i++){
				if (this.tab[i].equals(o)){
					this.tab[i] = this.prochainIndice-1;
					this.tab[prochainIndice-1] = null;
					this.prochainIndice--;
					if(this.size() - this.prochainIndice > TAILLEBLOC){
						this.tab = Arrays.copyOf(this.tab, this.tab.length-TAILLEBLOC);
					}
				}
			}
		}
	}

	@Override
	public int size() {
		return this.prochainIndice; // <- TODO résultat à adapter
	}

	@Override
	public boolean contains(Object o) {
		// TODO à compléter...
		for(int i = 0; i < this.prochainIndice; i++){
			if (this.tab[i].equals(o)){
				return true;
			}
		}
		return false; // <- TODO résultat à adapter
	}

	@Override
	public Iterateur getIterateur() {
		// TODO à compléter...
		TabEnsembleIterateur it = new TabEnsembleIterateur();
		return it; // <- TODO résultat à adapter
	}

	@Override
	public String toString() {
		
		String chaine = "[";
		for(int i = 0; i < this.prochainIndice; i++){
			chaine = chaine + this.tab[i] + " ";
		}
		chaine = chaine + "]";
		return chaine; // <- TODO résultat à adapter
	}

	@Override
	public TabEnsemble clone() {
		TabEnsemble newclone = new TabEnsemble();
		newclone.tab = this.tab.clone();
		newclone.prochainIndice = this.prochainIndice;
		return newclone; // <- TODO résultat à adapter
	}
}

package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
	/** la liste des Maillons/Elements */
	private Maillon stk;
	/** la capacit� de la pile */
	private int capacite;
	/** le nombre */
	private int nombre;

	/**
	 * Classe interne "statique" contenant chaque �l�ment de la chaine c'est une
	 * proposition, vous pouvez l'ignorer !
	 */
	private static class Maillon implements Cloneable {
		private Object element;
		private Maillon suivant;

		public Maillon(Object element, Maillon suivant) {
			this.element = element;
			this.suivant = suivant;
		}

		public Maillon suivant() {
			return this.suivant;
		}

		public Object element() {
			return this.element;
		}

		public Object clone() throws CloneNotSupportedException {
			Maillon m = (Maillon) super.clone();
			m.element = element;
			return m;
		}
	}

	/**
	 * Cr�ation d'une pile.
	 * 
	 * @param taille
	 *            la taille de la pile, la taille doit �tre > 0
	 */
	public Pile4(int taille) {
		if (taille <= 0)
			taille = CAPACITE_PAR_DEFAUT;
		this.stk = null;
		this.capacite = taille;
	}

	public Pile4() {
		this(PileI.CAPACITE_PAR_DEFAUT);
	}

	public void empiler(Object o) throws PilePleineException {
		if (estPleine())
			throw new PilePleineException();
		nombre= nombre+1;
	        Maillon maillon = new Maillon(o, stk);
                stk = maillon;
	}

	public Object depiler() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		Object object = stk.element();
                stk = stk.suivant();
                nombre= nombre-1;
                return object;
	}

	public Object sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return stk.element();
	}

	/**
	 * Effectue un test de l'�tat de la pile.
	 * 
	 * @return vrai si la pile est vide, faux autrement
	 */
	public boolean estVide() {
		return stk == null;
	}

	/**
	 * Effectue un test de l'�tat de la pile.
	 * 
	 * @return vrai si la pile est pleine, faux autrement
	 */
	public boolean estPleine() {
		return capacite ==nombre; 
	}

	/**
	 * Retourne une repr�sentation en String d'une pile, contenant la
	 * repr�sentation en String de chaque �l�ment.
	 * 
	 * @return une repr�sentation en String d'une pile
	 */
	public String toString() {
        Maillon maillonInitial = stk;
        String s = "[";
        while (stk != null){
            s += (stk.element()==null)? "null":stk.element().toString();
            stk = stk.suivant();
            if(stk!=null) s+=", ";    
        }
        stk = maillonInitial;
        return s + "]";
    }

	public boolean equals(Object o) {
		if (o instanceof Pile4) {
		   int capacite = this.capacite();
                   int taille = this.taille();
        
                   PileI pile = (PileI) o;
                   if(super.equals(o)) return true;
        
                   if(capacite != pile.capacite()) return false;
                   if(taille != pile.taille()) return false;
        
		}
		return true;
	}

	public int capacite() {
		return this.capacite;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public int taille() {
		return nombre;
	}
}

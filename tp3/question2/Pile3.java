package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

	private Vector<Object> v;

	public Pile3() {
		this(0);
	}

	public Pile3(int taille) {
              if (taille <= 0) taille = CAPACITE_PAR_DEFAUT;
              v =new Vector<Object>(taille);
	}

	public void empiler(Object o) throws PilePleineException {
		if(estPleine())throw new PilePleineException();
		v.add(o);
	}

	public Object depiler() throws PileVideException {
              if(estVide())throw new PileVideException();	
	      Object removed= v.lastElement();
	      v.remove(v.size()-1);
	      return removed;
	}

	public Object sommet() throws PileVideException {
		if(estVide())throw new PileVideException();
		return v.lastElement();
	}

	public int taille() {
		
	    return v.size();
	}

	public int capacite() {
		
	    return v.capacity();
	}

	public boolean estVide() {
		
	    return v.size()==0;
	}

	public boolean estPleine() {
	    
	    return v.size()==v.capacity();
	}

	public String toString() {
        String s = "[";
        int taille = this.taille();
        for(int i = taille-1; i >= 0; i--){
            s += v.get(i);
            if(i>0) 
                s+=", ";
        }
        s += "]";
        return s;
    }

	public boolean equals(Object o) {
	      int capacite = this.capacite();
              int taille = this.taille();
        
              PileI pile = (PileI) o;
              if(super.equals(o)) return true;
        
              if(capacite != pile.capacite()) return false;
              if(taille != pile.taille()) return false;
        
        
              return true;
	}

	// fonction fournie
	public int hashCode() {
		return toString().hashCode();
	}

}

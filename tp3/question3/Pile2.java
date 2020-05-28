package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if(taille <= 0) taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>(); 
        this.capacite = taille;
    }

    public Pile2(){
        this(0);
    }

     public void empiler(T o) throws PilePleineException{
        if(estPleine())throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        if(estVide())throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if(estVide())throw new PileVideException();
        return stk.peek();
    }

    public int taille() {
        return stk.size();
    }
    
    public int capacite() {
        return this.capacite;
    }
    
    public boolean estPleine() {
        return stk.size() == capacite;
    }

    public boolean estVide() {
        return stk.size() == 0;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }

} 
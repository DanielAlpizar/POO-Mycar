package Tools;

import java.util.*;

/**
 * 
 */
public interface IObservable {
	public void addObserver(Observer obs);


	public void deleteObserver(Observer obs);


	public void deleteObservers();


	public int countObservers();


	public void setChanged();



	public void clearChanged();



	public boolean hasChanged();



	public void notifyObservers();



	public void notifyObservers(Object obj);

}
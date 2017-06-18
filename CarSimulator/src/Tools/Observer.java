package Tools;

import java.util.*;

/**
 * 
 */
public interface Observer {
	
	//method to update the observer, used by subject
	public void update(Object info);
	
	//attach with subject to observe
	public void setSubject(Subject sub);

}
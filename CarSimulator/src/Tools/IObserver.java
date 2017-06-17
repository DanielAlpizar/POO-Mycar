package Tools;

public abstract class IObserver {
   protected Subject subject;
   public abstract void update();
}
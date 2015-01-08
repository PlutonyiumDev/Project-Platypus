package model;
import java.util.*;
public class Viewable
{
    LinkedList<View> views = new LinkedList<View>();
    
    public void attach(View view)
    {
        views.add(view);
    }
    
    public void remove(View view)
    {
        views.remove(view);
    }
    
    public void update()
    {
        for(View v:views)
        {
            v.update();
        }
    }
}
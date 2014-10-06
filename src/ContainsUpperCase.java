/**
 * Created by Justin on 10/6/2014.
 */
public class ContainsUpperCase implements Predicate
{
    public boolean execute(Object o)
    {
        return !o.toString().equals(o.toString().toLowerCase());
    }
}

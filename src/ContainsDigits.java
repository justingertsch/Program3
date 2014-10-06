/**
 * Created by Justin on 10/6/2014.
 */
public class ContainsDigits implements Predicate
{
    public boolean execute(Object o)
    {
        return o.toString().matches(".*\\d.*");
    }
}


/**
 * Created by Justin on 10/6/2014.
 */
public class FilterOutput implements Output
{
    private Output wrapped;
    private Predicate p;

    public FilterOutput(Predicate p, Output wrapped) {
        this.wrapped = wrapped;
        this.p = p;
    }

    public void write(Object o) {
        if(this.p.execute(o))
            writeString(o.toString());
    }

    public void writeString(String s) {
        this.wrapped.write(s );
    }

    public void close()
    {
        this.wrapped.close();
    }

    public boolean execute(Object o)
    {
        return this.p.execute(o);
    }
}

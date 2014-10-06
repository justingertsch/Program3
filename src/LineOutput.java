
/**
 * Created by Justin on 10/6/2014.
 */
public class LineOutput implements Output
{
    private Output wrapped;

    public LineOutput(Output wrapped) {
        this.wrapped = wrapped;
    }

    public void write(Object o) {
        writeString(o.toString());
    }

    public void writeString(String s) {
        this.wrapped.write(s + System.lineSeparator());
    }

    public void close()
    {
        this.wrapped.close();
    }
}

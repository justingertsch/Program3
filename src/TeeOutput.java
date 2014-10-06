import java.io.IOException;
import java.io.Writer;

/**
 * Created by Justin on 10/6/2014.
 */
public class TeeOutput implements Output
{
    private Output wrapped;
    private Writer otherOutput;

    public TeeOutput(Output wrapped, Writer otherOutput) {
        this.wrapped = wrapped;
        this.otherOutput = otherOutput;
    }

    public void write(Object o) {
        writeString(o.toString());
    }

    public void writeString(String s) {
        this.wrapped.write(s);
        try {
            otherOutput.write(s);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void close()
    {
        this.wrapped.close();
        try
        {
            this.otherOutput.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

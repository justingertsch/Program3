
/**
 * Created by Justin on 10/6/2014.
 */
public class NumberedOutput implements Output
{
    private Output wrapped;
    private int lineNumber = 0;

    public NumberedOutput(Output wrapped) {
        this.wrapped = wrapped;
    }

    public void write(Object o) {
        writeString(o.toString());
    }

    public void writeString(String s) {
        this.wrapped.writeString(generateNewLineNumber() + s + System.lineSeparator());
    }

    public void close()
    {
        this.wrapped.close();
    }

    private String generateNewLineNumber()
    {
        String s = String.format("%5s: ", ++this.lineNumber);
        return s;
    }

}

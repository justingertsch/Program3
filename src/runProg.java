import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Justin on 10/6/2014.
 */
public class runProg
{
    public static void main(String[] args)
    {

        try
        {
            Output s = new FilterOutput(new ContainsUpperCase(),
            new NumberedOutput(
                new LineOutput(
                    new TeeOutput(
                        new StreamOutput(
                            new FileWriter("testoutput.txt")), new FileWriter("otherOutput.txt")))));

            Scanner in = new Scanner(new File("decorator.dat"));
            while (in.hasNextLine())
            {
                s.write(in.nextLine());
            }
            s.close();
        }
        catch (IOException ex)
        {
            System.out.print("Something went wrong with files");
            System.exit(1);
        }


    }
}

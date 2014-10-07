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
            System.out.print("Please enter a file to read from: ");
            Scanner input = new Scanner(System.in);
            String file = input.nextLine();
            while (file.equals(""))
            {
                System.out.println("Please enter a file to read from: ");
                file = input.nextLine();
            }
            Output s = new StreamOutput(new FileWriter("output.text"));
            String userInput;
            do
            {
                System.out.println("1: LineOutput, 2: NumberedOutput, 3: TeeOuput, 4: FilterOuput, 0: Output Stream");
                userInput = input.nextLine().trim();
                if(!userInput.equals("0"))
                    s = wrapOutput(s, userInput, input);
            } while (!userInput.equals("0"));

            input = new Scanner(new File(file));
            while (input.hasNextLine())
            {
                s.write(input.nextLine());
            }
            s.close();
        } catch (IOException ex)
        {
            System.out.print("Something went wrong with specified file");
            System.exit(1);
        }
    }

    private static Output wrapOutput(Output o, String ui, Scanner input)
    {
        String file;
        switch (ui)
        {
            case "1":
                return new LineOutput(o);
            case "2":
                return new NumberedOutput(o);
            case "3":

                do
                {
                    System.out.println("Enter name of output file to create:");
                    file = input.nextLine();
                } while (file.equals(""));

                try
                {
                    return new TeeOutput(o, new FileWriter(file));
                } catch (IOException ex)
                {
                    System.out.println("Problem creating new output file.");
                    System.exit(1);
                }

            case "4":

                do
                {
                    System.out.println("1: Contains Digits, 2: Contains Upper Case");
                    file = input.nextLine();
                } while (file.equals("") || (!file.equals("1") && !file.equals("2")));

                if (file.equals("1"))
                {
                    return new FilterOutput(new ContainsDigits(), o);
                } else
                {
                    return new FilterOutput(new ContainsUpperCase(), o);
                }
        }
        System.out.println("Should not have reached here");
        System.exit(1);
        return o;
    }

}

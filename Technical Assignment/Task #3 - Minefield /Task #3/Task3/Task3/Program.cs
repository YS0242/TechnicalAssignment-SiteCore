using System.Collections;
using Task3;

class Program
{
    static void Main()
    {

        //Console.WriteLine("Enter the minefield's width:");
        //int width = Convert.ToInt32(Console.ReadLine());

        //Console.WriteLine("Enter the minefield's height:");
        //int height = Convert.ToInt32(Console.ReadLine());

        // Create a new instance of the Minefield class
        Minefield minefield = new Minefield();

        //Minefield minefield = new Minefield(width, height);

        //Console.WriteLine("Enter the number of safe points:");
        //int numberOfSafePoints = Convert.ToInt32(Console.ReadLine());

        //for (int i = 0; i < numberOfSafePoints; i++)
        //{
        //    Console.WriteLine($"Enter the coordinates for safe point {i + 1} (e.g., '2 3' for row 2 column 3):");
        //    string[] inputs = Console.ReadLine().Split(' ');
        //    int x = Convert.ToInt32(inputs[0]);
        //    int y = Convert.ToInt32(inputs[1]);

        //    minefield.SetSafePoint(x, y);
        //}

        // Let F = Bomb exists and T = Safe path 
        char[,] BombsSetField = {
            { 'F', 'T', 'F', 'F', 'F' },
            { 'F', 'F', 'T', 'F', 'F' },
            { 'F', 'F', 'F', 'T', 'F' },
            { 'F', 'F', 'F', 'T', 'F' },
            { 'F', 'F', 'T', 'F', 'F' }
        };
        minefield.PlaceBombs(BombsSetField); // Sets the minefield to the initialValues array

        ArrayList safePathForTotoshka = minefield.SafePathCheckerForTotoshka();
        ArrayList safePathForAlly = minefield.SafePathForAlly();

        int p = 1;
        int q = 2;

        // Display the safe paths for Totoshka
        Console.WriteLine("Safe paths for Totoshka:");
        foreach (int[] path in safePathForTotoshka)
        {
            Console.WriteLine($"Move {p}: (row: {path[0]}, column: {path[1]})");
            p++;
        }

        // Display the safe paths for Ally, which starts with "At Start Point" (Ally will always 1 step after Totoshka)
        Console.WriteLine("\nSafe paths for Ally:");
        foreach (var item in safePathForAlly)
        {
            if (item is string) // Check if the item is a string
            {
                Console.WriteLine("Move 1: " + item); // Print the string directly
            }
            else if (item is int[]) // Check if the item is an array of integers (coordinates)
            {
                int[] path = (int[])item;
                Console.WriteLine($"Move {q}: (row: {path[0]}, column: {path[1]})");
                q++;
            }
        }
    }
}
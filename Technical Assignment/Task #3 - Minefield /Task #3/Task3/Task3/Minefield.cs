using System;
using System.Collections;

namespace Task3
{
    public class Minefield
    {
        private char[,] minefield;

        public Minefield()
        {
            minefield = new char[5, 5]; // The comment code segments below is for customisation of minefield size
        }

        //public Minefield(int m, int n)
        //{
        //    minefield = new char[m, n];
        //    for (int i = 0; i < m; i++)
        //        for (int j = 0; j < n; j++)
        //            minefield[i, j] = 'F'; // By default, placing bombs at every points
        //}

        //public void SetSafePoint(int x, int y)
        //{
        //    if (x >= 0 && x < minefield.GetLength(0) && y >= 0 && y < minefield.GetLength(1))
        //    {
        //        minefield[x, y] = 'T'; // 'T' for safe point
        //    }
        //    else
        //    {
        //        Console.WriteLine("Error: Safe point position is out of the minefield's range!");
        //    }
        //}

        // Method to set the minefield with bombs and safe points
        public void PlaceBombs(char[,] bombs) 
        {
            if(bombs.GetLength(0) == minefield.GetLength(0) && bombs.GetLength(1) == minefield.GetLength(1))
            {
                for(int i = 0; i < minefield.GetLength(0); i++)
                {
                    for(int j = 0; j < minefield.GetLength(1); j++)
                    {
                        minefield[i, j] = bombs[i, j]; 
                    }
                }
            }

            else
            {
                Console.WriteLine("Error: cannot place bomb!");
            }

        }

        public void DisplayBombs()
        {
            for (int i = 0; i < minefield.GetLength(0); i++)
            {
                for (int j = 0; j < minefield.GetLength(1); j++)
                {
                    Console.Write(minefield[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        public ArrayList SafePathCheckerForTotoshka()
        {
            ArrayList safePathForTotoshka = new ArrayList();

            for (int i = 0; i < minefield.GetLength(0); i++)
            {
                for (int j = 0; j < minefield.GetLength(1); j++)
                {
                    if (minefield[i, j] == 'T')
                    {
                        safePathForTotoshka.Add(new int[] { i, j }); // Add the coordinates to the list as an array
                    }
                }
            }

            return safePathForTotoshka;
        }

        // Method to return an ArrayList of safe coordinates, shifted one index forward
        public ArrayList SafePathForAlly()
        {
            // First get the current safe paths
            ArrayList rearrangedSafePathForTotoshka = SafePathAdjacencyArranger();

            // Create a new ArrayList for Ally's safe path and add "At Start Point" as the first element
            ArrayList safePathForAlly = new ArrayList();
            safePathForAlly.Add("At Start Point");

            // Add all the elements from safePathForTotoshka to safePathForAlly
            safePathForAlly.AddRange(rearrangedSafePathForTotoshka);

            // Return the new ArrayList
            return safePathForAlly;
        }

        // Method to arrange the safe path for totoshka
        public ArrayList SafePathAdjacencyArranger()
        {
            ArrayList safePathForTotoshka = SafePathCheckerForTotoshka();
            ArrayList rearrangedSafePathForTotoshka = new ArrayList();

            if (safePathForTotoshka == null || safePathForTotoshka.Count == 0)
                return rearrangedSafePathForTotoshka;

            // Start with the first coordinate
            int[] currentPoint = (int[])safePathForTotoshka[0];
            rearrangedSafePathForTotoshka.Add(currentPoint);

            // Remove the first point from the safePathForTotoshka to avoid reselection
            safePathForTotoshka.Remove(currentPoint);

            // Keep track of points to be checked for adjacency
            var pointsToCheck = new ArrayList(safePathForTotoshka);

            while (pointsToCheck.Count > 0)
            {
                bool isAdjacentPointFound = false;

                foreach (int[] point in new ArrayList(pointsToCheck))
                {
                    if (IsAdjacent(currentPoint, point))
                    {
                        rearrangedSafePathForTotoshka.Add(point);
                        currentPoint = point;
                        pointsToCheck.Remove(point);
                        isAdjacentPointFound = true;
                        break; // Break after finding an adjacent point
                    }
                }

                if (!isAdjacentPointFound)
                {
                    // If no adjacent points are found, stop here
                    break;
                }
            }

            // Return the rearranged path
            return rearrangedSafePathForTotoshka;
        }

        // Method to check whether the safe points in the list is adjacent to the previous point
        private bool IsAdjacent(int[] point1, int[] point2)
        {
            // Check if point2 is horizontally, vertically, or diagonally adjacent to point1
            return (Math.Abs(point1[0] - point2[0]) == 1 && point1[1] == point2[1]) || // Adjacent horizontally
                   (Math.Abs(point1[1] - point2[1]) == 1 && point1[0] == point2[0]) || // Adjacent vertically
                   (Math.Abs(point1[0] - point2[0]) == 1 && Math.Abs(point1[1] - point2[1]) == 1); // Adjacent diagonally
        }

    }
}
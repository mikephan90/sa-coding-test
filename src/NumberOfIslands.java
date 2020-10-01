import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfIslands {
    public static void main(String[] args) throws Exception {
        int[][] matrix = { 
            { 1, 0, 1, 1, 1 }, 
            { 1, 0, 0, 0, 0 }, 
            { 1, 0, 1, 1, 0 }, 
            { 0, 1, 1, 0, 0 },
            { 1, 0, 0, 0, 0 }, 
            { 1, 0, 0, 1, 1 }, 
        };

        int numIslandsFound = numOfIslands(matrix);

        System.out.print("Number of islands found: " + numIslandsFound);
    }

    public static int numOfIslands(int[][] matrix) {
        // Get number of rows from matrix
        int rows = matrix.length;
        // If there is no array map, exit
        if (rows == 0) {
            return 0;
        }

        // Get number of cols from matrix
        int cols = matrix[0].length;

        // Count number of islands found
        int numIslands = 0;

        // Traverse array map through starting with column in the row until thru all
        // rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If '1' aka land is found, mark node as visited
                // Recursively call markNode to search for other '1's adjacent to the current
                // node. Upon exit of recursive call, add 1 to count of islands
                if (matrix[i][j] == 1) {
                    markNode(matrix, i, j, rows, cols);
                    numIslands++;
                };
            };
        };
        return numIslands;
    }

    // Helper function to recursively call searching the matrix
    public static void markNode(int[][] matrix, int x, int y, int a, int b) {
        // if a 0 is found, return out of function
        if(x < 0 || y < 0  || x >= a || y >= b || matrix[x][y] != 1) {
            return;
        }
    
        // Mark visited node, 2 will be considered as visited node IE: its not land or water
        matrix[x][y] = 2;

        // Here is recursive call to search adjacent nodes to see if there are any other '1' nodes. If 0, top if statement will exit this function
        markNode(matrix, x + 1, y, a, b);   // down
        markNode(matrix, x, y + 1, a, b);   // right
        markNode(matrix, x - 1, y, a, b);   // up
        markNode(matrix, x, y - 1, a, b);   // left
    };

    /**********************************************************
    *                   Junit single testing
    *********************************************************/
    @Test
    public void testNumberOfIslands() {
        // should return 1
        int[][] matrix = { 
            { 1, 1, 1, 1, 1 }, 
            { 1, 1, 1, 1, 1 }, 
            { 1, 1, 1, 1, 1 }, 
            { 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1 }, 
            { 1, 1, 1, 1, 1 }, 
        };

        assertEquals(1, numOfIslands(matrix));
    }

    @Test
    public void testNumberOfIslands1() {
        // should return 3
        int[][] matrix = { 
            { 1, 0 }, 
            { 1, 0 }, 
            { 1, 0 }, 
            { 0, 1 },
            { 1, 0 }, 
            { 1, 0 }, 
        };

        assertEquals(3, numOfIslands(matrix));
    }

    @Test
    public void testNumberOfIslands2() {
        // should return 0
        int[][] matrix = { 
            
        };

        assertEquals(0, numOfIslands(matrix));
    }

    @Test
    public void testNumberOfIslands3() {
        // should return 7
        int[][] matrix = { 
            { 1, 0, 1, 1, 1, 0, 1, 0 }, 
            { 1, 0, 0, 0, 0, 1, 1, 0 }, 
            { 1, 0, 1, 1, 1, 0, 1, 0 }, 
            { 0, 1, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 1, 1 }, 
            { 1, 0, 0, 1, 1, 0, 0, 0 }, 
        };

        assertEquals(7, numOfIslands(matrix));
    }

    @Test
    public void testNumberOfIslands4() {
        // should return 3
        int[][] matrix = { 
            { 1, 0, 1, 1, 1, 0, 1, 0 }, 
            { 1, 0, 0, 0, 0, 1, 1, 0 }, 
        };

        assertEquals(3, numOfIslands(matrix));
    }

    @Test
    public void testNumberOfIslands5() {
        // should return 4
        int[][] matrix = { 
            { 1, 0, 1, 0, 1, 0, 1, 0 },
        };

        assertEquals(4, numOfIslands(matrix));
    }
};
import java.util.Random;

public class main {
    public static void main(String[] args) {
        //此处输入指令
        generateNewPuzzle();
    }

    //给出一个数独对其求解并给出难度与运行时间
    //输入的数独需要以二维数组形式传入
    public void solveSudoku(int[][] grid) {
        long start = System.currentTimeMillis();
        SudokuGrid sudoku = new SudokuGrid(grid);
        System.out.println("The difficulty is " + sudoku.getDifficulty());
        SudokuSolver solver = new SudokuSolver(sudoku);
        solver.solveSudoku(0,0);
        solver.printGrid();
        long end = System.currentTimeMillis();
        System.out.println("Time used: " + (end-start) + "ms\n");
    }

    //生成一个数独并对其求解, 并计算运行时间
    //需要给出一个难度，1 2 3 4分别代表Easy Normal Hard Hell
    //如果没有给出难度参数则随机生成
    public static void generateNewPuzzle(int difficulty) {
        long start = System.currentTimeMillis();
        Generator gener = new Generator();
        PuzzleGenerator puzzleGener = new PuzzleGenerator();
        SudokuGrid sudoku = gener.generateSudoku();
        SudokuGrid puzzle = puzzleGener.generatePuzzle(sudoku, difficulty);
        System.out.println(puzzle.toString());
        System.out.println("The difficulty is " + puzzle.getDifficulty());
        System.out.println("\n-------------------------\n");
        SudokuSolver testSolver = new SudokuSolver(puzzle);
        testSolver.solveSudoku(0,0);
        testSolver.printGrid();
        long end = System.currentTimeMillis();
        System.out.println("Time used: " + (end-start) + "ms\n");
    }
    public static void generateNewPuzzle() {
        Random rand = new Random();
        generateNewPuzzle(rand.nextInt(4)+1);
    }
}

import java.util.Random;

public class PuzzleGenerator {
    //我们运用打洞法从现有的数独终盘上不断挖去数字，并对挖掉数字后的数独进行检测，确认生成的数独是否有且仅有唯一解
    //每挖去一个数字，调用一次checkSudoku函数来判断是否有唯一解
    //若checkSudoku返回false则重新生成一次随机坐标
    private Random rand = new Random();

    //定义难度
    //分为Easy, Normal, Hard, Hell四种难度
    //分别用1，2，3，4代表4种难度
    //复杂度区间为4000-6000的数独为Easy难度
    //复杂度区间为6000-10000的数独为Normal难度
    //复杂度区间为10000-16000的数独为Hard难度
    //复杂度区间在16000以上的数独为Hell难度
    private boolean isEasy(SudokuGrid puzzle) {
        int difficulty = puzzle.getMark();
        return (difficulty >= 4000 && difficulty < 6000);
    }

    private boolean isNormal(SudokuGrid puzzle) {
        int difficulty = puzzle.getMark();
        return (difficulty >= 6000 && difficulty < 10000);
    }

    private boolean isHard(SudokuGrid puzzle) {
        int difficulty = puzzle.getMark();
        return (difficulty >= 10000 && difficulty < 16000);
    }

    private boolean isHell(SudokuGrid puzzle) {
        int difficulty = puzzle.getMark();
        return (difficulty >= 16000);
    }


    public SudokuGrid generatePuzzle(SudokuGrid puzzle, int difficulty) {
        SudokuSolver checker = new SudokuSolver(puzzle);
        //根据难度调整生成选项
        switch (difficulty) {
            case 1:
                while(!isEasy(puzzle)) {
                    //随机生成坐标挖洞
                    int x = rand.nextInt(9);
                    int y = rand.nextInt(9);
                    int temp = puzzle.getNum(x, y);
                    while(puzzle.getNum(x, y) == 0) {
                        x = rand.nextInt(9);
                        y = rand.nextInt(9);
                    }
                    puzzle.setNum(x, y, 0);
                    if (!checker.checkSudoku(puzzle)) {
                        puzzle.setNum(x, y, temp);
                    }
                }
                break;
            case 2:
                while(!isNormal(puzzle)) {
                    int x = rand.nextInt(9);
                    int y = rand.nextInt(9);
                    int temp = puzzle.getNum(x, y);
                    while(puzzle.getNum(x, y) == 0) {
                        x = rand.nextInt(9);
                        y = rand.nextInt(9);
                    }
                    puzzle.setNum(x, y, 0);
                    if (!checker.checkSudoku(puzzle)) {
                        puzzle.setNum(x, y, temp);
                    }
                }
                break;
            case 3:
                while(!isHard(puzzle)) {
                    int x = rand.nextInt(9);
                    int y = rand.nextInt(9);
                    int temp = puzzle.getNum(x, y);
                    while(puzzle.getNum(x, y) == 0) {
                        x = rand.nextInt(9);
                        y = rand.nextInt(9);
                    }
                    puzzle.setNum(x, y, 0);
                    if (!checker.checkSudoku(puzzle)) {
                        puzzle.setNum(x, y, temp);
                    }
                }
                break;
            case 4:
                while(!isHell(puzzle)) {
                    int x = rand.nextInt(9);
                    int y = rand.nextInt(9);
                    int temp = puzzle.getNum(x, y);
                    while(puzzle.getNum(x, y) == 0) {
                        x = rand.nextInt(9);
                        y = rand.nextInt(9);
                    }
                    puzzle.setNum(x, y, 0);
                    if (!checker.checkSudoku(puzzle)) {
                        puzzle.setNum(x, y, temp);
                    }
                }
                break;
        }
        return puzzle;
    }
}
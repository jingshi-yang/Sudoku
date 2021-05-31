import java.util.*;

public class SudokuSolver {
    private SudokuGrid grid;
    private SudokuGrid initialGrid;
    //分别储存行，列和九宫格的数字
    private List<Set<Integer>> row = new ArrayList<>();
    private List<Set<Integer>> col = new ArrayList<>();
    private List<Set<Integer>> block = new ArrayList<>();
    //结果栈，将结果以{x,y,value}的格式储存
    private Stack<int[]> solutions = new Stack<>();

    //Constructor
    public SudokuSolver(SudokuGrid grid) {
        this.grid = grid;
        this.initialGrid = grid;
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            block.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid.getNum(i,j) == 0) continue;
                int blockIx = (i/3) * 3 + (j/3);
                block.get(blockIx).add(grid.getNum(i,j));
                row.get(i).add(grid.getNum(i,j));
                col.get(j).add(grid.getNum(i,j));
            }
        }
    }

    //解数独主算法
    //DFS & Backtracking
    public boolean solveSudoku(int x, int y) {
        return solveSudoku(x, y, new int[]{0, 0, 10}, this.grid);
    }

    public boolean solveSudoku(int x, int y, SudokuGrid grid) {
        return solveSudoku(x, y, new int[]{0, 0, 10}, grid);
    }

    public boolean solveSudoku(int x, int y, int[] lastSolution, SudokuGrid grid) {
        if (y == 9) {
            return true;
        }
        int nextX = (x + 1) % 9; //保证当x为9时x重置为0
        int nextY = (nextX == 0) ? (y + 1) : y; //当x为0时说明此时搜索到了下一列，y+1
        if (grid.getNum(x,y) != 0) {
            return solveSudoku(nextX, nextY);
        }
        int blockIx = (x/3) * 3 + (y/3);
        for (int i = 1; i < 10; i++) {
            if(row.get(x).contains(i) || col.get(y).contains(i) || block.get(blockIx).contains(i)) {
                continue;
            }
            //若当前正在搜索标记的答案则跳过本次循环直接进行下一次尝试
            if (x == lastSolution[0] && y == lastSolution[1] && i == lastSolution[2]) {
                continue;
            }
            row.get(x).add(i);
            col.get(y).add(i);
            block.get(blockIx).add(i);
            grid.setNum(x, y, i);
            solutions.push(new int[]{x, y, i});
            if (solveSudoku(nextX, nextY)) {
                return true;
            }
            //回溯
            grid.setNum(x, y, 0);
            row.get(x).remove(i);
            col.get(y).remove(i);
            block.get(blockIx).remove(i);
            solutions.pop();
        }
        return false;
    }



    //检验有且仅有唯一解
    public boolean checkSudoku(SudokuGrid grid) {
        //由于用打洞法生成数独，题目一定有解
        solveSudoku(0,0,grid);
        //多解
        if (solutions.size() > 0) {
            int[] finalSolution = solutions.pop();
            return !(solveSudoku(0, 0, finalSolution, grid));
        }
        return true;
    }

    //输出答案
    public void printGrid() {
        System.out.println(this.grid);
    }
}
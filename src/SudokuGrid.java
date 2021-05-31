public class SudokuGrid {
    //定义数独棋盘
    private int[][] grid;
    /*
    *        0 1 2   3 4 5   6 7 8
    *      * * * * * * * * * * * * *
    *    0 *       *       *       *
    *    1 *   0   *   1   *   2   *
    *    2 *       *       *       *
    *      * * * * * * * * * * * * *
    *    3 *       *       *       *
    *    4 *   3   *   4   *   5   *
    *    5 *       *       *       *
    *      * * * * * * * * * * * * *
    *    6 *       *       *       *
    *    7 *   6   *   7   *   8   *
    *    8 *       *       *       *
    *      * * * * * * * * * * * * *
    */

    //Constructor
    public SudokuGrid() {
        this.grid = new int[9][9];
    }
    public SudokuGrid(int[][] grid) {
        this.grid = grid;
    }

    //通过坐标转换出数字所在的Block位置
    private int blockNo(int row, int col) {
        int block = 0;
        block = (row/3)*3 + col/3;
        return block;
    }

    //数独难度评分算法
    /*
    我们认为，决定数独的难度的首要因素是填写数独时需要尝试的可能性的数量，而空格越多的数独往往具有更多的可能性。特别的，空格数并不与数独的难度成正
    相关的关系，因此简单地通过空格数量判断数独的难度是不可行的。进一步考虑，数独的可能解数量与每一个空格可能出现的数字有关，而根据数独的规则，每一
    个空格可能出现的数字与以下三个因素直接挂钩：同一行的数字，同一列的数字与同一区块内的数字。更直接的说，列，行与区块内的空格数量决定了每一个空格
    存在的可能数。
    考虑到三个因素中不同因素之间共同作用的影响比单一因素的影响更大，我们选择将空格行列与方格内的0的数量相乘来判断数独矩阵的“难度”。
    */
    private int benchmark() {
        int difficulty = 0;
        int[] countCol = new int[9];
        int[] countRow = new int[9];
        int[] countBlock = new int[9];
        //统计每一行列以及方格内0的数量
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    countRow[i]++;
                    countCol[j]++;
                    countBlock[blockNo(i,j)]++;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    difficulty += countRow[i] * countCol[j] * countBlock[blockNo(i,j)];
                }
            }
        }
        return difficulty;
    }

    //其他工具方法
    public int getNum(int x, int y) {return grid[x][y];}
    public int getMark() {return this.benchmark();}
    //难度分级
    public String getDifficulty() {
        if (this.getMark() >= 4000 && this.getMark() < 6000) {
            return "Easy";
        } else if (this.getMark() >= 6000 && this.getMark() <10000) {
            return "Normal";
        } else if (this.getMark() >= 10000 && this.getMark()<16000) {
            return "Hard";
        } else if (this.getMark() >= 16000) {
            return "Hell";
        } else return null;
    }

    public void setNum(int x, int y, int value) {grid[x][y] = value;}
    public void setNum(int[][] positions, int value) {
        for (int[] position : positions) {
            grid[position[0]][position[1]] = value;
        }
    }

    @Override
    public String toString() {
        System.out.format("* * * * * * * * * * * * *\n");
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(0,0), getNum(0,1), getNum(0,2),
                getNum(0,3), getNum(0,4), getNum(0,5),
                getNum(0,6), getNum(0,7), getNum(0,8));
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(1,0), getNum(1,1), getNum(1,2),
                getNum(1,3), getNum(1,4), getNum(1,5),
                getNum(1,6), getNum(1,7), getNum(1,8));
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(2,0), getNum(2,1), getNum(2,2),
                getNum(2,3), getNum(2,4), getNum(2,5),
                getNum(2,6), getNum(2,7), getNum(2,8));
        System.out.format("* * * * * * * * * * * * *\n");
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(3,0), getNum(3,1), getNum(3,2),
                getNum(3,3), getNum(3,4), getNum(3,5),
                getNum(3,6), getNum(3,7), getNum(3,8));
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(4,0), getNum(4,1), getNum(4,2),
                getNum(4,3), getNum(4,4), getNum(4,5),
                getNum(4,6), getNum(4,7), getNum(4,8));
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(5,0), getNum(5,1), getNum(5,2),
                getNum(5,3), getNum(5,4), getNum(5,5),
                getNum(5,6), getNum(5,7), getNum(5,8));
        System.out.format("* * * * * * * * * * * * *\n");
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(6,0), getNum(6,1), getNum(6,2),
                getNum(6,3), getNum(6,4), getNum(6,5),
                getNum(6,6), getNum(6,7), getNum(6,8));
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(7,0), getNum(7,1), getNum(7,2),
                getNum(7,3), getNum(7,4), getNum(7,5),
                getNum(7,6), getNum(7,7), getNum(7,8));
        System.out.format("* %d %d %d * %d %d %d * %d %d %d *\n",
                getNum(8,0), getNum(8,1), getNum(8,2),
                getNum(8,3), getNum(8,4), getNum(8,5),
                getNum(8,6), getNum(8,7), getNum(8,8));
        System.out.format("* * * * * * * * * * * * *");
        return "";
    }
}
import java.util.Random;

public class Generator {
    private Random rng = new Random();

    //生成长度为9的随机不重复数组
    private int[] randomArrayGenerator() {
        int[] seed = {9,1,2,3,4,5,6,7,8};
        int temp = 0;
        int randomInt = 0;
        //生成一个随机数randomInt,并将seed[0]与seed[randomInt]交换
        //重复36次以近似完全随机的得到一个随机不重复数组
        for (int i = 0; i <= 36; i++) {
            randomInt = rng.nextInt(8) + 1;
            temp = seed[randomInt];
            seed[randomInt] = seed[0];
            seed[0] = temp;
        }
        return seed;
    }

    //交换指定序号的两行的数字
    private void swapRow(int a, int b, SudokuGrid grid) {
        int temp;
        for (int i = 0; i < 9; i++) {
            temp = grid.getNum(a, i);
            grid.setNum(a, i, grid.getNum(b, i));
            grid.setNum(b, i, temp);
        }
    }

    //交换指定序号的两列的数字
    private void swapCol(int a, int b, SudokuGrid grid) {
        int temp;
        for (int i = 0; i < 9; i++) {
            temp = grid.getNum(i, a);
            grid.setNum(i, a, grid.getNum(i, b));
            grid.setNum(i, b, temp);
        }
    }

    //左右镜像数独
    private void reverseLR(SudokuGrid grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int temp = grid.getNum(i, j);
                grid.setNum(i, j, grid.getNum(i, 8-j));
                grid.setNum(i, 8-j, temp);
            }
        }
    }

    //上下翻转数独
    private void reverseUD(SudokuGrid grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int temp = grid.getNum(i, j);
                grid.setNum(i, j, grid.getNum(8-i, j));
                grid.setNum(8-i, j, temp);
            }
        }
    }

    //按照设定的初始状态填充九宫格
    private void fillGrid(SudokuGrid grid) {
        /*
         *        0 1 2   3 4 5   6 7 8
         *      * * * * * * * * * * * * *
         *    0 * i g h * c a b * f d e *
         *    1 * c a b * f d e * i g h *
         *    2 * f d e * i g h * c a b *
         *      * * * * * * * * * * * * *
         *    3 * g h i * a b c * d e f *
         *    4 * a b c * d e f * g h i *
         *    5 * d e f * g h i * a b c *
         *      * * * * * * * * * * * * *
         *    6 * h i g * b c a * e f d *
         *    7 * b c a * e f d * h i g *
         *    8 * e f d * h i g * b c a *
         *      * * * * * * * * * * * * *
         *    基本的数独Seed由本模式从BlockSeed生成
         */
        int[][] aPos = {{0,4},{1,1},{2,7},{4,0},{5,6},{6,5},{7,2},{8,8}};
        int[][] bPos = {{0,5},{1,2},{2,8},{4,1},{5,7},{6,3},{7,0},{8,6}};
        int[][] cPos = {{0,3},{1,0},{2,6},{4,2},{5,8},{6,4},{7,1},{8,7}};
        int[][] dPos = {{1,4},{2,1},{0,7},{5,0},{3,6},{7,5},{8,2},{6,8}};
        int[][] ePos = {{1,5},{2,2},{0,8},{5,1},{3,7},{7,3},{8,0},{6,6}};
        int[][] fPos = {{1,3},{2,0},{0,6},{5,2},{3,8},{7,4},{8,1},{6,7}};
        int[][] gPos = {{2,4},{0,1},{1,7},{3,0},{4,6},{8,5},{6,2},{7,8}};
        int[][] hPos = {{2,5},{0,2},{1,8},{3,1},{4,7},{8,3},{6,0},{7,6}};
        int[][] iPos = {{2,3},{0,0},{1,6},{3,2},{4,8},{8,4},{6,1},{7,7}};

        grid.setNum(aPos, grid.getNum(3,3));
        grid.setNum(bPos, grid.getNum(3,4));
        grid.setNum(cPos, grid.getNum(3,5));
        grid.setNum(dPos, grid.getNum(4,3));
        grid.setNum(ePos, grid.getNum(4,4));
        grid.setNum(fPos, grid.getNum(4,5));
        grid.setNum(gPos, grid.getNum(5,3));
        grid.setNum(hPos, grid.getNum(5,4));
        grid.setNum(iPos, grid.getNum(5,5));
    }

    //随机生成器主体
    //对于一个已经成立的数独终盘，我们发现在同一个九宫格范围内进行的行变换和列变换不会导致这个数独失效
    //同样，对已成立的数独终盘镜像或上下翻转得到的矩阵也同样成立
    //因此对一个根据固定模式生成的现有的数独终盘作行变换与列变换操作可以以极高的效率得到一个新的数独终盘
    public SudokuGrid generateSudoku() {
        SudokuGrid sudoku = new SudokuGrid();
        //生成seed
        int[] blockSeed = randomArrayGenerator();
        //填充中央的Block作为seed
        int count = 0;
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                sudoku.setNum(i, j, blockSeed[count]);
                count++;
            }
        }
        //按照预计模式填充数独
        fillGrid(sudoku);
        //随机对数独seed进行行列变换,重复36次
        for (int i = 0; i < 37; i++) {
            int rowTemp = 3*rng.nextInt(3);
            int colTemp = 3*rng.nextInt(3);
            swapRow(rowTemp, rng.nextInt(2)+1+rowTemp, sudoku);
            swapCol(colTemp, rng.nextInt(2)+1+colTemp, sudoku);
        }
        //随机决定是否左右镜像数独
        if (rng.nextInt(2) == 1) {
            reverseLR(sudoku);
        }
        //随机决定是否上下翻转数独
        if (rng.nextInt(2) == 1) {
            reverseUD(sudoku);
        }
        return sudoku;
    }
}
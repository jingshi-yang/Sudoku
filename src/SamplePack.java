public class SamplePack {
    //样例1 sudoku.name 容易
    //difficulty: 5975
    //Time used: 24ms
    int[][] sample1 = {
            {2,0,1,0,0,7,0,3,0},
            {0,0,9,3,0,0,8,0,1},
            {0,8,0,2,5,0,0,9,0},
            {5,0,0,8,0,4,0,0,3},
            {9,3,0,0,0,5,0,7,8},
            {6,0,0,0,0,2,0,0,4},
            {0,7,0,0,6,8,0,1,0},
            {8,0,5,0,0,3,7,0,0},
            {0,6,0,4,0,0,5,0,2}};

    //样例2 sudoku.name 容易
    //difficulty: 6295
    //Time used: 24ms
    int[][] sample2 = {
            {0,3,4,0,0,1,9,0,0},
            {0,0,2,0,3,0,0,4,0},
            {0,6,0,2,0,4,0,3,5},
            {7,0,3,5,0,0,8,0,0},
            {0,0,6,3,7,0,5,0,0},
            {0,0,8,1,0,0,6,0,3},
            {8,2,0,6,0,3,0,9,0},
            {0,7,0,0,5,0,2,0,0},
            {0,0,9,8,0,0,3,5,0}
    };

    //样例3 sudoku.name 容易
    //difficulty:5950
    //Time used: 29ms
    int[][] sample3 = {
            {5,1,0,8,0,4,0,0,0},
            {0,8,0,0,2,0,0,0,4},
            {0,7,0,6,1,0,3,8,0},
            {0,6,0,2,0,9,0,4,7},
            {0,0,8,0,4,0,6,0,0},
            {7,2,0,1,0,8,0,5,0},
            {0,4,7,0,8,1,0,3,0},
            {8,0,0,0,7,0,0,6,0},
            {0,0,0,4,0,6,0,7,8}
    };

    //样例4 sudoku.name 中等
    //difficulty: 9532
    //Time used: 45ms
    int[][] sample4 = {
            {0,0,2,6,0,0,8,5,0},
            {0,6,0,0,5,0,0,0,4},
            {0,0,9,0,0,2,0,0,7},
            {4,0,0,0,6,0,0,8,0},
            {0,0,5,4,0,0,6,0,0},
            {0,2,0,5,9,0,0,0,3},
            {7,0,0,2,0,0,9,0,0},
            {2,0,0,0,8,0,0,7,0},
            {0,8,6,0,0,3,5,0,0}
    };

    //样例5 sudoku.name 中等
    //difficulty: 10660
    //Time used: 38ms
    int[][] sample5 = {
            {0,0,4,0,5,0,0,6,0},
            {0,5,0,0,0,8,2,0,0},
            {0,7,0,3,2,0,0,9,0},
            {0,9,8,0,0,0,1,0,0},
            {0,2,0,0,0,4,0,8,0},
            {0,0,3,2,0,0,5,7,0},
            {0,8,0,0,1,9,0,2,0},
            {0,0,7,4,0,0,0,5,0},
            {0,4,0,0,7,0,9,0,0}
    };

    //样例6 sudoku.name 中等
    //difficulty: 9680
    //Time used: 32ms
    int[][] sample6 = {
            {0,8,0,0,0,3,7,0,0},
            {0,0,7,0,0,1,0,3,0},
            {4,0,0,0,0,6,0,0,5},
            {8,0,0,0,4,0,0,5,6},
            {0,7,0,0,2,0,0,9,0},
            {3,4,0,6,5,0,0,0,7},
            {6,0,0,9,0,0,0,0,1},
            {0,1,0,2,0,0,3,0,0},
            {0,0,2,1,0,0,0,4,0}
    };

    //样例7 sudoku.name 困难
    //difficulty: 12926
    //Time used: 56ms
    int[][] sample7 = {
            {0,0,7,0,0,2,0,0,4},
            {0,0,0,0,0,8,0,5,0},
            {4,0,0,0,3,0,1,0,0},
            {0,1,0,0,0,7,0,0,9},
            {0,0,4,8,5,0,2,0,0},
            {7,0,0,0,6,0,0,3,0},
            {0,0,5,0,1,0,0,0,3},
            {0,3,0,7,0,0,0,0,0},
            {2,0,0,5,0,0,9,0,0}
    };

    //样例8 sudoku.name 困难
    //difficulty: 13840
    //Time used: 51ms
    int[][] sample8 = {
            {0,0,1,0,5,0,9,0,0},
            {0,2,0,0,8,1,3,0,0},
            {7,0,0,4,0,0,0,6,0},
            {0,0,4,6,0,0,0,5,0},
            {0,0,0,0,0,0,0,0,0},
            {0,5,0,0,4,0,7,0,0},
            {0,4,0,0,0,9,0,0,8},
            {0,0,7,2,1,0,0,9,0},
            {0,0,5,0,3,0,4,0,0}
    };

    //样例9 sudoku.name 困难
    //difficulty: 13256
    //Time used: 48ms
    int[][] sample9 = {
            {0,5,0,0,7,0,8,0,0},
            {0,9,0,6,0,0,0,0,2},
            {0,0,0,1,0,0,0,5,0},
            {0,6,0,0,3,0,0,0,9},
            {5,0,0,9,0,0,0,0,8},
            {7,0,0,0,5,6,0,3,0},
            {0,4,0,0,0,1,0,0,0},
            {2,0,0,0,0,4,0,7,0},
            {0,0,8,0,6,0,0,2,0}
    };

    //样例10 sudoku.name 困难++
    //difficulty:13886
    //Time used: 30ms
    int[][] sample10 = {
            {0,0,0,4,0,0,0,0,8},
            {0,0,0,0,2,3,0,0,0},
            {7,3,0,0,0,0,4,0,2},
            {0,9,0,5,0,0,2,0,0},
            {0,7,0,0,4,0,0,6,0},
            {0,0,2,0,0,1,0,7,0},
            {3,0,1,0,0,0,0,9,5},
            {0,0,0,9,6,0,0,0,0},
            {2,0,0,0,0,5,0,0,0}
    };

    //样例11 sudoku.name 困难++
    //difficulty: 13116
    //Time used: 25ms
    int[][] sample11 = {
            {5,7,0,0,0,4,0,0,3},
            {0,0,0,0,0,0,9,0,1},
            {0,0,0,0,0,6,0,4,0},
            {0,9,0,7,1,0,0,0,4},
            {6,0,0,0,0,0,0,0,9},
            {1,0,0,6,9,3,0,2,0},
            {0,1,0,3,0,0,0,0,0},
            {2,0,6,0,0,0,0,0,0},
            {4,0,0,8,0,0,0,5,6}
    };

    //样例12 sudoku.name 困难++
    //difficulty: 15265
    //Time used: 66ms
    int[][] sample12 = {
            {0,0,9,0,0,0,8,0,0},
            {0,0,0,6,0,5,0,0,0},
            {1,0,0,0,3,0,0,0,7},
            {0,7,0,9,0,8,0,2,0},
            {0,0,2,0,0,0,1,0,0},
            {0,9,0,5,0,3,0,4,0},
            {3,0,0,0,4,0,0,0,2},
            {0,0,0,3,0,9,0,0,0},
            {0,0,6,0,0,0,5,0,0}
    };
}

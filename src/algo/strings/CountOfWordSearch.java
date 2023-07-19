package algo.strings;

public class CountOfWordSearch {
    static boolean[][] visited;
    static int count = 0;

    static int countWord(char board[][], String word, int m, int n) {
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    searchWord(board, word, i, j, m, n, 0);
//                    System.out.println(wordFound);
//                    if(wordFound) {
//                        count++;
//                    }
                }
            }
        }
        return count;
    }

    static boolean searchWord(char[][] board, String word, int i, int j, int m, int n, int index) {
//        System.out.println("i : "+i+ " : j : "+j+ " : index : "+ index);

        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;

        if (visited[i][j] || board[i][j] != word.charAt(index))
            return false;

        if (index + 1 == word.length()) {
            count++;
//            System.out.println("count increased : "+ count);
            return false;
        }

        visited[i][j] = true;

        searchWord(board, word, i, j + 1, m, n, index + 1); // left to right
//        searchWord(board, word, i, j - 1, m, n, index + 1);// right to left

//        searchWord(board, word, i - 1, j, m, n, index + 1);// bottom to top
        searchWord(board, word, i + 1, j, m, n, index + 1); // top to down
//        System.out.println("i : "+i+ " : j : "+j+ " : index : "+ (index+1)+" : res : "+res);

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        int m, n;

        char[][] board = {{'s','o','s','o'},{'s','o','o','s'},{'s','s','s','s'}};
        System.out.println(countWord(board, "sos", 3, 4));
    }


}

/**
 {'j','o','s','o'},
 {'s','j','o','s'},
 {'s','s','r','s'}
 */
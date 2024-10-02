import java.util.Scanner;

public class project3 {
    static char[][] board = new char[3][3];
     
    public static void main(String[] args) {
        System.out.println("Lets Play Tic Tac Toe Game ");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        boolean xTurn = true;
        while (true) {
            printBoard();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (board[x][y] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }
            board[x][y] = xTurn ? 'X' : 'O';
            if (checkWin()) {
                printBoard();
                System.out.println(xTurn ? "X wins!" : "O wins!");
                break;
            }
            if (checkDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            xTurn = !xTurn;
        }
    }

    static void printBoard() {
        System.out.println(" 0 | 1 | 2 ");
        System.out.println(" --------- ");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println(" --------- ");
        }
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ')
                return true;
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' ')
                return true;
        }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ')
            return true;
        return false;
    }

    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}


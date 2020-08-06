import java.util.Scanner;
public class ex8_9 {
    public static Scanner obj = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        DisplayTheBoard(board);
        while (true){
            turn(board,'X');
            DisplayTheBoard(board);
            if(Won('X',board)){
                System.out.println("player x win");
                System.exit(1);
            }
            else if(Draw(board)){
                System.out.println("No Winner");
                System.exit(2);
            }
            turn(board,'O');
            DisplayTheBoard(board);
            if(Won('O',board)){
                System.out.println("O win");
                System.exit(3);
            }
            else if(Draw(board)){
                System.out.println("No Winner");
                System.exit(4);
            }
        }
    }
    public static void turn(char[][] board, char player){
        boolean done=false;
        do{
            System.out.println("Enter a row for player: "+player);
            int row=obj.nextInt();
            System.out.println("Enter a colum for player: "+player);
            int colum=obj.nextInt();
            if(board[row][colum]=='\u0000'){
                board[row][colum]=player;
                done=true;
            }
            else
                System.out.println("The Cell is already occupied");
        }while (!done);
    }
    public static void DisplayTheBoard(char[][] board){
        System.out.println("\n-------------");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++)
                System.out.print(board[i][j]!='\u0000' ? board[i][j] + " | " :"  | ");
            System.out.println("\n-------------");
        }
    }
    public static boolean Won(char ch, char[][] board){
        for(int i=0;i<3;i++)
            if(ch==board[i][0] && ch==board[i][1] && ch==board[i][2]) return true;
        for(int i=0;i<3;i++)
            if(ch==board[i][0] && ch==board[i][1] && ch==board[i][2]) return true;
        for(int i=0;i<3;i++)
            if(ch==board[0][2] && ch==board[1][1] && ch==board[2][0]) return true;
        return  false;
    }
    public static boolean Draw(char[][] board){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]=='\u0000') return false;
        return true;
    }
}
import java.util.*;

class memoBoard{
    boolean [] rows;
    boolean [] cols;
    boolean d1;
    boolean d2;
    memoBoard(int n){
        this.rows=new boolean[n];
        this.cols=new boolean[n];
        this.d1=false;
        this.d2=false;
    }
}

class playersArray{
   Character P;
   String Input;
   playersArray(char P , String Input){
    this.P=P;
    this.Input=Input;
   }

}

public class TicTackToe {

  public static boolean checkWinProcess(char[][]board,memoBoard checkMemoBoard,char P){
     for(int i=0;i<checkMemoBoard.rows.length;i++){
        if(!checkMemoBoard.rows[i]){
           char p1=board[i][0];
           for(int j=0;j<board.length&&p1==P;j++){
               if(board[i][j]!=p1&&board[i][j]!=' '){
                 checkMemoBoard.rows[i]=true;
                 break;
               }else{
                 if(j==board.length-1&&p1==P&&board[i][j]!=' '&&board[i][j]==p1){
                        return true;
                    }
               }
           }
        }
         if(!checkMemoBoard.cols[i]){
           char p1=board[0][i];
           for(int j=0;j<board.length&&p1==P;j++){
               if(board[i][j]!=p1&&board[i][j]!=' '){
                 checkMemoBoard.cols[i]=true;
                 break;
               }
               else{
                if(j==board.length-1&&p1==P&&board[i][j]!=' '&&board[i][j]==p1){
                        return true;
                    }
               }
           }
        }

        if(!checkMemoBoard.d1){

                char p1=board[0][0];
                for(int j=0;j<board.length&&p1==P;j++){
                if(board[i][j]!=p1&&board[i][j]!=' '){
                    checkMemoBoard.d1=true;
                    break;
                }else{
                    if(j==board.length-1&&p1==P&&board[i][j]!=' '&&board[i][j]==p1){
                        return true;
                    }
                 }
               }

        }
        if(!checkMemoBoard.d2){
                char p1=board[0][board.length-1];
                for(int j=0;j<board.length&&p1==P;j++){
                if(board[j][board.length-1-j]!=p1&&board[j][board.length-1-j]!=' '){
                    checkMemoBoard.d2=true;
                    break;
                }else{
                    if(j==board.length-1&&p1==P&&board[i][j]!=' '&&board[i][j]==p1){
                        return true;
                    }
                 }
               }
        }

     }
     return false;
  }

  public static void main (String [] args){
     Scanner s=new Scanner(System.in);
     System.out.print("Enter number of rows: ");
     int n=s.nextInt();
     char [][] board= new char [n][n];
     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]=' ';
        }
     }
     char P1='X';
     char P2='O';
     playersArray [] numChances=new playersArray[n*n];
     memoBoard checkMemoBoard =new memoBoard(n);
     int i=0;
     while(i<n*n){
        if(i%2==0){
            System.out.print("Enter P1 input: ");
            String input = s.next();
            numChances[i]= new playersArray(P1, input);
            int j= numChances[i].Input.charAt(0)-'0';
            int k= numChances[i].Input.charAt(1)-'0';
            if(j<0||j>=n||k<0||k>=n||board[j][k]!=' '){
               System.out.print("invalid move  ");
               i--;
            }
            else{
                board[j][k]=P1;
                if(i>=2*n-2){
                   if(checkWinProcess(board, checkMemoBoard,P1)){
                    System.out.print("P1 Wins");
                    break;
                   }
                }
            }
        }
        else{
            System.out.print("Enter P2 input: ");
            numChances[i]=new playersArray(P2,s.next());
            int j= numChances[i].Input.charAt(0)-'0';
            int k= numChances[i].Input.charAt(1)-'0';
            if(j<0||j>=n||k<0||k>=n||board[j][k]!=' '){
               System.out.print("invalid move  ");
               i--;
            }
            else{
                board[j][k]=P2;
                if(i>=2*n-2){
                if(checkWinProcess(board, checkMemoBoard,P2)){
                    System.out.print("P2 Wins");
                    break;
                   }
                }
            }
        }
        i++;
        if(i==n*n&&!checkWinProcess(board, checkMemoBoard, P2)){
            System.out.print("Draw || no one wins");
        }
     }
     
     
    s.close();
  }
    
}

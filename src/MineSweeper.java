import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int row;
    int col;
    int mineNumber;
    int selectedRow;
    int selectedCol;
    String [][] gameMap = new String[row][col];
    String [][] mineMap= new String[row][col];
    MineSweeper( int row, int col){
        this.row = row;
        this.col = col;
        this.gameMap = new String [row][col];
        this.mineMap = new String [row][col];
        this.mineNumber = (row * col) / 4;

    }
    public void GameMap(){
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
            	this.gameMap[i][j] = "-";
                System.out.print(this.gameMap[i][j]+" ");
            }System.out.println();
        }

    }

    public void Map(){
        Random random = new Random();
        for (int i =0; i<mineNumber; i++){
            int r1 = random.nextInt(row);
            int r2 = random.nextInt(col);
            if (!Objects.equals(this.mineMap[r1][r2], "*")){
                this.mineMap[r1][r2] ="*";
            }
            
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (!Objects.equals(mineMap[i][j], "*")){
                    this.mineMap[i][j]=("-");
                }

            }
        }
    }
    void printMineMap(){
        Map();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(this.mineMap[i][j]+" ");
            }
            System.out.println();
        }
    }

    void run(){
    	String strNumber;
        System.out.println("Mayinlarin Konumu : ");
        printMineMap();
        System.out.println("Mayin Tarlasi Oyununa Hosgeldiniz !");
        GameMap();
        Scanner inp=new Scanner(System.in);
        int finish=(this.row*this.col)-this.mineNumber;
    while (finish>0){
            System.out.print("Satir Giriniz : ");
            selectedRow=inp.nextInt();
            System.out.print("Sutun Giriniz : ");
            selectedCol=inp.nextInt();
            if((selectedRow<0 || selectedRow>=this.row) || (selectedCol<0 || selectedCol>=this.col)){
                System.out.println("Hatali giris yaptiniz indis numarasini tekrar giriniz ! ");
                System.out.println("----------------------------------------------------------------");
                continue;
            }
            if(mineMap[selectedRow][selectedCol].equals("*")){
                System.out.println("OYUNU KAYBETTINIZ");
                break;
            }else{
                
                    int number = 0;
                    int lowRow = (selectedRow - 1), heighRow = (selectedRow + 1);
                    int lowCol = (selectedCol - 1), heighCol = (selectedCol + 1);

                    if ( (lowRow < 0) ){
                        lowRow = 0;
                    }
                    if (lowCol < 0){
                        lowCol = 0;
                    }
                    if(heighRow >= row){
                        heighRow = selectedRow;
                    }
                    if (heighCol >= col){
                        heighCol = selectedCol;
                    }
                    for(int i = lowRow; i <= heighRow; i++){
                        for (int j = lowCol; j<= heighCol; j++){
                            if(this.mineMap[i][j].equals("*")){
                                number++;

                            }
                        }
                    }
                    strNumber =Integer.toString(number);
                    this.gameMap[selectedRow][selectedCol]=strNumber;
                    finish--;

                    for (int i=0; i< gameMap.length; i++){
                        for (int j=0; j<gameMap[i].length; j++){
                            System.out.print(this.gameMap[i][j]+" ");
                        }System.out.println();
                    }
                    System.out.println("============================================");

                }
            }
        
        if (finish==0){
            System.out.println("OYUNU KAZANDINIZ !");
        }

    }
}
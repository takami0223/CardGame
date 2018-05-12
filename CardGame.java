import java.util.*;
import java.lang.*;
import java.io.*;

class CardGame {

    public static final int MAX_GAME = 2;
    public static final int MAX_CHANGE = 3;
    public static final int MAX_CARD_THREE = 3;
    public static final int MAX_MENU = 5;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Player player = new Player();
        Player computer = new Player();
        CardStock stock = new CardStock();
        GameFlow gameflow = new GameFlow();

        int main_Menu = 0;
        ArrayList<Integer> save_Getmoney = new ArrayList<>();
        ArrayList<Integer> save_lostmoney = new ArrayList<>();

        for(int i=0; i<100; i++){System.out.println();}

        while(main_Menu != MAX_MENU){

            System.out.println("\n<<<<< トランプゲーム >>>>>");
            System.out.println("[1] 3枚ポーカーで遊ぶ");
            System.out.println("[2] 5枚ポーカーで遊ぶ");
            System.out.println("[3] 勝ち金・負け金ランキング");
            System.out.println("[4] ポーカーのルールを確認(必読)");
            System.out.println("[5] ゲームを終了する");

            while(true) {
                try {
                    do {
                        Scanner scan1 = new Scanner(System.in);
                        System.out.print(">> ");
                        main_Menu = scan1.nextInt();
                    }while(main_Menu <= 0 || main_Menu > MAX_MENU);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("!*数値以外が入力されました*!");
                }
            }

            switch (main_Menu){

                case 1:
                    player.reset_points(); //プレイヤーのポイントリセット
                    stock.shuffle();

                    for(int i = 0; i < 100; i++){System.out.println();}

                    System.out.println("<< 3枚ポーカースタート >>");

                    for(int i = 0; i < 3; i++) {
                        try{Thread.sleep(1000);} catch(InterruptedException e){}

                case 3:
                    for(int i = 0; i < 100; i++){System.out.println();}

                    System.out.println("\n\t<<<<< 勝ち金ランキング >>>>>");
                    if(!save_Getmoney.isEmpty()) {
                        if(save_Getmoney.get(0) == 0) {
                            System.out.println(">まだ記録がありません");
                            continue;
                        }
                        for(int i=0; i<save_Getmoney.size(); i++) {
                            if(save_Getmoney.get(i) != 0)
                    }else{
                        System.out.println(">まだ記録がありません");
                    }

                    System.out.println("\n\t<<<<< 負け金ランキング >>>>>");
                    if(!save_lostmoney.isEmpty()) {
                        if(save_lostmoney.get(0) == 0) {
                            System.out.println(">まだ記録がありません");
                            continue;
                        }
                        for(int i=0; i<save_lostmoney.size(); i++) {
                            if(save_lostmoney.get(i) != 0)
                                System.out.println(">" + (i+1) + "位 : -" + save_lostmoney.get(i));
                        }
                    }else{
                        System.out.println(">まだ記録がありません");
                    }
                    break;

                case 4:
                    for(int i = 0; i < 100; i++){System.out.println();}

                    System.out.println("\n\t<<<<< ポーカーの役一覧 >>>>>");
                    System.out.println("|ロイヤルストレートフラッシュ: 全て同じスートで数字が[10][11][12][13][1] :(100点)");
                    System.out.println("|ストレートフラッシュ        : 連続した数字で全て同じスート              : (50点)");
                    System.out.println("|フォーカード                : 同じ数字(4枚)が同じ                       : (30点)");
                    System.out.println("|フルハウス                  : 同じ数字(2枚)が一組と同じ数字(3枚)が一組  : (20点)");
                    System.out.println("|フラッシュ                  : スートが同じ                              : (10点)");
                    System.out.println("|ストレート                  : 数字が連続                                :  (5点)");
                    System.out.println("|スリーカード                : 同じ数字(3枚)が同じ                       :  (3点)");
                    System.out.println("|ツーペア                    : 同じ数字(2枚)が二組                       :  (2点)");
                    System.out.println("|ワンペア                    : 同じ数字(2枚)が一組                       :  (1点)");
                    System.out.println();
                    System.out.println("\t<<<<< 勝ち金の倍率について >>>>>");
                    System.out.println("|役の「強さ」に差をつけてポーカーに勝った際，勝ち金に倍率がかかる");
                    System.out.println("|>ポーカーの役に 50 点以上の差がついた場合 : * 100 倍");
                    System.out.println("|>ポーカーの役に 20 点以上の差がついた場合 : *  50 倍");
                    System.out.println("|>ポーカーの役に 10 点以上の差がついた場合 : *  10 倍");
                    System.out.println("|>ポーカーの役に 5 点以上の差がついた場合  : *   2 倍");
                    System.out.println("|>ポーカーの役に 3 点以上の差がついた場合  : * 1.5 倍");
                    System.out.println("|>ポーカーの役に 1 点以上の差がついた場合  : *   1 倍");
                    System.out.println();
                    System.out.println("\t<<<<< 入力の例 >>>>>");
                    System.out.println("|>掛け金をUPしますか？(y or n) >> y");
                    System.out.println("|>いくらUPしますか？(現在：0,上限：100) >> +50   <- 上限はplayer-moneyを参照
");
                    System.out.println("|>カードをチェンジしますか？(y or n) >> y");
                    System.out.println("|\t----------------------");
                    System.out.println("|\t|   1   2   3   4   5");
                    System.out.println("|\t|<[S6][C3][S10][S12][S3]>");
                    System.out.println("|\t----------------------");
                    System.out.println("|>何枚目を交換しますか？ >> 1 2 3   <- 交換したい箇所を空白を挟んで入力");
                    System.out.println();

                    break;

                case 5:
                    System.exit(1);
                    break;
            }
        }
    }
}
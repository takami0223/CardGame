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

            System.out.println("\n<<<<< �g�����v�Q�[�� >>>>>");
            System.out.println("[1] 3���|�[�J�[�ŗV��");
            System.out.println("[2] 5���|�[�J�[�ŗV��");
            System.out.println("[3] �������E�����������L���O");
            System.out.println("[4] �|�[�J�[�̃��[�����m�F(�K��)");
            System.out.println("[5] �Q�[�����I������");

            while(true) {
                try {
                    do {
                        Scanner scan1 = new Scanner(System.in);
                        System.out.print(">> ");
                        main_Menu = scan1.nextInt();
                    }while(main_Menu <= 0 || main_Menu > MAX_MENU);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("!*���l�ȊO�����͂���܂���*!");
                }
            }

            switch (main_Menu){

                case 1:
                    player.reset_points(); //�v���C���[�̃|�C���g���Z�b�g
                    stock.shuffle();

                    for(int i = 0; i < 100; i++){System.out.println();}

                    System.out.println("<< 3���|�[�J�[�X�^�[�g >>");

                    for(int i = 0; i < 3; i++) {
                        try{Thread.sleep(1000);} catch(InterruptedException e){}

                case 3:
                    for(int i = 0; i < 100; i++){System.out.println();}

                    System.out.println("\n\t<<<<< �����������L���O >>>>>");
                    if(!save_Getmoney.isEmpty()) {
                        if(save_Getmoney.get(0) == 0) {
                            System.out.println(">�܂��L�^������܂���");
                            continue;
                        }
                        for(int i=0; i<save_Getmoney.size(); i++) {
                            if(save_Getmoney.get(i) != 0)
                    }else{
                        System.out.println(">�܂��L�^������܂���");
                    }

                    System.out.println("\n\t<<<<< �����������L���O >>>>>");
                    if(!save_lostmoney.isEmpty()) {
                        if(save_lostmoney.get(0) == 0) {
                            System.out.println(">�܂��L�^������܂���");
                            continue;
                        }
                        for(int i=0; i<save_lostmoney.size(); i++) {
                            if(save_lostmoney.get(i) != 0)
                                System.out.println(">" + (i+1) + "�� : -" + save_lostmoney.get(i));
                        }
                    }else{
                        System.out.println(">�܂��L�^������܂���");
                    }
                    break;

                case 4:
                    for(int i = 0; i < 100; i++){System.out.println();}

                    System.out.println("\n\t<<<<< �|�[�J�[�̖��ꗗ >>>>>");
                    System.out.println("|���C�����X�g���[�g�t���b�V��: �S�ē����X�[�g�Ő�����[10][11][12][13][1] :(100�_)");
                    System.out.println("|�X�g���[�g�t���b�V��        : �A�����������őS�ē����X�[�g              : (50�_)");
                    System.out.println("|�t�H�[�J�[�h                : ��������(4��)������                       : (30�_)");
                    System.out.println("|�t���n�E�X                  : ��������(2��)����g�Ɠ�������(3��)����g  : (20�_)");
                    System.out.println("|�t���b�V��                  : �X�[�g������                              : (10�_)");
                    System.out.println("|�X�g���[�g                  : �������A��                                :  (5�_)");
                    System.out.println("|�X���[�J�[�h                : ��������(3��)������                       :  (3�_)");
                    System.out.println("|�c�[�y�A                    : ��������(2��)����g                       :  (2�_)");
                    System.out.println("|�����y�A                    : ��������(2��)����g                       :  (1�_)");
                    System.out.println();
                    System.out.println("\t<<<<< �������̔{���ɂ��� >>>>>");
                    System.out.println("|���́u�����v�ɍ������ă|�[�J�[�ɏ������ہC�������ɔ{����������");
                    System.out.println("|>�|�[�J�[�̖��� 50 �_�ȏ�̍��������ꍇ : * 100 �{");
                    System.out.println("|>�|�[�J�[�̖��� 20 �_�ȏ�̍��������ꍇ : *  50 �{");
                    System.out.println("|>�|�[�J�[�̖��� 10 �_�ȏ�̍��������ꍇ : *  10 �{");
                    System.out.println("|>�|�[�J�[�̖��� 5 �_�ȏ�̍��������ꍇ  : *   2 �{");
                    System.out.println("|>�|�[�J�[�̖��� 3 �_�ȏ�̍��������ꍇ  : * 1.5 �{");
                    System.out.println("|>�|�[�J�[�̖��� 1 �_�ȏ�̍��������ꍇ  : *   1 �{");
                    System.out.println();
                    System.out.println("\t<<<<< ���̗͂� >>>>>");
                    System.out.println("|>�|������UP���܂����H(y or n) >> y");
                    System.out.println("|>������UP���܂����H(���݁F0,����F100) >> +50   <- �����player-money���Q��
");
                    System.out.println("|>�J�[�h���`�F���W���܂����H(y or n) >> y");
                    System.out.println("|\t----------------------");
                    System.out.println("|\t|   1   2   3   4   5");
                    System.out.println("|\t|<[S6][C3][S10][S12][S3]>");
                    System.out.println("|\t----------------------");
                    System.out.println("|>�����ڂ��������܂����H >> 1 2 3   <- �����������ӏ����󔒂�����œ���");
                    System.out.println();

                    break;

                case 5:
                    System.exit(1);
                    break;
            }
        }
    }
}
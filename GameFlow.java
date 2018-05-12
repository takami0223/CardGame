import java.util.*;
import java.util.Random;

class GameFlow {

    public static final int MAX_GAME = 2;
    public static final int MAX_CHANGE = 5;
    public static final int MAX_CARD_FIVE = 5;  //�J�[�h�̖���

    private int get_count = 0;
    private int lost_count = 0;

    private ArrayList<Integer> getMoney_data = new ArrayList<>(); //��������ۑ�
    private ArrayList<Integer> lostMoney_data = new ArrayList<>();//��������ۑ�

    public void flow(Player player, Player computer, CardStock stock, Scanner scan){

        player.reset_points();  //�v���C���[�̃|�C���g���Z�b�g
        player.reset_money();   //�v���C���[�̏��������Z�b�g
        computer.reset_points();//�R���s���[�^�̃|�C���g���Z�b�g
        computer.reset_money(); //�R���s���[�^�̏��������Z�b�g

        Random rnd = new Random();

        for(int i=0; i<100; i++){System.out.println();}
        System.out.println("<< 5���J�W�m�|�[�J�[�X�^�[�g >>");

            stock.shuffle();

            player.reset_bets();
            computer.reset_bets();

            Hand player_hand = stock.makeHand(MAX_CARD_FIVE);
            Hand computer_hand = stock.makeHand(MAX_CARD_FIVE);

            int player_Result;  //�v���C���[�̖�
            int computer_Result;//�R���s���[�^�̖�

            try{Thread.sleep(1000);} catch(InterruptedException e){}

            System.out.println();
            System.out.println("-- ��" + (i+1) + "�Q�[�� --");

            try{Thread.sleep(1000);} catch(InterruptedException e){}

            for(int j=0; j<MAX_CHANGE; j++){
                System.out.println();
                System.out.println("[ �`�F���W" + (j+1) + "��� / " + MAX_CHANGE + "]");

                System.out.println("\t---------------------------");
                System.out.println("\t| Player-money  �F" + player.get_money() + " (-" + player.get_bets() + ") |");
                System.out.println("\t---------------------------");

                System.out.println("\t------------------------------------");
                System.out.print("\t| Player  �F" + player_hand + " :");
                stock.showResult(player_hand,player);
                System.out.println("\t|         vs");
                //System.out.print("\t| Computer�F" + computer_hand + " :");
                System.out.println("\t| Computer�F<[  ][  ][  ][  ][  ]> :  ?");
                //stock.showResult(computer_hand,computer);
                System.out.println("\t------------------------------------");

                /*------------------*/
                /*---�|�����̕ύX---*/
                /*------------------*/
                String betUpCheck;
                do {
                    System.out.print(">�|������UP���܂����H      (y or n) >> ");
                    betUpCheck = scan.next();
                }while(betUpCheck.charAt(0) != 'y' && betUpCheck.charAt(0) != 'n');

                /*---�v���C���[���̑���---*/
                if(betUpCheck.charAt(0) == 'y'){
                    int betUp_player = 0;
                    while(true) {
                        try {
                            do {
                                Scanner scan2 = new Scanner(System.in);
                                betUp_player = scan2.nextInt();
                                if(betUp_player > player.get_money() || betUp_player < 0)
                                    System.out.println("!*�w�萔���s�K�؂ł�*!");
                            }while(betUp_player > player.get_money() || betUp_player < 0);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("!*���l�ȊO�����͂���܂���*!");
                        }
                    }
                    player.add_bets(betUp_player);
                }

                /*---�R���s���[�^���̑���---*/
                int betUp_computer;
                player_Result = stock.getResult(player_hand);       //�v���C���[�̖�
                computer_Result = stock.getResult(computer_hand);   //�R���s���[�^�̖�

                if(player_Result < computer_Result && computer.get_money() > 0) {
                    if((computer_Result - player_Result) >= 5) {    //5�_�ȏ�̍�
                        betUp_computer = rnd.nextInt(computer.get_money())+1;
                        computer.add_bets(betUp_computer);
                    }else if((computer_Result - player_Result) >= 3) {  //3�_�ȏ�̍�
                        betUp_computer = rnd.nextInt(computer.get_money()/2)+1;
                        computer.add_bets(betUp_computer);
                    }else if((computer_Result - player_Result) >= 1) {  //1�_�ȏ�̍�
                        betUp_computer = rnd.nextInt(computer.get_money()/3)+1;
                        computer.add_bets(betUp_computer);
                    }
                }

                /*----------------------------*/
                /*---�w��̃J�[�h���`�F���W---*/
                /*----------------------------*/
                String changeCheck;
                do {
                    System.out.print(">�J�[�h���`�F���W���܂����H(y or n) >> ");
                    changeCheck = scan.next();
                }while(changeCheck.charAt(0) != 'y' && changeCheck.charAt(0) != 'n');

                /*---�v���C���[���̑���---*/
                if(changeCheck.charAt(0) == 'y'){
                    System.out.println("\t----------------------");
                    System.out.println("\t|   1   2   3   4   5");
                    System.out.println("\t|" + player_hand);
                    System.out.println("\t----------------------");

                    String gomi = scan.nextLine(); //�j���p
                    String changeNum;
                    while(true) {
                        try {
                            do {
                                System.out.print(">�����ڂ��������܂����H >> ");
                                changeNum = scan.nextLine();
                            }while(changeNum.equals(""));

                            String[] changeNum2 = changeNum.split(" +");
                            stock.overLapDel(changeNum2);

                            int[] changeNumResult = new int[changeNum2.length];
                            for(int a=0; a<changeNum2.length; a++){
                                changeNumResult[a] = Integer.parseInt(changeNum2[a]); //int�^�ɕϊ�
                                if(changeNumResult[a] <= player_hand.cards.length && changeNumResult[a] > 0) {
                                    player_hand.cards[changeNumResult[a] - 1] = stock.deal();
                                }
                            }
                            break;
                        }catch (NumberFormatException e) {
                            System.out.println("!*���l�ȊO�����͂���܂���*!");
                        }
                    }
                }

                /*---�R���s���[�^���̑���(�t���b�V����ڎw���ꍇ)---*/

                int spade=0, heart=0, diamond=0, club=0, max=0;

                for(int t1 = 0; t1 < computer_hand.cards.length; t1++) {
                    if(computer_hand.cards[t1].getSuit().toString().equals("SPADE"))spade++;
                    if(computer_hand.cards[t1].getSuit().toString().equals("HEART"))heart++;
                    if(computer_hand.cards[t1].getSuit().toString().equals("DIAMOND"))diamond++;
                    if(computer_hand.cards[t1].getSuit().toString().equals("CLUB"))club++;
                }
                max = spade;
                if(max < heart)max = heart;
                if(max < diamond)max = diamond;
                if(max < club)max = club;

                for(int t2 = 0; t2 < computer_hand.cards.length; t2++) {
                    if(max == spade) {
                        if(computer_hand.cards[t2].getSuit().toString() != "SPADE")
                            computer_hand.cards[t2] = stock.deal();
                    }else if(max == heart) {
                        if(computer_hand.cards[t2].getSuit().toString() != "HEART")
                            computer_hand.cards[t2] = stock.deal();
                    }else if(max == diamond) {
                        if(computer_hand.cards[t2].getSuit().toString() != "DIAMOND")
                            computer_hand.cards[t2] = stock.deal();
                    }else if(max == club) {
                        if(computer_hand.cards[t2].getSuit().toString() != "CLUB")
                            computer_hand.cards[t2] = stock.deal();
                    }
                }

                for(int b=0; b<100; b++){System.out.println();}
            }

            for(int z=0; z<100; z++){System.out.println();}

            /*------------------------------*/
            /*---�e�Q�[���̃��U���g��\��---*/
            /*------------------------------*/
            System.out.println("\t---------------------------");
            System.out.print("\t| Player  �F" + player_hand + " :");
            System.out.println("\t---------------------------");

            computer_Result = stock.getResult(computer_hand);   //�R���s���[�^�̖�
            int bets_Sum = player.get_bets() + computer.get_bets();

            /*-�{�[�i�X��ݒ�-*/
            double bet_double = 0;

            if(Math.abs(player_Result - computer_Result) >= 50) {
                bet_double = 100.0;
            }else if(Math.abs(player_Result - computer_Result) >= 20) {
                bet_double = 50.0;
            }else if(Math.abs(player_Result - computer_Result) >= 10) {
                bet_double = 10.0;
            }else if(Math.abs(player_Result - computer_Result) >= 5) {
                bet_double = 2.0;
            }else if(Math.abs(player_Result - computer_Result) >= 3) {
                bet_double = 1.5;
            }else{
                bet_double = 1.0;
            }

            if(player_Result == computer_Result) {
                System.out.println(">�|�����͖v���ƂȂ�܂���");
            }else if(player_Result > computer_Result) {
                player.add_money((int)Math.round(bets_Sum * bet_double));
                System.out.println("> player �̏����� +" + bets_Sum + "(*" + bet_double + ")");
                System.out.println(">computer�̕����� -" + computer.get_bets());
            }else if(player_Result < computer_Result) {
                computer.add_money((int)Math.round(bets_Sum * bet_double));
                System.out.println("> player �̕����� -" + player.get_bets());
                System.out.println(">computer�̏����� +" + bets_Sum + "(*" + bet_double + ")");
            }

            try{Thread.sleep(1000);} catch(InterruptedException e){}

            /*---�|�����̕ϓ����ʂ�\��---*/
            System.out.println();
            System.out.println("-- ��" + (i+1) + "�Q�[���������ϓ� --");
            System.out.println("\t----------------------");
            if(player_Result > computer_Result) {
                System.out.println("\t| Computer-money�F" + computer.get_money() + " (-" + computer.get_bets() + "):���� |");
                getMoney_data.add((int)(Math.round(bets_Sum * bet_double)-player.get_bets()));
            }else if(player_Result < computer_Result) {
                System.out.println("\t| Player-money  �F" + player.get_money() +  " (-" + player.get_bets() + "):��>
�� |");
                System.out.println("\t| Computer-money�F" + computer.get_money() + " (+" + ((int)Math.round(bets_Sum * bet_double)-computer.get_bets()) + "):���� |");
                lostMoney_data.add(player.get_bets());
            }else{
                System.out.println("\t| Player-money  �F" + player.get_money() +  " (-" + player.get_bets() + "):��>
�� |");
                System.out.println("\t| Computer-money�F" + computer.get_money() + " (-" + computer.get_bets() + "):���� |");
            }
            System.out.println("\t----------------------");

            if(player.get_money() == 0) {
                System.out.println("> player �̏�������0�ɂȂ������ߏI�����܂�");
                break;
            }
            if(computer.get_money() == 0) {
                System.out.println("> computer �̏�������0�ɂȂ������ߏI�����܂�");
                break;
            }
            System.out.println();

            if(i < MAX_GAME-1)
                System.out.println("�� 5�b�� -> ���̃Q�[����");
            else
                System.out.println("�� 5�b�� -> ���j���[�ɖ߂�܂�");

            try{Thread.sleep(5000);} catch(InterruptedException e){}
            for(int q=0; q<100; q++){System.out.println();}

            /*---�J�[�h�𕜊�������---*/
            stock = new CardStock();

        }
    }

    public ArrayList<Integer> get_money() {
        ArrayList<Integer> get_money = new ArrayList<>();
        get_money = getMoney_data;

        return get_money;
    }

    public ArrayList<Integer> lost_money() {
        ArrayList<Integer> lost_money = new ArrayList<>();
        lost_money = lostMoney_data;

        return lost_money;
    }
}
package poc3;

import java.util.Random;

public class AirplanSeat {

	public static void main(String[] args) {

		// 100人坐飞机，第一个乘客在座位中随便选一个坐下，第100人正确坐到自己坐位的概率是？修改
		// 他们分别拿到了从1号到100号的座位，这些乘客会按号码顺序登机并应当对号入座，如果他们发现对应号座位被别人坐了，
		// 就会在剩下空的座位随便挑一个坐．现在假设1号乘客疯了（其他人没疯），他会在100个座位中随便选一个座位坐下，
		// 问：第100人正确坐到自己坐位的概率是多少？（也可推广到n名乘客n个座位的情况）
		// 面试的时候遇到这个问题，也算是个经典概率问题，在quora中找到了，好像不需要再问了，不过如果有有趣的脑洞答案欢迎一答~
		int TotalRound = 2000;
		int Len = 20;
		int TotalSucc = 0;
		Random rnd = new Random(Len);
		for (int round = 0; round < TotalRound; round++) {
			int seat[] = new int[Len];
			for (int i=0;i<Len;i++)
			{
				seat[i] = -1;
			}
			
			for (int i = 0; i < Len; i++) {
				// 新的规矩。 旅客随机选个数，然后这个数代表第几个空位，旅客就坐这个位子
				int SelectedEmptySeatCnt = rnd.nextInt(Len - i)+1;
				int SeatNum =-1;
				int emptySeatCnt = 0;
				for (int j = 0; j < Len; j++) {
					if (seat[j] == -1) {
						emptySeatCnt++;
						if (emptySeatCnt == SelectedEmptySeatCnt)
						{
							seat[j] = i;
							SeatNum = j;
							break;							
						}
					}							
				}
				//System.out.printf("People # %d sit on Seat %d\n", i, SeatNum);		
				 
//第一版，随机挑个位子，如果有人，那就再挑一次。
//				do {
//					int SeatNum = rnd.nextInt(Len);
//					if (seat[SeatNum] == 0) {
//						seat[SeatNum] = i;
//						// System.out.printf("People # %d sit on Seat %d\n", i, SeatNum);
//						break;
//					}
//				} while (true);
				
			}
			
			
			if (seat[Len - 1] == Len - 1) {
				System.err.printf("Round %d Success\n", round);
				TotalSucc++;
			}
		}
		System.err.printf("Sum: %d / %d  = %f \n", TotalSucc, TotalRound, (TotalSucc * 1.0 / TotalRound * 1.0));
	}

}

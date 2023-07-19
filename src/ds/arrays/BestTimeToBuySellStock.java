package ds.arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://www.youtube.com/watch?v=excAOvwF_Wk
public class BestTimeToBuySellStock {


    static int buySellStockNaive(int[] inp){
        int maxProfit= 0;
        for(int i=0;i<inp.length;i++){
            for(int j=i+1;j<inp.length;j++){
                if(inp[j]>inp[i]){
                    maxProfit = Math.max(maxProfit, inp[j]-inp[i]);
                }
            }
        }

        return maxProfit;
    }

    static int buySellStockBetter(int[] inp){
        int maxProfit = 0;

        int min = inp[0];//min buy

        for(int i=1;i<inp.length;i++){
            int profit = inp[i]-min;
//            maxProfit = Math.max(maxProfit, profit);
            if(profit > maxProfit){
                maxProfit = profit;
            }

//            min = Math.min(min, inp[i]);
            if(inp[i] < min){
                min = inp[i];
            }


        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] inp = {2,3,4};

        System.out.println("buySellStockNaive : "+ buySellStockNaive(inp));
        System.out.println("buySellStockBetter : "+ buySellStockBetter(inp));


    }
}

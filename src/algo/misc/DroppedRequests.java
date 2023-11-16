package algo.misc;

/**
 * Salesforce Online Assessment : Hackerrank
 * Non-critical requests for a transaction system are routed through a throttling gateway to ensure that the network is not choked by non-essential requests.
 *
 * The gateway has the following limits:
 *
 * • The number of transactions in any given second cannot exceed 3.
 *
 * • The number of transactions in any given 10 second period cannot exceed 20. A ten-second period includes all requests arriving from any time max(1, T-9) to T(inclusive of both) for any valid time T.
 *
 * The number of transactions in any given minute cannot exceed 60. Similar to above, 1 minute is from max(1, T-59) to T.
 *
 * Any request that exceeds any of the above limits will be dropped by the gateway. Given the times at which different requests arrive sorted ascending, find how many requests will be dropped.
 *
 * Note: Even if a request is dropped it is still considered for future calculations. Although, if a request is to be dropped due to multiple violations, it is still counted only once.
 */
import java.util.Arrays;

public class DroppedRequests {
    public static int getDroppedRequest(int[] requestTime){
        int oneSecStart=0,tenSecStart=0,sixtySecStart=0,dropped=0;
        for(int i=0; i<requestTime.length; i++) {
            int currSec = requestTime[i];
            if(currSec-requestTime[oneSecStart] >= 1){
                oneSecStart++;
                while (requestTime[oneSecStart-1] == requestTime[oneSecStart]){
                    oneSecStart++;
                }
            }

            if(currSec-requestTime[tenSecStart] >=10){
                tenSecStart++;
                while (requestTime[tenSecStart-1] == requestTime[tenSecStart]){
                    tenSecStart++;
                }
            }

            if(currSec-requestTime[sixtySecStart] >= 60){
                sixtySecStart++;
                while (requestTime[sixtySecStart-1] == requestTime[sixtySecStart]){
                    sixtySecStart++;
                }
            }

            if(i-sixtySecStart+1 > 60){
                dropped++;
            } else if(i-tenSecStart+1 > 20){
                dropped++;
            } else if(i-oneSecStart+1 > 3){
                dropped++;
            }
        }
        return dropped;
    }

    public static void main(String[] args) {
        int[] requestTime = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11};
        int dropped = getDroppedRequest(requestTime);
        System.out.println("Dropped requests: " + dropped);
    }
}

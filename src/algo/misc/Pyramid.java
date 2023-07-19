package algo.misc;

public class Pyramid {

    static void printPyramid(int level){
        int a = 1, d=2;
        for(int i=0;i<level;i++){
            int stars = a+i*d;
            int lastLevelCount = a+(level-1)*d;
            int spaces = (lastLevelCount-(stars))/2;
            StringBuilder s= new StringBuilder();
            int j=0;
            while (j< lastLevelCount){
                if(j==spaces) {

                    for (int x = 0; x < stars; x++) {
                        s.append("*\t");
                        j++;
                    }
                    break;
                }
                s.append("\t");
                j++;
            }
            System.out.println(s);

        }

    }

    static void printPyramid2(int level){
        int lastLevelStarCount = 2*level -1;

        int mid = lastLevelStarCount/2;

        for(int i=0;i<level;i++){
            StringBuilder s = new StringBuilder();
            int low = mid-i;
            int high = mid+i;
            for(int j=0;j<=high;j++){
                if(j>=low && j<=high){
                    s.append("*\t");
                } else {
                    s.append("-\t");
                }
            }
            System.out.println(s);
        }
    }

    static void printPyramid3(int level){
        for(int i=0;i<level;i++){
            int blankSpaces = level-i-1;
            for (int j=0;j<blankSpaces;j++){
                System.out.print("\t");
            }
            int starCount = 1 + i * 2;  //a+2d : AP
            for(int j=0; j<starCount;j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int level = 9;
        printPyramid3(level);
    }

    static void printArray (int[] array, boolean b) {
        if(b) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(i + ",\t");
            }
            System.out.println();
        }
        for (int value : array) {
            System.out.print(value + ",\t");
        }
        System.out.println();
    }
}

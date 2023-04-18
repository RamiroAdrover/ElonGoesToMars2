import java.util.Scanner;

public class test3 {
    static long weight;
    static long minWeight;
    static long[] items;
    static int testCases;
    static int elements;
    static int currentFilledPositions=0;
    static int[] positions = null;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        for (int i = 0; i< testCases; i++) {
            elements = scanner.nextInt();
            weight = scanner.nextLong();
            items = new long[elements];
            for(int j=0;j<elements;j++){
                items[j] = scanner.nextLong();
            }
            getObjects(elements, weight);

        }
    }
    protected static void setMinWeight(long weight){
        minWeight = (long) Math.ceil(weight/2.);
    }
    protected static boolean onRange(long weightAccumulator){
        return ((weightAccumulator>=minWeight)&&(weightAccumulator<=weight));
    }
    protected static void emptyArray(){
        for(int i=1; i< items.length;i++){
            items[i]= 0;
            positions[i] = 0;
        }
        positions[0]=currentFilledPositions;
        currentFilledPositions = 1;
    }
    protected static void getObjects(int elementsCount, long weight){

        positions = new int[elementsCount+1];
        currentFilledPositions = 0;
        long weightAccumulator = 0;
        int index = 0;
        setMinWeight(weight);

        while(!onRange(weightAccumulator) && index<elementsCount){
            if(onRange(items[index])){
                emptyArray();
                weightAccumulator = items[index];
                index= elementsCount;
            }else {
                if (items[index] + weightAccumulator <= weight) {
                    currentFilledPositions++;
                    weightAccumulator += items[index];
                    positions[currentFilledPositions] = index;
                }
            }
            index++;
        }
        if (onRange(weightAccumulator)){
            System.out.println(currentFilledPositions);
            for(int i = 0; i<elementsCount; i++) {
                if(positions[i]!=0 || (positions[i]==0 && i==0))
                    System.out.print((positions[i]+1)+" ");
            }
            System.out.println();
        }else{
            System.out.println(-1);
        }

    }
}

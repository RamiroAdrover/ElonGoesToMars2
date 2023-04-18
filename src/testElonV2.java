import java.util.Scanner;

public class testElonV2 {
    static long weight;

    static int minWeight;
    static long[] items;
    static int testCases;
    static int elements;

    public static void main(String[] args){

        //System.out.println("Ingresar cantidad de casos de prueba");

        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        for (int i = 0; i< testCases; i++) {

            //System.out.println("Ingresar cantidad de elementos y peso total");

            elements = scanner.nextInt();
            weight = scanner.nextLong();
            items = new long[elements+1];
            for(int j=1;j<elements+1;j++){
                items[j] = scanner.nextLong();
                //System.out.println("nro "+items[j]);
            }
            getObjects(elements, weight);

        }
    }
    protected static void setMinWeight(long weight){
        minWeight = (int) Math.ceil(weight/2);
    }
    protected static boolean onRange(int weightAccumulator){
        return ((weightAccumulator>=minWeight)&&(weightAccumulator<=weight));
    }
    protected static void getObjects(int elementsCount, long weight){
        //System.out.println("Ingrese pesos separados por un espacio");

        int[] positions = new int[elementsCount+1];
        int currentFilledPositions = 0;
        int weightAccumulator = 0;
        int index = 1;
        setMinWeight(weight);
        while(!onRange(weightAccumulator) && index<elementsCount+1){
            if(items[index]+weightAccumulator<=weight){
                currentFilledPositions++;
                weightAccumulator+=items[index];
                positions[currentFilledPositions] = index;
            }
            index++;
        }
        if (currentFilledPositions>0){
            System.out.println(currentFilledPositions);
            for(int i = 1; ((i<elementsCount+1) && (positions[i] != 0)); i++) {
                System.out.print(positions[i]+" ");
            }
            System.out.println();
        }else{
            System.out.println(-1);
        }

    }
    //https://www.jdoodle.com/online-java-compiler/
}

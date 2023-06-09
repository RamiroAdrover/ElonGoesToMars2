import java.util.Scanner;

public class testElonV2 {
    static long weight;

    static long minWeight;
    //min tiene que ser long, HECHO
    static long[] items;
    static int testCases;
    static int elements;

    static int currentFilledPositions=0;

    static int[] positions = null;

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
        for(int i=2; i< items.length;i++){
            items[i]= 0;
            positions[i] = 0;
        }
        positions[1]=currentFilledPositions;
        currentFilledPositions = 1;
    }
    protected static void getObjects(int elementsCount, long weight){
        //System.out.println("Ingrese pesos separados por un espacio");

        positions = new int[elementsCount+1];
        currentFilledPositions = 0;
        long weightAccumulator = 0;
        int index = 1;
        setMinWeight(weight);

        //System.out.println("peso minimo "+minWeight);

        while(!onRange(weightAccumulator) && index<elementsCount+1){

            //FALTA caso objeto solo cumple HECHO, revisar
            //System.out.println("on range? "+onRange(items[index]));

            if(onRange(items[index])){ //tendria que tener en cuenta que el item actual tambien sea mayor que lo acumulado actualmente? NO, ya lo hago en el while

                //System.out.println("entro en on range"+items[index]);

                currentFilledPositions++;
                emptyArray();
                index= elementsCount+1;
            }else {
                if (items[index] + weightAccumulator <= weight) {
                    currentFilledPositions++;
                    weightAccumulator += items[index];
                    positions[currentFilledPositions] = index;
                }
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

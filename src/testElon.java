import java.util.Scanner;

public class testElon {
    static int weight = 10000;
    static long[] items;
    static int testCases;
    static int elements;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int i = 0; i< testCases; i++) {
            elements = scanner.nextInt();
            weight = scanner.nextInt();
            getObjects(elements, weight);
        }
    }

    protected static void getObjects(int cantElements, int weight){
        Scanner scanner = new Scanner(System.in);
        items = new long[cantElements];
        String pesos = scanner.nextLine();
        String[] pesosString = pesos.split(" ");
        int pesoMinimoACubrir = (int) Math.ceil(weight/2);
        int pesoAcumulado = 0;
        int[] posiciones = new int[cantElements];
        int indiceWhile = 0;
        int cantElementosArregloFinal = -1;

        for (int i=0; i<cantElements; i++) {
            items[i] = Long.parseLong(pesosString[i]);
        }

        while ((pesoAcumulado<=pesoMinimoACubrir) && (indiceWhile<cantElements)) {
            if(items[indiceWhile] + pesoAcumulado <= weight) {
                cantElementosArregloFinal++;
                pesoAcumulado += items[indiceWhile];
                posiciones[cantElementosArregloFinal] = (indiceWhile + 1);
            }
            indiceWhile++;
        }

        if (cantElementosArregloFinal >= 0) {
            System.out.println(cantElementosArregloFinal+1);
            for(int i =0; ((i<cantElements) && (posiciones[i] != 0)); i++) {
                System.out.print(posiciones[i]+" ");
            }
        }else {
            System.out.println(cantElementosArregloFinal);
        }
    }

}
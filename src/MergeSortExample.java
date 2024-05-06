public class MergeSortExample {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};//En el método main, se crea un arreglo inicial llamado arr con los valores {12, 11, 13, 5, 6, 7}.
        System.out.println("Arreglo original:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArreglo ordenado:");
        printArray(arr);
    }

    public static void mergeSort(int[] arr, int left, int right) {//La función mergeSort toma tres argumentos: el arreglo arr, el índice izquierdo left y el índice derecho right.
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {//
        int n1 = mid - left + 1;
        int n2 = right - mid;
          //Calcula las longitudes de los subarreglos (n1 y n2) y crea arreglos temporales para almacenar los valores.
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {//Después de llamar a mergeSort, se imprime el arreglo ordenado con el mensaje “Arreglo ordenado:”
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
     * In this program implemented all tasks:
     *
     * <p>1 - Вивестивсі елементи масиву, кратні заданому значенню
     * <p>2 - Обчислитисуму всіх непарних елементів массиву
     * <p>3 - Вивестиномери (індекси) заданих елементів
     * <p>4 - Відсортувати заданий масив за зростанням та за зменщенням
     * <p>5 - Вивести кількість парних елементів масиву
     * <p>6 - Вивести кількість непарних елементів масиву
     * <p>7 - Вивести кількість кратних заданому числу елементів масиву
     * <p>8 - Вивести суму кожного другого елемента мисиву
     *
     */
//comment
public class Main {
    public static void main(String[] args) {
        //5 1 7 2 76 23 12 543 46 23 3 86 100 54 45
        int number_of_elements;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in array: ");
        number_of_elements = scanner.nextInt();
        System.out.println("Enter array: ");
        int[] array = new int[number_of_elements];
        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        sortByIncreasing(array);
        System.out.println("Sorting by increasing elements: " + Arrays.toString(array));
        sortByDecreasing(array);
        System.out.println("Sorting by decreasing elements: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Sorted by Arrays.sort() method: " + Arrays.toString(array));

        System.out.println("Enter divisor: ");
        int divisor = scanner.nextInt();
        System.out.println("Elements that can be divided by " + divisor + ": "
                + Arrays.toString(getMultipleElements(array, divisor)));

        System.out.println("Sum of odd elements = " +
                getSumOfOddElements(array));

        System.out.println("Enter number of elements: ");
        number_of_elements = scanner.nextInt();
        System.out.println("Enter elements: ");
        int[] elements = new int[number_of_elements];
        for(int i = 0; i < number_of_elements; i++) {
            elements[i] = scanner.nextInt();
        }
        System.out.println("Indexes of elements "
                + Arrays.toString(elements) + ": ");
        int[] ind = getIndexesOfElements(array, elements);
        for(int i = 0; i < ind.length; i++ ) {
            if(ind[i] == -1) {
                System.out.println("Element " + elements[i] + " not found");
            }
            else
                System.out.println("Index of " + elements[i] + ": " + ind[i]);
        }

        System.out.println("Number of even elements: " + getNumberOfEvenElements(array));
        System.out.println("Number of odd elements: " + getNumberOfOddElements(array));

        System.out.println("Sum of every second element: " + sumOfEverySecondElement(array));

        System.out.println("Elements that can be divided by " + divisor + ": "
                + getNumberOfMultipleElements(array, divisor));
    }

    /**
     * Method that returns all multiple elements for input array by input value
     * @throws ArithmeticException if divisor is 0
     * @param array input array
     * @param n divisor
     * @return int[] array of all multiple elements for input array by input value
     * */
    public static int[] getMultipleElements(int[] array, int n) {
        if(n == 0) {
            throw new ArithmeticException("Divided by zero");
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int element: array) {
            if(element % n == 0) {
                result.add(element);
            }
        }

        int[] resultAsPrimitive = new int[result.size()];
        Arrays.setAll(resultAsPrimitive, result::get);

        return resultAsPrimitive;
    }

    /**
     * Method calculates and returns sum of odd elements
     * @param array input array
     * @return int sum of all odd elements in array
     * */
    public static int getSumOfOddElements(int[] array) {
        int sum = 0;
        for(int element: array) {
            if(element % 2 != 0) {
                sum += element;
            }
        }
        return sum;
    }

    /**
     * It takes an array and an array of elements, and returns an array of indexes of the elements in the array
     *
     * @param array an array of integers
     * @param elements an array of integers
     * @return An array of integers.
     */
    public static int[] getIndexesOfElements(int[] array, int[] elements) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int element : elements) {
            for (int j = 0; j < array.length; j++) {
                if(element == array[j]) {
                    indexes.add(j);
                }
            }
            if(array[indexes.get(indexes.size()-1)] != element) {
                indexes.add(-1);
            }
        }
        int[] indexesAsPrimitive = new int[indexes.size()];
        Arrays.setAll(indexesAsPrimitive, indexes::get);

        return indexesAsPrimitive;
    }

    /**
     * For each element in the array, compare it to every other element in the array and swap them if the first element is
     * less than the second element.
     *
     * @param array the array to be sorted
     */
    public static void sortByIncreasing(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length-1; j++) {
                if(array[j] < array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * For each element in the array, compare it to every other element in the array and swap them if the first element is
     * greater than the second.
     *
     * @param array the array to be sorted
     */
    public static void sortByDecreasing(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length-1; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    /**
     * Given an array of integers, return the number of odd elements in the array.
     *
     * @param array an array of integers
     * @return The number of odd elements in the array.
     */
    public static int getNumberOfOddElements(int[] array) {
        int count = 0;
        for(int element: array) {
            if(element % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Count the number of even elements in the array.
     *
     * @param array an array of integers
     * @return The number of even elements in the array.
     */
    public static int getNumberOfEvenElements(int[] array) {
        int count = 0;
        for(int element: array) {
            if(element % 2 == 0 && element != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method that returns number of multiple elements for input array
     * @throws ArithmeticException if divisor is 0
     * @param array input array
     * @param n divisor
     * @return int number of multiple elements of array
     * */
    public static int getNumberOfMultipleElements(int[] array, int n) {
        if(n == 0) {
            throw new ArithmeticException("Divided by zero");
        }
        int count = 0;
        for (int element: array) {
            if(element % n == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method calculates integer sum of every second element is array
     * (indexing start with 1, 2, 3... etc.)
     * @param array input array
     * @returns sum of every second element of array
     */
    public static int sumOfEverySecondElement(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            if(i % 2 != 0) {        // every second element will have odd index
                sum+=array[i];
            }
        }
        return sum;
    }

    /**
     * If <b>order</b> is true, sorting by <u>increasing</u> elements,
     * else if <b>order</b> is false, sorting by <u>decreasing</u> elements.
     * @param order boolean variable that defines order of sorting (Ascending or descending).
     */
    public static void sort(int[] array, boolean order) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length-1; j++) {
                if(order) {
                    if(array[j] > array[j+1]) {
                        int tmp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = tmp;
                    }
                }
                else {
                    if(array[j] < array[j+1]) {
                        int tmp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
    }
}



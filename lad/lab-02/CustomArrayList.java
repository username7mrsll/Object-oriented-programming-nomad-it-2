import java.util.Arrays;
import java.util.Comparator;

public class CustomArrayList {

    private int[] arr;
    private int index;
    private int size;

    public CustomArrayList() {
        size = 4;
        arr = new int[size];
        index = 0;
    }

    public void add(Integer value) {
        if (index >= size - 1) {
            arr = getNewArray();
        }
        arr[index] = value;
        index++;
    }

    public void add(int index, int value) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        arr[index] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(arr).limit(index).toArray());
    }

    public Integer get(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return arr[index];
    }

    private int[] getNewArray() {
        size = size * 2;
        int[] newArr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void sort() {
        sort((a, b) -> Integer.compare(a, b));
    }

    public void sort(Comparator<Integer> comparator) {
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
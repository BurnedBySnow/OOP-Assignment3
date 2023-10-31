import java.util.ArrayList;
import java.util.List;

public class BoardUtils {

    static int getInvCount(int[] arr, int size) {
        int inv_count = 0;
        for (int i = 0; i < size * size - 1; i++) {
            for (int j = i + 1; j < size * size; j++) {
                if (arr[j] != 0 && arr[i] != 0 && arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    static int findXPosition(int[][] arr, int size) {
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (arr[i][j] == 0)
                    return size - i;
            }
        }
        return -1;
    }

    static boolean isSolvable(Button[][] tiles, int size) {
        int[][] tileNumbers = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tileNumbers[i][j] = tiles[i][j].getNumber();
            }
        }

        int[] arr = new int[size * size];
        int k = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                arr[k++] = tileNumbers[i][j];

        int invCount = getInvCount(arr, size);

        if (size % 2 == 1)
            return invCount % 2 == 0;
        else {
            int pos = findXPosition(tileNumbers, size);
            if (pos % 2 == 1)
                return invCount % 2 == 0;
            else
                return invCount % 2 == 1;
        }
    }

    static boolean winCheck(Button[][] tiles, int size) {
        List<Integer> list = new ArrayList<>();

        int index = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j].getNumber() != index && tiles[i][j].getNumber() != 0)
                    return false;
            }
        }
        return true;
    }
}

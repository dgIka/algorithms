import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class greedNum {
    public static void main(String args[]) {
        HashMap<Integer, Integer> stuff = new HashMap<>();
        stuff.put(2, 9);
        stuff.put(4, 16);
        stuff.put(3, 14);
        stuff.put(6, 30);

        System.out.println(greedNumbers(23432532));
        System.out.println(greedNumbers(123));
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigits(digits));

        int[] stations = {0, 200, 375, 550, 950};
        System.out.println(minStops(stations, 400));
    }
public static int greedNumbers(int numbers) {
    ArrayList<Integer> nums = new ArrayList<>();
    for (String a: Integer.toString(numbers).split("")) {
        nums.add(Integer.parseInt(a));
    }
    int max = 9;
    StringBuilder maxNumer = new StringBuilder();
    while(nums.size() > 0) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == max && nums.contains(max)) {
                maxNumer.append(nums.get(i));
                nums.remove(i);
            } else if (!nums.contains(max)) {
                max--;
            }
        }
    }
    return Integer.parseInt(maxNumer.toString());

}
public static String maxNumberFromDigits(int[] digits) {
        Arrays.sort(digits);
        String result = "";
        for(int i = digits.length - 1; i >= 0; i--) {
            result += digits[i];
        }
        return result;
}

public static int minStops(int[] stations, int capacity) {
        int result = 0;
        int currentStop = 0;

        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;
            while (nextStop < stations.length - 1 && stations[nextStop + 1] - stations[currentStop] <= capacity) {
                nextStop++;
            }
            if(currentStop == nextStop) return -1;

            if (nextStop < stations.length - 1) {
                result++;
            }
            currentStop = nextStop;
        }
        return result;
}

}



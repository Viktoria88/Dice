import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Cool on 19.10.2016.
 */
public class Dice {
    public static int max = 3;

    public static void main(String[] args) throws IOException {
        countSum();
    }

    public static int scanerTosses() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pleas, enter the number of tosses");
        int breakBones = Integer.parseInt(reader.readLine());
        return breakBones;
    }

    public static int scanerBones() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pleas, enter the number of dice from 1 do 3");
        int dice = Integer.parseInt(reader.readLine());

        int maxNumbers = dice * max * 6;
        if (dice > max || dice < 0) {
            System.out.println("Pleas, enter the number from 1 do 3");
            return scanerBones();
        }
        return dice;
    }

    public static ArrayList<Integer> countSum() throws IOException {
        ArrayList<Integer> sum = new ArrayList<Integer>();

        int breakBone = scanerTosses();
        int dice = scanerBones();
        for (int i = 0; i < breakBone; i++) {
            int[] bone = new int[dice];
            int summ = 0;
            for (int j = 0; j < bone.length; j++) {
                bone[j] = (int) (Math.random() * 6) + 1;
            }
            for (int bone1 : bone) {
                summ += bone1;
            }
            sum.add(summ);
        }
        for (int i = 0; i < sum.size(); i++) {
            System.out.println(sum.get(i));
        }

        int maxNumber = dice * max * 6;
        int[] counter = new int[maxNumber];
        for (int i = 0; i < sum.size(); i++) {
            counter[sum.get(i)]++;
        }

        System.out.println();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {

                System.out.println(i + " : enter " + counter[i] + " time.");
            }
        }
        return sum;
    }
}

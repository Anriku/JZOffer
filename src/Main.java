import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static final int REMOVED = -1;

    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("#.00");
        Scanner scanner = new Scanner(System.in);
        int pNum;
        int oldPTimes[];
        float newPTimes[];

        pNum = scanner.nextInt();
        oldPTimes = new int[pNum];
        newPTimes = new float[pNum];
        for (int i = 0; i < pNum; i++) {
            int time = scanner.nextInt();
            oldPTimes[i] = time;
            newPTimes[i] = time;
        }

        float sum = 0;
        int removedP = 0;
        for (int i = 0; i < pNum - 3;) {
            if (newPTimes[i] > newPTimes[i + 1]) {
                float temp = newPTimes[i + 2] * 1.2f;
                if (newPTimes[i] <= temp) {
                    oldPTimes[i + 1] = REMOVED;
                    newPTimes[i + 1] = REMOVED;
                    newPTimes[i + 2] = temp;
                    sum += newPTimes[i] + temp;

                    i = i + 2;
                } else {
                    oldPTimes[i] = REMOVED;
                    newPTimes[i] = REMOVED;
                    newPTimes[i] =

                    i++;
                }
                removedP++;
            } else {
                sum += newPTimes[i];
                i++;
            }
        }

        System.out.println(format.format(sum));
        for (int i = 0; i < pNum; i++) {
            if (oldPTimes[i] != REMOVED) {
                System.out.print(oldPTimes[i] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < pNum;i++) {
            if (oldPTimes[i] != REMOVED) {
                System.out.print(format.format(newPTimes[i]) + " ");
            }
        }
        System.out.println();

        System.out.println(1 - removedP * 0.05);
    }

}

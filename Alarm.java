import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter alarm time (HH:mm:ss): ");
        String alarmInput = scanner.nextLine();

        LocalTime alarmTime = LocalTime.parse(alarmInput,
                DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("Alarm set for " + alarmTime);

        while (true) {
            LocalTime currentTime = LocalTime.now().withNano(0);

            System.out.print("\rCurrent Time: " + currentTime);

            if (currentTime.equals(alarmTime)) {
                System.out.println("\n\n⏰ ALARM! WAKE UP!");
                for (int i = 0; i < 5; i++) {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}

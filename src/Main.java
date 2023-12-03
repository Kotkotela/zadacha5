import java.util.Calendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату формата 31.12.2020: ");
        String Date = scanner.nextLine();
        System.out.println("Введите вторую дату формата 31.12.2020: ");
        String Date2 = scanner.nextLine();
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = inputFormat.parse(Date);
            Date date2 = inputFormat.parse(Date2);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date);
            calendar1.add(Calendar.DAY_OF_MONTH, 45);
            Date newDate = calendar1.getTime();
            String formattedDate = outputFormat.format(newDate);
            System.out.println(" +45 дней: " + formattedDate);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            calendar2.set(Calendar.MONTH,0);
            calendar2.set(Calendar.DAY_OF_MONTH,1);
            newDate = calendar2.getTime();
            formattedDate = outputFormat.format(newDate);
            System.out.println(" сдвиг на начало года: " + formattedDate);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(date);
            int a = 10;
            int b = 0;
            while (b<a){
                calendar3.add(Calendar.DAY_OF_MONTH,1);
                int c = calendar3.get(Calendar.DAY_OF_WEEK);
                if(c != Calendar.SATURDAY && c != Calendar.SUNDAY){
                    b++;
                }
            }
            newDate = calendar3.getTime();
            formattedDate = outputFormat.format(newDate);
            System.out.println(" Новая дата после добавления 10 рабочих дней: " + formattedDate);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTime(date2);
            int f = 0;
            while (calendar4.getTime().before(date)) {
                calendar4.add(Calendar.DAY_OF_MONTH, 1);
                int g = calendar4.get(Calendar.DAY_OF_WEEK);
                if (g != Calendar.SATURDAY && g != Calendar.SUNDAY) {
                    f++;
                }
            }
            System.out.println("Количество рабочих дней между первой и второй датами: " + f);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
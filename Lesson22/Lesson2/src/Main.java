import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String фамилия = obj.getString("фамилия");
                String оценка = obj.getString("оценка");
                String предмет = obj.getString("предмет");

                output.append("Студент ").append(фамилия)
                        .append(" получил ").append(оценка)
                        .append(" по предмету ").append(предмет)
                        .append(".\n");
            }

            System.out.println(output.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

//public class Main {
//    public static void main(String[] args) {
//        String longString = generateLongString(1000); // Генерация строки с более 1000 символов
//
//        // Использование String
//        long startTimeString = System.nanoTime();
//        String replacedString = replaceString(longString);
//        long endTimeString = System.nanoTime();
//        long elapsedTimeString = endTimeString - startTimeString;
//        System.out.println("Время выполнения замены средствами String: " + elapsedTimeString + " нс");
//
//        // Использование StringBuilder
//        long startTimeStringBuilder = System.nanoTime();
//        StringBuilder stringBuilder = new StringBuilder(longString);
//        replaceStringBuilder(stringBuilder);
//        String replacedStringBuilder = stringBuilder.toString();
//        long endTimeStringBuilder = System.nanoTime();
//        long elapsedTimeStringBuilder = endTimeStringBuilder - startTimeStringBuilder;
//        System.out.println("Время выполнения замены средствами StringBuilder: " + elapsedTimeStringBuilder + " нс");
//    }
//
//    private static String generateLongString(int length) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            sb.append('a');
//        }
//        return sb.toString();
//    }
//
//    private static String replaceString(String str) {
//        return str.replace("a", "A");
//    }
//
//    private static void replaceStringBuilder(StringBuilder sb) {
//        for (int i = 0; i < sb.length(); i++) {
//            if (sb.charAt(i) == 'a') {
//                sb.setCharAt(i, 'A');
//            }
//        }
//    }
//}

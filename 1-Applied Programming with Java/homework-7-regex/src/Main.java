import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        // Task 1
        {
            // Match (words or dots) (space) (something in parentheses)
            String regex = "([\\w\\.]+)\\s+\\(([^])]+)\\)+";
            Pattern pattern = Pattern.compile(regex);

            BufferedReader bufferedReader = new BufferedReader(new FileReader("CSCB525F2020HW7File1.txt"));
            Map<String, String> map = new HashMap<>();

            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(fileLine);
                while (matcher.find()) {
                    map.put(matcher.group(1), matcher.group(2));
                }
            }

            map.entrySet().stream().forEach(System.out::println);
        }

        // Task 2
        {
            Pattern namePattern = Pattern.compile("^[\\w-]+");
            Pattern ipPattern = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

            Map<String, ArrayList<String>> nameToIpsMap = new HashMap<>();

            BufferedReader bufferedReader = new BufferedReader(new FileReader("CSCB525F2020HW7File2.txt"));
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                ArrayList<String> ips = new ArrayList<>();
                Matcher ipMatcher = ipPattern.matcher(fileLine);
                while (ipMatcher.find()) {
                    ips.add(ipMatcher.group(1));
                }

                Matcher nameMatcher = namePattern.matcher(fileLine);
                if (!ips.isEmpty() && nameMatcher.find()) {
                    nameToIpsMap.put(nameMatcher.group(), ips);
                }
            }

            nameToIpsMap.forEach((name, ips) -> {
                System.out.println(name + ": [" + String.join(", ", ips) + "]");
            });
        }
    }
}

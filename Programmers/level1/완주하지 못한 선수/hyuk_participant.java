import java.util.*;

public class hyuk_participant {
    public static void main(String[] args) throws Exception {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        System.out.println(solution(part, comp));
    }
    private static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

        return participant[i];
    }
}
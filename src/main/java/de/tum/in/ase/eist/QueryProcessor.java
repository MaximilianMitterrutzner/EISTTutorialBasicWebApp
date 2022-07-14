package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Maximilian Mitterrutzner";
        } else if (query.contains("largest")) {
            String string = query.split(":")[2];
            List<Integer> integers = Arrays.stream(string.split(",")).map(s -> Integer.valueOf(s.trim())).toList();

            int max = Integer.MIN_VALUE;

            for(Integer i : integers) {
                max = Math.max(max, i);
            }

            return Integer.toString(max);
        } else { // TODO extend the programm here
            return "";
        }
    }
}

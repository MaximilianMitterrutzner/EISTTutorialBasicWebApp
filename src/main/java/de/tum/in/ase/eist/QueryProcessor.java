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
        } else if(query.contains("plus")) {
            return Integer.toString(Integer.parseInt(query.split(" ")[3]) + Integer.parseInt(query.split(" ")[5]));
        } else if(query.contains("square") && query.contains("cube")) {
            String string = query.split(":")[2];
            List<Integer> integers = Arrays.stream(string.split(",")).map(s -> Integer.valueOf(s.trim())).toList();

            StringBuilder out = new StringBuilder();
            for (Integer i : integers) {
                if(almostEqual((int) Math.round(Math.pow(i, 1.0/2.0)), Math.pow(i, 1.0/2.0))
                && almostEqual((int) Math.round(Math.pow(i, 1.0/3.0)), Math.pow(i, 1.0/3.0))) {
                    out.append(i).append(", ");
                }
            }
            if(!out.isEmpty()) {
                return out.substring(0, out.length() - 2);
            }
            return "";
        } else { // TODO extend the programm here
            return "";
        }
    }

    private boolean almostEqual(int one, double two) {
        return Math.abs(one - two) < 0.00001;
    }
}

package day6;

// Stream - one-way-directional array. Also, able to use reductions
// map     - get T, return T
// flatMap - get value, return stream object of the same class

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6Streams {

    public static void main(String[] args) {

        List<String> participants = new ArrayList<>();
        participants.add("Trung");
        participants.add("Ly");
        participants.add("Tin");
        participants.add("Ivan");
        participants.add("Nguyen");
        participants.add("Nguyen");
        participants.add("NGuyen");
        participants.add("Nguyen");

        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");

        Stream<String> participantsStream = participants.stream();
        List<String> list = participantsStream
                .map(String::toUpperCase)
                .distinct()
                .parallel()
                .filter((x)-> x.contains("N"))
                //.forEach((participant)->{System.out.println(participant);})
                .collect(Collectors.toList());

        for(String s: list) {
            System.out.println(s);
        }

        // ERROR!!!! STREAM IS CLOSED NOW!
        // participantsStream.forEach(System.out::println);

        Stream<String> participants2Stream = participants.stream();
        IntSummaryStatistics intSummaryStatistic = participants2Stream
            .map(String::toUpperCase)
            .distinct()
            .parallel()
            .filter((x)-> x.contains("N"))
            //.forEach((participant)->{System.out.println(participant);})
            .collect(Collectors.summarizingInt(String::length));

        System.out.format("Result: %d, min: %d, max: %d\n", intSummaryStatistic.getSum(), intSummaryStatistic.getMin(), intSummaryStatistic.getMax());

        Stream<String> participants3Stream = participants.stream();
        String result = participants3Stream
                .map(String::toUpperCase)
                .distinct()
                .parallel()
                //.forEach((participant)->{System.out.println(participant);})
                .collect(Collectors.joining("\",\"", "{\"", "\"}"));

        System.out.format("Result: %s\n", result);
    }
}

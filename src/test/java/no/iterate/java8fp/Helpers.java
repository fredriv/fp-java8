package no.iterate.java8fp;

import java.util.Optional;
import java.util.stream.Stream;

public class Helpers {

    public static <T> T undefined() {
        throw new RuntimeException("Not implemented");
    }

    public static <T> Stream<T> toStream(Optional<T> opt) {
        return opt.map(Stream::of).orElseGet(Stream::empty);
    }

}

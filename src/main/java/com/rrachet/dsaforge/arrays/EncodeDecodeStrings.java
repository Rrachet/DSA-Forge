package com.rrachet.dsaforge.arrays;

import java.util.ArrayList;
import java.util.List;

/** Length-prefixed string encoding that safely handles separators. */
public final class EncodeDecodeStrings {
    private EncodeDecodeStrings() {}
    public static String encode(List<String> values) {
        StringBuilder out = new StringBuilder();
        for (String value : values) out.append(value.length()).append('#').append(value);
        return out.toString();
    }
    public static List<String> decode(String encoded) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < encoded.length()) {
            int separator = encoded.indexOf('#', i);
            if (separator < 0) throw new IllegalArgumentException("malformed encoding");
            int length = Integer.parseInt(encoded.substring(i, separator));
            int start = separator + 1, end = start + length;
            if (end > encoded.length()) throw new IllegalArgumentException("malformed encoding");
            result.add(encoded.substring(start, end));
            i = end;
        }
        return result;
    }
}

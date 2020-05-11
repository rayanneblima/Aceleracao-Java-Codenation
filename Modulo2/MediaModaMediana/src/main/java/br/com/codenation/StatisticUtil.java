package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticUtil {

    public static int average(int[] elements) {
        //return new Double(IntStream.of(elements).average().getAsDouble()).intValue();
        return (int)IntStream.of(elements).average().getAsDouble();
    }

    public static int mode(int[] elements) {
        List<Integer> values = Arrays.stream(elements)
				.boxed()
				.collect(Collectors.toList());
        int ocorre = 0;
        int moda = 0;
        
        for(int value : values) {
            int freq = Collections.frequency(values, value);
            if(freq > ocorre) {
                ocorre = freq;
                moda = value;
            }
        }
        return moda;
    }

    public static int median(int[] elements) {
    	List<Integer> values = Arrays.stream(elements)
				.boxed()
				.sorted()
				.collect(Collectors.toList());

	if(values.size() % 2 == 1) {
            return values.get((values.size()/2));
	}
        return (values.get((values.size()/2) - 1) + values.get((values.size()/2))) /2;
    }
}
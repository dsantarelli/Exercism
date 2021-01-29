import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class HandshakeCalculator {

    private static final int REVERSE_MASK = 16;

    private static final HashMap<Integer, Signal> signalMasks = createSignalMasks();
    private static HashMap<Integer, Signal> createSignalMasks() {
        HashMap<Integer, Signal> map = new HashMap<Integer, Signal>();
        map.put(1, Signal.WINK);
        map.put(2, Signal.DOUBLE_BLINK);
        map.put(4, Signal.CLOSE_YOUR_EYES);
        map.put(8, Signal.JUMP);
        return map;
    }

    List<Signal> calculateHandshake(int number) {

        ArrayList<Signal> signals = new ArrayList<Signal>();        
        signalMasks.keySet().stream()
            .filter(mask -> checkMask(number, mask))
            .map(mask -> signalMasks.get(mask))
            .forEach(signal -> signals.add(signal));

        if (checkMask(number, REVERSE_MASK))
            Collections.reverse(signals);

        return signals;
    }

    private static boolean checkMask(int number, int mask) {
        return (number & mask) == mask;
    }
}
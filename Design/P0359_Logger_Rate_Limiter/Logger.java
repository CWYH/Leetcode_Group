import java.util.HashMap;

/**
 * 359. Logger Rate Limiter -- Easy
 */

class Logger {
    private HashMap<String, Integer> h = new HashMap<>();

    /** Initialize your data structure here. */
    public Logger() {
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!h.containsKey(message)) {
            h.put(message, timestamp);
            return true;
        }
        if (timestamp - h.get(message) >= 10) {
            h.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
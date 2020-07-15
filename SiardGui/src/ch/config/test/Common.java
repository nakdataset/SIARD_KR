package ch.config.test;

public class Common {

	private final static int SEQ_START = 0;
	private final static int SEQ_END = 999999999;

	protected static int seq = 0;
	protected static Object obj = new Object();

	public static String getSeqNumber() {
        synchronized (obj) {
            if (seq == SEQ_END)
                seq = SEQ_START;

            seq++;
            String seqNumber = String.valueOf(seq);
            return seqNumber;
        }
	}

}

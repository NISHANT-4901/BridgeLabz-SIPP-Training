package Day4_5_LinerAndBinarySearch;

public class StringBufferProblem2_ComparePerformance {
    public static void main(String[] args) {
        int iterations = 1000000;

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("hello");
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) + " ns");

        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbd.append("hello");
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) + " ns");
    }
}

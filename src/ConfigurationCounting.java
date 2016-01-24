import java.util.Arrays;

public class ConfigurationCounting {
    public static void main(String[] args) {
        //System.out.println("Total number of assignments: " + 0);
        //System.out.println(0 + " set(s) with occupancies: " + 0);
        //System.out.println(binomial(4, 2));
        System.out.println("Total number of assignments: " + init(3, 3));
        
    }
    
    private static int init(int nodes, int channels) {
        int[] distribution = new int[channels];
        distribution[distribution.length - 1] = channels;
        //System.out.println(arrayPrint(distribution));
        System.out.println("1 == " + perm(removeZeros(new int[] {0, 0, 3})));
        System.out.println("3 == " + perm(removeZeros(new int[] {0, 1, 2})));
        System.out.println("6 == " + perm(removeZeros(new int[] {1, 1, 1})));
        //combos(channels, channels, nodes, 0, distribution);
        return 0;
    }
    
    private static String arrayPrint(int[] array) {
        String holder = Arrays.toString(array);
        holder = holder.substring(1, holder.length() - 1);
        return holder;
    }
    
    private static int[] removeZeros(int[] array) {
        int holder[] = new int[array.length];
        int zeroShifter = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                holder[i - zeroShifter] = array[i];
            }
            else {
                zeroShifter++;
            }
        }
        int[] returner = new int[holder.length - zeroShifter];
        System.arraycopy(holder, 0, returner, 0, returner.length);
        return returner;
    }
    
    private static int perm(int[] array) {
        // Base case
        if(array.length <= 1) {
            return 1;
        }
        else {
            
            return 0;
        }
    }
    
    private static int combos(int totalChannels, int currentChannel, int remainingNodes, int sum, int[] distribution) {
        if(remainingNodes == 0) {
            currentChannel--;
        }
        
        
        return 0;
    }
    
    private static int binomial(int n, int k) {
        if(n == 0 && k == 0) {
            return 1;
        }
        else if(n < 0 || k < 0) {
            return 0;
        }
        else {
            return binomial(n - 1, k) + binomial(n - 1, k - 1);
        }
    }
    
    private static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
    
    
}

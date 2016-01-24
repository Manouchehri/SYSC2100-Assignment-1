public class ConfigurationCounting {
    public static void main(String[] args) {
        //System.out.println("Total number of assignments: " + 0);
        //System.out.println(0 + " set(s) with occupancies: " + 0);

        System.out.println(binomial(4, 2));
    }
    
    private static int init(int nodes, int channels) {
        int distribution[] = new int[channels];
        distribution[distribution.length - 1] = channels;
        return 0;
    }
    
    private static int combos(int totalChannels, int currentChannel, int remainingNodes, int sum, int[] combos) {
        
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

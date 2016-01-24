import java.util.Arrays;
import java.util.ArrayList;


public class ConfigurationCounting {
    public static void main(String[] args) {
        //System.out.println("Total number of assignments: " + init(3, 3));
        System.out.println("Running: ");
        
        ArrayList<Integer[]> list = configs();
    }
    
    /*
    int remainingNodes, int no_of_channels, int currentChannel, int[] combinations, long sum
    
    int k = channels;
    int n = nodes;
    
    
    */
    private static ArrayList<Integer[]> configs(int k, int n, int ck) {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        return list;
    }
    
    private static int combos(int totalChannels, int currentChannel, int remainingNodes, int sum, int[] distribution) {
        if(remainingNodes == 0) {
            currentChannel--;
        }
        
        
        return 0;
    }
}

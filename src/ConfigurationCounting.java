import java.util.ArrayList;

public class ConfigurationCounting {
    public static void main(String[] args) {
        //System.out.println("Total number of assignments: " + init(3, 3));
        System.out.println("Running: ");

        ArrayList<int[]> list = configs(3, 3);
    }

    private static void configs(int numOfChannels, int numOfNodes, int currentChannel, int[] currentLayout, ArrayList<int[]> list) {
        /* Have all the nodes been assigned yet? */
        if (numOfNodes <= 0) {
            list.add(currentLayout); /* This is a valid configuration, add it to the list. */
        }
        else { /* There's still nodes left to assign. */
            int[] testLayout = new int[currentLayout.length]; /* Create a holder array. */
            System.arraycopy(currentLayout, 0, testLayout, 0, currentLayout.length); /* Copy the array. */
            if (currentChannel < numOfChannels) { /* Have we gone beyond the number of channels left? */
                testLayout[currentChannel]++; /* Add a node to the current channel. */
                configs(numOfChannels, numOfNodes, ++currentChannel, currentLayout, list); /* Move onto the next channel. */
            }
            else { /* We've ran out of channels and can't assign a node. */
                return; /* Throw testLayout away. */
            }
            configs(numOfChannels, --numOfNodes, 0, testLayout, list); /* testLayout might be valid, continue to check. */
        }
    }

    private static ArrayList<int[]> configs(int numOfChannels, int numOfNodes) {
        ArrayList<int[]> globalList = new ArrayList<>();
        configs(numOfChannels, numOfNodes, 0, new int[numOfChannels], globalList);
        System.out.println();
        return globalList;
    }
}

import java.util.ArrayList;

public class ConfigurationCounting {
    public static void main(String[] args) {
        ArrayList<int[]> configList = createConfigs(3, 3);
        System.out.println("Total number of assignments: " + configList.size());
    }

    /**
     * This is the method used to generate a list of all the possible configurations.
     * @param numOfChannels This is the number of channels.
     * @param numOfNodes This is the number of nodes.
     * @return ArrayList<int[]> This is an ArrayList containing an int[] of each possible configurations.
     */
    public static ArrayList<int[]> createConfigs(int numOfChannels, int numOfNodes) {
        if(numOfChannels <= 0) {
            throw new IndexOutOfBoundsException("Number of channels must be greater than 0.");
        }
        else if(numOfNodes <= 0) {
            throw new IndexOutOfBoundsException("Number of nodes must be greater than 0.");
        }
        else {
            ArrayList<int[]> configList = new ArrayList<>();
            createConfigs(numOfChannels, numOfNodes, 0, new int[numOfChannels], configList);
            return configList;
        }
    }

    private static void createConfigs(int numOfChannels, int numOfNodes, int currentChannel, int[] currentLayout, ArrayList<int[]> list) {
        if (numOfNodes <= 0) { /* Have all the nodes been assigned yet? */
            list.add(currentLayout); /* This is a valid configuration, add it to the list. */
        }
        else { /* There's still nodes left to assign. */
            int[] testLayout = new int[currentLayout.length]; /* Create a holder array. */
            System.arraycopy(currentLayout, 0, testLayout, 0, currentLayout.length); /* Copy the array. */
            if (currentChannel < numOfChannels) { /* Have we gone beyond the number of channels left? */
                testLayout[currentChannel]++; /* Add a node to the current channel. */
                createConfigs(numOfChannels, numOfNodes, ++currentChannel, currentLayout, list); /* Move onto the next channel. */
            }
            else { /* We've ran out of channels and can't assign a node. */
                return; /* Throw testLayout away. */
            }
            createConfigs(numOfChannels, --numOfNodes, 0, testLayout, list); /* testLayout might be valid, continue to check. */
        }
    }
}

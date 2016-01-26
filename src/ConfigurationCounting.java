import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigurationCounting {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int numOfNodes = 0;
        while (numOfNodes <= 0) { /* Force the user to enter a number greater than 0. */
            System.out.print("Enter the number of nodes: ");
            numOfNodes = userInput.nextInt();
        }
        int numOfChannels = 0;
        while (numOfChannels <= 0) {
            System.out.print("Enter the number of channels: ");
            numOfChannels = userInput.nextInt();
        }

        HashMap<String, Integer> list = createConfigs(numOfChannels, numOfNodes);

        list.forEach((layout, occurrence) -> {
            if (occurrence > 1)
                System.out.println(occurrence + " sets with occupancies: " + layout);
            else
                System.out.println(occurrence + " set with occupancies: " + layout);
        });

        int sum = 0;
        for (Integer set : list.values())
            sum += set;
        System.out.println("Total number of assignments: " + sum);
    }

    /**
     * This is the method used to generate a list of all the possible configurations.
     *
     * @param numOfChannels This is the number of channels.
     * @param numOfNodes    This is the number of nodes.
     * @return This returns a HashMap<String, Integer> containing a string representation of the channels and number of times they occur.
     */
    public static HashMap<String, Integer> createConfigs(int numOfChannels, int numOfNodes) {
        if (numOfChannels <= 0) /* This won't happen with the current user input, but since the method is public, it should be able to handle out of range numbers gracefully. */
            throw new IndexOutOfBoundsException("Number of channels must be greater than 0.");
        if(numOfNodes <= 0)
            throw new IndexOutOfBoundsException("Number of nodes must be greater than 0.");

        HashMap<String, Integer> list = new HashMap<>();
        createConfigs(numOfChannels, 0, numOfNodes, new int[numOfChannels], list);
        return list;
    }

    private static void createConfigs(int numOfChannels, int currentChannel, int numOfNodesLeft, int[] currentNodeLayout, HashMap<String, Integer> list) {
        if (numOfNodesLeft <= 0) { /* Have all the nodes been assigned yet? */
            String holder = Arrays.toString(currentNodeLayout); /* This is a valid configuration, add it to the list. */
            if (!list.containsKey(holder))
                list.put(holder, 1); /* This configuration layout has never been seen before, so create it. */
            else
                list.replace(holder, list.get(holder) + 1); /* This layout has been seen before, so just increment it. */
        }
        else { /* There's still nodes left to assign. */
            int[] testLayout = new int[currentNodeLayout.length]; /* Create a holder array. */
            System.arraycopy(currentNodeLayout, 0, testLayout, 0, currentNodeLayout.length); /* Copy the array. */
            if (currentChannel < numOfChannels) { /* Have we gone beyond the number of channels left? */
                testLayout[currentChannel]++; /* Add a node to the current channel. */
                createConfigs(numOfChannels, ++currentChannel,   numOfNodesLeft, currentNodeLayout, list); /* Branch out to the next channel. */
                createConfigs(numOfChannels, 0, /* Reset. */   --numOfNodesLeft, testLayout,        list); /* Continue with the current node assignment. */
            }
        }
    }
}

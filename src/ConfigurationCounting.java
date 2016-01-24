import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigurationCounting {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int numOfChannels = 3;
        while (numOfChannels <= 0) { /* Force the user to enter a number greater than 0. */
            System.out.print("Enter the number of channels: ");
            numOfChannels = userInput.nextInt();
        }
        int numOfNodes = 3;
        while (numOfNodes <= 0) {
            System.out.print("Enter the number of nodes: ");
            numOfNodes = userInput.nextInt();
        }

        HashMap<String, Integer> configList = createConfigs(numOfChannels, numOfNodes);

        int sum = 0;
        for (String set : configList.keySet()) {
            int holder = configList.get(set);
            sum += holder;
            if (holder > 1) {
                System.out.println(holder + " sets with occupancies: " + set);
            }
            else {
                System.out.println(holder + " set  with occupancies: " + set);
            }
        }
        System.out.println("Total number of assignments: " + sum);
    }

    /**
     * This is the method used to generate a list of all the possible configurations.
     *
     * @param numOfChannels This is the number of channels.
     * @param numOfNodes    This is the number of nodes.
     * @return
     */
    public static HashMap<String, Integer> createConfigs(int numOfChannels, int numOfNodes) {
        if (numOfChannels <= 0) { /* This won't happen with the current user input, but since the method is public, it should be able to handle out of range numbers gracefully. */
            throw new IndexOutOfBoundsException("Number of channels must be greater than 0.");
        }
        else if(numOfNodes <= 0) {
            throw new IndexOutOfBoundsException("Number of nodes must be greater than 0.");
        }
        else {
            HashMap<String, Integer> configList = new HashMap<>();
            createConfigs(numOfChannels, numOfNodes, 0, new int[numOfChannels], configList);
            return configList;
        }
    }

    private static void createConfigs(int numOfChannels, int numOfNodes, int currentChannel, int[] currentLayout, HashMap<String, Integer> list) {
        if (numOfNodes <= 0) { /* Have all the nodes been assigned yet? */
            /* This is a valid configuration, add it to the list. */
            String holder = Arrays.toString(currentLayout);
            if (!list.containsKey(holder)) {
                list.put(holder, 1);
            }
            else {
                list.replace(holder, list.get(holder) + 1);
            }
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


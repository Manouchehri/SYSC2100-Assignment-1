import java.util.ArrayList;

public class ConfigurationCounting {
    public static void main(String[] args) {
        //System.out.println("Total number of assignments: " + init(3, 3));
        System.out.println("Running: ");

        ArrayList<int[]> list = configs(3, 3);
    }

    private static void configs(int numOfChannels, int numOfNodes, int currentChannel, int[] currentLayout, ArrayList<int[]> list) {
        if (numOfNodes <= 0) {
            list.add(currentLayout);
        } else {
            int[] testLayout = new int[currentLayout.length];
            System.arraycopy(currentLayout, 0, testLayout, 0, currentLayout.length);
            if (currentChannel < numOfChannels) {
                testLayout[currentChannel]++;
                configs(numOfChannels, numOfNodes, ++currentChannel, currentLayout, list);
            } else {
                return;
            }
            configs(numOfChannels, --numOfNodes, 0, testLayout, list);
        }
    }

    private static ArrayList<int[]> configs(int numOfChannels, int numOfNodes) {
        ArrayList<int[]> globalList = new ArrayList<>();
        configs(numOfChannels, numOfNodes, 0, new int[numOfChannels], globalList);
        System.out.println();
        return globalList;
    }
}

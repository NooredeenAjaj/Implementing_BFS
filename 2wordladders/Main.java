
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Read the number of words and queries
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        // Create a graph with words as nodes
        Map<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>(N);

        // Create an array to store all queries
        String[][] queries = new String[Q][2];

        // Read words and queries
        for (int i = 0; i < Q + N; i++) {
            if (i < N) {
                graph.put(scanner.next(), new LinkedList<String>());
            } else {
                queries[i - N][0] = scanner.next();
                queries[i - N][1] = scanner.next();
            }
        }

        // Build the graph by adding edges between nodes that satisfy specific
        // conditions
        buildGraph(graph);

        // Run BFS to find the shortest path from start to end for each query
        for (int i = 0; i < queries.length; i++) {
            System.out.println(find(graph, queries[i][0], queries[i][1]));
        }
    }

    // Method to build the graph
    public static void buildGraph(Map<String, LinkedList<String>> graph) {
        Set<String> nodes = graph.keySet();

        // For every pair of nodes, if the first node can be a parent of the second, add
        // an edge between them
        for (String parent : nodes) {
            for (String child : nodes) {
                if (isMyChild(parent, child) && (!parent.equals(child))) {
                    graph.get(parent).add(child);
                }
            }
        }
    }

    // Method to perform BFS and find the shortest path from start to end
    public static String find(Map<String, LinkedList<String>> graph, String start, String target) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int distance = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.removeFirst();

                // If the target is reached, return the distance
                if (node.equals(target)) {
                    return Integer.valueOf(distance).toString();
                }

                // Add unvisited neighbors to the queue
                for (String neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.addLast(neighbor);
                    }
                }
            }

            // Increment the distance with each level
            distance++;
        }

        // If no path is found, return "Impossible"
        return "Impossible";
    }

    // Method to determine if a word can be reached from another based on the
    // problem's rules
    public static boolean isMyChild(String str1, String str2) {
        String parentGenes = str1.substring(1);
        String childGenes = str2;
        int commonGenes = 0;

        // Check if the last four letters of the parent are present in the child
        for (char gene : parentGenes.toCharArray()) {
            int geneAtIndex = childGenes.indexOf(gene);
            if (geneAtIndex >= 0) {
                commonGenes += 1;
                String newStr = childGenes.substring(0, geneAtIndex) + '!' + childGenes.substring(geneAtIndex + 1);
                childGenes = newStr;
            }
        }

        // If four common genes are found, the parent can reach the child
        return commonGenes == 4;
    }
}

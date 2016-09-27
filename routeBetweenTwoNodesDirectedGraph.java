/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    private HashSet<DirectedGraphNode> visited = new HashSet<>();
    
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (graph.size() < 2)
            return false;
        return DFS(s,t);
    }
    
    private boolean DFS(DirectedGraphNode root, DirectedGraphNode t) {
        if (root == t)
            return true;
        else if (root.neighbors.isEmpty()) {
            return false;
        }
        
        //read the value
        boolean hasRoute = false;
        for (DirectedGraphNode node : root.neighbors) {
            if (!visited.contains(node)) {
                visited.add(node);
                hasRoute = hasRoute || DFS(node, t);
            }
        }
        return hasRoute;
    }
}
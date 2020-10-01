class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        # build the graph data structure so that for each node we know its neighbors/childs
        
        # for each node, we start with one of its neightbor and check the furthest node it can visit
        
        # if during the path, we found a node that is from current node's parent, then we found a cycle
        
        # if we didnt find its parent, then we find a one way path that should be added into the result
        
        
        def dfs(current_node, parent_node, depth, jump, graph_nodes, critical_edges):
            
            # we answer only a single question: how far can we go?
            jump[current_node] = depth + 1  # at least we are here
            
            # how far can we go from my childs?
            for neighbor in graph_nodes[current_node]:
                # is it my parent?
                if neighbor == parent_node:
                    continue  # never go back 
                # have i visited it?  as this graph is connected, it is possible we have travled the path previously
                if jump[neighbor] > 0:
                    jump[current_node] = min(jump[current_node], jump[neighbor])  # if i can go back, jump[c] will decrease
                else:
                # the neighbor has not been visited, so lets ask it: how far can you go? and do not forget to add found edges!
                    jump[current_node] = min(jump[current_node], dfs(neighbor, current_node, depth+1, jump, graph_nodes, critical_edges))
            
            # if I can not go backward, I am in a critical edge
            if jump[current_node] >= depth + 1 and parent_node != -1:  # this bug was found after testing the codes, you cant add the dummy parent.
                critical_edges.append([current_node, parent_node])
                
            # meanwhile, let my parent know how far I can go
            
            return jump[current_node]
         
            
        
        graph_nodes = collections.defaultdict(list)
        
        for c in connections:
            graph_nodes[c[0]].append(c[1])
            graph_nodes[c[1]].append(c[0])
            
        critical_edges = [] # result
        jump = [-1]*n  # no nodes can go to this virtual parent
        
        dfs(0, # 0 is the current node (its value)
            -1, # its parent, which does not exist. we need parent so that we can send informatio backward
            0,  # current level
            jump, # furthest node you can go to from the current node
            graph_nodes, # to provide data
            critical_edges,  # found critical edges
           )
        
        return critical_edges
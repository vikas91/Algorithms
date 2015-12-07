package javaAlgorithms.UnionFind;
/* This algorithm reduces the problem with QU which gives long trees 
 * When connecting 2 nodes we always make larger node root of smaller node
 * This implementation we create a root object and get size of root node every time
 * However we don't need to create an extra array for keeping track of soxe of each node.
 */
public class WeightedQuickUnion extends QuickUnion {
	
	public WeightedQuickUnion(int N){
		super(N);
	}
	class Root{
		int root_length, root_value;
		Root(int root_length, int root_value){
			this.root_length=root_length;
			this.root_value=root_value;
		}
	}
	protected Root get_root_obj(int p){
		int root_length=1;
		while(inputArray[p]!=p){
			p=inputArray[p];
			root_length++;
		}
		Root root_obj = new Root(root_length, p);
		return root_obj;
	}
	public void union(int p, int q){
		Root p_root_obj = get_root_obj(p);
		Root q_root_obj = get_root_obj(q);
		if (p_root_obj.root_length<q_root_obj.root_length){
			inputArray[p_root_obj.root_value] = q_root_obj.root_value;
		}else{
			inputArray[q_root_obj.root_value] = p_root_obj.root_value;
		}
		
	}
}

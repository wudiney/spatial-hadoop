package Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String argv[]) throws IOException {
		RTree<String> root = new RTree<String>();
		BufferedReader br = new BufferedReader(new FileReader(
				"./MN_LAKES_S_100000_new_c.txt"));
		String line = br.readLine();
		float[][] result;
		ArrayList<float[][]> points = new ArrayList<float[][]>();
		ArrayList<String> lines = new ArrayList<String>();
		while (line != null){
			int pos1 = line.indexOf('(');
			int pos2 = line.indexOf(')');
			String delims = "[,| ]+";
			String data = line.substring(pos1 + 1, pos2);
			String[] strings = data.split(delims);
//			System.out.println(strings.length);
//			System.out.println(strings[0]);
//			System.out.println(strings[1]);
			float x = Float.parseFloat(strings[0]);
			float y = Float.parseFloat(strings[1]);
			result = new float[][]{{x,y},{1,1}};
			//result = t.getMBR(line);
			points.add(result);
			lines.add(line);
			//root.insert(result[0], result[1], line);
			line = br.readLine();
			//System.out.println(num);
		}
		final long startTime = System.currentTimeMillis();
		for(int i = 0; i<points.size(); i++)
			root.insert(points.get(i)[0],points.get(i)[1], lines.get(i));
		final long endTime = System.currentTimeMillis();
		//System.out.println(root.getAllLeaves().size());
		
		//List<String> a_list = root.search(new float[]{100000,100000}, new float[]{200000,200000});
		//System.out.println(a_list.size());
		System.out.println("Total execution time: " + (endTime - startTime) +" ms");
	}
	
}

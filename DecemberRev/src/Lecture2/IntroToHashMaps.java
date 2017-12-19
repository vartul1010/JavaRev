package dec16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntroToHashMaps {

	public static void main(String[] args) {
//		HashMap<String, Integer> pm = new HashMap<String, Integer>();
//
//		pm.put("India", 120);
//		pm.put("Pak", 80);
//		pm.put("China", 200);
//		System.out.println(pm);
//
//		pm.put("India", 125);
//		System.out.println(pm);
//
//		System.out.println(pm.get("India") + " " + pm.containsKey("India"));
//		System.out.println(pm.get("Utopia") + " " + pm.containsKey("Utopia"));
//
//		ArrayList<String> keys = new ArrayList<String>(pm.keySet());
//		System.out.println(keys);
//
//		ArrayList<Integer> values = new ArrayList<>(pm.values());
//		System.out.println(values);

		ArrayList<Integer> one = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2, 3, 5));
		ArrayList<Integer> two = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 4, 5));
		System.out.println(gce1(one, two));
		System.out.println(gce2(one, two));
	}

	public static ArrayList<Integer> gce1(ArrayList<Integer> one, ArrayList<Integer> two) {
		ArrayList<Integer> rv = new ArrayList<Integer>();
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int val : one) {
			map.put(val, true);
		}

		for (int val : two) {
			if (map.containsKey(val)) {
				rv.add(val);
				map.remove(val);
			}
		}

		return rv;
	}

	public static ArrayList<Integer> gce2(ArrayList<Integer> one, ArrayList<Integer> two) {
		ArrayList<Integer> rv = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int val : one) {
			if(map.containsKey(val)){
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}

		for (int val : two) {
			if (map.containsKey(val) && map.get(val) > 0) {
				rv.add(val);
				map.put(val, map.get(val) - 1);
			}
		}

		return rv;
	}

	public static void lcscseq(ArrayList<Integer> list){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		for(int val: list){
			map.put(val, false);
		}
		
		for(int val: list){
			if(map.containsKey(val - 1) == false){
				map.put(val, true);
			}
		}

		int finalL = 0;
		int finalSP = -1;
		for(int val: list){
			if(map.get(val) == true){
				int seqL = 0;
				while(map.containsKey(val + seqL)){
					seqL++;
				}
				
				if(seqL > finalL){
					finalL = seqL;
					finalSP = val;
				}
			}
		}
		
		for(int i = 0; i < finalL; i++){
			System.out.println(finalSP + i);
		}
		
	}
}

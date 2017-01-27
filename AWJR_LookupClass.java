package sstable;

import java.util.ArrayList;

import stdlib.ST;

/*
 * This program reads in text from standard input and calculates the number 
 * of unique substrings of length L that it contains. 
 * For example, if the input is cgcgggcgcg then there are 5 unique substrings 
 * of length 3: cgc, cgg, gcg, ggc, and ggg. We will use the string method 
 * substring(i, i + L) to extract ith substring and insert into a symbol table. 
 * We will then test it out on the first million digits of π.
 * 
 * input: (See Github comments)
 * output: 79385
 * 
 * @Aileen Wu, Jonah Rubin
 * @1/27/17
 */

public class AWJR_LookupClass {
	private ST<String, String> st;
	
	public static void main(String[] args) {
		String lstring = args[0];	// long text string input, key
		String L = args[1];			// length L of unique substrings
		
		AWJR_LookupClass newthing = new AWJR_LookupClass(lstring, L);
		System.out.println(newthing.getUniqNum());
	}
	
	
	/*
	 * Constructor for Lookup object
	 * arguments are key and value for input into symbol table
	 */
	public AWJR_LookupClass(String lstring, String L) {
		int num = Integer.parseInt(L);

		st = new ST<String, String>();
		for (int i = 0; i < lstring.length()-num; i++) {
			st.put(Integer.toString(i), lstring.substring(i, i+num));	// putting key, value into symbol table
		}
	}
	
	/*
	 * Method to return number of unique substrings
	 * No parameters
	 */
	public int getUniqNum() {
		ArrayList<String> uniqList = new ArrayList<String>();
		int counter = 0;
		
		for (int i = 0; i < st.size(); i++) {
			String subthing = st.get(Integer.toString(i));
			boolean uniqueness = true;	// boolean updated after checking for uniqueness
			
			for (int j = 0; j < uniqList.size(); j++) {
				if (subthing.equals(uniqList.get(j))) {
					uniqueness = false;
				}
			}
			
			if (uniqueness) {
				counter++;
				uniqList.add(subthing);	// adding to unique array for comparisons
			}
		}
		return counter;
	}
}

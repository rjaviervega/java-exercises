/*
* Java: String Manipulation Samples
* =================================
* 
* These class implements a list of string manipulation functions good
* for learning JAVA purposes, and to practice basic string manipulation. 
* 
* - R. Javier Vega
*
*/

import java.util.*;

public class StringExercises {
	
	public static void main (String args[]) 
	{		
		System.out.println("String Manipulation Exercises in Java");		
		System.out.println("=====================================");
		System.out.println("");
		
		System.out.print("Phrase: ");
		String words = "This are some words!";		
				
		System.out.println(words);	
		System.out.println("");
		
		System.out.println("Replacing Characters");
		System.out.println("====================");
		System.out.println("Blank_space with %20: "+replaceSpaces(words));	
		System.out.println("Blank_space with ',': "+replaceChars(words, ' ', ","));
		System.out.println("Reverse words   : "+reverseString(words));
		System.out.println("Reverse in place: "+reverseInPlace(words));		
		
		System.out.println("");
		
		System.out.println("String Permutation Test");		
		System.out.println("=======================");
		
		String str1 = "221112";		
		String str2 = "111122";
		System.out.println("Permutation: "+str1+" vs "+str2+" = "+testHashPermutation(str1, str2));		
		System.out.println("Permutation: "+str1+" vs 121212 = "+testHashPermutation(str1, "121212"));				
		System.out.println("");
		
		System.out.println("Unique Chars Test");
		System.out.println("=================");
		System.out.println("Unique Chars in ("+"ABCDE"+") "+ uniqueCharacters("ABCDE"));						
		System.out.println("Unique Chars in ("+"ABCDEA"+") "+ uniqueCharacters("ABCDEA"));
		System.out.println("");
		
		System.out.println("Simple Encoder/Decoder");
		System.out.println("======================");

		System.out.print("Simple badEncoder: (aaabbbccccccddddddddddd) => ");
		System.out.println(badEncoder("aaabbbccccccddddddddddd"));
		
		System.out.print("Simple badDecoder: (abc12xd4xa33abc10x) => ");
		System.out.println(badDecoder("abc6xd4xa33abc10x"));
		System.out.println("");
		
		System.out.println("Match Pharentesis");
		System.out.println("=================");
		
		System.out.println("({([])}) => "+ matchPharentesis("({([])})"));
		System.out.println("{{([])}} => "+ matchPharentesis("{{([])}}"));		
		System.out.println("({[(]})) => "+ matchPharentesis("({[(]}))"));		
		System.out.println("{({][})} => "+ matchPharentesis("{({][})}"));
		System.out.println("");
		
		System.out.println("");
	}
	
	
	
	//
	// Replace Blank Characters By %20
	//
	public static String replaceSpaces(String str) 
	{
		String returnStr =  "";
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)==' ') {
				returnStr = returnStr + "%20";
			} else {
				returnStr = returnStr + str.charAt(i);
			}
		}
		return returnStr;
	}
	
	
	
	//
	// Relace Characters on String
	//
	public static String replaceChars(String s, char f, String r) 
	{
		String result = "";
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)!=f) result += s.charAt(i); else result += r;
		}
		return result;
	}
	
	
	
	//
	// Test Permutation Using a HashMap to Store Char Count
	//
	public static boolean testHashPermutation(String s1, String s2)
	{
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

		// Hash Characters count from String 1
		for (int i=0; i<s1.length(); i++) {
			if (map1.get(s1.charAt(i))!=null) map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1); else map1.put(s1.charAt(i), 1);
		}
		
		// Hash Characters count from String 2
		for (int i=0; i<s2.length(); i++) {
			if (map2.get(s2.charAt(i))!=null) map2.put(s2.charAt(i), map2.get(s2.charAt(i))+1); else map2.put(s2.charAt(i), 1);
		}
		
		// Compare Hashes From S1 
		for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
			if (entry.getValue() != map2.get(entry.getKey()) ) return false;
		}

		// Compare Hashes From S2
		for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
			if (entry.getValue() != map1.get(entry.getKey()) ) return false;
		}
		
		return true;
		
	}
	
	
	//
	// Test Permutation By Creating Array and Comparing 
	//
	public static boolean testSortPermutation(String str1, String str2) {
	
		// Sort strings and compare
		char[] str1sorted = str1.toCharArray();
		char[] str2sorted = str2.toCharArray();		
		
		java.util.Arrays.sort(str1sorted);
		java.util.Arrays.sort(str2sorted);	
		
		System.out.println(str1sorted);	
		System.out.println(str2sorted);	
		
		String s = new String(str1sorted);	
		String s2 = new String(str2sorted);
				
		return s.contentEquals(s2);
		
	}	
	
	
	//
	// Reverse String 
	//
	public static String reverseString(String s) 
	{
		String res = "";
		for (int i=s.length()-1; i>=0; i--) {
			res += s.charAt(i);
		}
		return res;
	}
	
	
	
	//
	// Reverse String in Place using an Array of Char
	//
	public static String reverseInPlace(String s)
	{
		char[] ss = new char[s.length()];
		
		// Copy Chars
		for (int i=0; i<s.length(); i++) {
			ss[i] = s.charAt(i);
		}
		
		for (int i=0; i<ss.length; i++) {
			if (i<ss.length/2) {
				char l = ss[ss.length-i-1];
				ss[ss.length-i-1] = ss[i];
				ss[i] = l;
			}
		}
		
		return String.copyValueOf(ss);
		
	}
	
	
	
	//
	// Test if characters in string are all unique.
	// Map char-count in hash and return false if > 1.
	//
	public static boolean uniqueCharacters(String s)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i=0; i<s.length(); i++) {
			if (map.get(s.charAt(i))==null) map.put(s.charAt(i), 1); else return false;
		}
		
		return true;
	}
	
	
	//
	// Simple Encode String 
	// Given string: aaabbbcccdefg
	// Output:  3a3b3cdefg -> encoded string
	//
	public static String badEncoder(String s)
	{
		Character c = 0;
		int count = 0;
		String result = "";
				
		for (int i=0; i<s.length(); i++) {
			if (c!=s.charAt(i)) {
				if (count>0) result += ""+count+c;
				c = s.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		
		if (count>0) result += ""+count+c;
		
		return result;
		
	}
	
	
	
	// 
	// Given string with format abc5xd2xa 
	// expand to: abcdddddaa
	//
	public static String badDecoder(String s)
	{
		String result = "";
		// Iterate on String s:
		for (int i=0; i<s.length(); i++) {			
			// If we find a digit 
			if (Character.isDigit(s.charAt(i))) {
				String digits = "";
				// Capture all digits (dddd...)
				while (Character.isDigit(s.charAt(i))){
					digits += s.charAt(i);
					i++;
				}
				// Test next char for (x value) or for end of string
				// to hold one more character.
				if (s.length()>i+1 && s.charAt(i)=='x') {
					// if found - find character to repeat.
					Character repeat = s.charAt(++i);
					for (int j=0; j<Integer.parseInt(digits); j++) {
						result += repeat;
					}
				} else {
					// if no x found, copy digits and following character
					result += digits;
					result += s.charAt(i);					
				}
			} else {
				result += s.charAt(i);
			}
		}
		return result;
	}
	
	
	
	
	//
	// Match Pharentesis in String
	// Example: 
	// Given: "({([])})" return true;
	// Given: "{{([])}}" return true;
	// Given: "({[(]}))" return false;
	// Given: "{({][})}" return false;
	//
	public static boolean matchPharentesis(String s) 
	{
		// Use Stack Based Algorithm
		// if {,(,[ is found - push on Stack
		// if }, ), ] pop from stack 
		// if matching pharentesis not found return false.
		
		Stack<Character> p = new Stack<Character>();
		
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
				p.push( (Character) s.charAt(i));
			else {
				if (s.charAt(i)=='}') {
					Character c = (Character) p.pop();
					if (c!='{') return false;
				}
				if (s.charAt(i)==')') {
					Character c = (Character) p.pop();
					if (c!='(') return false;
				}
				if (s.charAt(i)==']') {
					Character c = (Character) p.pop();
					if (c!='[') return false;
				}
			}
		}
		
		if (!p.empty()) return false;
		
		return true;
		
	}
	
	
	
	
	
	
}
package com.learning.dynamic;

/*
 *                 <b> Word Break II <b>
 *   Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence 
 *   where each word is a valid dictionary word. Return all such possible sentences in any order.
 *   
 *   Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *   
 *   
 *   Example 1:

		Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
		Output: ["cats and dog","cat sand dog"]

	Example 2:

		Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
		Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]

	Explanation: Note that you are allowed to reuse a dictionary word.

	Example 3:

		Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
		Output: []


	Constraints:
	
	    1 <= s.length <= 20
	    1 <= wordDict.length <= 1000
	    1 <= wordDict[i].length <= 10
	    s and wordDict[i] consist of only lower case English letters.
	    All the strings of wordDict are unique.

 */

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> memo = new HashMap<>();
        memo.put("", new ArrayList<String>());
        memo.get("").add("");
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict, memo);
    }

	 private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo){
	        if (memo.containsKey(s)){
	            return memo.get(s);
	        }
	        List<String> ans = new ArrayList<>();
	        for (int len = 1; len <= s.length(); len++){
	            String s1 = s.substring(0, len);
	            String s2 = s.substring(len);
	            
	            if (dict.contains(s1)){
	                List<String> s2_res = dfs(s2, dict, memo);
	                for (String item : s2_res){
	                    if (item.equals("")){
	                        ans.add(s1);
	                    } else {
	                        ans.add(s1 + " " + item);
	                    }
	                }
	            }
	        }
	        memo.put(s, ans);
	        return ans;
	    }
	
	public static void main(String[] args) {
		String s = "pineapplepenapple";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("applepen");
		wordDict.add("pine");
		wordDict.add("pineapple");
		
		WordBreak wb = new WordBreak();
		System.out.println("Words :" +  wb.wordBreak(s, wordDict));
	}
}

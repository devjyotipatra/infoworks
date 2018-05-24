package com.infoworks.devj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by devjyotip on 5/24/18.
 */
public class Exp2 {

  /*
  * Idea is that some variable length prefix of one string should be same as the suffix of another.
   */

  Map<String, Integer> MAP_PREFIX = new HashMap();

  Map<String, String> MAP_SUFFIX= new HashMap();


  private void generateSuffixeToPrefixMapping(String str) {
    if(str.length() <= 2) {
      MAP_SUFFIX.put(str, "");
      return;
    }

    for(int i=str.length()-2; i>=0; i--) {
      String subStrSuffix = str.substring(str.length()-1, i);
      String subStrPrefix = str.substring(0, i+1);

      MAP_SUFFIX.put(subStrSuffix, subStrPrefix);  // (suffix -> prefix)
    }
  }

  private void generateAndMatchPrefixes(String str) {
    List<String> suffixFound = new ArrayList();

    for(int i=1; i<str.length(); i++) {
      String subStr = str.substring(0, i);
      if() {

      }
    }
  }

  public String getMinLengthString(String[] arr) {
    String res = "";

    for(int i=0; i<arr.length; i++) {
      generateSuffixeToPrefixMapping(arr[i]);  // (suffix -> prefix)
    }


    for(int i=0; i<arr.length; i++) {
      generateAndMatchPrefixes(arr[i]);  
    }

    return res;
  }
}

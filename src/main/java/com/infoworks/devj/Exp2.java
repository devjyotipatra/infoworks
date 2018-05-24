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

  Map<String, Integer> MAP_SUFFIX= new HashMap();


  private void generateAllSuffixes(String str) {
    if(str.length() <= 2) {
      MAP_SUFFIX.put(str, 0);
      return;
    }

    for(int i=str.length()-2; i>=0; i--) {
      String suffix = str.substring(str.length()-1, i);
      MAP_SUFFIX.put(suffix, 0);  // (suffix -> 0)
    }
  }

  private void generateAndMatchPrefixes(String str) {
    List<String> prefixMatched = new ArrayList();

    for(int i=1; i<str.length(); i++) {
      String prefix = str.substring(0, i);
      if(MAP_SUFFIX.containsKey(prefix)) {
        prefixMatched.add(prefix);
        MAP_SUFFIX.put(prefix, 1);  //suffix matched, mark as 1
      }
    }
  }

  public String getMinLengthString(String[] arr) {
    String res = "";

    for(int i=0; i<arr.length; i++) {
      generateAllSuffixes(arr[i]);
    }


    for(int i=0; i<arr.length; i++) {
      generateAndMatchPrefixes(arr[i]);
    }

    return res;
  }
}

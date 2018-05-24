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


  private void generateSuffixes(String str) {
    for(int i=str.length()-1; i>=0; i--) {
      String subStr = str.substring(0, )
      MAP_SUFFIX.put();
    }
  }

  private void generateAndMatchPrefixes(int strId, String str) {
    List<String> suffixFound = new ArrayList();

    for(int i=1; i<str.length(); i++) {
      String subStr = str.substring(0, i);
      if() {

      }
    }
  }
}

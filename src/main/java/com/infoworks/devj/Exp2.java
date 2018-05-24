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
  * This doesnt solve the min-covering-string problem. This algo returns a reduced string which will have
  * length of atmost the size of all the strings combined. But this does not gaurantee the minimum.
  *
  * It seems that finding the min-covering-string problem has exponential complexity in terms of the
  * number of total characters in the input array.
   */

  Map<String, Integer> MAP_PREFIX = new HashMap();

  Map<String, Integer> MAP_SUFFIX= new HashMap();


  private void generateAllPrefixes(int strId, String str) {
        for(int i=1; i<str.length(); i++) {
            String prefix = str.substring(0, i);
            MAP_PREFIX.put(prefix, strId);  // (prefix -> strId)
        }
    }


  private void generateAllSuffixes(int strId, String str) {
    for(int i=str.length()-2; i>=0; i--) {
      String suffix = str.substring(i, str.length());
      MAP_SUFFIX.put(suffix, strId);  // (suffix -> strId)
    }
  }

  // Match prefix, match suffix. If matches are found, then stitch and replace the
  // base strings with the concatenated strings in the array
  private String[] getReducedStringArray(int strId, String[] arr) {
      String str = arr[strId];

      String maxPrefixMatch = "";
    String maxSuffixMatch = "";

    int i=1, j=str.length()-1;
    int prev_i=i, prev_j=j;
    while(i < j) {
      String prefix = str.substring(0, i);
      String suffix = str.substring(j, str.length());

      if(MAP_SUFFIX.containsKey(prefix)) {
          maxPrefixMatch = prefix;
          i = i + 1;
      }

      if(MAP_PREFIX.containsKey(suffix)) {
          maxSuffixMatch = suffix;
          j = j - 1;
      }

      // No more matches possible
      if(prev_i == i && prev_j == j) {
          break;
      }
    }

    String reducedStr = str;
    if(maxPrefixMatch.length()>0) {
        reducedStr = arr[MAP_SUFFIX.get(maxPrefixMatch)] + maxPrefixMatch;
    }

    if(maxSuffixMatch.length()>0) {
        reducedStr = reducedStr + maxSuffixMatch + arr[MAP_PREFIX.get(maxSuffixMatch)];
    }

    // If the string can be reduced, then replace the base strings with the reduced string in the array
    if(reducedStr.length() > str.length()) {
        int k = 0, l = 0;
        String[] newArr = new String[arr.length - 2];
        for (; k < arr.length; k++, l++) {
            if (k != strId || k != MAP_SUFFIX.get(maxPrefixMatch) || k != MAP_PREFIX.get(maxSuffixMatch)) {
                newArr[l] = arr[k];
            } else {
                l = l - 1;
            }
        }

        newArr[l+1] = reducedStr;
        return newArr;
    }

    return arr;
  }


  public String getMinLengthString(String[] arr) {
    for(int i=0; i<arr.length; i++) {
      generateAllSuffixes(i, arr[i]);
    }


    for(int i=0; i<arr.length; i++) {
        generateAllPrefixes(i, arr[i]);
    }

    int lenArr = arr.length, i = 0;
    while(i < lenArr) {
        String[] newArr = getReducedStringArray(i, arr);
        if(newArr.length < arr.length) {
            arr = newArr;
        } else {
            i = i + 1;
        }
    }

    // Whatever is left in the arr, are the final and irreducible set of strings.
    // So concatenate them.
    StringBuilder sb = new StringBuilder();
    for(int j=0; j<arr.length; j++) {
        sb.append(arr[j]);
    }

    return sb.toString();
  }
}

package com.infoworks.devj;

/**
 * Hello world!
 *
 */
public class Exp1 {

  private Integer[] getInitSeq(int size) {
    Integer[] arr = new Integer[size];
    for(int i=0; i<size; i++) {
      arr[i] = 1;
    }

    return arr;
  }


  private Integer[] findLongestIncreasingSeq(Integer[] arr, int n) {
    Integer[] seq = getInitSeq(n);

    for(int i=0; i<n; i++) {
      for(int j=0; j<i; j++) {
        if(arr[i] > arr[j] && seq[i] < seq[j] + 1) {
          seq[i] = seq[j] + 1;
        }
      }
    }

    return seq;
  }


  private Integer[] findLongestDecreasingSeq(Integer[] arr, int n) {
    Integer[] seq = getInitSeq(n);

    for(int i=n-2; i>=0; i--) {
      for(int j=n-1; j>i; j--) {
        if(arr[i] > arr[j] && seq[i] < seq[j] + 1) {
          seq[i] = seq[j] + 1;
        }
      }
    }
    return seq;
  }

  public int getMaxIncDecSeqValue(Integer[] arr) {
    if(arr == null) {
      return 0;
    }

    if(arr.length <= 2) {
      return arr.length;
    }

    int n = arr.length;
    Integer[] iseq = findLongestIncreasingSeq(arr, n);
    Integer[] dseq = findLongestDecreasingSeq(arr, n);

    int i = 0, max = 0;
    do {
      if(iseq[i] + dseq[i] - 1 > max) {
        max = iseq[i] + dseq[i] - 1;
      }
      i = i + 1;
    } while(i < n);

    return max;
  }
}

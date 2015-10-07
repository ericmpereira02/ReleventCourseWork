/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: politicsblackmill
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Politics implements Comparable<Politics> {
    String supporter;
    String candidates;
    int num;
    public Politics (String supporter, String canidates, int number) {
        this.supporter = supporter;
        this.candidates = canidates;
        this.num = number;
    }

  
    @SuppressWarnings("unchecked")
    public static void main (final String[] args) {
        List<Politics> listSupporters = new ArrayList<Politics>(); 
        List<Politics> listCandidates = new ArrayList<Politics>();
        final Scanner kb = new Scanner(System.in);
        int numOfCandidates = kb.nextInt();
        int numOfSupporters = kb.nextInt();
        String[] candidateName = new String[numOfCandidates];
        for (int i = 0; i < numOfCandidates; i++) {
            candidateName[i] = kb.next();
        }
        for (int i = 0; i < numOfSupporters; i++) {
            String supporters = kb.next();
            String candidates = kb.next();
            Politics supporter = new Politics (supporters, candidates, 0 );
        }
    }

    @Override
    public int compareTo(Politics item) {
        if (this.number < item.number) {
            return -1;
        }
        if (this.number > item.number) {
            return 1;
        } else {
            return 0;
          }
    }
}

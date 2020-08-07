package com.dsa.aux;

public class RunLengthEncoding {
  public String encode(String input) {
    if(input == null || input.length() == 0)
      throw new IllegalArgumentException();

    char prevCharStart = 0, prevCharEnd = 1;
    char[] charInput = input.toCharArray();
    StringBuilder sbStart = new StringBuilder(), sbEnd = new StringBuilder();
    int startCount = 0, endCount = 0, i = 0, j = (charInput.length)-1;

    while(i <= j) { 
      if(charInput[i] == prevCharStart) {
        startCount++;
      } else if(prevCharStart != 0) {
        sbStart.append(startCount)
               .append(prevCharStart);
        startCount = 1;
      } else startCount = 1;
      
      if(charInput[j] == prevCharEnd) {
        endCount++;
      } else if(prevCharEnd != 1) {
          sbEnd.insert(0, prevCharEnd)
               .insert(0, endCount);
          endCount = 1;
      } else endCount = 1;

      prevCharStart = charInput[i++];
      prevCharEnd   = charInput[j--];
    }
    System.out.println("Iterations = " + i);

    if(charInput.length % 2 == 0) {
      if(prevCharStart == prevCharEnd) {
        sbStart.append(startCount+endCount)
               .append(prevCharStart);
      } else {
          sbStart.append(startCount)
                 .append(prevCharStart);
          sbEnd.insert(0, prevCharEnd)
               .insert(0, endCount);
        } // a b c c r
    } else if(startCount != 1 || endCount != 1) {
        if(startCount != 1 && endCount != 1) {
          sbStart.append(startCount+endCount-1)
                 .append(prevCharStart);
        } else if(startCount != 1) {
            sbStart.append(startCount)
                   .append(prevCharStart);
        } else {
          sbStart.append(endCount)
                 .append(prevCharEnd);
        }
    } else sbStart.append(1)
                  .append(charInput[i-1]);

    
    return sbStart.append(sbEnd).toString();


    // Loop from front
    //   int k = 0 ;
    // for(char c : charInput) {
    //   if(c == prevCharStart) {
    //     startCount++;
    //   }else if(prevCharStart != 0) {
    //     sbStart.append(startCount).append(prevCharStart);
    //     startCount = 1;
    //   }else startCount = 1;
    //   prevCharStart = c; 
    //   k++;
    // }
    // sbStart.append(startCount).append(prevCharStart); //1c

    // System.out.println("Iterations = " + k);
    // return sbStart.toString();
  }
}
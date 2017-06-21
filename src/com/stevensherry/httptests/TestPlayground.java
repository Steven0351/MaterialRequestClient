package com.stevensherry.httptests;

import com.stevensherry.clientclasses.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by steven.sherry on 6/21/2017.
 */
public class TestPlayground {

  public static void main(String[] args) {
    BomRequest bomRequest = new BomRequest(LocalDateTime.now().plusDays(1),"me","187523");
    CycleCountRequest cycleCountRequest = new CycleCountRequest(LocalDateTime.now().plusDays(3),"me");
    MaterialIssueRequest materialIssueRequest = new MaterialIssueRequest(LocalDateTime.now().plusDays(2),"me","2513");
    AdjustmentRequest adjustmentRequest = new AdjustmentRequest(LocalDateTime.now().plusDays(5),"me","stuff");

    ArrayList<Request> requests = new ArrayList<>();
    requests.add(bomRequest);
    requests.add(cycleCountRequest);
    requests.add(materialIssueRequest);
    requests.add(adjustmentRequest);

    for (Request request : requests) {
      System.out.println(request);
    }
    System.out.println("---------------------------------");
    Collections.sort(requests);

    for (Request request : requests) {
      System.out.println(request);
    }
  }

}

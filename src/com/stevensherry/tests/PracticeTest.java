package com.stevensherry.tests;

import com.stevensherry.clientclasses.CycleCountRequest;
import com.stevensherry.clientclasses.MaterialIssueRequest;
import com.stevensherry.clientclasses.Request;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by steven.sherry on 6/21/2017.
 */
public class PracticeTest {
  MaterialIssueRequest materialIssueRequest = new MaterialIssueRequest(LocalDateTime.of(2017,10,
          26,12,30),"me","2598");
  CycleCountRequest cycleCountRequest = new CycleCountRequest(LocalDateTime.of(2017,11,26,
          12,30), "me");
  @Test
  void checkDate() {
    LocalDateTime dateTime = materialIssueRequest.getDateRequested();
    assertEquals(LocalDateTime.of(2017,10,26,12,30),dateTime);
    assertEquals("me", materialIssueRequest.getRequestor());
    assertEquals("2598", materialIssueRequest.getWorkOrder());
    assertEquals(-1,materialIssueRequest.compareTo(cycleCountRequest));
    assertTrue(materialIssueRequest instanceof Request);
  }
}

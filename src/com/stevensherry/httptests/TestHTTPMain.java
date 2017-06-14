package com.stevensherry.httptests;

import java.io.IOException;

/**
 * Created by stevensherry on 6/13/17.
 */
public class TestHTTPMain {

  public static void main(String[] args) {
    UserLogin user = new UserLogin("admin", "INfantry030014**", "admin");
    try {
      user.login();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println(user);
    }
  }

}

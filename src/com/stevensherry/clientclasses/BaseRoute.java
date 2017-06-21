package com.stevensherry.clientclasses;

/**
 * Created by steven.sherry on 6/21/2017.
 */
public enum BaseRoute {
  ADD ("/add"),
  ADJUSTMENT ("/adjustment-request"),
  BASE_URL ("http://localhost:3005"),
  BASE_ENDPOINT ("/api/v1"),
  BOM ("/bom-request"),
  CREATE_MATERIAL ("/create-material-request"),
  CYCLE_COUNT ("/cycle-count-request"),
  ISSUE_MATERIAL ("/material-issue_request"),
  INVENTORY ("/inventory-items"),
  PURCHASE ("/purchase-request"),
  RECEIVING ("/receiving-issue"),
  USER ("/user"),
  USER_INFO ("/user-information"),
  WO_COMPLETION ("work-order-completion-request");

  private final String route;

  BaseRoute(String route) {
    this.route = route;
  }

  public String getRoute(){
    return this.route;
  }

  // Set up for basic route end-point - can be used for GET methods with no parameters
  public static String buildRoute(BaseRoute endPoint) {
    return BASE_URL.getRoute() + BASE_ENDPOINT.getRoute() + endPoint.getRoute();
  }

  // Next two methods are primarily for GET, PUT, and DELETE methods
  public static String buildRoute(BaseRoute baseRoute, String param) {
    return buildRoute(baseRoute) + "/" + param;
  }

  public static String buildRoute(BaseRoute baseRoute, String firstParam, String secondParam) {
    return buildRoute(baseRoute, firstParam) + "/" + secondParam;
  }

  //Next three methods are for POST methods
  public static String buildPostRoute(BaseRoute endPoint) {
    return buildRoute(endPoint) + ADD.getRoute();
  }

  public static String buildPostRoute(BaseRoute endPoint, String param) {
    return buildPostRoute(endPoint) + "/" + param;
  }

}

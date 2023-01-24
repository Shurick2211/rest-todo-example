package com.nimko.shppmentorpracktic7.gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class GatlingTest extends Simulation {

    HttpProtocolBuilder http = HttpDsl.http.baseUrl("http://localhost:5000");

    public GatlingTest() {
       this.setUp(Scenario.reqPostPut.injectOpen(
               CoreDsl.constantUsersPerSec(30)
                       .during(30)),
               Scenario.reqGet.injectOpen(
                       CoreDsl.constantUsersPerSec(30)
                               .during(30)
               )
       ).protocols(http);
    }
}

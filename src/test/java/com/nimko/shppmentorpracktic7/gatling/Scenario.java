package com.nimko.shppmentorpracktic7.gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;

public class Scenario {

    public static ScenarioBuilder req = CoreDsl.scenario("Request scenario")
            .exec(Steps.reqPost)
            .exec(Steps.reqPutWork)
            ;
}

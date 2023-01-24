package com.nimko.shppmentorpracktic7.gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;

public class Scenario {

    public static ScenarioBuilder reqPostPut = CoreDsl.scenario("Post & put request scenario")
            .exec(Steps.reqPost)
            .exec(Steps.reqPutWork)
            .exec(Steps.reqPutDone)
            ;

    public static ScenarioBuilder reqGet = CoreDsl.scenario("Get request scenario")
            .exec(Steps.reqGet)
            ;

    public static ScenarioBuilder reqAdmin = CoreDsl.scenario("Post-put-delete request scenario")
            .exec(Steps.reqPostAdm)
            .exec(Steps.reqPutCancelAdm)
            .exec(Steps.reqGetOne)
            .exec(Steps.reqDelete)
            ;

}

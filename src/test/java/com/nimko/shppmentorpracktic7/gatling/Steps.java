package com.nimko.shppmentorpracktic7.gatling;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpDsl;

import static io.gatling.javaapi.core.CoreDsl.StringBody;

public class Steps {
    public static ChainBuilder reqPost = CoreDsl.exec(
            HttpDsl
                    .http("post request")
                    .post("/todos")
                    .basicAuth("user","user")
                    .header("Content-type","application/json")
                    .body(StringBody("{\"to_do\": \"ring\",\"planned_date_time\":" +
                            " \"2023-02-05T15:40:15.394Z\",\"state\": \"PLANNED\"}"))
                    .check(HttpDsl.status().is(201))
    );

    public static ChainBuilder reqPutWork = CoreDsl.exec(
            HttpDsl
                    .http("put request WORK")
                    .post("/todos")
                    .basicAuth("user","user")
                    .header("Content-type","application/json")
                    .body(StringBody("{\"to_do\": \"ring\",\"planned_date_time\":" +
                            " \"2023-02-05T15:40:15.394Z\",\"state\": \"WORK_IN_PROGRESS\"}"))
                    .check(HttpDsl.status().is(201))
    );

    public static ChainBuilder reqPutDone = CoreDsl.exec(
            HttpDsl
                    .http("put request WORK")
                    .post("/todos")
                    .basicAuth("user","user")
                    .header("Content-type","application/json")
                    .body(StringBody("{\"to_do\": \"ring\",\"planned_date_time\":" +
                            " \"2023-02-05T15:40:15.394Z\",\"state\": \"DONE\"}"))
                    .check(HttpDsl.status().is(201))
    );

    public static ChainBuilder reqGet = CoreDsl.exec(
            HttpDsl
                    .http("get request")
                    .get("/todos")
                    .check(HttpDsl.status().is(200))
    );
}

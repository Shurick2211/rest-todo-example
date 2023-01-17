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
                    .body(StringBody("{\"toDo\": \"ring\",\"plannedDateTime\":" +
                            " \"2023-02-05T15:40:15.394Z\",\"state\": \"PLANNED\"}"))
                    .check(HttpDsl.status().is(201))
    );

    public static ChainBuilder reqPutWork = CoreDsl.exec(
            HttpDsl
                    .http("put request WORK")
                    .post("/todos")
                    .basicAuth("user","user")
                    .header("Content-type","application/json")
                    .body(StringBody("{\"toDo\": \"ring\",\"plannedDateTime\":" +
                            " \"2023-02-05T15:40:15.394Z\",\"state\": \"WORK_IN_PROGRESS\"}"))
                    .check(HttpDsl.status().is(201))
    );
}

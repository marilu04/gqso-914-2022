package com.danielfireman.ifal.calcapi;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;

@Path("/soma/{ops}*")
public class SomaMultiplos {

    @GET
    public double somaMultiplos(@PathParam String ops) {
        return Arrays.stream(ops.split("/"))
                .map(op -> Double.parseDouble(op))
                .reduce(0.0, (a, b) -> a + b);
    }
}

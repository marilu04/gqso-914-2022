package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/soma/{num}/{num2}")
public class Soma {

    @GET
    public double calculaSoma(@PathParam double num, @PathParam double num2) {
        try {
          return num;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetros inválidos: " + num + " " +num2);
        }
    }
}

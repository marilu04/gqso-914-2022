package com.danielfireman.ifal.calcapi;

import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class IntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void soma(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/25/25")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("50.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }

  @Test
  public void soma_erro(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/2a/2a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }

  @Test
  public void subtracao(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/subtracao/25/25")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals("0.0", rsp.body().string());
      assertEquals(StatusCode.OK.value(), rsp.code());
    }
  }

  @Test
  public void subtracao_erro(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/subtracao/2a/2b")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST.value(), rsp.code());
    }
  }
}
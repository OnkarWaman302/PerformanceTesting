package onlineBoutique;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://onlineboutique.dev")
    .inferHtmlResources(AllowList(), DenyList("", ".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/112.0");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_10 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "none"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_11 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_12 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("DNT", "1"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "cross-site"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Origin", "https://onlineboutique.dev"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private String uri1 = "https://www.google.com/complete/search";

  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .// 00_Launch
    exec(
      http("request_0")
        .get(uri1 + "?client=firefox&q=onli")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri1 + "?client=firefox&q=online")
            .headers(headers_0),
          http("request_2")
            .get(uri1 + "?client=firefox&q=onlineb")
            .headers(headers_0),
          http("request_3")
            .get(uri1 + "?client=firefox&q=onlinebo")
            .headers(headers_0),
          http("request_4")
            .get(uri1 + "?client=firefox&q=onlinebou")
            .headers(headers_0),
          http("request_5")
            .get(uri1 + "?client=firefox&q=onlinebout")
            .headers(headers_0),
          http("request_6")
            .get(uri1 + "?client=firefox&q=onlinebouti")
            .headers(headers_0),
          http("request_7")
            .get(uri1 + "?client=firefox&q=onlineboutiq")
            .headers(headers_0),
          http("request_8")
            .get(uri1 + "?client=firefox&q=onlineboutiqu")
            .headers(headers_0),
          http("request_9")
            .get(uri1 + "?client=firefox&q=onlineboutique")
            .headers(headers_0)
        )
    )
    .pause(3)
    .exec(
      http("request_10")
        .get("/")
        .headers(headers_10)
    )
    .pause(66)
    // 01_ClickOnSunglasses
    .exec(
      http("request_11")
        .get("/product/OLJCESPC7Z")
        .headers(headers_11)
    )
    .pause(14)
    .exec(
      http("request_12")
        .get("/")
        .headers(headers_12)
    )
    .pause(6)
    // 03_AddToCart
    .exec(
      http("request_13")
        .post("/cart")
        .headers(headers_13)
        .formParam("product_id", "OLJCESPC7Z")
        .formParam("quantity", "1")
    )
    .pause(18)
    // 04_ContinueShopping
    .exec(
      http("request_14")
        .get("/")
        .headers(headers_11)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}

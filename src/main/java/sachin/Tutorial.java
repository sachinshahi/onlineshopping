package sachin;

import spark.Spark;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Tutorial {
    public static void main(String[] args) {
        port(4000);

        int maxThreads = 8;
        int minThreads = 2;
        int timeOutMills = 30000;
        threadPool(maxThreads, minThreads, timeOutMills);

        // secure("ssl/keystore.jks", "password", null, null);
        staticFiles.location("/public");
        staticFiles.expireTime(600);
        staticFiles.header("key-1", "value-1");
        staticFiles.header("key-1", "New-value-1");
        staticFiles.header("key-2", "Value-2");
        staticFiles.header("key-3", "Value-3");


        get("/hello", (req, res) -> "Hello World");

        get("/hello/:name", (request, response) -> {
            return "Hello:" + request.params(":name");
        });

        get("/say/*/to/*", (req, res) -> {
            return "Number of spalt parameters: " + req.splat().length;
        });

        path("/api", () -> {
            before("/*", (q, a) -> {
                //log.info("Received api call");
            });
            path("/email", () -> {
              /* post("/add", );
               put("/change", );
               delete("/remove", );*/
            });
            path("/username", () -> {
               /* post("/add",)
                put("/change",) ;
                delete("/remove",);*/

            });
        });

        before((request, response) -> {
            boolean authenticated = true;
            if (!authenticated) {
                halt(401, "You are not welcome here");
            }
        });

        after(((request, response) -> {
            response.header("foo", "set by after filter");
        }));

        afterAfter(((request, response) -> {
            response.header("foo", "set by AfterAfter filter");
            response.header("Content-Encoding", "gzip");
        }));

        before("/protected/*", (request, response) -> {
            halt(401, "Go Away!");
        });

        notFound("<html><body><h1> Custom 404 handling </h1></body></html>");

        notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Custom 4040 \"}";
        });

        internalServerError("<html><body><h1> Custom 500 handling </h1></body></html>");

        internalServerError((req, res) -> {
            res.type("application/json");
            return "{\" message \" : \" Custom 500 handling \"}";
        });


        get("/jsonhello", "application/json", (request, response) -> {
            return new MyMessage("Hello World");
        }, new JsonTransformer());

    /* Gson gson = new Gson();
     get("/hello", ((request, response) -> {
         *//*return new sachin.MyMessage("Hello World"),gson::toJson)*//*;
     }));*/

        get("template-example", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return TemplateEngine.render(model, "path-to-template");
        });


    }
}

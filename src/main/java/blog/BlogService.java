package blog;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class BlogService {
    public static void main(String[] args) {
        port(5000);

        get("/posts", (req, res) -> {
            return "Hello Sparkingly World";
        });

        /*post("/posts", (request, response) -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                NewPostPayload creation = mapper.readValue(request.body(), NewPostPayload.class);
                if(!creation.isValid()){
                    response.status(HTTP_BAD_REQUEST);
                }
                //int id = model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories());
                response.status(200);
                response.type("application/json");
                //return id;
            } catch (JsonParseException e){

            }
        });*/
    }

}



package blog;

import lombok.Data;

import java.util.List;


@Data
public class NewPostPayload {
    private String title;
    private List categories;
    private String content;

    public boolean isValid() {
        return title != null && !title.isEmpty() && !categories.isEmpty();
    }
}

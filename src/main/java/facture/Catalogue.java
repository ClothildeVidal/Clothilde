package facture;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

    List<Article> articles = new ArrayList<>();

    public void addArticle(Article a) {
        articles.add(a);
    }

    public Article findByCode(String code) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getCode() == code) {
                return articles.get(i);
            }
        }
        return null;
    }
}

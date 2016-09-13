package com.garytokman.tokmangary_ce06.Model;

import java.util.ArrayList;
import java.util.List;

// Gary Tokman
// JAV2 - 1609
// Articles

public class Articles {

    public static List<Article> sArticles() {
        List<Article> articles = new ArrayList<>();

        articles.add(new Article("Vimeos new price tier adds plethora of features for businesses", "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2016/09/Vimeo-Business.jpg", "Vimeo is adding a new membership tier to its platform aimed at businesses looking to create high quality video content."));
        articles.add(new Article("Victim turns tables on scammer, contacts his mom on Facebook", "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2016/09/scam-troll.jpg", "When this cybersecurity researcher decided to sell his $500 Apple Store gift card on Reddit, he had no clue he'd be dealing with a serial scammer."));
        articles.add(new Article("Amazon prematurely announces a cheaper Echo Dot", "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2016/03/EchoDot_featured.jpg", "Amazon launched the Alexa-enabled Echo Dot back in March. Strangely, the unit has been listed as sold out on the firm’s website since July, which led many people to speculate that a new variant was on its way — and it’s now looking like they were right. Earlier today, Amazon prematurely fired a tweet from its official Echo Twitter …"));

        return articles;
    }

}

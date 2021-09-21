package com.guillotine.guillotine;

import com.guillotine.guillotine.models.Contributor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class ContentCreator {

    byte[] create(Contributor contributor){
        StringBuilder builder = new StringBuilder("");
        builder.append("<div>")
                    .append("\n")
                .append("<h1>").append(contributor.getUser().getlogin()).append("</h1>")
                    .append("\n")
                .append("<img src=").append(contributor.getUser().getAvatar_url()).append("></img>")
                    .append("\n")
                .append("<h1>").append("With total PRs: "+contributor.getTotalprs()).append("</h1>")
                    .append("\n")
                .append("<h2>").append("Labels used").append("</h2>")
                    .append("\n");
        if(contributor.getLabels()!=null) {
            for (int i = 0; i < contributor.getLabels().length; i++) {
                builder.append(contributor.getLabels()[i].getName())
                        .append(" : ")
                        .append(contributor.getLabels()[i].getDescription())
                        .append("\n");

            }
        } else {
            builder.append("No Labels")
                    .append("\n");
        }
               builder.append("</div>");

        return Base64.getEncoder().encode(builder.toString().getBytes(StandardCharsets.UTF_8));
    }
}

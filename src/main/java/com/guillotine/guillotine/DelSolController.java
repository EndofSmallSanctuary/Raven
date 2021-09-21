package com.guillotine.guillotine;

import com.guillotine.guillotine.models.Contributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelSolController {
    @Autowired
    ContentResolver resolver;
    @Autowired
    ContentCreator creator;


    @PostMapping("/artificialselector")
    String isDeserveSalvation(@RequestParam("masterkey")String masterkey,
                              @RequestParam("mastertail")String mastertail){

        if (masterkey.equals(Inventory.TOKEN)) {
            if(resolver.resolve(mastertail))
            return "Done";
            else return "In process";
        }
        else return  "Unknown token error";
    }

    @PostMapping("/contributor")
    byte[] contributorHtml(@RequestBody Contributor contributor){
        return creator.create(contributor);
    }
}



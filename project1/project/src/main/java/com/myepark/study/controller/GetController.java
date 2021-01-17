package com.myepark.study.controller;

import com.myepark.study.model.SearchParam;
import com.myepark.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    // localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path="/getMethod")
    public String getRequeset(){
        return "Hi getMethod";
    }

    // localhost:8080/api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter")
    public String getParameter(
            @RequestParam String id,
            @RequestParam (name = "password") String pwd
    ){
        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);

        return id + pwd;
    }

    // localhost:8080/api/getMultiParameter?account=abcd&email=com.myepark.study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public String getMultiParameter(
            SearchParam searchParam
    ){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0}
        return searchParam.toString();
    }

    @GetMapping("/header")
    public Header getHeader() {

        // {"resultCode": "OK", "description": "OK"}
        return Header.builder()
                .resultCode("OK")
                .description("OK").build();
    }

}

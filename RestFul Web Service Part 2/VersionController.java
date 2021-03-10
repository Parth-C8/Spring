package com.example.restfulWebServiceTwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    //uri version

    @GetMapping("/v1/person")
    public PersonVersionOne PersonV1() {
        return new PersonVersionOne("Parth Choudhary");
    }

    @GetMapping("/v2/person")
    public PersonVersionTwo PersonV2() {
        return new PersonVersionTwo(new Name("Parth", "Choudhary"));
    }


    //Request Parameter

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonVersionOne ParamV1() {
        return new PersonVersionOne("Parth Choudhary");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonVersionTwo Param2() {
        return new PersonVersionTwo(new Name("Parth", "Choudhary"));
    }

    //header Versioning

    @GetMapping(value = "/person/header", headers = "API-VERSION=1")
    public PersonVersionOne HeaderV1() {
        return new PersonVersionOne("Parth Choudhary");
    }

    @GetMapping(value = "/person/header", headers = "API-VERSION=2")
    public PersonVersionTwo HeaderV2() {
        return new PersonVersionTwo(new Name("Parth", "Choudhary"));
    }

    // mime type versioning

    @GetMapping(value = "/person/produce", produces = "application/vnd.company.app-v1+json")
    public PersonVersionOne ProduceV1() {
        return new PersonVersionOne("Parth Choudhary");
    }

    @GetMapping(value = "/person/produce", produces = "application/vnd.company.app-v2+json")
    public PersonVersionTwo ProduceV2() {
        return new PersonVersionTwo(new Name("Parth", "Choudhary"));
    }

}

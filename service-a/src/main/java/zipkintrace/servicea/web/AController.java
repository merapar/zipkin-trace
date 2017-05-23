package zipkintrace.servicea.web;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zipkintrace.servicea.ServiceA;
import zipkintrace.servicea.web.resources.AResource;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/v1/a")
public class AController {

    @Autowired
    private ServiceA serviceA;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HttpEntity<AResource> getA() {
        log.info("Getting A...............................................................");
        serviceA.process();
        val aResource = new AResource("test call A");
        return new ResponseEntity<>(aResource, HttpStatus.OK);
    }
}

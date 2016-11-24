package io.mycat.web.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiang on 2016/11/25 0025.
 */
@RestController
public class DBcontroll {

    @GetMapping(value = "/adddb")
    public String adddb() {
        return "adddb";
    }
}

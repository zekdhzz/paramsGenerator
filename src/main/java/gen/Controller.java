package gen;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

@RestController
public class Controller {
    private static Random RANDOM = new Random();

    @RequestMapping("/rquid")
    public String getRqUid() {
        String rqUid = new Timestamp((new Date()).getTime()).getTime() + "FF00";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (32 - rqUid.length()); i++) {
            sb.append(RANDOM.nextInt(10));
        }
        rqUid += sb.toString();
        return rqUid;
    }

    @RequestMapping("/ts")
    public String getTimestamp() {
        return String.valueOf(new Timestamp((new Date()).getTime()).getTime());
    }
}

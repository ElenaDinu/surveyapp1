package ro.elena.surveyapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChestionarHTML {

        @Autowired
        JdbcTemplate jdbcTemplate;

        @GetMapping("/save")
        public String save(@RequestParam("first_name")String newFirst_name, @RequestParam("last_name") String newLast_name, @RequestParam ("city_name") String newCity_name, @RequestParam ("email") String newEmail, @RequestParam ("INTREBARE_A") String newINTREBARE_A, @RequestParam ("INTREBARE_B") String newINTREBARE_B, @RequestParam ("INTREBARE_C") String newINTREBARE_C, @RequestParam ("INTREBARE_D") String newINTREBARE_D, @RequestParam ("INTREBARE_E") String newINTREBARE_E, @RequestParam ("RASPUNS_FREE_TEXT") String newRASPUNS_FREE_TEXT ){
            Formular formular= new Formular ();
         ;
           formular.INTREBARE_A=newINTREBARE_A;
           formular.INTREBARE_B = newINTREBARE_B;
            formular.INTREBARE_C =newINTREBARE_C;
            formular.INTREBARE_D = newINTREBARE_D;
            formular.INTREBARE_E =newINTREBARE_E;
            formular.RASPUNS_FREE_TEXT = newRASPUNS_FREE_TEXT;

            jdbcTemplate.update ("insert into survey2.raspunsuri values (null, NOW(), ?, ?, ? ,?,?,?)",    newINTREBARE_A, newINTREBARE_B,  newINTREBARE_C, newINTREBARE_D, newINTREBARE_E, newRASPUNS_FREE_TEXT);
            return "redirect:http://localhost:8080/users.html";
        }

    }


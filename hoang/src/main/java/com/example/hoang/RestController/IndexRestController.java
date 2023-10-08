package com.example.hoang.RestController;

import com.example.hoang.DTO.LoginInfoDTO;
import com.example.hoang.DTO.SignUpDTO;
import com.example.hoang.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {
    @Autowired
    private LoginService ls;

    @PostMapping("/loginEncodeRest")
    @ResponseBody
    public String LoginEncode(@RequestBody LoginInfoDTO loginInf) {
        String hoang = ls.LoginEncode(loginInf);
        return hoang;
    }

    @PostMapping("/SignupRest")
    @ResponseBody
    public ResponseEntity<Object> Signup(@RequestBody SignUpDTO signupDTO) {
        String rs = ls.Signup(signupDTO);
        if (rs.contains("Error")){
            return new ResponseEntity<>("Sign up fail", HttpStatus.EXPECTATION_FAILED);
        } else{
            return new ResponseEntity<>("Sign up success", HttpStatus.OK);
        }

    }
}

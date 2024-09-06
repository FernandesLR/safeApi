package com.safeapi.safeapi.controller;


import com.safeapi.safeapi.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordController {

    @Autowired
    private PasswordService passService;

    @PostMapping("/password-validate")
    public ResponseEntity<String> validatePassword(@RequestBody BodyRequest request) { // instancia um objeto e passa para um record para facilitar a manipulação dos dados.
        System.out.println(request);
        var faills = passService.validatePass(request.password()); // passa para um método principal que vai validar a senha
        if(faills.isEmpty()){
            return ResponseEntity.ok(faills.toString());
        }

        return ResponseEntity.ok().build();
    }

}

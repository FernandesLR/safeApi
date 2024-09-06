package com.safeapi.safeapi.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {


    public List<String> validatePass(String pass){
        ArrayList<String> faillures = new ArrayList<>();

        checkLength(pass, faillures);
        checkCapitalKey(pass, faillures);



        return faillures;

    }

    public void checkLength(String pass, List<String> listFaills){

        if(pass.length() <= 8){
            listFaills.add("A senha deve possuir pelo menos 8 caracteres.");
            System.out.println("print função checkLength. resultado: " + listFaills);
        }else{
            System.out.println("Não entrou no if");
        }

    }

    public void checkCapitalKey(String pass, List<String> listFaills){
        boolean isCapital = false;

        for(int i=0; i<pass.length(); i++){
            if(Character.isUpperCase(pass.charAt(i))){
                isCapital = true;
                break;
            }
        }
        if(!isCapital) {
            listFaills.add("a senha deve conter pelo menos uma letra maiúscula.");
        }
        System.out.println("print da função checkCapitalKey. resultado: " + listFaills);
    }
}

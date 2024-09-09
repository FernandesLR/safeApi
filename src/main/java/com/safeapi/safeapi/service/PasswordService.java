package com.safeapi.safeapi.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {


    public List<String> validatePass(String pass){
        ArrayList<String> faillures = new ArrayList<>();

        checkLength(pass, faillures);
        checkUpperCase(pass, faillures);
        checkLowerCase(pass, faillures);
        checkNumber(pass, faillures);
        checkSpecialCharacter(pass, faillures);



        return faillures;

    }

    public void checkLength(String pass, List<String> listFaills){

        if(pass.length() <= 8){
            listFaills.add("A senha deve possuir pelo menos 8 caracteres.");
            System.out.println("print função checkLength. resultado: " + listFaills);
        }

    }

    private void checkUpperCase(String pass, List<String> listFaills){
        if(!Pattern.matches(".*[A-Z].*", pass)){
            listFaills.add("A senha deve possuir pelo menos uma letra maiúscula");
        }else{
            System.out.println("Não entrou no if 1");
        }
    }

    private void checkLowerCase(String pass, List<String> listFails){
        if(!(Pattern.matches(".*[a-z].*", pass))) {
            listFails.add("A senha deve conter pelo menos uma letra minúscula.");
        }else{
            System.out.println("Não entrou no if 2");
        }
    }
    private void checkNumber(String pass, List<String> listFails){
        if(!Pattern.matches(".*[0-9].*", pass)){
            listFails.add("A senha conter pelo menos um dígito numérico.");
        }
    }
    private void checkSpecialCharacter(String pass, List<String> listFails){
        if(!Pattern.matches(".*[\\W].*", pass)){
            listFails.add("A senha conter pelo menos um caractere especial (e.g, !@#$%).");
        }
    }

}

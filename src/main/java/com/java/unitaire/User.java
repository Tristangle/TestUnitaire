package com.java.unitaire;

import com.sun.management.UnixOperatingSystemMXBean;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
@Entity
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;
    private String email;
    private String nom;
    private String prenom;
    private String motDePasse;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", unique = true)
    @Getter
    private ToDoList toDoList;

    private LocalDate dateNaissance;

    private LocalDate date = LocalDate.now();

    public User(String email, String nom, String prenom,String motDePasse, LocalDate dateNaissance, LocalDate date, ToDoList toDoList){
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.date = date;
        this.toDoList = toDoList;
    }

    public User() {

    }

    public static boolean contientMinuscule(String motDePasse) {
        for (int i = 0; i < motDePasse.length(); i++) {
            if (Character.isLowerCase(motDePasse.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean contientMajuscule(String motDePasse) {
        for (int i = 0; i < motDePasse.length(); i++) {
            if (Character.isUpperCase(motDePasse.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean contientChiffre(String motDePasse) {
        for (int i = 0; i < motDePasse.length(); i++) {
            if (Character.isDigit(motDePasse.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public boolean isValidPassword(){
        if(this.motDePasse.isEmpty()){
            return false;
        }
        else if(this.motDePasse.length() <= 8 || this.motDePasse.length()>= 40){
            return false;
        }
        else if(!(contientMinuscule(this.motDePasse) && contientMajuscule(this.motDePasse))){
            return false;
        }
        else if(!contientChiffre(this.motDePasse)){
            return false;
        }
        return true;
    }


    public boolean isValid(){
        if(this.email.isEmpty()){
            return false;
        }
        if(!this.email.contains("@") || !this.email.contains(".")){
            return false;
        }
        if(this.nom.isEmpty()){
            return false;
        }
        if(this.prenom.isEmpty()){
            return false;
        }
        if(!isValidPassword()){
            return false;
        }
        if(dateNaissance.isAfter(date.minusYears(13))){
            return false;
        }

        return true;
    }

}

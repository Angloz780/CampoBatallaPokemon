package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class HelloController2 {

    Pokemon pokemonSeleccionado;
    Pokemon2 oponente;

    ArrayList <Pokemon2> ListaPokemon = new ArrayList<>();

    Fondo f1 = new Fondo(new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\Campo_de_batalla_DPPt_2.png"));

    Pokemon2 p21 = new Pokemon2("Mienshao", 248f, 248f, "LV.65", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\mienshao.gif"));
    Pokemon2 p22 = new Pokemon2("Decidueye", 267f, 267f, "Lv.45", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\decidueye.gif"));
    Pokemon2 p23 = new Pokemon2("Braviary", 300f, 300f,"Lv.50", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\braviary.gif"));
    Pokemon2 p24 = new Pokemon2("Lugia", 340f, 340f, "Lv.75", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\lugia.gif"));

    @FXML
    ImageView fondoInterfaz;

    @FXML
    AnchorPane btPrincipales;
    @FXML
    Button btCurar;
    @FXML
    Button btAtacar;

    @FXML
    AnchorPane btSecundarios;
    @FXML
    Button btAtaque1;
    @FXML
    Button btAtaque2;
    @FXML
    Button btAtaque3;
    @FXML
    Button btCancelar;

    @FXML
    ImageView miPokemon;
    @FXML
    Label nombreAliado;
    @FXML
    Label nivelAliado;
    @FXML
    ProgressBar vidaAliado;
    @FXML
    AnchorPane panelAliado;
    @FXML
    Text PSAliado;

    @FXML
    ImageView pokemonEnemigo;
    @FXML
    Label nombreEnemigo;
    @FXML
    Label nivelEnemigo;
    @FXML
    ProgressBar vidaEnemigo;
    @FXML
    AnchorPane panelEnemigo;
    @FXML
    Text PSEnemigo;

    private HelloController HelloController;

    public void Pokemones(Pokemon pokemonSeleccionado) {

        Image fond1 = new Image(f1.fondo1.toURI().toString());
        fondoInterfaz.setImage(fond1);

        this.pokemonSeleccionado = pokemonSeleccionado;

        Image imagen1 = new Image(pokemonSeleccionado.imagen.toURI().toString());
        miPokemon.setImage(imagen1);
        nombreAliado.setText(pokemonSeleccionado.pokemon);
        nivelAliado.setText(pokemonSeleccionado.nivel);
        vidaAliado.setProgress(1.0f);

        ListaPokemon.add(p21);
        ListaPokemon.add(p22);
        ListaPokemon.add(p23);
        ListaPokemon.add(p24);

        oponente = ListaPokemon.get((int) (Math.random() * ListaPokemon.size()));

        Image imagen2 = new Image(oponente.imagen2.toURI().toString());
        pokemonEnemigo.setImage(imagen2);
        nombreEnemigo.setText(oponente.pokemon2);
        vidaEnemigo.setProgress(1.0f);
        nivelEnemigo.setText(oponente.nivel2);

        btAtaque1.setVisible(false);
        btAtaque2.setVisible(false);
        btAtaque3.setVisible(false);
        btCancelar.setVisible(false);

    }

    @FXML
    protected void btAtaques() {

        System.out.println("BotonAtaqueSeleccionado");
        btAtacar.setVisible(false);
        btCurar.setVisible(false);
        btAtaque1.setVisible(true);
        btAtaque2.setVisible(true);
        btAtaque3.setVisible(true);
        btCancelar.setVisible(true);

    }

    @FXML
    protected void subirVida() {

        System.out.println("BotonVidaSeleccionado");
        Random r = new Random();

        int rdmVida = r.nextInt(50) + 25;
        pokemonSeleccionado.vida += rdmVida;
        vidaAliado.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("Curacion1 de " + rdmVida);

        rdmVida = r.nextInt(50) + 25;
        oponente.vida2 += rdmVida;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("Curacion2 de " + rdmVida);
    }

    @FXML
    protected void btSeguro() {

        int danoSeguro = 20;

        System.out.println("BotonSeguroSeleccionado");

        pokemonSeleccionado.barra -= danoSeguro;
        vidaAliado.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("Daño seguro1 de " + danoSeguro);
        controlarDeLaVidaAliado();

        oponente.vida2 -= danoSeguro;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("Daño seguro2 de " + danoSeguro);
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btArriesgado() {

        System.out.println("BotonArriesgadoSeleccionado");
        Random r = new Random();

        int rdmArriesgado = r.nextInt(15) + 10;
        pokemonSeleccionado.barra-= rdmArriesgado;
        vidaAliado.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("Daño arriesgado1 de " + rdmArriesgado);
        controlarDeLaVidaAliado();

        rdmArriesgado = r.nextInt(15) + 10;
        oponente.vida2 -= rdmArriesgado;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("Daño arriesgado2 de " + rdmArriesgado);
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btMuyArriesgado() {

        System.out.println("BotonMuyArriesgadoSeleccionado");
        Random r = new Random();

        int rdmMuyArriesgado = r.nextInt(50);
        pokemonSeleccionado.barra -= rdmMuyArriesgado;
        vidaAliado.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("Daño muy arriesgado1 de " + rdmMuyArriesgado);
        controlarDeLaVidaAliado();

        rdmMuyArriesgado = r.nextInt(50);
        oponente.vida2 -= rdmMuyArriesgado;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("Daño muy arriesgado2 de " + rdmMuyArriesgado);
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btCancelar() {

        System.out.println("BotonCancelarSeleccionado");
        btAtacar.setVisible(true);
        btCurar.setVisible(true);
        btAtaque1.setVisible(false);
        btAtaque2.setVisible(false);
        btAtaque3.setVisible(false);
        btCancelar.setVisible(false);

    }

    @FXML
    protected void cambiartextoEnemigo() {
        PSEnemigo.setText(String.valueOf(oponente.vida2));
    }

    @FXML
    protected void cambiartextoEnemigo2() {
        PSEnemigo.setText("PS");
    }

    @FXML
    protected void cambiartextoAliado() {
        PSAliado.setText(String.valueOf(pokemonSeleccionado.vida));
    }

    @FXML
    protected void cambiartextoAliado2() {
        PSAliado.setText("PS");
    }

    private void controlarDeLaVidaAliado () {

        if (pokemonSeleccionado.vida == 0) {
            showAlert1(alertaPokemonAliado(pokemonSeleccionado));
        }
    }

    private void controlarDeLaVidaEnemigo() {

        if (oponente.vida2 == 0) {
            showAlert2(alertaPokemonEnemigo(oponente));
        }

    }

    private void showAlert1(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.OK) {
            HelloController.stage2.close();
            HelloController.actualizarInterfaz(pokemonSeleccionado);
        }else{
            System.exit(0);
        }
    }
    private void showAlert2(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.OK) {

            HelloController.stage2.close();
            HelloController.actualizarInterfaz(pokemonSeleccionado);

        }else{
            System.exit(0);
        }
    }


    public Alert alertaPokemonEnemigo(Pokemon2 oponente) {

        Alert customAlert = new Alert(Alert.AlertType.NONE);

        customAlert.setTitle("Pokemon Ganador");
        customAlert.setContentText("El pokemon ganador es " +oponente.pokemon2);
        customAlert.setGraphic(new ImageView(new Image(oponente.imagen2.toURI().toString())));
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CLOSE);
        showAlert1(customAlert);

        return customAlert;

    }

    public Alert alertaPokemonAliado(Pokemon pokemonSeleccionado) {

        Alert customAlert = new Alert(Alert.AlertType.NONE);

        customAlert.setTitle("Pokemon Ganador");
        customAlert.setContentText("El pokemon ganador es " +pokemonSeleccionado.pokemon);
        customAlert.setGraphic(new ImageView(new Image(pokemonSeleccionado.imagen.toURI().toString())));
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CANCEL);
        showAlert2(customAlert);

        return customAlert;

    }

    void enviarDatos(HelloController HelloController){
        this.HelloController=HelloController;
    }

}

class Pokemon2 {

    String pokemon2;
    Float barra2;
    Float vida2;
    String nivel2;
    File imagen2;
    String tipo2;

    Pokemon2(String pokemon2, Float barra2, Float vida2, String nivel2, File imagen2) {
        this.pokemon2 = pokemon2;
        this.barra2 = barra2;
        this.vida2 = vida2;
        this.nivel2 = nivel2;
        this.imagen2 = imagen2;
        this.tipo2 = tipo2;
    }
}

class Fondo {

    File fondo1;

    public Fondo(File fondo1) {
        this.fondo1 = fondo1;
    }

}



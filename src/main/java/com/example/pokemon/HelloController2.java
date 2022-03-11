package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class HelloController2 {

    Pokemon pokemonSeleccionado;
    Pokemon2 oponente;

    ArrayList <Pokemon2> ListaPokemon = new ArrayList<>();

    Fondo f1 = new Fondo(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\campo.png"));

    Pokemon2 p7 = new Pokemon2("Drampa", 360f, 360f, "LV.65", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\drampa.gif"));
    Pokemon2 p8 = new Pokemon2("Melmetal", 474f, 474f, "Lv.45", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\melmetal.gif"));
    Pokemon2 p9 = new Pokemon2("Toxtricity", 354f, 354f,"Lv.50", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\toxtricity.gif"));
    Pokemon2 p10 = new Pokemon2("Lugia", 416f, 416f, "Lv.75", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\lugia.gif"));

    //Imagen campo de batalla
    @FXML
    ImageView fondoInterfaz;

    //Botones curar y atacar
    @FXML
    AnchorPane btsPrin;
    @FXML
    Button btCurar;
    @FXML
    Button btAtacar;
    @FXML
    Button btMochila;

    //Botones de ataque y cancelar
    @FXML
    AnchorPane btsSecun;
    @FXML
    Button ataqueSeguro;
    @FXML
    Button ataqueArriesgado;
    @FXML
    Button atqueMuyArriesgado;
    @FXML
    Button cancelar;

    //Datos mi Pokemon elegido
    @FXML
    ImageView miPokemon;
    @FXML
    Label nomMiPokemon;
    @FXML
    Label nvlMiPokemon;
    @FXML
    ProgressBar vidaMiPokemon;
    @FXML
    AnchorPane panelMiPokemon;
    @FXML
    Text PsMiPokemon;

    //Datos Pokemon enemigo
    @FXML
    ImageView enemigo;
    @FXML
    Label nomEnemigo;
    @FXML
    Label nvlEnemigo;
    @FXML
    ProgressBar vidaEnemigo;
    @FXML
    AnchorPane panelEnemigo;
    @FXML
    Text PsEnemigo;

    private HelloController HelloController;

    public void Pokemones(Pokemon pokemonSeleccionado) {

        Image fond1 = new Image(f1.fondo1.toURI().toString());
        fondoInterfaz.setImage(fond1);

        this.pokemonSeleccionado = pokemonSeleccionado;

        Image imagen1 = new Image(pokemonSeleccionado.imagen2.toURI().toString());
        miPokemon.setImage(imagen1);
        nomMiPokemon.setText(pokemonSeleccionado.pokemon);
        nvlMiPokemon.setText(pokemonSeleccionado.nivel);
        vidaMiPokemon.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);

        //Mienshao
        ListaPokemon.add(p7);
        //Decidueye
        ListaPokemon.add(p8);
        //Braviary
        ListaPokemon.add(p9);
        //Lugia
        ListaPokemon.add(p10);

        oponente = ListaPokemon.get((int) (Math.random() * ListaPokemon.size()));

        Image imagen2 = new Image(oponente.imagen2.toURI().toString());
        enemigo.setImage(imagen2);
        nomEnemigo.setText(oponente.pokemon2);
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        nvlEnemigo.setText(oponente.nivel2);

        //Ataque seguro
        ataqueSeguro.setVisible(false);
        //Ataque arriesgado
        ataqueArriesgado.setVisible(false);
        //Ataque muy arriesgado
        atqueMuyArriesgado.setVisible(false);
        //Cancelar
        cancelar.setVisible(false);
        //Boton Mochila
        btMochila.setVisible(false);

    }

    @FXML
    protected void btAtaques() {

        System.out.println("Boton de ataque seleccionado");
        btAtacar.setVisible(false);
        btCurar.setVisible(false);
        ataqueSeguro.setVisible(true);
        ataqueArriesgado.setVisible(true);
        atqueMuyArriesgado.setVisible(true);
        cancelar.setVisible(true);
        btMochila.setVisible(true);

    }

    @FXML
    protected void subirVida() {

        System.out.println("Boton de subir vida seleccionado");
        Random r = new Random();

        int rdmVida = r.nextInt(50) + 25;
        pokemonSeleccionado.vida += rdmVida;
        vidaMiPokemon.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("Curacion num1 de " + rdmVida);
        HelloController.actualizarInterfaz();

        rdmVida = r.nextInt(50) + 25;
        oponente.vida2 += rdmVida;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("Curacion num2 de " + rdmVida);
    }

    @FXML
    protected void btSeguro() {

        int danoSeguro = 20;

        System.out.println("Boton de ataque seguro seleccionado");

        pokemonSeleccionado.vida -= danoSeguro;
        vidaMiPokemon.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("El ataque seguro1 ha hecho " + danoSeguro +"ps de dano");
        HelloController.actualizarInterfaz();
        controlarDeLaVidaAliado();

        oponente.vida2 -= danoSeguro;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("El ataque seguro2 ha hecho " + danoSeguro +"ps de dano");
        controlarDeLaVidaEnemigo();
    }

    @FXML
    protected void btArriesgado() {

        System.out.println("Boton de ataque arriesgado seleccionado");
        Random r = new Random();

        int rdmArriesgado = r.nextInt(15) + 10;
        pokemonSeleccionado.vida -= rdmArriesgado;
        vidaMiPokemon.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("El ataque arriesgado num1 ha hecho " + rdmArriesgado+"ps de dano");
        HelloController.actualizarInterfaz();
        controlarDeLaVidaAliado();

        rdmArriesgado = r.nextInt(15) + 10;
        oponente.vida2 -= rdmArriesgado;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("El ataque arriesgado num2 ha hecho " + rdmArriesgado+"ps de dano");
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btMuyArriesgado() {

        System.out.println("Boton de ataque muy arriesgado seleccionado");
        Random r = new Random();

        int rdmMuyArriesgado = r.nextInt(50);
        pokemonSeleccionado.vida -= rdmMuyArriesgado;
        vidaMiPokemon.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
        System.out.println("El ataque muy arriesgado num1 ha hecho " + rdmMuyArriesgado+"ps de dano");
        HelloController.actualizarInterfaz();
        controlarDeLaVidaAliado();

        rdmMuyArriesgado = r.nextInt(50);
        oponente.vida2 -= rdmMuyArriesgado;
        vidaEnemigo.setProgress(oponente.vida2 / oponente.barra2);
        System.out.println("El ataque muy arriesgado num2 ha hecho " + rdmMuyArriesgado+"ps de dano");
        controlarDeLaVidaEnemigo();

    }

    @FXML
    protected void btCancelar() {

        System.out.println("Boton de cancelar seleccionado");
        btAtacar.setVisible(true);
        btCurar.setVisible(true);
        ataqueSeguro.setVisible(false);
        ataqueArriesgado.setVisible(false);
        atqueMuyArriesgado.setVisible(false);
        cancelar.setVisible(false);
        btMochila.setVisible(false);

    }

    Stage stage3;
    HelloControllerMochila v = null;

    @FXML
    protected void botonMochila(){

        System.out.println("Boton pulsado pasamos a la pantalla de mochila");

        try {

            if (stage3 == null || !stage3.isShowing()) {

                stage3 = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Mochila.fxml"));

                AnchorPane root = loader.load();
                Scene scene = new Scene(root, 594, 502);

                stage3.setScene(scene);
                stage3.show();
                v = loader.getController();

                v.initialize(pokemonSeleccionado);
                v.enviarDatos2(this);

            }

            v.initialize(pokemonSeleccionado);
            v.enviarDatos2(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void cambiartextoEnemigo() {
        PsEnemigo.setText(String.valueOf(oponente.vida2));
    }

    @FXML
    protected void cambiartextoEnemigo2() {
        PsEnemigo.setText("PS");
    }

    @FXML
    protected void cambiartextoAliado() {PsMiPokemon.setText(String.valueOf(pokemonSeleccionado.vida));}

    @FXML
    protected void cambiartextoAliado2() {
        PsMiPokemon.setText("PS");
    }

    private void controlarDeLaVidaAliado () {

        if (pokemonSeleccionado.vida <= 0) {
            showAlert1(alertaPokemonAliado(oponente));
        }
    }

    private void controlarDeLaVidaEnemigo() {

        if (oponente.vida2 <= 0) {
            showAlert2(alertaPokemonEnemigo(pokemonSeleccionado));
        }

    }

    private void showAlert1(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.NO) {
            System.exit(0);
        }else{
            HelloController.stage2.close();
        }
    }
    private void showAlert2(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.NO) {
            System.exit(0);
        }else{
            HelloController.stage2.close();
        }
    }

    public Alert alertaPokemonEnemigo(Pokemon pokemonSeleccionado) {

        Alert customAlert = new Alert(Alert.AlertType.NONE);

        customAlert.setTitle("Pokemon Ganador");
        customAlert.setContentText("El pokemon ganador es " +pokemonSeleccionado.pokemon);
        customAlert.setGraphic(new ImageView(new Image(pokemonSeleccionado.imagen.toURI().toString())));
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CLOSE);
        showAlert1(customAlert);

        return customAlert;
    }

    public Alert alertaPokemonAliado(Pokemon2 oponente) {

        Alert customAlert = new Alert(Alert.AlertType.NONE);

        customAlert.setTitle("Pokemon Ganador");
        customAlert.setContentText("El pokemon ganador es " +oponente.pokemon2);
        customAlert.setGraphic(new ImageView(new Image(oponente.imagen2.toURI().toString())));
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.NEXT, ButtonType.CLOSE);
        showAlert2(customAlert);

        return customAlert;
    }

    void enviarDatos(HelloController HelloController){
        this.HelloController=HelloController;
    }

    public void actualizarInterfaz2() {
        vidaMiPokemon.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
    }
}

class Pokemon2 {

    String pokemon2;
    Float barra2;
    Float vida2;
    String nivel2;
    File imagen2;

    Pokemon2(String pokemon2, Float barra2, Float vida2, String nivel2, File imagen2) {
        this.pokemon2 = pokemon2;
        this.barra2 = barra2;
        this.vida2 = vida2;
        this.nivel2 = nivel2;
        this.imagen2 = imagen2;
    }
}

class Fondo {

    File fondo1;

    public Fondo(File fondo1) {
        this.fondo1 = fondo1;
    }

}



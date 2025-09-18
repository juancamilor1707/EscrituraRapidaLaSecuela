package com.example.escriturarapida.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Word {

    private final List<String> easy;
    private final List<String> medium;
    private final List<String> hard;

    public Word() {
        easy = new ArrayList<>(Arrays.asList(
                "casa", "perro", "gato", "sol", "coche", "árbol", "libro", "lápiz", "taza", "pan",
                "mesa", "silla", "puerta", "ventana", "luz", "mano", "pie", "agua", "leche", "pez",
                "pájaro", "camino", "tren", "bus", "reloj", "teléfono", "llave", "zapato", "bolsa", "sombrero",
                "manzana", "pera", "uva", "plátano", "naranja", "sal", "azúcar", "arroz", "carne", "huevo",
                "pelota", "juego", "estrella", "cielo", "lluvia", "viento", "fuego", "nieve", "pared", "suelo"
        ));

        medium = new ArrayList<>(Arrays.asList(
                "montaña", "río", "bosque", "puente", "pueblo", "escuela", "mercado", "castillo", "palacio", "jardín",
                "cuadro", "espejo", "cristal", "profesor", "alumno", "botella", "pluma", "cuaderno", "computadora", "impresora",
                "elefante", "jirafa", "canguro", "tortuga", "delfín", "loro", "gorrión", "mono", "conejo", "león",
                "motor", "escalera", "bicicleta", "cámara", "bolsillo", "cartera", "boleto", "viaje", "puerto", "estación",
                "invierno", "verano", "primavera", "otoño", "tormenta", "trueno", "relámpago", "lágrima", "océano", "isla"
        ));

        hard = new ArrayList<>(Arrays.asList(
                "inverosímil", "electroencefalografía", "otorrinolaringología", "paralelepípedo", "transustanciación",
                "esternocleidomastoideo", "desoxirribonucleico", "anticonstitucional", "interdisciplinario", "extraordinario",
                "sobresdrújula", "antropomorfismo", "hipopotomonstrosesquipedaliofobia", "criptografía", "idiosincrasia",
                "hegemonía", "contemporáneo", "arqueología", "filantropía", "metamorfosis",
                "endocrinología", "procrastinación", "biodegradable", "desencriptar", "fotovoltaico",
                "espectroelectromagnético", "neuroplasticidad", "polimorfismo", "onomatopeya", "paradigma",
                "homeostasis", "apendicectomía", "tridimensional", "heterogéneo", "inconmensurable",
                "constitucionalismo", "desoxirribosa", "intertextualidad", "oxímoron", "parafrasear",
                "transcendental", "circunferencia", "epistemología", "isósceles", "anacronismo",
                "desmitificación", "hipérbaton", "cosmogonía", "sinestesia", "ontología"
        ));

        Collections.shuffle(easy);
        Collections.shuffle(medium);
        Collections.shuffle(hard);
    }

    public List<String> getEasy() {
        return easy;
    }

    public List<String> getMedium() {
        return medium;
    }

    public List<String> getHard() {
        return hard;
    }
}

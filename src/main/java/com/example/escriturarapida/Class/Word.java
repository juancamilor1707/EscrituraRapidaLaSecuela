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
                "abrigo", "cóndor", "escápula", "pintura", "telescopio", "alfombra", "murciélago", "relojera", "sándwich", "paraguas",
                "bicicleta", "ventilador", "escalera", "almohada", "panadería", "mariposa", "libélula", "reloj", "fósforo", "candelabro",
                "muralla", "pintor", "globo", "camiseta", "corredor", "mapache", "lámpara", "cárcel", "rascacielos", "murmullo",
                "carretera", "alfiler", "cuchara", "esmalte", "plátano", "bicicleta", "pingüino", "estrella", "espátula", "cuaderno",
                "jirafa", "lápiz", "fotografía", "lavadora", "computadora", "teléfono", "murciélago", "paraguas", "ventana", "teclado"
        ));

        // Nivel medio
        medium = new ArrayList<>(Arrays.asList(
                "hipopótamo", "ornitorrinco", "zoológico", "extraordinario", "transatlántico", "anticonstitucional", "paralelepípedo", "cristalografía", "electrodoméstico", "conmutador",
                "cancillería", "reivindicación", "fotolitografía", "perspectiva", "contrarrevolución", "desoxirribonucleico", "polimorfismo", "cibernético", "paradójico", "hiperactividad",
                "neumonoultramicroscopicosilicovolcanoconiosis", "incomprensible", "transeúnte", "reconocimiento", "inconstitucional", "desafortunadamente", "subterráneo", "extraterrestre", "inmortalidad", "retroalimentación",
                "biodegradable", "electroencefalograma", "microorganismo", "cuantificación", "antropomórfico", "inverosímil", "hipersensibilidad", "contemporáneo", "transcripción", "fotovoltaico",
                "paralelepípedo", "metamorfosis", "desoxirribonucleótido", "neurociencia", "catalizador", "contradicción", "hipotéticamente", "aceleración", "subestimación", "antropológico"
        ));

        // Nivel hard
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
                "desmitificación", "hipérbaton", "cosmogonía", "sinestesia", "ontología",
                "autopoiesis", "neurocognitivo", "paleontología", "fisiopatología", "antropocentrismo",
                "electrocardiograma", "microscopía", "bioinformática", "paradiplomacia", "fenomenología",
                "biocompatibilidad", "microbiología", "electromagnetismo", "termodinámica", "hiperconectividad"
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

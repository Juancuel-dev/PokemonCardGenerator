package es.agora.pokemoncardcreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PokemonRepository {
    private ArrayList<Pokemon> lista1;
    private ArrayList<Pokemon> lista2;
    private ArrayList<Pokemon> lista3;
    private HashMap<Integer, Pokemon> equipo;
    private static PokemonRepository instance;

    private PokemonRepository() {

        this.lista1 = new ArrayList<>();
        this.lista2 = new ArrayList<>();
        this.lista3 = new ArrayList<>();

        this.equipo = new HashMap<>();

        this.lista1.add(new Pokemon("001", "Bulbasaur", new ArrayList<>(List.of(Tipo.Planta, Tipo.Veneno)), "Tras nacer, crece alimentándose durante un tiempo de los nutrientes que contiene el bulbo de su lomo.", "res/drawable/p001.png"));
        this.lista2.add(new Pokemon("002", "Ivysaur", new ArrayList<>(List.of(Tipo.Planta, Tipo.Veneno)), "Cuanta más luz solar recibe, más aumenta su fuerza y más se desarrolla el capullo que tiene en el lomo.", "res/drawable/p002.png"));
        this.lista3.add(new Pokemon("003", "Venusaur", new ArrayList<>(List.of(Tipo.Planta, Tipo.Veneno)), "Puede convertir la luz del sol en energía. Por esa razón, es más poderoso en verano.", "res/drawable/p003.png"));
        this.lista1.add(new Pokemon("004", "Charmander", new ArrayList<>(List.of(Tipo.Fuego)), "La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenue.", "res/drawable/p004.png"));
        this.lista2.add(new Pokemon("005", "Charmeleon", new ArrayList<>(List.of(Tipo.Fuego)), "Al agitar su ardiente cola, eleva poco a poco la temperatura a su alrededor para sofocar a sus rivales.", "res/drawable/p005.png"));
        this.lista3.add(new Pokemon("006", "Charizard", new ArrayList<>(List.of(Tipo.Fuego, Tipo.Volador)), "Cuando se enfurece de verdad, la llama de la punta de su cola se vuelve de color azul claro.", "res/drawable/p006.png"));
        this.lista1.add(new Pokemon("007", "Squirtle", new ArrayList<>(List.of(Tipo.Agua)), "Tras nacer, se le hincha el lomo y se le forma un caparazón. Escupe poderosa espuma por la boca.", "res/drawable/p007png"));
        this.lista2.add(new Pokemon("008", "Wartortle", new ArrayList<>(List.of(Tipo.Agua)), "Tiene una cola larga y peluda que simboliza la longevidad y lo hace popular entre los mayores.", "res/drawable/p008.png"));
        this.lista3.add(new Pokemon("009", "Blastoise", new ArrayList<>(List.of(Tipo.Agua)), "Aumenta de peso deliberadamente para contrarrestar la fuerza de los chorros de agua que dispara. ", "res/drawable/p009.png"));

        this.lista1.add(new Pokemon("152", "Chikorita", new ArrayList<>(List.of(Tipo.Planta)), "Le encanta tomar el sol. Usa la hoja que tiene en la cabeza para localizar sitios cálidos.", "res/drawable/p152.png"));
        this.lista2.add(new Pokemon("153", "Bayleef", new ArrayList<>(List.of(Tipo.Planta)), "Su cuello desprende un aroma especiado que, por alguna razón, incita a combatir a quienes lo huelen.", "res/drawable/p153.png"));
        this.lista3.add(new Pokemon("154", "Meganium", new ArrayList<>(List.of(Tipo.Planta)), "Estar a su lado produce una sensación de frescor similar a la de un relajante paseo por el bosque.", "res/drawable/p154.png"));
        this.lista1.add(new Pokemon("155", "Cyndaquil", new ArrayList<>(List.of(Tipo.Fuego)), "Suele estar encorvado. Si se enfada o se asusta, lanzará llamas por el lomo. ", "res/drawable/p155.png"));
        this.lista2.add(new Pokemon("156", "Quilava", new ArrayList<>(List.of(Tipo.Fuego)), "Antes de empezar a luchar, le da la espalda al rival para alardear del alcance y la fuerza de sus llamas.", "res/drawable/p156.png"));
        this.lista3.add(new Pokemon("157", "Typhlosion", new ArrayList<>(List.of(Tipo.Fuego)), "Posee una técnica secreta y devastadora que consiste en atacar frotando su pelaje ardiente para provocar explosiones.", "res/drawable/p157.png"));
        this.lista1.add(new Pokemon("158", "Totodile", new ArrayList<>(List.of(Tipo.Agua)), "Sus desarrolladas y potentes mandíbulas pueden triturar cualquier cosa, por lo que hasta su propio Entrenador debe andarse con cuidado.", "res/drawable/p158.png"));
        this.lista2.add(new Pokemon("159", "Croconaw", new ArrayList<>(List.of(Tipo.Agua)), "Sus colmillos están curvados hacia dentro, por lo que, una vez que muerde a una presa, esta no tiene forma de escapar.", "res/drawable/p159.png"));
        this.lista3.add(new Pokemon("160", "Feraligatr", new ArrayList<>(List.of(Tipo.Agua)), "Tras morder a su víctima con sus enormes y potentes mandíbulas, agita la cabeza con fuerza para despedazarla.", "res/drawable/p160.png"));

        this.lista1.add(new Pokemon("252", "Treeko", new ArrayList<>(List.of(Tipo.Planta)), "Tiene pequeñas púas en las plantas de los pies que le permiten andar por techos y paredes sin caerse", "res/drawable/p252.png"));
        this.lista2.add(new Pokemon("253", "Grovyle", new ArrayList<>(List.of(Tipo.Planta)), "Los desarrollados músculos de sus extremidades inferiores le proporcionan una tremenda agilidad y una portentosa capacidad de salto.", "res/drawable/p253.png"));
        this.lista3.add(new Pokemon("254", "Sceptile", new ArrayList<>(List.of(Tipo.Planta)), "Corretea ágil y veloz por la selva y emplea las afiladas hojas de sus brazos para darles el golpe de gracia a sus presas.", "res/drawable/p254.png"));
        this.lista1.add(new Pokemon("255", "Torchic", new ArrayList<>(List.of(Tipo.Fuego)), "Posee una saca de fuego en el abdomen, cuya llama arderá durante toda su vida. El calor que desprende resulta muy agradable al abrazarlo. ", "res/drawable/p255.png"));
        this.lista2.add(new Pokemon("256", "Conbusken", new ArrayList<>(List.of(Tipo.Fuego, Tipo.Lucha)), "Propina unas patadas demoledoras. Profiere potentes gritos para aguzar su concentración.", "res/drawable/p256.png"));
        this.lista3.add(new Pokemon("257", "Blaziken", new ArrayList<>(List.of(Tipo.Fuego, Tipo.Lucha)), "Ante un rival difícil, expulsa llamas por las muñecas. Tiene mucha fuerza en las patas; hasta puede saltar edificios.", "res/drawable/p257.png"));
        this.lista1.add(new Pokemon("258", "Mudkip", new ArrayList<>(List.of(Tipo.Agua)), "Puede reducir a añicos grandes rocas. Descansa enterrado en el lodo del lecho de los ríos.", "res/drawable/p258.png"));
        this.lista2.add(new Pokemon("259", "Marshtomp", new ArrayList<>(List.of(Tipo.Agua, Tipo.Tierra)), "Vive en terrenos cubiertos de lodo viscoso, lo que contribuye a que sus patas se fortalezcan y se vuelvan extremadamente robustas.", "res/drawable/p259.png"));
        this.lista3.add(new Pokemon("260", "Swampert", new ArrayList<>(List.of(Tipo.Agua, Tipo.Tierra)), "Con sus brazos duros como una roca puede partir pedruscos gigantescos en mil pedazos de un solo golpe.", "res/drawable/p260.png"));

        this.lista1.add(new Pokemon("387", "Turtwig", new ArrayList<>(List.of(Tipo.Planta)), "Si su caparazón, hecho de tierra, está húmedo al tacto, es señal de que Turtwig se encuentra en plena forma.", "res/drawable/p387.png"));
        this.lista2.add(new Pokemon("388", "Grotle", new ArrayList<>(List.of(Tipo.Planta)), "Viven en el bosque, donde se dice que hay manantiales cristalinos que solo ellos conocen.", "res/drawable/p388.png"));
        this.lista3.add(new Pokemon("389", "Torterra", new ArrayList<>(List.of(Tipo.Planta, Tipo.Tierra)), "Las gentes de antaño creían que la superficie terrestre se encontraba sobre un gran Torterra.", "res/drawable/p389.png"));
        this.lista1.add(new Pokemon("390", "Chimchar", new ArrayList<>(List.of(Tipo.Fuego)), "Es muy ágil. Antes de dormir apaga la llama del trasero para no provocar un incendio.", "res/drawable/p390.png"));
        this.lista2.add(new Pokemon("391", "Monferno", new ArrayList<>(List.of(Tipo.Fuego, Tipo.Lucha)), "Controla hábilmente la intensidad del fuego de la cola para mantener al enemigo a una distancia ideal.", "res/drawable/p391.png"));
        this.lista3.add(new Pokemon("392", "Infernape", new ArrayList<>(List.of(Tipo.Fuego, Tipo.Lucha)), "Desconcierta a sus rivales con su tremenda agilidad. Su característica forma de luchar utiliza todos sus miembros.", "res/drawable/p392.png"));
        this.lista1.add(new Pokemon("393", "Piplup", new ArrayList<>(List.of(Tipo.Agua)), "No se le da bien andar. Se tropieza mucho, pero su orgullo le hace sacar pecho como si nada.", "res/drawable/p393.png"));
        this.lista2.add(new Pokemon("394", "Prinplup", new ArrayList<>(List.of(Tipo.Agua)), "Vive por su cuenta, alejado de sus congéneres. Puede partir en dos un árbol gigantesco de un fuerte aletazo.", "res/drawable/p394.png"));
        this.lista3.add(new Pokemon("395", "Empoleon", new ArrayList<>(List.of(Tipo.Agua, Tipo.Acero)), "Si alguien hiere su orgullo, lo desgarra con sus alas, capaces de cortar incluso témpanos de hielo.", "res/drawable/p395.png"));

        this.lista1.add(new Pokemon("650", "Chespin", new ArrayList<>(List.of(Tipo.Planta)), "Cuando acumula energía antes de propinar un cabezazo, las púas de su cabeza se vuelven tan afiladas que atraviesan el cuerpo del enemigo.", "res/drawable/p650.png"));
        this.lista2.add(new Pokemon("651", "Quilladin", new ArrayList<>(List.of(Tipo.Planta)), "Lo protege una robusta coraza que, al ser tan pesada, le proporciona al mismo tiempo una forma natural de fortalecer las piernas.", "res/drawable/p651.png"));
        this.lista3.add(new Pokemon("652", "Chesnaught", new ArrayList<>(List.of(Tipo.Planta, Tipo.Lucha)), "Cuando sus aliados se encuentran en apuros, despliega un escudo con los brazos y bloquea los ataques utilizando su propio cuerpo.", "res/drawable/p652.png"));
        this.lista1.add(new Pokemon("653", "Fennekin", new ArrayList<>(List.of(Tipo.Fuego)), "Tiende a exaltarse con facilidad. Su temperatura corporal también aumenta en exceso, por lo que expulsa el calor por las orejas para calmarse.", "res/drawable/p653.png"));
        this.lista2.add(new Pokemon("654", "Braixen", new ArrayList<>(List.of(Tipo.Fuego)), "Agita la rama candente de la cola para enviar señales a sus compañeros. En caso de peligro, la mueve describiendo una trayectoria circular.", "res/drawable/p654.png"));
        this.lista3.add(new Pokemon("655", "Delphox", new ArrayList<>(List.of(Tipo.Fuego, Tipo.Psiquico)), "Deja marcas en el suelo con la punta candente de su varita. Las gentes de antaño practicaban la adivinación interpretando dichas marcas.", "res/drawable/p655.png"));
        this.lista1.add(new Pokemon("656", "Froakie", new ArrayList<>(List.of(Tipo.Agua)), "Su aire despreocupado no es más que una fachada con la que engaña a sus enemigos para después arrollarlos a una velocidad abrumadora.", "res/drawable/p656.png"));
        this.lista2.add(new Pokemon("657", "Frogadier", new ArrayList<>(List.of(Tipo.Agua)), "Es muy hábil ideando tácticas que usan el terreno a su favor. Dispara piedras envueltas en burbujas con tal puntería que no falla nunca.", "res/drawable/p657.png"));
        this.lista3.add(new Pokemon("658", "Greninja", new ArrayList<>(List.of(Tipo.Agua, Tipo.Siniestro)), "Puede detectar enemigos fuera de su campo visual al captar los movimientos del aire con su larga lengua enroscada alrededor del cuello.", "res/drawable/p658.png"));
    }

    public static PokemonRepository getInstance() {
        if (instance == null) {
            instance = new PokemonRepository();
        }
        return instance;
    }


    public ArrayList<Pokemon> getLista(int opc) {

        switch (opc) {
            case 1:
                return lista1;

            case 2:
                return lista2;

            case 3:
                return lista3;
        }

        return null;
    }


    public HashMap<Integer, Pokemon> toMapa(int opc) {

        HashMap<Integer, Pokemon> mapa = new HashMap<>();

        switch (opc) {
            case 1:
                for (Pokemon p : lista1) {
                    mapa.put(Integer.parseInt(p.getNumero()), p);
                }
                return mapa;

            case 2:
                for (Pokemon p : lista2) {
                    mapa.put(Integer.parseInt(p.getNumero()), p);
                }
                return mapa;

            case 3:
                for (Pokemon p : lista3) {
                    mapa.put(Integer.parseInt(p.getNumero()), p);
                }
                return mapa;
        }

        return null;


    }

    public HashMap<Integer, Pokemon> getEquipo() {

        return equipo;

    }

    public void agregarPokemonAlEquipo(Pokemon pokemon) {

        equipo.put(Integer.parseInt(pokemon.getNumero()), pokemon);

    }

    public void removePokemon(int position, int list) {

        int buscado = 0;
        switch (list) {
            case 1:
                if (position >= 0 && position < lista1.size()) {
                    if (buscar(position,lista1))
                        lista1.remove(position);
                }
                break;

            case 2:
                if (position >= 0 && position < lista2.size()) {
                    if (buscar(position,lista2))
                        lista2.remove(position);
                }
                break;

            case 3:
                if (position >= 0 && position < lista3.size()) {
                    if (buscar(position,lista3))
                        lista3.remove(position);
                }
                break;

        }

    }


    public Pokemon buscar(String num, ArrayList<Pokemon> list) {
        for(Pokemon p:list){
            if(p.getNumero().equals(num)){
                return p;
            }
        }
        return null;
    }

    public boolean buscar(int pos, ArrayList<Pokemon> lista) {
        return lista.get(pos) != null;
    }

    public boolean contienePokemon(int numero) {

        return equipo.containsKey(numero);

    }


}

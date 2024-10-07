import java.util.*;

enum Attribute {
    STRENGTH,
    AGILITY,
    INTELLIGENCE,
    UNIVERSAL
}

abstract class Hero implements Comparable<Hero> {
    String name;
    int health;
    Attribute attribute;

    public Hero(String name, int health, Attribute attribute) {
        this.name = name;
        this.health = health;
        this.attribute = attribute;
    }

    public abstract List<String> getAbilities();
    @Override
    public int compareTo(Hero hero) {
        if (hero == null)
            return 1;
        return Integer.compare(this.health, hero.health);
    }

    @Override
    public String toString() {
        return String.format("%s is the %s hero with %s health",name,attribute,health);
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}

class TemplarAssassin extends Hero {
    int psiBladesCount;
    public TemplarAssassin(int psiBladesCount) {
        super("Templar Assassin", 560, Attribute.AGILITY);
        this.psiBladesCount = psiBladesCount;
    }

    @Override
    public List<String> getAbilities() {
        return Arrays.asList("Refraction", "Meld", "Psi Blades", "Trap");
    }
    @Override
    public String toString(){
        return String.format("%s is the %s hero with %s health, the player get %s psiblade kills!",name,attribute,health,psiBladesCount);
    }
}

class Windranger extends Hero {

    boolean isTheAspectChosen;
    public Windranger(boolean isTheAspectChoosen) {
        super("Windranger", 600, Attribute.UNIVERSAL);
        this.isTheAspectChosen = isTheAspectChoosen;
    }

    @Override
    public List<String> getAbilities() {
        if (isTheAspectChosen) {
            return Arrays.asList("Shackleshot", "Powershot", "Windrun", "Whirlwind");
        }
        return Arrays.asList("Shackleshot", "Powershot", "Windrun", "Focus Fire");
    }
}

class Lina extends Hero {
    boolean isAghanim;
    public Lina(boolean isAghanim) {
        super("Lina", 550, Attribute.INTELLIGENCE);
        this.isAghanim = isAghanim;
    }

    @Override
    public List<String> getAbilities() {
        if(isAghanim){
            return Arrays.asList("Dragon Slave", "Light Strike Array", "Fiery Soul","Flame clock", "Laguna Blade");
        }
        return Arrays.asList("Dragon Slave", "Light Strike Array", "Fiery Soul", "Laguna Blade");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new TemplarAssassin(12));
        heroes.add(new Windranger(true));
        heroes.add(new Lina(true));
        Collections.sort(heroes);
        for (Hero hero : heroes) {
            System.out.println(hero);
            System.out.println("Abilities: " + hero.getAbilities());
        }
    }
}
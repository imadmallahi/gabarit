package fr.tdf.gdpa.gabarit.infra.enumuration;

public enum TypeTacheEnum {

    JALON("Jalon"),
    TACHE_SECONDAIRE("Tâche secondaire"),
    TACHE_OPTIONNELLE("Tâche optionnelle");

    private final String label;

    TypeTacheEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}


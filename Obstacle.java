public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int award;
    private int initialHealth;
    private int minDamage;
    private int maxDamage;

    Obstacle(String name, int id, int damage, int health, int award) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.initialHealth = health;
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMinDamage(int damage) {
        this.minDamage = damage;
    }

    public void setMaxDamage(int damage) {
        this.maxDamage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;

    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }
}
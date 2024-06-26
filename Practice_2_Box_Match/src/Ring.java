public class Ring {
    Fighter f1, f2;
    int minWeight, maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (checkWeight()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("=====YENİ ROUND=====");
                // whoStarts() metodunun sonucuna göre f1 ya da f2 önce başlar
                if (whoStarts() == true) {
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }

                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                } else {
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                }
                printScore();
            }
        } else {
            System.out.println("Sporcular farklı sıklette");
        }
    }
    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }
    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        }

        return false;
    }
    // Math.random 0 ile 1 arasında rastgele bir sayı verir. Sayı 0.5'ten büyükse true, küçükse false değeri %50 ihtimalle döner
    public boolean whoStarts() {
        return Math.random() > 0.5f ? true : false;
    }
    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }
}

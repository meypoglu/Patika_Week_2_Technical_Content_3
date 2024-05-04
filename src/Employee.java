import java.time.Year;

public class Employee {
    String name;
    int salary, workHours, hireYear;

    Employee (String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    float tax() {
        if (salary >= 1000) {
            return salary * 0.03f;
        }
        return 0;
    }

    int bonus() {
        if (workHours > 40) {
            return (workHours - 40) * 30;
        }
        return 0;
    }

    float salaryRaise() {
        int year = Year.now().getValue() - hireYear;
        float raise = 0;

        if (year < 10 ) {
            raise = 0.05f;
        } else if (year >= 10 && year < 20) {
            raise = 0.1f;
        } else {
            raise = 0.15f;
        }
        return raise * salary;
    }

    public String toString() {
        return "Adı: " + name + "\nMaaşı: " + salary + "\nÇalışma Saati: " + workHours +
                "\nBaşlangıç Yılı: " + hireYear + "\nVergi: " + tax() + "\nBonus: " + bonus() +
                "\nMaaş Artışı: " + salaryRaise() + "\nVergi ve Bonuslar ile birlikte alınan maaş: " +
                (salary + bonus() + salaryRaise() - tax()) + "\nToplam Maaş: " + (salaryRaise() + bonus() + salary);

    }
}

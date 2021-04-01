package example5;

import example5.dao.CarDao;
import example5.model.Car2;

public class MainCar {
    public static void main(String[] args) {
        Car2 volvo = new Car2(null, "Volvo", "XC70", "2.5");
        Car2 vw = new Car2(null, "VW", "Passat", "1.9");
        System.out.println(volvo);
        System.out.println(vw);
        CarDao carDao = new CarDao();
        carDao.createCar(volvo);
        carDao.createCar(vw);

    }
}

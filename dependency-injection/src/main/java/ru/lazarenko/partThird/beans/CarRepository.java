package ru.lazarenko.partThird.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lazarenko.partThird.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarRepository {
    private final Connection connection;

    @Autowired
    public CarRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Car> getAllCars(){
        String SQL = "SELECT * FROM cars";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)){
            List<Car> cars = new ArrayList<>();
            while (resultSet.next()){
                String model = resultSet.getString("model");
                Integer price = resultSet.getInt("price");
                String owner = resultSet.getString("owner");
                String year = resultSet.getString("year");
                cars.add(new Car(model, price, owner, year));
            }
            return cars;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return List.of();
        }
    }

    public boolean saveCar(Car car){
        String SQL = "INSERT INTO cars VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setLong(1, java.sql.Types.NULL);
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getPrice());
            preparedStatement.setString(4, car.getOwner());
            preparedStatement.setString(5, car.getYear());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }
}

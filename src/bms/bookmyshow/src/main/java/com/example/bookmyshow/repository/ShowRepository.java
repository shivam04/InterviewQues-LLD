package bms.bookmyshow.src.main.java.com.example.bookmyshow.repository;

import bms.bookmyshow.src.main.java.com.example.bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}

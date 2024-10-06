package com.example.HotelDemo.Repository;

import com.example.HotelDemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.example.HotelDemo.sql.QueryRewrite.*;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}

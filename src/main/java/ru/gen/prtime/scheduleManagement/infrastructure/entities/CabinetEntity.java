//package ru.gen.prtime.scheduleManagement.infrastructure.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Comment;
//import ru.gen.prtime.userAccessManagement.security.entities.User;
//
//import java.util.List;
//
//@Comment("Пространство, в котором специалист проводит приемы")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "сabinet")
//public class CabinetEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "cabinet_name")
//    private String cabinetName;
//
//    @Column(name = "cabinet_address")
//    private String cabinetAddress;
//
//    @ManyToOne
//    @JoinColumn(name = "specialist_id")
//    private User specialist;
//}

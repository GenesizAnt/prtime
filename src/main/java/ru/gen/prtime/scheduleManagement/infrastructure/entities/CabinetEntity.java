package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Comment("Пространство, в котором специалист проводит приемы")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "сabinet")
public class CabinetEntity {
}

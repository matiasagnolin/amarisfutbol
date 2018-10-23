package com.amaris.futbol.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name = "HREmployees")
@Getter
@Setter
@NoArgsConstructor
public class HREmployee extends BaseEntity {


}
